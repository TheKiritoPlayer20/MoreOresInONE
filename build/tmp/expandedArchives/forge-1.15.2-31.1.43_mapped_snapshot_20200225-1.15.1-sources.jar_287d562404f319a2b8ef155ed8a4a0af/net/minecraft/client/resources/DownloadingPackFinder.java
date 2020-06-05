package net.minecraft.client.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.WorkingScreen;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.resources.FilePack;
import net.minecraft.resources.IPackFinder;
import net.minecraft.resources.PackCompatibility;
import net.minecraft.resources.ResourcePackInfo;
import net.minecraft.resources.VanillaPack;
import net.minecraft.resources.data.PackMetadataSection;
import net.minecraft.util.HTTPUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class DownloadingPackFinder implements IPackFinder {
   private static final Logger LOGGER = LogManager.getLogger();
   private static final Pattern PATTERN_SHA1 = Pattern.compile("^[a-fA-F0-9]{40}$");
   private final VanillaPack vanillaPack;
   private final File serverPackDir;
   private final ReentrantLock lockDownload = new ReentrantLock();
   private final ResourceIndex resourceIndex;
   @Nullable
   private CompletableFuture<?> currentDownload;
   @Nullable
   private ClientResourcePackInfo serverPack;

   public DownloadingPackFinder(File p_i48116_1_, ResourceIndex p_i48116_2_) {
      this.serverPackDir = p_i48116_1_;
      this.resourceIndex = p_i48116_2_;
      this.vanillaPack = new VirtualAssetsPack(p_i48116_2_);
   }

   public <T extends ResourcePackInfo> void addPackInfosToMap(Map<String, T> nameToPackMap, ResourcePackInfo.IFactory<T> packInfoFactory) {
      T t = ResourcePackInfo.createResourcePack("vanilla", true, () -> {
         return this.vanillaPack;
      }, packInfoFactory, ResourcePackInfo.Priority.BOTTOM);
      if (t != null) {
         nameToPackMap.put("vanilla", t);
      }

      if (this.serverPack != null) {
         nameToPackMap.put("server", (T)this.serverPack);
      }

      File file1 = this.resourceIndex.getFile(new ResourceLocation("resourcepacks/programmer_art.zip"));
      if (file1 != null && file1.isFile()) {
         T t1 = ResourcePackInfo.createResourcePack("programer_art", false, () -> {
            return new FilePack(file1) {
               public String getName() {
                  return "Programmer Art";
               }
            };
         }, packInfoFactory, ResourcePackInfo.Priority.TOP);
         if (t1 != null) {
            nameToPackMap.put("programer_art", t1);
         }
      }

   }

   public VanillaPack getVanillaPack() {
      return this.vanillaPack;
   }

   public static Map<String, String> func_195742_b() {
      Map<String, String> map = Maps.newHashMap();
      map.put("X-Minecraft-Username", Minecraft.getInstance().getSession().getUsername());
      map.put("X-Minecraft-UUID", Minecraft.getInstance().getSession().getPlayerID());
      map.put("X-Minecraft-Version", SharedConstants.getVersion().getName());
      map.put("X-Minecraft-Version-ID", SharedConstants.getVersion().getId());
      map.put("X-Minecraft-Pack-Format", String.valueOf(SharedConstants.getVersion().getPackVersion()));
      map.put("User-Agent", "Minecraft Java/" + SharedConstants.getVersion().getName());
      return map;
   }

   public CompletableFuture<?> downloadResourcePack(String p_217818_1_, String p_217818_2_) {
      String s = DigestUtils.sha1Hex(p_217818_1_);
      String s1 = PATTERN_SHA1.matcher(p_217818_2_).matches() ? p_217818_2_ : "";
      this.lockDownload.lock();

      CompletableFuture completablefuture1;
      try {
         this.clearResourcePack();
         this.clearDownloads();
         File file1 = new File(this.serverPackDir, s);
         CompletableFuture<?> completablefuture;
         if (file1.exists()) {
            completablefuture = CompletableFuture.completedFuture("");
         } else {
            WorkingScreen workingscreen = new WorkingScreen();
            Map<String, String> map = func_195742_b();
            Minecraft minecraft = Minecraft.getInstance();
            minecraft.runImmediately(() -> {
               minecraft.displayGuiScreen(workingscreen);
            });
            completablefuture = HTTPUtil.downloadResourcePack(file1, p_217818_1_, map, 104857600, workingscreen, minecraft.getProxy());
         }

         this.currentDownload = completablefuture.<Void>thenCompose((p_217812_3_) -> {
            return !this.checkHash(s1, file1) ? Util.completedExceptionallyFuture(new RuntimeException("Hash check failure for file " + file1 + ", see log")) : this.setServerPack(file1);
         }).whenComplete((p_217815_1_, p_217815_2_) -> {
            if (p_217815_2_ != null) {
               LOGGER.warn("Pack application failed: {}, deleting file {}", p_217815_2_.getMessage(), file1);
               deleteQuiet(file1);
            }

         });
         completablefuture1 = this.currentDownload;
      } finally {
         this.lockDownload.unlock();
      }

      return completablefuture1;
   }

   private static void deleteQuiet(File p_217811_0_) {
      try {
         Files.delete(p_217811_0_.toPath());
      } catch (IOException ioexception) {
         LOGGER.warn("Failed to delete file {}: {}", p_217811_0_, ioexception.getMessage());
      }

   }

   public void clearResourcePack() {
      this.lockDownload.lock();

      try {
         if (this.currentDownload != null) {
            this.currentDownload.cancel(true);
         }

         this.currentDownload = null;
         if (this.serverPack != null) {
            this.serverPack = null;
            Minecraft.getInstance().scheduleResourcesRefresh();
         }
      } finally {
         this.lockDownload.unlock();
      }

   }

   private boolean checkHash(String p_195745_1_, File p_195745_2_) {
      try (FileInputStream fileinputstream = new FileInputStream(p_195745_2_)) {
         String s = DigestUtils.sha1Hex((InputStream)fileinputstream);
         if (p_195745_1_.isEmpty()) {
            LOGGER.info("Found file {} without verification hash", (Object)p_195745_2_);
            return true;
         }

         if (s.toLowerCase(java.util.Locale.ROOT).equals(p_195745_1_.toLowerCase(java.util.Locale.ROOT))) {
            LOGGER.info("Found file {} matching requested hash {}", p_195745_2_, p_195745_1_);
            return true;
         }

         LOGGER.warn("File {} had wrong hash (expected {}, found {}).", p_195745_2_, p_195745_1_, s);
      } catch (IOException ioexception) {
         LOGGER.warn("File {} couldn't be hashed.", p_195745_2_, ioexception);
      }

      return false;
   }

   private void clearDownloads() {
      try {
         List<File> list = Lists.newArrayList(FileUtils.listFiles(this.serverPackDir, TrueFileFilter.TRUE, (IOFileFilter)null));
         list.sort(LastModifiedFileComparator.LASTMODIFIED_REVERSE);
         int i = 0;

         for(File file1 : list) {
            if (i++ >= 10) {
               LOGGER.info("Deleting old server resource pack {}", (Object)file1.getName());
               FileUtils.deleteQuietly(file1);
            }
         }
      } catch (IllegalArgumentException illegalargumentexception) {
         LOGGER.error("Error while deleting old server resource pack : {}", (Object)illegalargumentexception.getMessage());
      }

   }

   public CompletableFuture<Void> setServerPack(File p_217816_1_) {
      PackMetadataSection packmetadatasection = null;
      NativeImage nativeimage = null;
      String s = null;

      try (FilePack filepack = new FilePack(p_217816_1_)) {
         packmetadatasection = filepack.getMetadata(PackMetadataSection.SERIALIZER);

         try (InputStream inputstream = filepack.getRootResourceStream("pack.png")) {
            nativeimage = NativeImage.read(inputstream);
         } catch (IllegalArgumentException | IOException ioexception) {
            LOGGER.info("Could not read pack.png: {}", (Object)ioexception.getMessage());
         }
      } catch (IOException ioexception1) {
         s = ioexception1.getMessage();
      }

      if (s != null) {
         return Util.completedExceptionallyFuture(new RuntimeException(String.format("Invalid resourcepack at %s: %s", p_217816_1_, s)));
      } else {
         LOGGER.info("Applying server pack {}", (Object)p_217816_1_);
         this.serverPack = new ClientResourcePackInfo("server", true, () -> {
            return new FilePack(p_217816_1_);
         }, new TranslationTextComponent("resourcePack.server.name"), packmetadatasection.getDescription(), PackCompatibility.getCompatibility(packmetadatasection.getPackFormat()), ResourcePackInfo.Priority.TOP, true, nativeimage);
         return Minecraft.getInstance().scheduleResourcesRefresh();
      }
   }
}
package net.minecraft.world.gen.feature.structure;

import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class PillagerOutpostStructure extends ScatteredStructure<PillagerOutpostConfig> {
   /** List of enemies that can spawn in the Pillage Outpost. */
   private static final List<Biome.SpawnListEntry> PILLAGE_OUTPOST_ENEMIES = Lists.newArrayList(new Biome.SpawnListEntry(EntityType.PILLAGER, 1, 1, 1));

   public PillagerOutpostStructure(Function<Dynamic<?>, ? extends PillagerOutpostConfig> pillageOutpostConfigIn) {
      super(pillageOutpostConfigIn);
   }

   public String getStructureName() {
      return "Pillager_Outpost";
   }

   public int getSize() {
      return 3;
   }

   public List<Biome.SpawnListEntry> getSpawnList() {
      return PILLAGE_OUTPOST_ENEMIES;
   }

   public boolean hasStartAt(ChunkGenerator<?> chunkGen, Random rand, int chunkPosX, int chunkPosZ) {
      ChunkPos chunkpos = this.getStartPositionForPosition(chunkGen, rand, chunkPosX, chunkPosZ, 0, 0);
      if (chunkPosX == chunkpos.x && chunkPosZ == chunkpos.z) {
         int i = chunkPosX >> 4;
         int j = chunkPosZ >> 4;
         rand.setSeed((long)(i ^ j << 4) ^ chunkGen.getSeed());
         rand.nextInt();
         if (rand.nextInt(5) != 0) {
            return false;
         }

         Biome biome = chunkGen.getBiomeProvider().getBiome(new BlockPos((chunkPosX << 4) + 9, 0, (chunkPosZ << 4) + 9));
         if (chunkGen.hasStructure(biome, Feature.PILLAGER_OUTPOST)) {
            for(int k = chunkPosX - 10; k <= chunkPosX + 10; ++k) {
               for(int l = chunkPosZ - 10; l <= chunkPosZ + 10; ++l) {
                  if (Feature.VILLAGE.hasStartAt(chunkGen, rand, k, l)) {
                     return false;
                  }
               }
            }

            return true;
         }
      }

      return false;
   }

   public Structure.IStartFactory getStartFactory() {
      return PillagerOutpostStructure.Start::new;
   }

   protected int getSeedModifier() {
      return 165745296;
   }

   public static class Start extends MarginedStructureStart {
      public Start(Structure<?> structureIn, int chunkX, int chunkZ, Biome biomeIn, MutableBoundingBox boundsIn, int referenceIn, long seed) {
         super(structureIn, chunkX, chunkZ, biomeIn, boundsIn, referenceIn, seed);
      }

      public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
         BlockPos blockpos = new BlockPos(chunkX * 16, 90, chunkZ * 16);
         PillagerOutpostPieces.func_215139_a(generator, templateManagerIn, blockpos, this.components, this.rand);
         this.recalculateStructureSize();
      }
   }
}
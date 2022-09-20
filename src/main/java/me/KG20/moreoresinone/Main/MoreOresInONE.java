package me.KG20.moreoresinone.Main;

import me.KG20.moreoresinone.Config.MoreOresInOneConfig;
import me.KG20.moreoresinone.Event.EventHandler;
import me.KG20.moreoresinone.Init.*;
import me.KG20.moreoresinone.Proxy.ClientProxy;
import me.KG20.moreoresinone.Proxy.CommonProxy;
import me.KG20.moreoresinone.Tools.BasisToolMaterial;
import me.KG20.moreoresinone.world.feature.PlacedFeatures;
import me.KG20.moreoresinone.world.gen.BiomeModifiers;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

import java.util.List;

@Mod(Constants.modid)
public class MoreOresInONE
{

    private static CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public MoreOresInONE(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().register(RegisterArmor.class);
        FMLJavaModLoadingContext.get().getModEventBus().register(RegisterBlocks.class);
        FMLJavaModLoadingContext.get().getModEventBus().register(RegisterItems.class);
        FMLJavaModLoadingContext.get().getModEventBus().register(RegisterTier.class);
        FMLJavaModLoadingContext.get().getModEventBus().register(RegisterTools.class);
        FMLJavaModLoadingContext.get().getModEventBus().register(BiomeModifiers.class);
        FMLJavaModLoadingContext.get().getModEventBus().register(PlacedFeatures.class);


        MinecraftForge.EVENT_BUS.register(EventHandler.class);
        proxy.construct();
        MoreOresInOneConfig.loadConfig(MoreOresInOneConfig.Server_Config, FMLPaths.CONFIGDIR.get().resolve("moreoresinone.toml"));

    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event){
        proxy.setup();
    }

    @SubscribeEvent
    public void ready(FMLLoadCompleteEvent event){
        RegisterTier registerTier = new RegisterTier();
        proxy.complete();
    }
}

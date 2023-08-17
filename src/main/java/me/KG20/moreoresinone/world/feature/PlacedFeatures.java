package me.KG20.moreoresinone.world.feature;

import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import java.util.List;

public class PlacedFeatures {

    public PlacedFeatures(){
        PLACED_FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Constants.modid);

    public static final RegistryObject<PlacedFeature> OVERWORLD_EXPIERENCE_ORE = PLACED_FEATURES.register("overworld_experience_ore",
            () -> new PlacedFeature(OrePlacement.OVERWORLD_EXPERIENCE_ORE.getHolder().get(),
                    commonOrePlacement(Config.count_overworld_experience.get(),heightRange(Config.minheight_overworld_experience.get(), Config.maxheight_overworld_experience.get()))));

    public static final RegistryObject<PlacedFeature> NETHER_EXPIERENCE_ORE = PLACED_FEATURES.register("nether_experience_ore",
            () -> new PlacedFeature(OrePlacement.NETHER_EXPERIENCE_ORE.getHolder().get(),
                    commonOrePlacement(Config.count_nether_experience.get(),heightRange(Config.minheight_nether_experience.get(), Config.maxheight_nether_experience.get()))));
    public static final RegistryObject<PlacedFeature> END_EXPIERENCE_ORE = PLACED_FEATURES.register("end_experience_ore",
            () -> new PlacedFeature(OrePlacement.END_EXPERIENCE_ORE.getHolder().get(),
                    commonOrePlacement(Config.count_end_experience.get(),heightRange(Config.minheight_end_experience.get(), Config.maxheight_end_experience.get()))));
    public static final RegistryObject<PlacedFeature> RUBY_ORE = PLACED_FEATURES.register("ruby_ore",
            () -> new PlacedFeature(OrePlacement.RUBY_ORE.getHolder().get(),
                    commonOrePlacement(Config.count_ruby.get(),heightRange(Config.minheight_ruby.get(), Config.maxheight_ruby.get()))));
    public static final RegistryObject<PlacedFeature> SAPPHIRE_ORE = PLACED_FEATURES.register("sapphire_ore",
            () -> new PlacedFeature(OrePlacement.SAPPHIRE_ORE.getHolder().get(),
                    commonOrePlacement(Config.count_sapphire.get(),heightRange(Config.minheight_sapphire.get(), Config.maxheight_sapphire.get()))));
    public static final RegistryObject<PlacedFeature> CRYORITE_ORE = PLACED_FEATURES.register("cryorite_ore",
            () -> new PlacedFeature(OrePlacement.CRYORITE_ORE.getHolder().get(),
                    commonOrePlacement(Config.count_cryorite.get(),heightRange(Config.minheight_cryorite.get(), Config.maxheight_cryorite.get()))));
    public static final RegistryObject<PlacedFeature> TOPAZ_ORE = PLACED_FEATURES.register("topaz_ore",
            () -> new PlacedFeature(OrePlacement.TOPAZ_ORE.getHolder().get(),
                    commonOrePlacement(Config.count_topaz.get(),heightRange(Config.minheight_topaz.get(), Config.maxheight_topaz.get()))));
    public static final RegistryObject<PlacedFeature> CORUNDUM_ORE = PLACED_FEATURES.register("corundum_ore",
            () -> new PlacedFeature(OrePlacement.CORUNDUM_ORE.getHolder().get(),
                    commonOrePlacement(Config.count_corundum.get(),heightRange(Config.minheight_corundum.get(), Config.maxheight_corundum.get()))));


    private static HeightRangePlacement heightRange(int minHeight, int maxHeight){
        return HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight));
    }

    private static List<PlacementModifier> commonOrePlacement(int amountPerChunk, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(amountPerChunk), placementModifier);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier placementModifier1, PlacementModifier placementModifier2) {
        return List.of(placementModifier1, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
    }

}

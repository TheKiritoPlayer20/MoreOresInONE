package me.KG20.moreoresinone.world.feature;

import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Main.Constants;
import me.KG20.moreoresinone.world.gen.BiomeModifiers;
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

    public static final RegistryObject<PlacedFeature> OVERWORLD_EXPIERENCE_ORE = registerOrePlacement("overworld_exp_ore", OrePlacement.OVERWORLD_EXPIERENCE_ORE_FEATURE, Config.count_overworld_experience.get(), Config.minheight_overworld_experience.get(), Config.maxheight_overworld_experience.get());
    public static final RegistryObject<PlacedFeature> NETHER_EXPIERENCE_ORE = registerOrePlacement("nether_exp_ore", OrePlacement.NETHER_EXPIERENCE_ORE_FEATURE, Config.count_nether_experience.get(), Config.minheight_nether_experience.get(), Config.maxheight_nether_experience.get());
    public static final RegistryObject<PlacedFeature> END_EXPIERENCE_ORE = registerOrePlacement("end_exp_ore", OrePlacement.END_EXPIERENCE_ORE_FEATURE, Config.count_end_experience.get(), Config.minheight_end_experience.get(), Config.maxheight_end_experience.get());
    public static final RegistryObject<PlacedFeature> RUBY_ORE = registerOrePlacement("ruby_ore", OrePlacement.RUBY_ORE_FEATURE, Config.count_ruby.get(), Config.minheight_ruby.get(), Config.maxheight_ruby.get());
    public static final RegistryObject<PlacedFeature> SAPPHIRE_ORE = registerOrePlacement("sapphire_ore", OrePlacement.SAPPHIRE_ORE_FEATURE, Config.count_sapphire.get(), Config.minheight_sapphire.get(), Config.maxheight_sapphire.get());
    public static final RegistryObject<PlacedFeature> CRYORITE_ORE = registerOrePlacement("cryorite_ore", OrePlacement.CRYORITE_ORE_FEATURE, Config.count_cryorite.get(), Config.minheight_cryorite.get(), Config.maxheight_cryorite.get());
    public static final RegistryObject<PlacedFeature> TOPAZ_ORE = registerOrePlacement("topaz_ore", OrePlacement.TOPAZ_ORE_FEATURE, Config.count_topaz.get(), Config.minheight_topaz.get(), Config.maxheight_topaz.get());
    public static final RegistryObject<PlacedFeature> CORUNDUM_ORE = registerOrePlacement("corundum_ore", OrePlacement.CORUNDUM_ORE_FEATURE, Config.count_corundum.get(), Config.minheight_corundum.get(), Config.maxheight_corundum.get());

    public static RegistryObject<PlacedFeature> registerOrePlacement(String name, Holder<ConfiguredFeature<OreConfiguration, ?>> feature, int oreCount, int minHeight, int maxHeight){
        return PLACED_FEATURES.register(name, () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)feature, commonOrePlacement(oreCount, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)))));
    }

    private static List<PlacementModifier> commonOrePlacement(int amountPerChunk, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(amountPerChunk), placementModifier);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier placementModifier1, PlacementModifier placementModifier2) {
        return List.of(placementModifier1, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }

}

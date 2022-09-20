package me.KG20.moreoresinone.world.feature;

import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Init.RegisterBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class OrePlacement {

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_EXPERIENCE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RegisterBlocks.overworldEXPOre.defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RegisterBlocks.deepslateOverworldEXPOre.defaultBlockState())
    );

    public static final List<OreConfiguration.TargetBlockState> NETHER_EXPERIENCE_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, RegisterBlocks.netherEXPOre.defaultBlockState())
    );

    public static final List<OreConfiguration.TargetBlockState> END_EXPERIENCE_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), RegisterBlocks.endEXPOre.defaultBlockState())
    );

    public static final List<OreConfiguration.TargetBlockState> RUBY_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RegisterBlocks.rubyOre.defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RegisterBlocks.deepslateRubyOre.defaultBlockState())
    );

    public static final List<OreConfiguration.TargetBlockState> SAPPHIRE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RegisterBlocks.sapphireOre.defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RegisterBlocks.deepslateSapphireOre.defaultBlockState())
    );

    public static final List<OreConfiguration.TargetBlockState> CRYORITE_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.BLUE_ICE), RegisterBlocks.cryoriteOre.defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.PACKED_ICE), RegisterBlocks.packedcryoriteOre.defaultBlockState())
    );

    public static final List<OreConfiguration.TargetBlockState> TOPAZ_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, RegisterBlocks.topazOre.defaultBlockState())
    );

    public static final List<OreConfiguration.TargetBlockState> CORUNDUM_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), RegisterBlocks.corundumOre.defaultBlockState())
    );

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> OVERWORLD_EXPIERENCE_ORE_FEATURE = registerFeature("overworld_exp_ore_feature", OVERWORLD_EXPERIENCE_ORES, Config.veinsize_overworld_experience.get());
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_EXPIERENCE_ORE_FEATURE = registerFeature("nether_exp_ore_feature", NETHER_EXPERIENCE_ORES, Config.veinsize_nether_experience.get());
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_EXPIERENCE_ORE_FEATURE = registerFeature("end_exp_ore_feature", END_EXPERIENCE_ORES, Config.veinsize_end_experience.get());
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> RUBY_ORE_FEATURE = registerFeature("ruby_ore_feature", RUBY_ORES, Config.veinsize_ruby.get());
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SAPPHIRE_ORE_FEATURE = registerFeature("sapphire_ore_feature", SAPPHIRE_ORES, Config.veinsize_sapphire.get());
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CRYORITE_ORE_FEATURE = registerFeature("cryorite_ore_feature", CRYORITE_ORES, Config.veinsize_cryorite.get());
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TOPAZ_ORE_FEATURE = registerFeature("topaz_ore_feature", TOPAZ_ORES, Config.veinsize_topaz.get());
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CORUNDUM_ORE_FEATURE = registerFeature("corundum_ore_feature", CORUNDUM_ORES, Config.veinsize_corundum.get());

    public static Holder<ConfiguredFeature<OreConfiguration, ?>> registerFeature(String name, List<OreConfiguration.TargetBlockState> feature, int veinsize){
        return FeatureUtils.register(name, Feature.ORE, new OreConfiguration(feature, veinsize));
    }

    /*

    public static final Holder<PlacedFeature> OVERWORLD_EXPIERENCE_ORE = registerOrePlacement("overworld_experience_ore", OVERWORLD_EXPIERENCE_ORE_FEATURE, Config.count_overworld_experience.get(), Config.minheight_overworld_experience.get(), Config.maxheight_overworld_experience.get());
    public static  final Holder<PlacedFeature> DEEPSLATE_OVERWORLD_EXPIERENCE_ORE = registerOrePlacement("deepslate_overworld_exp_ore", DEEPSLATE_OVERWORLD_EXPIERENCE_ORE_FEATURE, Config.count_overworld_experience.get(), Config.minheight_overworld_experience.get(), Config.maxheight_overworld_experience.get());
    public static  final Holder<PlacedFeature> NETHER_EXPIERENCE_ORE = registerOrePlacement("nether_exp_ore", NETHER_EXPIERENCE_ORE_FEATURE, Config.count_nether_experience.get(), Config.minheight_nether_experience.get(), Config.maxheight_nether_experience.get());
    public static  final Holder<PlacedFeature> END_EXPIERENCE_ORE = registerOrePlacement("end_exp_ore", END_EXPIERENCE_ORE_FEATURE, Config.count_end_experience.get(), Config.minheight_end_experience.get(), Config.maxheight_end_experience.get());
    public static  final Holder<PlacedFeature> RUBY_ORE = registerOrePlacement("ruby_ore", RUBY_ORE_FEATURE, Config.count_ruby.get(), Config.minheight_ruby.get(), Config.maxheight_ruby.get());
    public static  final Holder<PlacedFeature> SAPPHIRE_ORE = registerOrePlacement("sapphire_ore", SAPPHIRE_ORE_FEATURE, Config.count_sapphire.get(), Config.minheight_sapphire.get(), Config.maxheight_sapphire.get());
    public static  final Holder<PlacedFeature> DEEPSLATE_RUBY_ORE = registerOrePlacement("deepslate_ruby_ore", DEEPSLATE_RUBY_ORE_FEATURE, Config.count_ruby.get(), Config.minheight_ruby.get(), Config.maxheight_ruby.get());
    public static  final Holder<PlacedFeature> DEEPSLATE_SAPPHIRE_ORE = registerOrePlacement("deepslate_sapphire_ore", DEEPSLATE_SAPPHIRE_ORE_FEATURE, Config.count_sapphire.get(), Config.minheight_sapphire.get(), Config.maxheight_sapphire.get());
    public static  final Holder<PlacedFeature> CRYORITE_ORE = registerOrePlacement("cryorite_ore", CRYORITE_ORE_FEATURE, Config.count_cryorite.get(), Config.minheight_cryorite.get(), Config.maxheight_cryorite.get());
    public static  final Holder<PlacedFeature> PACKED_CRYORITE_ORE = registerOrePlacement("packed_cryorite_ore", PACKED_CRYORITE_ORE_FEATURE, Config.count_cryorite.get(), Config.minheight_cryorite.get(), Config.maxheight_cryorite.get());
    public static  final Holder<PlacedFeature> TOPAZ_ORE = registerOrePlacement("topaz_ore", TOPAZ_ORE_FEATURE, Config.count_topaz.get(), Config.minheight_topaz.get(), Config.maxheight_topaz.get());
    public static  final Holder<PlacedFeature> CORUNDUM_ORE = registerOrePlacement("corundum_ore", CORUNDUM_ORE_FEATURE, Config.count_corundum.get(), Config.minheight_corundum.get(), Config.maxheight_corundum.get());


    public static Holder<PlacedFeature> registerOrePlacement(String name, Holder<ConfiguredFeature<OreConfiguration, ?>> feature, int oreCount, int minHeight, int maxHeight){
        return PlacementUtils.register(name, feature, commonOrePlacement(oreCount, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier placementModifier1, PlacementModifier placementModifier2) {
        return List.of(placementModifier1, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int amountPerChunk, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(amountPerChunk), placementModifier);
    }

     */
}

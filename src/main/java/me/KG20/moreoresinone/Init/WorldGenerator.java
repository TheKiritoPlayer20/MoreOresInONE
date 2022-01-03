package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

public class WorldGenerator {

    public static PlacedFeature OVERWORLD_EXPIERENCE_ORE = OverworldOres("overworld_exp_ore", RegisterBlocks.overworldEXPOre.defaultBlockState(), Config.veinsize_overworld_experience.get(), Config.minheight_overworld_experience.get(), Config.maxheight_overworld_experience.get(), Config.count_overworld_experience.get());
    public static PlacedFeature DEEPSLATE_OVERWORLD_EXPIERENCE_ORE = DeepslateOverworldOres("deepslate_overworld_exp_ore", RegisterBlocks.deepslateOverworldEXPOre.defaultBlockState(), Config.veinsize_overworld_experience.get(), Config.minheight_overworld_experience.get(), Config.maxheight_overworld_experience.get(), Config.count_overworld_experience.get());
    public static PlacedFeature NETHER_EXPIERENCE_ORE = NetherOres("nether_exp_ore", RegisterBlocks.netherEXPOre.defaultBlockState(), Config.veinsize_nether_experience.get(), Config.minheight_nether_experience.get(), Config.maxheight_nether_experience.get(), Config.count_nether_experience.get());
    public static PlacedFeature END_EXPIERENCE_ORE = EndOres("end_exp_ore", RegisterBlocks.endEXPOre.defaultBlockState(), Config.veinsize_end_experience.get(), Config.minheight_end_experience.get(), Config.maxheight_end_experience.get(), Config.count_end_experience.get());
    public static PlacedFeature RUBY_ORE = OverworldOres("ruby_ore", RegisterBlocks.rubyOre.defaultBlockState(), Config.veinsize_ruby.get(), Config.minheight_ruby.get(), Config.maxheight_ruby.get(), Config.count_ruby.get());
    public static PlacedFeature SAPPHIRE_ORE = OverworldOres("sapphire_ore", RegisterBlocks.sapphireOre.defaultBlockState(), Config.veinsize_sapphire.get(), Config.minheight_sapphire.get(), Config.maxheight_sapphire.get(), Config.count_sapphire.get());
    public static PlacedFeature DEEPSLATE_RUBY_ORE = DeepslateOverworldOres("deepslate_ruby_ore", RegisterBlocks.deepslateRubyOre.defaultBlockState(), Config.veinsize_ruby.get(), Config.minheight_ruby.get(), Config.maxheight_ruby.get(), Config.count_ruby.get());
    public static PlacedFeature DEEPSLATE_SAPPHIRE_ORE = DeepslateOverworldOres("deepslate_sapphire_ore", RegisterBlocks.deepslateSapphireOre.defaultBlockState(), Config.veinsize_sapphire.get(), Config.minheight_sapphire.get(), Config.maxheight_sapphire.get(), Config.count_sapphire.get());
    public static PlacedFeature CRYORITE_ORE = OverworldCryoriteOres("cryorite_ore", RegisterBlocks.cryoriteOre.defaultBlockState(), Config.veinsize_cryorite.get(), Config.minheight_cryorite.get(), Config.maxheight_cryorite.get(), Config.count_cryorite.get());
    public static PlacedFeature PACKED_CRYORITE_ORE = OverworldPackedCryoriteOres("packed_cryorite_ore", RegisterBlocks.packedcryoriteOre.defaultBlockState(), Config.veinsize_cryorite.get(), Config.minheight_cryorite.get(), Config.maxheight_cryorite.get(), Config.count_cryorite.get());
    public static PlacedFeature TOPAZ_ORE = NetherOres("topaz_ore", RegisterBlocks.topazOre.defaultBlockState(), Config.veinsize_topaz.get(), Config.minheight_topaz.get(), Config.maxheight_topaz.get(), Config.count_topaz.get());
    public static PlacedFeature AMETHYST_ORE = EndOres("amethyst_ore", RegisterBlocks.amethystOre.defaultBlockState(), Config.veinsize_amethyst.get(), Config.minheight_amethyst.get(), Config.maxheight_amethyst.get(), Config.count_amethyst.get());

    public static void registerOrePlacement(){
        registerPlacedFeature("overworld_exp_ore", OVERWORLD_EXPIERENCE_ORE);
        registerPlacedFeature("deepslate_overworld_exp_ore", DEEPSLATE_OVERWORLD_EXPIERENCE_ORE);
        registerPlacedFeature("nether_exp_ore", NETHER_EXPIERENCE_ORE);
        registerPlacedFeature("end_exp_ore", END_EXPIERENCE_ORE);
        registerPlacedFeature("ruby_ore", RUBY_ORE);
        registerPlacedFeature("sapphire_ore", SAPPHIRE_ORE);
        registerPlacedFeature("deepslate_ruby_ore", DEEPSLATE_RUBY_ORE);
        registerPlacedFeature("deepslate_sapphire_ore", DEEPSLATE_SAPPHIRE_ORE);
        registerPlacedFeature("cryorite_ore", CRYORITE_ORE);
        registerPlacedFeature("packed_cryorite_ore", PACKED_CRYORITE_ORE);
        registerPlacedFeature("topaz_ore", TOPAZ_ORE);
        registerPlacedFeature("amethyst_ore", AMETHYST_ORE);
    }

    //countIn, minHeightIn, maxHeightBaseIn, maxHeightIn

    public static PlacedFeature OverworldOres(String name, BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int amountPerChunk) {
        ConfiguredFeature<?, ?> feature = Feature.ORE.configured(new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, blockState, oreVeinSize));
        registerConfiguredFeature(name, feature);
        return feature.placed(commonOrePlacement(amountPerChunk, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))));
    }

    public static PlacedFeature DeepslateOverworldOres(String name, BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int amountPerChunk) {
        ConfiguredFeature<?, ?> feature = Feature.ORE.configured(new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, blockState, oreVeinSize));
        registerConfiguredFeature(name, feature);
        return feature.placed(commonOrePlacement(amountPerChunk, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))));
    }

    public static PlacedFeature OverworldCryoriteOres(String name, BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int amountPerChunk) {
        ConfiguredFeature<?, ?> feature = Feature.ORE.configured(new OreConfiguration(new BlockMatchTest(Blocks.BLUE_ICE), blockState, oreVeinSize));
        registerConfiguredFeature(name, feature);
        return feature.placed(commonOrePlacement(amountPerChunk, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))));
    }

    public static PlacedFeature OverworldPackedCryoriteOres(String name, BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int amountPerChunk) {
        ConfiguredFeature<?, ?> feature = Feature.ORE.configured(new OreConfiguration(new BlockMatchTest(Blocks.PACKED_ICE), blockState, oreVeinSize));
        registerConfiguredFeature(name, feature);
        return feature.placed(commonOrePlacement(amountPerChunk, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))));
    }

    public static PlacedFeature NetherOres(String name, BlockState blockState, int count, int minHeight, int maxHeight, int amountPerChunk) {
        ConfiguredFeature<?, ?> feature = Feature.ORE.configured(new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, blockState, count));
        registerConfiguredFeature(name, feature);
        return feature.placed(commonOrePlacement(amountPerChunk, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))));
    }

    public static PlacedFeature EndOres(String name, BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int amountPerChunk) {
        ConfiguredFeature<?, ?> feature = Feature.ORE.configured(new OreConfiguration(new BlockMatchTest(Blocks.END_STONE), blockState, oreVeinSize));
        registerConfiguredFeature(name, feature);
        return feature.placed(commonOrePlacement(amountPerChunk, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier placementModifier1, PlacementModifier placementModifier2) {
        return List.of(placementModifier1, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int amountPerChunk, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(amountPerChunk), placementModifier);
    }

    private static void registerPlacedFeature(String name, PlacedFeature feature){
        PlacementUtils.register(new ResourceLocation(Constants.modid, name).toString(), feature);
    }

    private static void registerConfiguredFeature(String name, ConfiguredFeature<?, ?> feature){
        FeatureUtils.register(new ResourceLocation(Constants.modid, name).toString(), feature);
    }
}

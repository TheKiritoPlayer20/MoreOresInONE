package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Config.Config;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

public class WorldGenerator {

    public static ConfiguredFeature<?,?> OVERWORLD_EXPIERENCE_ORE = OverworldOres(RegisterBlocks.overworldEXPOre.defaultBlockState(), Config.veinsize_overworld_experience.get(), Config.minheight_overworld_experience.get(), Config.maxheight_overworld_experience.get(), Config.chance_overworld_experience.get());
    public static ConfiguredFeature<?,?> DEEPSLATE_OVERWORLD_EXPIERENCE_ORE = DeepslateOverworldOres(RegisterBlocks.deepslateOverworldEXPOre.defaultBlockState(), Config.veinsize_overworld_experience.get(), Config.minheight_overworld_experience.get(), Config.maxheight_overworld_experience.get(), Config.chance_overworld_experience.get());
    public static ConfiguredFeature<?,?> NETHER_EXPIERENCE_ORE = NetherOres(RegisterBlocks.netherEXPOre.defaultBlockState(), Config.veinsize_nether_experience.get(), Config.minheight_nether_experience.get(), Config.maxheight_nether_experience.get(), Config.chance_nether_experience.get());
    public static ConfiguredFeature<?,?> END_EXPIERENCE_ORE = EndOres(RegisterBlocks.endEXPOre.defaultBlockState(), Config.veinsize_end_experience.get(), Config.minheight_end_experience.get(), Config.maxheight_end_experience.get(), Config.chance_end_experience.get());
    public static ConfiguredFeature<?,?> RUBY_ORE = OverworldOres(RegisterBlocks.rubyOre.defaultBlockState(), Config.veinsize_ruby.get(), Config.minheight_ruby.get(), Config.maxheight_ruby.get(), Config.chance_ruby.get());
    public static ConfiguredFeature<?,?> SAPPHIRE_ORE = OverworldOres(RegisterBlocks.sapphireOre.defaultBlockState(), Config.veinsize_sapphire.get(), Config.minheight_sapphire.get(), Config.maxheight_sapphire.get(), Config.chance_sapphire.get());
    public static ConfiguredFeature<?,?> DEEPSLATE_RUBY_ORE = DeepslateOverworldOres(RegisterBlocks.deepslateRubyOre.defaultBlockState(), Config.veinsize_ruby.get(), Config.minheight_ruby.get(), Config.maxheight_ruby.get(), Config.chance_ruby.get());
    public static ConfiguredFeature<?,?> DEEPSLATE_SAPPHIRE_ORE = DeepslateOverworldOres(RegisterBlocks.deepslateSapphireOre.defaultBlockState(), Config.veinsize_sapphire.get(), Config.minheight_sapphire.get(), Config.maxheight_sapphire.get(), Config.chance_sapphire.get());
    public static ConfiguredFeature<?,?> CRYORITE_ORE = OverworldCryoriteOres(RegisterBlocks.cryoriteOre.defaultBlockState(), Config.veinsize_cryorite.get(), Config.minheight_cryorite.get(), Config.maxheight_cryorite.get(), Config.chance_cryorite.get());
    public static ConfiguredFeature<?,?> PACKED_CRYORITE_ORE = OverworldPackedCryoriteOres(RegisterBlocks.packedcryoriteOre.defaultBlockState(), Config.veinsize_cryorite.get(), Config.minheight_cryorite.get(), Config.maxheight_cryorite.get(), Config.chance_cryorite.get());
    public static ConfiguredFeature<?,?> TOPAZ_ORE = NetherOres(RegisterBlocks.topazOre.defaultBlockState(), Config.veinsize_topaz.get(), Config.minheight_topaz.get(), Config.maxheight_topaz.get(), Config.chance_topaz.get());
    public static ConfiguredFeature<?,?> AMETHYST_ORE = EndOres(RegisterBlocks.amethystOre.defaultBlockState(), Config.veinsize_amethyst.get(), Config.minheight_amethyst.get(), Config.maxheight_amethyst.get(), Config.chance_amethyst.get());

    //countIn, minHeightIn, maxHeightBaseIn, maxHeightIn

    public static ConfiguredFeature<?,?> OverworldOres(BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int chance){
        return Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, blockState, oreVeinSize)).rangeUniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)).squared().count(chance);
    }

    public static ConfiguredFeature<?,?> DeepslateOverworldOres(BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int chance){
        return Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, blockState, oreVeinSize)).rangeUniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)).squared().count(chance);
    }

    public static ConfiguredFeature<?,?> OverworldCryoriteOres(BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int chance){
        return Feature.ORE.configured(new OreConfiguration(new BlockMatchTest(Blocks.BLUE_ICE), blockState, oreVeinSize)).rangeUniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)).squared().count(chance);
    }

    public static ConfiguredFeature<?,?> OverworldPackedCryoriteOres(BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int chance){
        return Feature.ORE.configured(new OreConfiguration(new BlockMatchTest(Blocks.PACKED_ICE), blockState, oreVeinSize)).rangeUniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)).squared().count(chance);
    }

    public static ConfiguredFeature<?,?> NetherOres(BlockState blockState, int count, int minHeight, int maxHeight, int chance){
        return Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, blockState, count)).rangeUniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)).squared().count(chance);
    }

    public static ConfiguredFeature<?,?> EndOres(BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int chance){
        return Feature.ORE.configured(new OreConfiguration(new BlockMatchTest(Blocks.END_STONE), blockState, oreVeinSize)).rangeUniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)).squared().count(chance);
    }

}

package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Config.Config;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;


public class WorldGenerator {


    public static ConfiguredFeature<?,?> OVERWORLD_EXPIERENCE_ORE = OverworldOres(RegisterBlocks.overworldEXPOre.getDefaultState(), Config.veinsize_overworld_experience.get(), Config.minheight_overworld_experience.get(), Config.maxheight_overworld_experience.get(), Config.chance_overworld_experience.get());
    public static ConfiguredFeature<?,?> NETHER_EXPIERENCE_ORE = NetherOres(RegisterBlocks.netherEXPOre.getDefaultState(), Config.veinsize_nether_experience.get(), Config.minheight_nether_experience.get(), Config.maxheight_nether_experience.get(), Config.chance_nether_experience.get());
    public static ConfiguredFeature<?,?> END_EXPIERENCE_ORE = EndOres(RegisterBlocks.endEXPOre.getDefaultState(), Config.veinsize_end_experience.get(), Config.minheight_end_experience.get(), Config.maxheight_end_experience.get(), Config.chance_end_experience.get());
    public static ConfiguredFeature<?,?> RUBY_ORE = OverworldOres(RegisterBlocks.rubyOre.getDefaultState(), Config.veinsize_ruby.get(), Config.minheight_ruby.get(), Config.maxheight_ruby.get(), Config.chance_ruby.get());
    public static ConfiguredFeature<?,?> SAPPHIRE_ORE = OverworldOres(RegisterBlocks.sapphireOre.getDefaultState(), Config.veinsize_sapphire.get(), Config.minheight_sapphire.get(), Config.maxheight_sapphire.get(), Config.chance_sapphire.get());
    public static ConfiguredFeature<?,?> CRYORITE_ORE = OverworldCryoriteOres(RegisterBlocks.cryoriteOre.getDefaultState(), Config.veinsize_cryorite.get(), Config.minheight_cryorite.get(), Config.maxheight_cryorite.get(), Config.chance_cryorite.get());
    public static ConfiguredFeature<?,?> PACKED_CRYORITE_ORE = OverworldPackedCryoriteOres(RegisterBlocks.packedcryoriteOre.getDefaultState(), Config.veinsize_cryorite.get(), Config.minheight_cryorite.get(), Config.maxheight_cryorite.get(), Config.chance_cryorite.get());
    public static ConfiguredFeature<?,?> TOPAZ_ORE = NetherOres(RegisterBlocks.topazOre.getDefaultState(), Config.veinsize_topaz.get(), Config.minheight_topaz.get(), Config.maxheight_topaz.get(), Config.chance_topaz.get());
    public static ConfiguredFeature<?,?> AMETHYST_ORE = EndOres(RegisterBlocks.amethystOre.getDefaultState(), Config.veinsize_amethyst.get(), Config.minheight_amethyst.get(), Config.maxheight_amethyst.get(), Config.chance_amethyst.get());

    //countIn, minHeightIn, maxHeightBaseIn, maxHeightIn

    public static ConfiguredFeature<?,?> OverworldOres(BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int chance){
        return Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, blockState, oreVeinSize)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight,0,maxHeight))).square().chance(chance);
    }

    public static ConfiguredFeature<?,?> OverworldCryoriteOres(BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int chance){
        return Feature.ORE.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.BLUE_ICE), blockState, oreVeinSize)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight))).square().chance(chance);
    }

    public static ConfiguredFeature<?,?> OverworldPackedCryoriteOres(BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int chance){
        return Feature.ORE.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.PACKED_ICE), blockState, oreVeinSize)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight))).square().chance(chance);
    }

    public static ConfiguredFeature<?,?> NetherOres(BlockState blockState, int count, int minHeight, int maxHeight, int chance){
        return Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, blockState, count)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight,0,maxHeight))).square().chance(chance);
    }

    public static ConfiguredFeature<?,?> EndOres(BlockState blockState, int oreVeinSize, int minHeight, int maxHeight, int chance){
        return Feature.ORE.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), blockState, oreVeinSize)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight,0,maxHeight))).square().chance(chance);
    }

}

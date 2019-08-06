package me.KG20.moreoresinone.Init;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import static net.minecraft.world.gen.placement.Placement.COUNT_RANGE;


public class WorldGenerator {

    //countIn, minHeightIn, maxHeightBaseIn, maxHeightIn
    private static final CountRangeConfig topzazOre = new CountRangeConfig(20, 0, 0, 128);
    private static final int topazOreVeinSize = 4;
    private static final CountRangeConfig amethystOre = new CountRangeConfig(10, 0, 0, 128);
    private static final int amethystOreVeinSize = 4;



    public static void setup(){
        ForgeRegistries.BIOMES.getValues().forEach(biome -> {
            if(biome.getCategory() == Biome.Category.SAVANNA || biome.getCategory() == Biome.Category.DESERT || biome.getCategory() == Biome.Category.MESA || biome.getTempCategory() == Biome.TempCategory.WARM){
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
                        new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), RegisterBlocks.rubyOre.getDefaultState()), Placement.EMERALD_ORE, IPlacementConfig.NO_PLACEMENT_CONFIG));

            }else if(biome.getCategory() == Biome.Category.TAIGA || biome.getCategory() == Biome.Category.OCEAN || biome.getCategory() == Biome.Category.ICY || biome.getTempCategory() == Biome.TempCategory.COLD) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
                        new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), RegisterBlocks.sapphireOre.getDefaultState()), Placement.EMERALD_ORE, IPlacementConfig.NO_PLACEMENT_CONFIG));

            }
        });

        Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(Feature.ORE,
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, RegisterBlocks.topazOre.getDefaultState(), topazOreVeinSize), COUNT_RANGE, topzazOre));

        Biomes.THE_END.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
                new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.amethystOre.getDefaultState()), COUNT_RANGE, amethystOre));
        Biomes.END_BARRENS.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
                new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.amethystOre.getDefaultState()), COUNT_RANGE, amethystOre));
        Biomes.END_HIGHLANDS.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
                new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.amethystOre.getDefaultState()), COUNT_RANGE, amethystOre));
        Biomes.END_MIDLANDS.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
                new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.amethystOre.getDefaultState()), COUNT_RANGE, amethystOre));
        Biomes.SMALL_END_ISLANDS.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
                new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.amethystOre.getDefaultState()), COUNT_RANGE, amethystOre));

    }

}

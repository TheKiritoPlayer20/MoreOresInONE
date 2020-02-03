package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Config.Config;
import net.minecraft.block.Block;
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
    private static final CountRangeConfig overworldexperienceOre = new CountRangeConfig(Config.count_overworld_experience.get(), Config.minheight_overworld_experience.get(), 0, Config.maxheight_overworld_experience.get());
    private static final CountRangeConfig netherexperienceOre = new CountRangeConfig(Config.count_nether_experience.get(), Config.minheight_nether_experience.get(), 0, Config.maxheight_nether_experience.get());
    private static final CountRangeConfig endexperienceOre = new CountRangeConfig(Config.count_end_experience.get(), Config.minheight_end_experience.get(), 0, Config.maxheight_end_experience.get());
    private static final CountRangeConfig rubyOre = new CountRangeConfig(Config.count_ruby.get(), Config.minheight_ruby.get(), 0, Config.maxheight_ruby.get());
    private static final int rubyOreVeinSize = Config.veinsize_ruby.get();
    private static final CountRangeConfig sapphireOre = new CountRangeConfig(Config.count_sapphire.get(), Config.minheight_sapphire.get(), 0, Config.maxheight_sapphire.get());
    private static final int sapphireOreVeinSize = Config.veinsize_sapphire.get();
    private static final CountRangeConfig topazOre = new CountRangeConfig(Config.count_topaz.get(), Config.minheight_topaz.get(), 0, Config.maxheight_topaz.get());
    private static final int topazOreVeinSize = Config.veinsize_topaz.get();
    private static final CountRangeConfig amethystOre = new CountRangeConfig(Config.count_amethyst.get(), Config.minheight_amethyst.get(), 0, Config.maxheight_amethyst.get());
    private static final int amethystOreVeinSize = 4;



    public static void setup(){
        ForgeRegistries.BIOMES.getValues().forEach(biome -> {

            if(Config.every_biome.get()){
                if(Config.generate_ruby.get()){
                    biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
                            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegisterBlocks.rubyOre.getDefaultState(), rubyOreVeinSize)).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( rubyOre)));
                }
                if(Config.generate_sapphire.get()){
                    biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
                            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegisterBlocks.sapphireOre.getDefaultState(), sapphireOreVeinSize)).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( sapphireOre)));
                }
            }else{
                if(Config.ruby_temperature.get() == 1D){
                    if((biome.getCategory() == Biome.Category.SAVANNA || biome.getCategory() == Biome.Category.DESERT || biome.getCategory() == Biome.Category.MESA || biome.getTempCategory() == Biome.TempCategory.WARM || biome.getDefaultTemperature() < Config.ruby_temperature.get()) && Config.generate_ruby.get()){
                        biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
                                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegisterBlocks.rubyOre.getDefaultState(), rubyOreVeinSize)).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( rubyOre)));
                    }
                }else{
                    if(biome.getDefaultTemperature() <= Config.ruby_temperature.get()){
                        biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
                                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegisterBlocks.rubyOre.getDefaultState(), rubyOreVeinSize)).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( rubyOre)));
                    }
                }
                if(Config.sapphire_temperature.get() == 0.2D){
                    if((biome.getCategory() == Biome.Category.TAIGA || biome.getCategory() == Biome.Category.OCEAN || biome.getCategory() == Biome.Category.ICY || biome.getTempCategory() == Biome.TempCategory.COLD || biome.getDefaultTemperature() < Config.sapphire_temperature.get()) && Config.generate_sapphire.get()) {
                        biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
                                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegisterBlocks.sapphireOre.getDefaultState(), sapphireOreVeinSize)).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( sapphireOre)));
                    }
                }else{
                    if(biome.getDefaultTemperature() <= Config.sapphire_temperature.get()){
                        biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
                                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegisterBlocks.sapphireOre.getDefaultState(), sapphireOreVeinSize)).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( sapphireOre)));
                    }
                }

            }
            if(Config.generate_Overworld_EXP_ORE.get()){
                biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                        new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), RegisterBlocks.overworldEXPOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( overworldexperienceOre)));
            }

        });
        if(Config.generate_topaz.get()){
            Biomes.NETHER.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, RegisterBlocks.topazOre.getDefaultState(), topazOreVeinSize)).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( topazOre)));
        }
        if(Config.generate_Nether_EXP_ORE.get()){
            Biomes.NETHER.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                    new ReplaceBlockConfig(Blocks.NETHERRACK.getDefaultState(), RegisterBlocks.netherEXPOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( netherexperienceOre)));
        }


        if(Config.generate_amethyst.get()){
            Biomes.THE_END.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                    new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.amethystOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( amethystOre)));
            Biomes.END_BARRENS.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                    new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.amethystOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( amethystOre)));
            Biomes.END_HIGHLANDS.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                    new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.amethystOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( amethystOre)));
            Biomes.END_MIDLANDS.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                    new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.amethystOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( amethystOre)));
            Biomes.SMALL_END_ISLANDS.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                    new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.amethystOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( amethystOre)));
        }
        if(Config.generate_End_EXP_ORE.get()){
            Biomes.THE_END.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                    new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.endEXPOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( endexperienceOre)));
            Biomes.END_BARRENS.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                    new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.endEXPOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( endexperienceOre)));
            Biomes.END_HIGHLANDS.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                    new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.endEXPOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( endexperienceOre)));
            Biomes.END_MIDLANDS.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                    new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.endEXPOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( endexperienceOre)));
            Biomes.SMALL_END_ISLANDS.addFeature(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(
                    new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), RegisterBlocks.endEXPOre.getDefaultState())).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_( endexperienceOre)));
        }
    }

}

package net.minecraft.world.biome;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.OptionalInt;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.AxisRotatingBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.ForestFlowerBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.PlainFlowerBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BasaltDeltasFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.BlockBlobConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateProvidingFeatureConfig;
import net.minecraft.world.gen.feature.BlockWithContextConfig;
import net.minecraft.world.gen.feature.ColumnConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeFungusConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.LiquidsConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.MultipleWithChanceRandomFeatureConfig;
import net.minecraft.world.gen.feature.NetherackBlobReplacementFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.feature.RuinedPortalFeature;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.ThreeLayerFeature;
import net.minecraft.world.gen.feature.TwoFeatureChoiceConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.feature.structure.BastionRemnantConfig;
import net.minecraft.world.gen.feature.structure.BastionRemnantsPieces;
import net.minecraft.world.gen.feature.structure.BuriedTreasureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.OceanRuinConfig;
import net.minecraft.world.gen.feature.structure.OceanRuinStructure;
import net.minecraft.world.gen.feature.structure.RuinedPortalStructure;
import net.minecraft.world.gen.feature.structure.ShipwreckConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BushFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.DarkOakFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.JungleFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.PineFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CaveEdgeConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidWithNoiseConfig;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class DefaultBiomeFeatures {
   private static final BlockState GRASS = Blocks.GRASS.getDefaultState();
   private static final BlockState FERN = Blocks.FERN.getDefaultState();
   private static final BlockState PODZOL = Blocks.PODZOL.getDefaultState();
   private static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
   private static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
   private static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.getDefaultState();
   private static final BlockState JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();
   private static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();
   private static final BlockState SPRUCE_LEAVES = Blocks.SPRUCE_LEAVES.getDefaultState();
   private static final BlockState ACACIA_LOG = Blocks.ACACIA_LOG.getDefaultState();
   private static final BlockState ACACIA_LEAVES = Blocks.ACACIA_LEAVES.getDefaultState();
   private static final BlockState BIRCH_LOG = Blocks.BIRCH_LOG.getDefaultState();
   private static final BlockState BIRCH_LEAVES = Blocks.BIRCH_LEAVES.getDefaultState();
   private static final BlockState DARK_OAK_LOG = Blocks.DARK_OAK_LOG.getDefaultState();
   private static final BlockState DARK_OAK_LEAVES = Blocks.DARK_OAK_LEAVES.getDefaultState();
   private static final BlockState WATER = Blocks.WATER.getDefaultState();
   private static final BlockState LAVA = Blocks.LAVA.getDefaultState();
   private static final BlockState DIRT = Blocks.DIRT.getDefaultState();
   private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
   private static final BlockState GRANITE = Blocks.GRANITE.getDefaultState();
   private static final BlockState DIORITE = Blocks.DIORITE.getDefaultState();
   private static final BlockState ANDESITE = Blocks.ANDESITE.getDefaultState();
   private static final BlockState COAL_ORE = Blocks.COAL_ORE.getDefaultState();
   private static final BlockState IRON_ORE = Blocks.IRON_ORE.getDefaultState();
   private static final BlockState GOLD_ORE = Blocks.GOLD_ORE.getDefaultState();
   private static final BlockState REDSTONE_ORE = Blocks.REDSTONE_ORE.getDefaultState();
   private static final BlockState DIAMOND_ORE = Blocks.DIAMOND_ORE.getDefaultState();
   private static final BlockState LAPIS_ORE = Blocks.LAPIS_ORE.getDefaultState();
   private static final BlockState STONE = Blocks.STONE.getDefaultState();
   private static final BlockState EMERALD_ORE = Blocks.EMERALD_ORE.getDefaultState();
   private static final BlockState INFESTED_STONE = Blocks.INFESTED_STONE.getDefaultState();
   private static final BlockState SAND = Blocks.SAND.getDefaultState();
   private static final BlockState CLAY = Blocks.CLAY.getDefaultState();
   private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
   private static final BlockState MOSSY_COBBLESTONE = Blocks.MOSSY_COBBLESTONE.getDefaultState();
   private static final BlockState LARGE_FERN = Blocks.LARGE_FERN.getDefaultState();
   private static final BlockState TALL_GRASS = Blocks.TALL_GRASS.getDefaultState();
   private static final BlockState LILAC = Blocks.LILAC.getDefaultState();
   private static final BlockState ROSE_BUSH = Blocks.ROSE_BUSH.getDefaultState();
   private static final BlockState PEONY = Blocks.PEONY.getDefaultState();
   private static final BlockState BROWN_MUSHROOM = Blocks.BROWN_MUSHROOM.getDefaultState();
   private static final BlockState RED_MUSHROOM = Blocks.RED_MUSHROOM.getDefaultState();
   private static final BlockState SEAGRASS = Blocks.SEAGRASS.getDefaultState();
   private static final BlockState PACKED_ICE = Blocks.PACKED_ICE.getDefaultState();
   private static final BlockState BLUE_ICE = Blocks.BLUE_ICE.getDefaultState();
   private static final BlockState LILY_OF_THE_VALLEY = Blocks.LILY_OF_THE_VALLEY.getDefaultState();
   private static final BlockState BLUE_ORCHID = Blocks.BLUE_ORCHID.getDefaultState();
   private static final BlockState POPPY = Blocks.POPPY.getDefaultState();
   private static final BlockState DANDELION = Blocks.DANDELION.getDefaultState();
   private static final BlockState DEAD_BUSH = Blocks.DEAD_BUSH.getDefaultState();
   private static final BlockState MELON = Blocks.MELON.getDefaultState();
   private static final BlockState PUMPKIN = Blocks.PUMPKIN.getDefaultState();
   private static final BlockState SWEET_BERRY_BUSH = Blocks.SWEET_BERRY_BUSH.getDefaultState().with(SweetBerryBushBlock.AGE, Integer.valueOf(3));
   private static final BlockState FIRE = Blocks.FIRE.getDefaultState();
   private static final BlockState field_235153_cd_ = Blocks.field_235335_bO_.getDefaultState();
   private static final BlockState NETHERRACK = Blocks.NETHERRACK.getDefaultState();
   private static final BlockState field_235154_cf_ = Blocks.field_235336_cN_.getDefaultState();
   private static final BlockState field_235155_cg_ = Blocks.field_235343_mB_.getDefaultState();
   private static final BlockState LILY_PAD = Blocks.LILY_PAD.getDefaultState();
   private static final BlockState SNOW = Blocks.SNOW.getDefaultState();
   private static final BlockState JACK_O_LATERN = Blocks.JACK_O_LANTERN.getDefaultState();
   private static final BlockState SUNFLOWER = Blocks.SUNFLOWER.getDefaultState();
   private static final BlockState CACTUS = Blocks.CACTUS.getDefaultState();
   private static final BlockState SUGAR_CANE = Blocks.SUGAR_CANE.getDefaultState();
   private static final BlockState RED_MUSHROOM_BLOCK = Blocks.RED_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));
   private static final BlockState BROWN_MUSHROOM_BLOCK = Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.UP, Boolean.valueOf(true)).with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));
   private static final BlockState MUSHROOM_STEM = Blocks.MUSHROOM_STEM.getDefaultState().with(HugeMushroomBlock.UP, Boolean.valueOf(false)).with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));
   private static final BlockState field_235156_cq_ = Blocks.field_235334_I_.getDefaultState();
   private static final BlockState field_235157_cr_ = Blocks.NETHER_QUARTZ_ORE.getDefaultState();
   private static final BlockState field_235158_cs_ = Blocks.field_235368_mh_.getDefaultState();
   private static final BlockState field_235159_ct_ = Blocks.field_235374_mn_.getDefaultState();
   private static final BlockState field_235160_cu_ = Blocks.NETHER_WART_BLOCK.getDefaultState();
   private static final BlockState field_235161_cv_ = Blocks.field_235377_mq_.getDefaultState();
   private static final BlockState field_235162_cw_ = Blocks.field_235383_mw_.getDefaultState();
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> field_235134_a_ = Structure.field_236366_b_.func_236391_a_(NoFeatureConfig.field_236559_b_);
   public static final StructureFeature<MineshaftConfig, ? extends Structure<MineshaftConfig>> field_235150_b_ = Structure.field_236367_c_.func_236391_a_(new MineshaftConfig((double)0.004F, MineshaftStructure.Type.NORMAL));
   public static final StructureFeature<MineshaftConfig, ? extends Structure<MineshaftConfig>> field_235152_c_ = Structure.field_236367_c_.func_236391_a_(new MineshaftConfig(0.004D, MineshaftStructure.Type.MESA));
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> field_235166_d_ = Structure.field_236368_d_.func_236391_a_(NoFeatureConfig.field_236559_b_);
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> field_235167_e_ = Structure.field_236369_e_.func_236391_a_(NoFeatureConfig.field_236559_b_);
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> field_235168_f_ = Structure.field_236370_f_.func_236391_a_(NoFeatureConfig.field_236559_b_);
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> field_235169_g_ = Structure.field_236371_g_.func_236391_a_(NoFeatureConfig.field_236559_b_);
   public static final StructureFeature<ShipwreckConfig, ? extends Structure<ShipwreckConfig>> field_235170_h_ = Structure.field_236373_i_.func_236391_a_(new ShipwreckConfig(false));
   public static final StructureFeature<ShipwreckConfig, ? extends Structure<ShipwreckConfig>> field_235171_i_ = Structure.field_236373_i_.func_236391_a_(new ShipwreckConfig(true));
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> field_235172_j_ = Structure.field_236374_j_.func_236391_a_(NoFeatureConfig.field_236559_b_);
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> field_235173_k_ = Structure.field_236375_k_.func_236391_a_(NoFeatureConfig.field_236559_b_);
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> field_235174_l_ = Structure.field_236376_l_.func_236391_a_(NoFeatureConfig.field_236559_b_);
   public static final StructureFeature<OceanRuinConfig, ? extends Structure<OceanRuinConfig>> field_235175_m_ = Structure.field_236377_m_.func_236391_a_(new OceanRuinConfig(OceanRuinStructure.Type.COLD, 0.3F, 0.9F));
   public static final StructureFeature<OceanRuinConfig, ? extends Structure<OceanRuinConfig>> field_235176_n_ = Structure.field_236377_m_.func_236391_a_(new OceanRuinConfig(OceanRuinStructure.Type.WARM, 0.3F, 0.9F));
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> field_235177_o_ = Structure.field_236378_n_.func_236391_a_(NoFeatureConfig.field_236559_b_);
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> field_235178_p_ = Structure.field_236382_r_.func_236391_a_(NoFeatureConfig.field_236559_b_);
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> field_235179_q_ = Structure.field_236379_o_.func_236391_a_(NoFeatureConfig.field_236559_b_);
   public static final StructureFeature<BuriedTreasureConfig, ? extends Structure<BuriedTreasureConfig>> field_235180_r_ = Structure.field_236380_p_.func_236391_a_(new BuriedTreasureConfig(0.01F));
   public static final StructureFeature<BastionRemnantConfig, ? extends Structure<BastionRemnantConfig>> field_235181_s_ = Structure.field_236383_s_.func_236391_a_(new BastionRemnantConfig(BastionRemnantsPieces.field_236257_a_));
   public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> field_235182_t_ = Structure.field_236381_q_.func_236391_a_(new VillageConfig(new ResourceLocation("village/plains/town_centers"), 6));
   public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> field_235183_u_ = Structure.field_236381_q_.func_236391_a_(new VillageConfig(new ResourceLocation("village/desert/town_centers"), 6));
   public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> field_235184_v_ = Structure.field_236381_q_.func_236391_a_(new VillageConfig(new ResourceLocation("village/savanna/town_centers"), 6));
   public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> field_235185_w_ = Structure.field_236381_q_.func_236391_a_(new VillageConfig(new ResourceLocation("village/snowy/town_centers"), 6));
   public static final StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> field_235186_x_ = Structure.field_236381_q_.func_236391_a_(new VillageConfig(new ResourceLocation("village/taiga/town_centers"), 6));
   public static final StructureFeature<RuinedPortalFeature, ? extends Structure<RuinedPortalFeature>> field_235187_y_ = Structure.field_236372_h_.func_236391_a_(new RuinedPortalFeature(RuinedPortalStructure.Location.STANDARD));
   public static final StructureFeature<RuinedPortalFeature, ? extends Structure<RuinedPortalFeature>> field_235188_z_ = Structure.field_236372_h_.func_236391_a_(new RuinedPortalFeature(RuinedPortalStructure.Location.DESERT));
   public static final StructureFeature<RuinedPortalFeature, ? extends Structure<RuinedPortalFeature>> field_235129_A_ = Structure.field_236372_h_.func_236391_a_(new RuinedPortalFeature(RuinedPortalStructure.Location.JUNGLE));
   public static final StructureFeature<RuinedPortalFeature, ? extends Structure<RuinedPortalFeature>> field_235130_B_ = Structure.field_236372_h_.func_236391_a_(new RuinedPortalFeature(RuinedPortalStructure.Location.SWAMP));
   public static final StructureFeature<RuinedPortalFeature, ? extends Structure<RuinedPortalFeature>> field_235131_C_ = Structure.field_236372_h_.func_236391_a_(new RuinedPortalFeature(RuinedPortalStructure.Location.MOUNTAIN));
   public static final StructureFeature<RuinedPortalFeature, ? extends Structure<RuinedPortalFeature>> field_235132_D_ = Structure.field_236372_h_.func_236391_a_(new RuinedPortalFeature(RuinedPortalStructure.Location.OCEAN));
   public static final StructureFeature<RuinedPortalFeature, ? extends Structure<RuinedPortalFeature>> field_235133_E_ = Structure.field_236372_h_.func_236391_a_(new RuinedPortalFeature(RuinedPortalStructure.Location.NETHER));
   public static final BaseTreeFeatureConfig OAK_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().build();
   private static final BeehiveTreeDecorator field_235163_cx_ = new BeehiveTreeDecorator(0.002F);
   private static final BeehiveTreeDecorator field_235164_cy_ = new BeehiveTreeDecorator(0.02F);
   private static final BeehiveTreeDecorator field_235165_cz_ = new BeehiveTreeDecorator(0.05F);
   public static final BaseTreeFeatureConfig field_230132_o_ = OAK_TREE_CONFIG.func_236685_a_(ImmutableList.of(field_235163_cx_));
   public static final BaseTreeFeatureConfig field_230133_p_ = OAK_TREE_CONFIG.func_236685_a_(ImmutableList.of(field_235164_cy_));
   public static final BaseTreeFeatureConfig OAK_TREE_WITH_MORE_BEEHIVES_CONFIG = OAK_TREE_CONFIG.func_236685_a_(ImmutableList.of(field_235165_cz_));
   public static final BaseTreeFeatureConfig JUNGLE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(JUNGLE_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(4, 8, 0), new TwoLayerFeature(1, 0, 1))).func_236703_a_(ImmutableList.of(new CocoaTreeDecorator(0.2F), TrunkVineTreeDecorator.field_236879_b_, LeaveVineTreeDecorator.field_236871_b_)).func_236700_a_().build();
   public static final BaseTreeFeatureConfig JUNGLE_SAPLING_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(JUNGLE_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(4, 8, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().build();
   public static final BaseTreeFeatureConfig PINE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new PineFoliagePlacer(1, 0, 1, 0, 3, 1), new StraightTrunkPlacer(6, 4, 0), new TwoLayerFeature(2, 0, 2))).func_236700_a_().build();
   public static final BaseTreeFeatureConfig SPRUCE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new SpruceFoliagePlacer(2, 1, 0, 2, 1, 1), new StraightTrunkPlacer(5, 2, 1), new TwoLayerFeature(2, 0, 2))).func_236700_a_().build();
   public static final BaseTreeFeatureConfig ACACIA_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ACACIA_LOG), new SimpleBlockStateProvider(ACACIA_LEAVES), new AcaciaFoliagePlacer(2, 0, 0, 0), new ForkyTrunkPlacer(5, 2, 2), new TwoLayerFeature(1, 0, 2))).func_236700_a_().build();
   public static final BaseTreeFeatureConfig BIRCH_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(5, 2, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().build();
   public static final BaseTreeFeatureConfig field_230129_h_ = BIRCH_TREE_CONFIG.func_236685_a_(ImmutableList.of(field_235163_cx_));
   public static final BaseTreeFeatureConfig field_230135_r_ = BIRCH_TREE_CONFIG.func_236685_a_(ImmutableList.of(field_235164_cy_));
   public static final BaseTreeFeatureConfig field_230136_s_ = BIRCH_TREE_CONFIG.func_236685_a_(ImmutableList.of(field_235165_cz_));
   public static final BaseTreeFeatureConfig field_230130_i_ = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(5, 2, 6), new TwoLayerFeature(1, 0, 1))).func_236700_a_().func_236703_a_(ImmutableList.of(field_235163_cx_)).build();
   public static final BaseTreeFeatureConfig SWAMP_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(3, 0, 0, 0, 3), new StraightTrunkPlacer(5, 3, 0), new TwoLayerFeature(1, 0, 1))).func_236701_a_(1).func_236703_a_(ImmutableList.of(LeaveVineTreeDecorator.field_236871_b_)).build();
   public static final BaseTreeFeatureConfig FANCY_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new FancyFoliagePlacer(2, 0, 4, 0, 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).func_236700_a_().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build();
   public static final BaseTreeFeatureConfig field_230131_m_ = FANCY_TREE_CONFIG.func_236685_a_(ImmutableList.of(field_235163_cx_));
   public static final BaseTreeFeatureConfig field_230134_q_ = FANCY_TREE_CONFIG.func_236685_a_(ImmutableList.of(field_235164_cy_));
   public static final BaseTreeFeatureConfig FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG = FANCY_TREE_CONFIG.func_236685_a_(ImmutableList.of(field_235165_cz_));
   public static final BaseTreeFeatureConfig JUNGLE_GROUND_BUSH_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BushFoliagePlacer(2, 0, 1, 0, 2), new StraightTrunkPlacer(1, 0, 0), new TwoLayerFeature(0, 0, 0))).func_236702_a_(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build();
   public static final BaseTreeFeatureConfig DARK_OAK_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(DARK_OAK_LOG), new SimpleBlockStateProvider(DARK_OAK_LEAVES), new DarkOakFoliagePlacer(0, 0, 0, 0), new DarkOakTrunkPlacer(6, 2, 1), new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty()))).func_236701_a_(Integer.MAX_VALUE).func_236702_a_(Heightmap.Type.MOTION_BLOCKING).func_236700_a_().build();
   public static final BaseTreeFeatureConfig MEGA_SPRUCE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new MegaPineFoliagePlacer(0, 0, 0, 0, 4, 13), new GiantTrunkPlacer(13, 2, 14), new TwoLayerFeature(1, 1, 2))).func_236703_a_(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(PODZOL)))).build();
   public static final BaseTreeFeatureConfig MEGA_PINE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new MegaPineFoliagePlacer(0, 0, 0, 0, 4, 3), new GiantTrunkPlacer(13, 2, 14), new TwoLayerFeature(1, 1, 2))).func_236703_a_(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(PODZOL)))).build();
   public static final BaseTreeFeatureConfig MEGA_JUNGLE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(JUNGLE_LEAVES), new JungleFoliagePlacer(2, 0, 0, 0, 2), new MegaJungleTrunkPlacer(10, 2, 19), new TwoLayerFeature(1, 1, 2))).func_236703_a_(ImmutableList.of(TrunkVineTreeDecorator.field_236879_b_, LeaveVineTreeDecorator.field_236871_b_)).build();
   public static final BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GRASS), SimpleBlockPlacer.field_236447_c_)).tries(32).build();
   public static final BlockClusterFeatureConfig TAIGA_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(GRASS, 1).addWeightedBlockstate(FERN, 4), SimpleBlockPlacer.field_236447_c_)).tries(32).build();
   public static final BlockClusterFeatureConfig LUSH_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(GRASS, 3).addWeightedBlockstate(FERN, 1), SimpleBlockPlacer.field_236447_c_)).blacklist(ImmutableSet.of(PODZOL)).tries(32).build();
   public static final BlockClusterFeatureConfig LILY_OF_THE_VALLEY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILY_OF_THE_VALLEY), SimpleBlockPlacer.field_236447_c_)).tries(64).build();
   public static final BlockClusterFeatureConfig BLUE_ORCHID_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BLUE_ORCHID), SimpleBlockPlacer.field_236447_c_)).tries(64).build();
   public static final BlockClusterFeatureConfig DEFAULT_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(POPPY, 2).addWeightedBlockstate(DANDELION, 1), SimpleBlockPlacer.field_236447_c_)).tries(64).build();
   public static final BlockClusterFeatureConfig PLAINS_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(PlainFlowerBlockStateProvider.field_236805_c_, SimpleBlockPlacer.field_236447_c_)).tries(64).build();
   public static final BlockClusterFeatureConfig FOREST_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(ForestFlowerBlockStateProvider.field_236802_c_, SimpleBlockPlacer.field_236447_c_)).tries(64).build();
   public static final BlockClusterFeatureConfig DEAD_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DEAD_BUSH), SimpleBlockPlacer.field_236447_c_)).tries(4).build();
   public static final BlockClusterFeatureConfig MELON_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MELON), SimpleBlockPlacer.field_236447_c_)).tries(64).whitelist(ImmutableSet.of(GRASS_BLOCK.getBlock())).replaceable().func_227317_b_().build();
   public static final BlockClusterFeatureConfig PUMPKIN_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PUMPKIN), SimpleBlockPlacer.field_236447_c_)).tries(64).whitelist(ImmutableSet.of(GRASS_BLOCK.getBlock())).func_227317_b_().build();
   public static final BlockClusterFeatureConfig SWEET_BERRY_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SWEET_BERRY_BUSH), SimpleBlockPlacer.field_236447_c_)).tries(64).whitelist(ImmutableSet.of(GRASS_BLOCK.getBlock())).func_227317_b_().build();
   public static final BlockClusterFeatureConfig field_235147_ap_ = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(FIRE), SimpleBlockPlacer.field_236447_c_)).tries(64).whitelist(ImmutableSet.of(NETHERRACK.getBlock())).func_227317_b_().build();
   public static final BlockClusterFeatureConfig field_235148_aq_ = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(field_235153_cd_), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(field_235154_cf_.getBlock())).func_227317_b_().build();
   public static final BlockClusterFeatureConfig LILY_PAD_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILY_PAD), SimpleBlockPlacer.field_236447_c_)).tries(10).build();
   public static final BlockClusterFeatureConfig RED_MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RED_MUSHROOM), SimpleBlockPlacer.field_236447_c_)).tries(64).func_227317_b_().build();
   public static final BlockClusterFeatureConfig BROWN_MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BROWN_MUSHROOM), SimpleBlockPlacer.field_236447_c_)).tries(64).func_227317_b_().build();
   public static final BlockClusterFeatureConfig field_235149_au_ = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(field_235155_cg_), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
   public static final BlockClusterFeatureConfig LILAC_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILAC), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
   public static final BlockClusterFeatureConfig ROSE_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ROSE_BUSH), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
   public static final BlockClusterFeatureConfig PEONY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PEONY), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
   public static final BlockClusterFeatureConfig SUNFLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SUNFLOWER), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
   public static final BlockClusterFeatureConfig TALL_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TALL_GRASS), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
   public static final BlockClusterFeatureConfig LARGE_FERN_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LARGE_FERN), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
   public static final BlockClusterFeatureConfig CACTUS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CACTUS), new ColumnBlockPlacer(1, 2))).tries(10).func_227317_b_().build();
   public static final BlockClusterFeatureConfig SUGAR_CANE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SUGAR_CANE), new ColumnBlockPlacer(2, 2))).tries(20).xSpread(4).ySpread(0).zSpread(4).func_227317_b_().requiresWater().build();
   public static final BlockStateProvidingFeatureConfig HAY_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new AxisRotatingBlockStateProvider(Blocks.HAY_BLOCK));
   public static final BlockStateProvidingFeatureConfig SNOW_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(SNOW));
   public static final BlockStateProvidingFeatureConfig MELON_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(MELON));
   public static final BlockStateProvidingFeatureConfig PUMPKIN_PILE_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(PUMPKIN, 19).addWeightedBlockstate(JACK_O_LATERN, 1));
   public static final BlockStateProvidingFeatureConfig BLUE_ICE_PILE_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(BLUE_ICE, 1).addWeightedBlockstate(PACKED_ICE, 5));
   public static final FluidState field_235135_aI_ = Fluids.WATER.getDefaultState();
   public static final FluidState field_235136_aJ_ = Fluids.LAVA.getDefaultState();
   public static final LiquidsConfig WATER_SPRING_CONFIG = new LiquidsConfig(field_235135_aI_, true, 4, 1, ImmutableSet.of(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE));
   public static final LiquidsConfig LAVA_SPRING_CONFIG = new LiquidsConfig(field_235136_aJ_, true, 4, 1, ImmutableSet.of(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE));
   public static final LiquidsConfig NETHER_SPRING_CONFIG = new LiquidsConfig(field_235136_aJ_, false, 4, 1, ImmutableSet.of(Blocks.NETHERRACK));
   public static final LiquidsConfig field_235137_aN_ = new LiquidsConfig(field_235136_aJ_, true, 4, 1, ImmutableSet.of(Blocks.NETHERRACK, Blocks.SOUL_SAND, Blocks.GRAVEL, Blocks.MAGMA_BLOCK, Blocks.field_235406_np_));
   public static final LiquidsConfig ENCLOSED_NETHER_SPRING_CONFIG = new LiquidsConfig(field_235136_aJ_, false, 5, 0, ImmutableSet.of(Blocks.NETHERRACK));
   public static final LiquidsConfig field_235138_aP_ = new LiquidsConfig(field_235136_aJ_, false, 4, 1, ImmutableSet.of(Blocks.SOUL_SAND));
   public static final LiquidsConfig field_235139_aQ_ = new LiquidsConfig(field_235136_aJ_, false, 5, 0, ImmutableSet.of(Blocks.SOUL_SAND));
   public static final ColumnConfig field_235140_aR_ = (new ColumnConfig.Builder()).func_236480_a_(1).func_236482_b_(1, 4).func_236479_a_();
   public static final ColumnConfig field_235141_aS_ = (new ColumnConfig.Builder()).func_236481_a_(2, 3).func_236482_b_(5, 10).func_236479_a_();
   public static final NetherackBlobReplacementFeature field_235142_aT_ = (new NetherackBlobReplacementFeature.Builder()).func_236624_a_(new Vector3i(3, 3, 3)).func_236626_b_(new Vector3i(7, 7, 7)).func_236623_a_(Blocks.NETHERRACK.getDefaultState()).func_236625_b_(Blocks.field_235337_cO_.getDefaultState()).func_236622_a_();
   public static final NetherackBlobReplacementFeature field_235143_aU_ = (new NetherackBlobReplacementFeature.Builder()).func_236624_a_(new Vector3i(3, 3, 3)).func_236626_b_(new Vector3i(7, 7, 7)).func_236623_a_(Blocks.NETHERRACK.getDefaultState()).func_236625_b_(Blocks.field_235406_np_.getDefaultState()).func_236622_a_();
   public static final BasaltDeltasFeature field_235144_aV_ = (new BasaltDeltasFeature.Builder()).func_236514_a_(Blocks.LAVA.getDefaultState()).func_236513_a_(3, 7).func_236515_a_(Blocks.MAGMA_BLOCK.getDefaultState(), 2).func_236512_a_();
   public static final BigMushroomFeatureConfig BIG_RED_MUSHROOM = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(RED_MUSHROOM_BLOCK), new SimpleBlockStateProvider(MUSHROOM_STEM), 2);
   public static final BigMushroomFeatureConfig BIG_BROWN_MUSHROOM = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(BROWN_MUSHROOM_BLOCK), new SimpleBlockStateProvider(MUSHROOM_STEM), 3);
   public static final BlockStateProvidingFeatureConfig field_235145_aY_ = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(Blocks.field_235343_mB_.getDefaultState(), 87).addWeightedBlockstate(Blocks.field_235382_mv_.getDefaultState(), 11).addWeightedBlockstate(Blocks.field_235373_mm_.getDefaultState(), 1));
   public static final BlockStateProvidingFeatureConfig field_235146_aZ_ = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(Blocks.field_235375_mo_.getDefaultState(), 85).addWeightedBlockstate(Blocks.field_235343_mB_.getDefaultState(), 1).addWeightedBlockstate(Blocks.field_235373_mm_.getDefaultState(), 13).addWeightedBlockstate(Blocks.field_235382_mv_.getDefaultState(), 1));
   public static final BlockStateProvidingFeatureConfig field_235151_ba_ = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(Blocks.field_235376_mp_.getDefaultState()));

   public static void func_235189_a_(Biome p_235189_0_) {
      p_235189_0_.func_235063_a_(field_235152_c_);
      p_235189_0_.func_235063_a_(field_235173_k_);
   }

   public static void func_235196_b_(Biome p_235196_0_) {
      p_235196_0_.func_235063_a_(field_235150_b_);
      p_235196_0_.func_235063_a_(field_235173_k_);
   }

   public static void func_235197_c_(Biome p_235197_0_) {
      p_235197_0_.func_235063_a_(field_235150_b_);
      p_235197_0_.func_235063_a_(field_235170_h_);
   }

   public static void addCarvers(Biome biomeIn) {
      biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
      biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02F)));
   }

   public static void addOceanCarvers(Biome biomeIn) {
      biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.06666667F)));
      biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02F)));
      biomeIn.addCarver(GenerationStage.Carving.LIQUID, Biome.createCarver(WorldCarver.UNDERWATER_CANYON, new ProbabilityConfig(0.02F)));
      biomeIn.addCarver(GenerationStage.Carving.LIQUID, Biome.createCarver(WorldCarver.UNDERWATER_CAVE, new ProbabilityConfig(0.06666667F)));
   }

   public static void addLakes(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.LAKES, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
      biomeIn.addFeature(GenerationStage.Decoration.LAKES, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(LAVA)).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
   }

   public static void addDesertLakes(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.LAKES, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(LAVA)).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
   }

   public static void addMonsterRooms(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Feature.MONSTER_ROOM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.DUNGEONS.configure(new ChanceConfig(8))));
   }

   public static void addStoneVariants(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, DIRT, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 256))));
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GRAVEL, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 256))));
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GRANITE, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, DIORITE, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ANDESITE, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
   }

   public static void addOres(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, COAL_ORE, 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, IRON_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GOLD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 32))));
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, REDSTONE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16))));
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, DIAMOND_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 16))));
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, LAPIS_ORE, 7)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 16, 16))));
   }

   public static void addExtraGoldOre(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GOLD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 32, 32, 80))));
   }

   public static void addExtraEmeraldOre(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(STONE, EMERALD_ORE)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addInfestedStone(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, INFESTED_STONE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 0, 0, 64))));
   }

   public static void addSedimentDisks(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(SAND, 7, 2, Lists.newArrayList(DIRT, GRASS_BLOCK))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(3))));
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(CLAY, 4, 1, Lists.newArrayList(DIRT, CLAY))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(GRAVEL, 6, 2, Lists.newArrayList(DIRT, GRASS_BLOCK))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
   }

   public static void addSwampClayDisks(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(CLAY, 4, 1, Lists.newArrayList(DIRT, CLAY))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
   }

   public static void addTaigaRocks(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(MOSSY_COBBLESTONE, 0)).withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(3))));
   }

   public static void addTaigaLargeFerns(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LARGE_FERN_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(7))));
   }

   public static void addSparseBerryBushes(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SWEET_BERRY_BUSH_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(12))));
   }

   public static void addBerryBushes(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SWEET_BERRY_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
   }

   public static void addBamboo(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BAMBOO.withConfiguration(new ProbabilityConfig(0.0F)).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(16))));
   }

   public static void addBambooJungleVegetation(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BAMBOO.withConfiguration(new ProbabilityConfig(0.2F)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(160, 80.0D, 0.3D, Heightmap.Type.WORLD_SURFACE_WG))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(FANCY_TREE_CONFIG).withChance(0.05F), Feature.field_236291_c_.withConfiguration(JUNGLE_GROUND_BUSH_CONFIG).withChance(0.15F), Feature.field_236291_c_.withConfiguration(MEGA_JUNGLE_TREE_CONFIG).withChance(0.7F)), Feature.RANDOM_PATCH.withConfiguration(LUSH_GRASS_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(30, 0.1F, 1))));
   }

   public static void addTaigaConifers(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(PINE_TREE_CONFIG).withChance(0.33333334F)), Feature.field_236291_c_.withConfiguration(SPRUCE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addScatteredOakTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F)), Feature.field_236291_c_.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
   }

   public static void addBirchTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.withConfiguration(field_230129_h_).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addForestTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(field_230129_h_).withChance(0.2F), Feature.field_236291_c_.withConfiguration(field_230131_m_).withChance(0.1F)), Feature.field_236291_c_.withConfiguration(field_230132_o_))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addTallBirchForestTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(field_230130_i_).withChance(0.5F)), Feature.field_236291_c_.withConfiguration(field_230129_h_))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addSavannaTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(ACACIA_TREE_CONFIG).withChance(0.8F)), Feature.field_236291_c_.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
   }

   public static void addShatteredSavannaTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(ACACIA_TREE_CONFIG).withChance(0.8F)), Feature.field_236291_c_.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
   }

   public static void addScatteredOakAndSpruceTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(SPRUCE_TREE_CONFIG).withChance(0.666F), Feature.field_236291_c_.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F)), Feature.field_236291_c_.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
   }

   public static void addOakAndSpruceTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(SPRUCE_TREE_CONFIG).withChance(0.666F), Feature.field_236291_c_.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F)), Feature.field_236291_c_.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));
   }

   public static void addJungleTreeForest(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F), Feature.field_236291_c_.withConfiguration(JUNGLE_GROUND_BUSH_CONFIG).withChance(0.5F), Feature.field_236291_c_.withConfiguration(MEGA_JUNGLE_TREE_CONFIG).withChance(0.33333334F)), Feature.field_236291_c_.withConfiguration(JUNGLE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(50, 0.1F, 1))));
   }

   public static void addOakAndJungleTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F), Feature.field_236291_c_.withConfiguration(JUNGLE_GROUND_BUSH_CONFIG).withChance(0.5F)), Feature.field_236291_c_.withConfiguration(JUNGLE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
   }

   public static void addSparseOakTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.withConfiguration(OAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
   }

   public static void addScatteredSpruceTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.withConfiguration(SPRUCE_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
   }

   public static void addGiantSpruceTaigaTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(MEGA_SPRUCE_TREE_CONFIG).withChance(0.33333334F), Feature.field_236291_c_.withConfiguration(PINE_TREE_CONFIG).withChance(0.33333334F)), Feature.field_236291_c_.withConfiguration(SPRUCE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addGiantTreeTaigaTrees(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(MEGA_SPRUCE_TREE_CONFIG).withChance(0.025641026F), Feature.field_236291_c_.withConfiguration(MEGA_PINE_TREE_CONFIG).withChance(0.30769232F), Feature.field_236291_c_.withConfiguration(PINE_TREE_CONFIG).withChance(0.33333334F)), Feature.field_236291_c_.withConfiguration(SPRUCE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addJungleGrass(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LUSH_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(25))));
   }

   public static void addTallGrass(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TALL_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(7))));
   }

   public static void addDenseGrass(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
   }

   public static void addVeryDenseGrass(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));
   }

   public static void addGrassAndDeadBushes(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));
   }

   public static void addDoubleFlowers(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_RANDOM_SELECTOR.withConfiguration(new MultipleWithChanceRandomFeatureConfig(ImmutableList.of(Feature.RANDOM_PATCH.withConfiguration(LILAC_CONFIG), Feature.RANDOM_PATCH.withConfiguration(ROSE_BUSH_CONFIG), Feature.RANDOM_PATCH.withConfiguration(PEONY_CONFIG), Feature.FLOWER.withConfiguration(LILY_OF_THE_VALLEY_CONFIG)), 0)).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(5))));
   }

   public static void addGrass(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
   }

   public static void addSwampVegetation(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.withConfiguration(SWAMP_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(BLUE_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(1))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LILY_PAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(8, 0.25F))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(8, 0.125F))));
   }

   public static void addHugeMushrooms(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_BOOLEAN_SELECTOR.withConfiguration(new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM.withConfiguration(BIG_RED_MUSHROOM), Feature.HUGE_BROWN_MUSHROOM.withConfiguration(BIG_BROWN_MUSHROOM))).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(1, 0.25F))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(1, 0.125F))));
   }

   public static void addOakTreesFlowersGrass(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withChance(0.33333334F)), Feature.field_236291_c_.withConfiguration(OAK_TREE_WITH_MORE_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(PLAINS_FLOWER_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 15, 4))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));
   }

   public static void addDeadBushes(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
   }

   public static void addTaigaGrassDeadBushesMushrooms(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TAIGA_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(7))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(3, 0.25F))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(3, 0.125F))));
   }

   public static void addDefaultFlowers(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DEFAULT_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
   }

   public static void addExtraDefaultFlowers(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DEFAULT_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));
   }

   public static void addSparseGrass(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
   }

   public static void addTaigaGrassAndMushrooms(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TAIGA_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(1, 0.25F))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(1, 0.125F))));
   }

   public static void addPlainsTallGrass(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TALL_GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 0, 7))));
   }

   public static void addMushrooms(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(4))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(8))));
   }

   public static void addReedsAndPumpkins(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SUGAR_CANE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PUMPKIN_PATCH_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(32))));
   }

   public static void addReedsPumpkinsCactus(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SUGAR_CANE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(13))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PUMPKIN_PATCH_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(32))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CACTUS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
   }

   public static void addJunglePlants(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(MELON_PATCH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.VINES.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHT_64.configure(new FrequencyConfig(50))));
   }

   public static void addExtraReedsPumpkinsCactus(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SUGAR_CANE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(60))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PUMPKIN_PATCH_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(32))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CACTUS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
   }

   public static void addExtraReedsAndPumpkins(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SUGAR_CANE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PUMPKIN_PATCH_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(32))));
   }

   public static void addDesertFeatures(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.DESERT_WELL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(1000))));
   }

   public static void func_235191_ai_(Biome p_235191_0_) {
      p_235191_0_.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(64))));
   }

   public static void addExtraKelp(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.KELP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(120, 80.0D, 0.0D, Heightmap.Type.OCEAN_FLOOR_WG))));
   }

   public static void addSeagrass(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(SEAGRASS, ImmutableList.of(STONE), ImmutableList.of(WATER), ImmutableList.of(WATER))).withPlacement(Placement.CARVING_MASK.configure(new CaveEdgeConfig(GenerationStage.Carving.LIQUID, 0.1F))));
   }

   public static void addTallSeagrassSparse(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(80, 0.3D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addTallSeagrassLush(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(80, 0.8D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addKelp(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.KELP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(80, 80.0D, 0.0D, Heightmap.Type.OCEAN_FLOOR_WG))));
   }

   public static void addSprings(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(WATER_SPRING_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(50, 8, 8, 256))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(LAVA_SPRING_CONFIG).withPlacement(Placement.COUNT_VERY_BIASED_RANGE.configure(new CountRangeConfig(20, 8, 16, 256))));
   }

   public static void addIcebergs(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.ICEBERG.withConfiguration(new BlockStateFeatureConfig(PACKED_ICE)).withPlacement(Placement.ICEBERG.configure(new ChanceConfig(16))));
      biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.ICEBERG.withConfiguration(new BlockStateFeatureConfig(BLUE_ICE)).withPlacement(Placement.ICEBERG.configure(new ChanceConfig(200))));
   }

   public static void addBlueIce(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.BLUE_ICE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.RANDOM_COUNT_RANGE.configure(new CountRangeConfig(20, 30, 32, 64))));
   }

   public static void addFreezeTopLayer(Biome biomeIn) {
      biomeIn.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Feature.FREEZE_TOP_LAYER.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
   }

   public static void func_235192_as_(Biome p_235192_0_) {
      p_235192_0_.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Blocks.GRAVEL.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 5, 0, 37))));
      p_235192_0_.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Blocks.field_235406_np_.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 5, 10, 37))));
      func_235190_a_(p_235192_0_, 10, 16);
      func_235193_at_(p_235192_0_);
   }

   public static void func_235190_a_(Biome p_235190_0_, int p_235190_1_, int p_235190_2_) {
      p_235190_0_.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, field_235156_cq_, 10)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(p_235190_1_, 10, 20, 128))));
      p_235190_0_.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, field_235157_cr_, 14)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(p_235190_2_, 10, 20, 128))));
   }

   public static void func_235193_at_(Biome p_235193_0_) {
      p_235193_0_.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236289_V_.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHER_ORE_REPLACEABLES, Blocks.field_235398_nh_.getDefaultState(), 3)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 16, 8))));
      p_235193_0_.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236289_V_.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHER_ORE_REPLACEABLES, Blocks.field_235398_nh_.getDefaultState(), 2)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 8, 16, 128))));
   }

   public static void func_235194_au_(Biome p_235194_0_) {
      p_235194_0_.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236281_L_.withConfiguration(HugeFungusConfig.field_236300_c_).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(8))));
      p_235194_0_.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236282_M_.withConfiguration(field_235145_aY_).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(6))));
   }

   public static void func_235195_av_(Biome p_235195_0_) {
      p_235195_0_.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236281_L_.withConfiguration(HugeFungusConfig.field_236302_e_).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(8))));
      p_235195_0_.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236282_M_.withConfiguration(field_235146_aZ_).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(5))));
      p_235195_0_.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236282_M_.withConfiguration(field_235151_ba_).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(4))));
      p_235195_0_.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236284_O_.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 128))));
   }
}
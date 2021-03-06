package net.minecraft.block.trees;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

public class SpruceTree extends BigTree {
   /**
    * Get a {@link net.minecraft.world.gen.feature.ConfiguredFeature} of tree
    */
   @Nullable
   protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
      return Feature.field_236291_c_.withConfiguration(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG);
   }

   /**
    * Get a {@link net.minecraft.world.gen.feature.ConfiguredFeature} of the huge variant of this tree
    */
   @Nullable
   protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
      return Feature.field_236291_c_.withConfiguration(p_225547_1_.nextBoolean() ? DefaultBiomeFeatures.MEGA_SPRUCE_TREE_CONFIG : DefaultBiomeFeatures.MEGA_PINE_TREE_CONFIG);
   }
}
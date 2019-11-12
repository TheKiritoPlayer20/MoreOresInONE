package net.minecraft.world.gen.feature.structure;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class PillagerOutpostConfig implements IFeatureConfig {
   public final double probability;

   public PillagerOutpostConfig(double probability) {
      this.probability = probability;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("probability"), ops.createDouble(this.probability))));
   }

   public static <T> PillagerOutpostConfig deserialize(Dynamic<T> p_214642_0_) {
      float f = p_214642_0_.get("probability").asFloat(0.0F);
      return new PillagerOutpostConfig((double)f);
   }
}
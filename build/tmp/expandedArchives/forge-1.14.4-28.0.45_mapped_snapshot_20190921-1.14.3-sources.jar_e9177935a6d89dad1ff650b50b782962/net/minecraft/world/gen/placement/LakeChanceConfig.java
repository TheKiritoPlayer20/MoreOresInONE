package net.minecraft.world.gen.placement;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

public class LakeChanceConfig implements IPlacementConfig {
   public final int chance;

   public LakeChanceConfig(int chance) {
      this.chance = chance;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("chance"), ops.createInt(this.chance))));
   }

   public static LakeChanceConfig deserialize(Dynamic<?> p_214730_0_) {
      int i = p_214730_0_.get("chance").asInt(0);
      return new LakeChanceConfig(i);
   }
}
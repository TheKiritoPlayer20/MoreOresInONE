package net.minecraft.world.gen.feature;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;

public class LiquidsConfig implements IFeatureConfig {
   public final IFluidState state;

   public LiquidsConfig(IFluidState state) {
      this.state = state;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("state"), IFluidState.serialize(ops, this.state).getValue())));
   }

   public static <T> LiquidsConfig deserialize(Dynamic<T> p_214677_0_) {
      IFluidState ifluidstate = p_214677_0_.get("state").map(IFluidState::deserialize).orElse(Fluids.EMPTY.getDefaultState());
      return new LiquidsConfig(ifluidstate);
   }
}
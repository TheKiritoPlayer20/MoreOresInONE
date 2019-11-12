package net.minecraft.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import java.util.function.Function;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;
import net.minecraft.world.IWorld;

public class HayBlockPileFeature extends BlockPileFeature {
   public HayBlockPileFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49867_1_) {
      super(p_i49867_1_);
   }

   protected BlockState getRandomBlock(IWorld worldIn) {
      Direction.Axis direction$axis = Direction.Axis.random(worldIn.getRandom());
      return Blocks.HAY_BLOCK.getDefaultState().with(RotatedPillarBlock.AXIS, direction$axis);
   }
}
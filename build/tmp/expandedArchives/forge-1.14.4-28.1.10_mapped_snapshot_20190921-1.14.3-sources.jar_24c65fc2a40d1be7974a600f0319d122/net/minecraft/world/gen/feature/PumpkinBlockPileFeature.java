package net.minecraft.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import java.util.function.Function;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.IWorld;

public class PumpkinBlockPileFeature extends BlockPileFeature {
   public PumpkinBlockPileFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51461_1_) {
      super(p_i51461_1_);
   }

   protected BlockState getRandomBlock(IWorld worldIn) {
      return worldIn.getRandom().nextFloat() < 0.95F ? Blocks.PUMPKIN.getDefaultState() : Blocks.JACK_O_LANTERN.getDefaultState();
   }
}
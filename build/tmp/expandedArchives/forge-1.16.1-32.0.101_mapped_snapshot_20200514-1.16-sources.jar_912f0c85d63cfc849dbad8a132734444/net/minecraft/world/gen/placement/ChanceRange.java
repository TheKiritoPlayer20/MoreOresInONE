package net.minecraft.world.gen.placement;

import com.mojang.serialization.Codec;
import java.util.Random;
import java.util.stream.Stream;
import net.minecraft.util.math.BlockPos;

public class ChanceRange extends SimplePlacement<ChanceRangeConfig> {
   public ChanceRange(Codec<ChanceRangeConfig> p_i232099_1_) {
      super(p_i232099_1_);
   }

   public Stream<BlockPos> getPositions(Random random, ChanceRangeConfig p_212852_2_, BlockPos pos) {
      if (random.nextFloat() < p_212852_2_.chance) {
         int i = random.nextInt(16) + pos.getX();
         int j = random.nextInt(16) + pos.getZ();
         int k = random.nextInt(p_212852_2_.top - p_212852_2_.topOffset) + p_212852_2_.bottomOffset;
         return Stream.of(new BlockPos(i, k, j));
      } else {
         return Stream.empty();
      }
   }
}
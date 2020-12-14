package net.minecraft.world.gen.placement;

import com.mojang.serialization.Codec;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.util.math.BlockPos;

public class DepthAverage extends SimplePlacement<DepthAverageConfig> {
   public DepthAverage(Codec<DepthAverageConfig> p_i232074_1_) {
      super(p_i232074_1_);
   }

   public Stream<BlockPos> getPositions(Random random, DepthAverageConfig p_212852_2_, BlockPos pos) {
      int i = p_212852_2_.count;
      int j = p_212852_2_.baseline;
      int k = p_212852_2_.spread;
      return IntStream.range(0, i).mapToObj((p_227439_4_) -> {
         int l = random.nextInt(16) + pos.getX();
         int i1 = random.nextInt(16) + pos.getZ();
         int j1 = random.nextInt(k) + random.nextInt(k) - k + j;
         return new BlockPos(l, j1, i1);
      });
   }
}
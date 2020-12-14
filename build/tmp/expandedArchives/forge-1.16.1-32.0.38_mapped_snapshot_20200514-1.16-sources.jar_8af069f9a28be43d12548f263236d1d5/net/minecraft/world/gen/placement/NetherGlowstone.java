package net.minecraft.world.gen.placement;

import com.mojang.serialization.Codec;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.util.math.BlockPos;

public class NetherGlowstone extends SimplePlacement<FrequencyConfig> {
   public NetherGlowstone(Codec<FrequencyConfig> p_i232102_1_) {
      super(p_i232102_1_);
   }

   public Stream<BlockPos> getPositions(Random random, FrequencyConfig p_212852_2_, BlockPos pos) {
      return IntStream.range(0, random.nextInt(random.nextInt(p_212852_2_.count) + 1)).mapToObj((p_215062_2_) -> {
         int i = random.nextInt(16) + pos.getX();
         int j = random.nextInt(16) + pos.getZ();
         int k = random.nextInt(120) + 4;
         return new BlockPos(i, k, j);
      });
   }
}
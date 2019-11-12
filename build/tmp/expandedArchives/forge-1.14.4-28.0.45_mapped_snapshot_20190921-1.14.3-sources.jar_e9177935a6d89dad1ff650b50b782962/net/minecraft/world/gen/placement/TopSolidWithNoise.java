package net.minecraft.world.gen.placement;

import com.mojang.datafixers.Dynamic;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;

public class TopSolidWithNoise extends Placement<TopSolidWithNoiseConfig> {
   public TopSolidWithNoise(Function<Dynamic<?>, ? extends TopSolidWithNoiseConfig> p_i51360_1_) {
      super(p_i51360_1_);
   }

   public Stream<BlockPos> getPositions(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generatorIn, Random random, TopSolidWithNoiseConfig configIn, BlockPos pos) {
      double d0 = Biome.INFO_NOISE.getValue((double)pos.getX() / configIn.noiseFactor, (double)pos.getZ() / configIn.noiseFactor);
      int i = (int)Math.ceil((d0 + configIn.noiseOffset) * (double)configIn.noiseToCountRatio);
      return IntStream.range(0, i).mapToObj((p_215065_4_) -> {
         int j = random.nextInt(16);
         int k = random.nextInt(16);
         int l = worldIn.getHeight(configIn.heightmap, pos.getX() + j, pos.getZ() + k);
         return new BlockPos(pos.getX() + j, l, pos.getZ() + k);
      });
   }
}
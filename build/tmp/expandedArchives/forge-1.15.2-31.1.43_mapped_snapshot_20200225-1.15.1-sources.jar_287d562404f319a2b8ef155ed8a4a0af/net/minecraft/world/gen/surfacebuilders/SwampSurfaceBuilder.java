package net.minecraft.world.gen.surfacebuilders;

import com.mojang.datafixers.Dynamic;
import java.util.Random;
import java.util.function.Function;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;

public class SwampSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
   public SwampSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51304_1_) {
      super(p_i51304_1_);
   }

   public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
      double d0 = Biome.INFO_NOISE.noiseAt((double)x * 0.25D, (double)z * 0.25D, false);
      if (d0 > 0.0D) {
         int i = x & 15;
         int j = z & 15;
         BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

         for(int k = startHeight; k >= 0; --k) {
            blockpos$mutable.setPos(i, k, j);
            if (!chunkIn.getBlockState(blockpos$mutable).isAir()) {
               if (k == 62 && chunkIn.getBlockState(blockpos$mutable).getBlock() != defaultFluid.getBlock()) {
                  chunkIn.setBlockState(blockpos$mutable, defaultFluid, false);
               }
               break;
            }
         }
      }

      SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
   }
}
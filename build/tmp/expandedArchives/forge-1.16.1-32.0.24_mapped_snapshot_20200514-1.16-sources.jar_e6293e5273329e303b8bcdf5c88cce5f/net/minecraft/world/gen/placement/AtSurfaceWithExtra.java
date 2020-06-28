package net.minecraft.world.gen.placement;

import com.mojang.serialization.Codec;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;

public class AtSurfaceWithExtra extends Placement<AtSurfaceWithExtraConfig> {
   public AtSurfaceWithExtra(Codec<AtSurfaceWithExtraConfig> p_i232081_1_) {
      super(p_i232081_1_);
   }

   public Stream<BlockPos> getPositions(IWorld worldIn, ChunkGenerator generatorIn, Random random, AtSurfaceWithExtraConfig configIn, BlockPos pos) {
      int i = configIn.count;
      if (random.nextFloat() < configIn.extraChance) {
         i += configIn.extraCount;
      }

      return IntStream.range(0, i).mapToObj((p_227444_3_) -> {
         int j = random.nextInt(16) + pos.getX();
         int k = random.nextInt(16) + pos.getZ();
         int l = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, j, k);
         return new BlockPos(j, l, k);
      });
   }
}
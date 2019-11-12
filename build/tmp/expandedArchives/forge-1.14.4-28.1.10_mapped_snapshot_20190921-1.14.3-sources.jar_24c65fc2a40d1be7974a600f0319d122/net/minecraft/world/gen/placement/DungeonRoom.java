package net.minecraft.world.gen.placement;

import com.mojang.datafixers.Dynamic;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;

public class DungeonRoom extends Placement<DungeonRoomConfig> {
   public DungeonRoom(Function<Dynamic<?>, ? extends DungeonRoomConfig> p_i51366_1_) {
      super(p_i51366_1_);
   }

   public Stream<BlockPos> getPositions(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generatorIn, Random random, DungeonRoomConfig configIn, BlockPos pos) {
      int i = configIn.chance;
      return IntStream.range(0, i).mapToObj((p_215055_3_) -> {
         int j = random.nextInt(16);
         int k = random.nextInt(generatorIn.getMaxHeight());
         int l = random.nextInt(16);
         return pos.add(j, k, l);
      });
   }
}
package net.minecraft.entity.ai.brain.sensor;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.longs.Long2LongMap;
import it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.PointOfInterestManager;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.server.ServerWorld;

public class NearestBedSensor extends Sensor<MobEntity> {
   private final Long2LongMap field_225471_a = new Long2LongOpenHashMap();
   private int field_225472_b;
   private long field_225473_c;

   public NearestBedSensor() {
      super(20);
   }

   public Set<MemoryModuleType<?>> getUsedMemories() {
      return ImmutableSet.of(MemoryModuleType.NEAREST_BED);
   }

   protected void update(ServerWorld p_212872_1_, MobEntity p_212872_2_) {
      if (p_212872_2_.isChild()) {
         this.field_225472_b = 0;
         this.field_225473_c = p_212872_1_.getGameTime() + (long)p_212872_1_.getRandom().nextInt(20);
         PointOfInterestManager pointofinterestmanager = p_212872_1_.func_217443_B();
         Predicate<BlockPos> predicate = (p_225469_1_) -> {
            long i = p_225469_1_.toLong();
            if (this.field_225471_a.containsKey(i)) {
               return false;
            } else if (++this.field_225472_b >= 5) {
               return false;
            } else {
               this.field_225471_a.put(i, this.field_225473_c + 40L);
               return true;
            }
         };
         Stream<BlockPos> stream = pointofinterestmanager.func_225399_a(PointOfInterestType.HOME.func_221045_c(), predicate, new BlockPos(p_212872_2_), 48, PointOfInterestManager.Status.ANY);
         Path path = p_212872_2_.getNavigator().func_225463_a(stream, PointOfInterestType.HOME.func_225478_d());
         if (path != null && path.func_224771_h()) {
            BlockPos blockpos = path.func_224770_k();
            Optional<PointOfInterestType> optional = pointofinterestmanager.func_219148_c(blockpos);
            if (optional.isPresent()) {
               p_212872_2_.getBrain().setMemory(MemoryModuleType.NEAREST_BED, blockpos);
            }
         } else if (this.field_225472_b < 5) {
            this.field_225471_a.long2LongEntrySet().removeIf((p_225470_1_) -> {
               return p_225470_1_.getLongValue() < this.field_225473_c;
            });
         }

      }
   }
}
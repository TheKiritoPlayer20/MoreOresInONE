package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.util.math.MathHelper;

public class OctavesNoiseGenerator implements INoiseGenerator {
   private final ImprovedNoiseGenerator[] octaves;

   public OctavesNoiseGenerator(Random seed, int octavesIn) {
      this.octaves = new ImprovedNoiseGenerator[octavesIn];

      for(int i = 0; i < octavesIn; ++i) {
         this.octaves[i] = new ImprovedNoiseGenerator(seed);
      }

   }

   public double func_205563_a(double p_205563_1_, double p_205563_3_, double p_205563_5_) {
      return this.func_215462_a(p_205563_1_, p_205563_3_, p_205563_5_, 0.0D, 0.0D, false);
   }

   public double func_215462_a(double p_215462_1_, double p_215462_3_, double p_215462_5_, double p_215462_7_, double p_215462_9_, boolean p_215462_11_) {
      double d0 = 0.0D;
      double d1 = 1.0D;

      for(ImprovedNoiseGenerator improvednoisegenerator : this.octaves) {
         d0 += improvednoisegenerator.func_215456_a(maintainPrecision(p_215462_1_ * d1), p_215462_11_ ? -improvednoisegenerator.yCoord : maintainPrecision(p_215462_3_ * d1), maintainPrecision(p_215462_5_ * d1), p_215462_7_ * d1, p_215462_9_ * d1) / d1;
         d1 /= 2.0D;
      }

      return d0;
   }

   public ImprovedNoiseGenerator getOctave(int p_215463_1_) {
      return this.octaves[p_215463_1_];
   }

   public static double maintainPrecision(double p_215461_0_) {
      return p_215461_0_ - (double)MathHelper.lfloor(p_215461_0_ / 3.3554432E7D + 0.5D) * 3.3554432E7D;
   }

   public double func_215460_a(double p_215460_1_, double p_215460_3_, double p_215460_5_, double p_215460_7_) {
      return this.func_215462_a(p_215460_1_, p_215460_3_, 0.0D, p_215460_5_, p_215460_7_, false);
   }
}
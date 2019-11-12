package net.minecraft.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;

public class MegaJungleFeature extends HugeTreesFeature<NoFeatureConfig> {
   public MegaJungleFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51483_1_, boolean p_i51483_2_, int p_i51483_3_, int p_i51483_4_, BlockState p_i51483_5_, BlockState p_i51483_6_) {
      super(p_i51483_1_, p_i51483_2_, p_i51483_3_, p_i51483_4_, p_i51483_5_, p_i51483_6_);
      setSapling((net.minecraftforge.common.IPlantable)Blocks.JUNGLE_SAPLING);
   }

   public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundsIn) {
      int i = this.getHeight(rand);
      if (!this.func_203427_a(worldIn, position, i)) {
         return false;
      } else {
         this.func_214601_d(worldIn, position.up(i), 2, boundsIn, changedBlocks);

         for(int j = position.getY() + i - 2 - rand.nextInt(4); j > position.getY() + i / 2; j -= 2 + rand.nextInt(4)) {
            float f = rand.nextFloat() * ((float)Math.PI * 2F);
            int k = position.getX() + (int)(0.5F + MathHelper.cos(f) * 4.0F);
            int l = position.getZ() + (int)(0.5F + MathHelper.sin(f) * 4.0F);

            for(int i1 = 0; i1 < 5; ++i1) {
               k = position.getX() + (int)(1.5F + MathHelper.cos(f) * (float)i1);
               l = position.getZ() + (int)(1.5F + MathHelper.sin(f) * (float)i1);
               this.setLogState(changedBlocks, worldIn, new BlockPos(k, j - 3 + i1 / 2, l), this.trunk, boundsIn);
            }

            int j2 = 1 + rand.nextInt(2);
            int j1 = j;

            for(int k1 = j - j2; k1 <= j1; ++k1) {
               int l1 = k1 - j1;
               this.func_222838_b(worldIn, new BlockPos(k, k1, l), 1 - l1, boundsIn, changedBlocks);
            }
         }

         for(int i2 = 0; i2 < i; ++i2) {
            BlockPos blockpos = position.up(i2);
            if (func_214587_a(worldIn, blockpos)) {
               this.setLogState(changedBlocks, worldIn, blockpos, this.trunk, boundsIn);
               if (i2 > 0) {
                  this.tryPlaceVines(worldIn, rand, blockpos.west(), VineBlock.EAST);
                  this.tryPlaceVines(worldIn, rand, blockpos.north(), VineBlock.SOUTH);
               }
            }

            if (i2 < i - 1) {
               BlockPos blockpos1 = blockpos.east();
               if (func_214587_a(worldIn, blockpos1)) {
                  this.setLogState(changedBlocks, worldIn, blockpos1, this.trunk, boundsIn);
                  if (i2 > 0) {
                     this.tryPlaceVines(worldIn, rand, blockpos1.east(), VineBlock.WEST);
                     this.tryPlaceVines(worldIn, rand, blockpos1.north(), VineBlock.SOUTH);
                  }
               }

               BlockPos blockpos2 = blockpos.south().east();
               if (func_214587_a(worldIn, blockpos2)) {
                  this.setLogState(changedBlocks, worldIn, blockpos2, this.trunk, boundsIn);
                  if (i2 > 0) {
                     this.tryPlaceVines(worldIn, rand, blockpos2.east(), VineBlock.WEST);
                     this.tryPlaceVines(worldIn, rand, blockpos2.south(), VineBlock.NORTH);
                  }
               }

               BlockPos blockpos3 = blockpos.south();
               if (func_214587_a(worldIn, blockpos3)) {
                  this.setLogState(changedBlocks, worldIn, blockpos3, this.trunk, boundsIn);
                  if (i2 > 0) {
                     this.tryPlaceVines(worldIn, rand, blockpos3.west(), VineBlock.EAST);
                     this.tryPlaceVines(worldIn, rand, blockpos3.south(), VineBlock.NORTH);
                  }
               }
            }
         }

         return true;
      }
   }

   private void tryPlaceVines(IWorldGenerationReader worldIn, Random random, BlockPos pos, BooleanProperty sideProperty) {
      if (random.nextInt(3) > 0 && isAir(worldIn, pos)) {
         this.setBlockState(worldIn, pos, Blocks.VINE.getDefaultState().with(sideProperty, Boolean.valueOf(true)));
      }

   }

   private void func_214601_d(IWorldGenerationReader worldIn, BlockPos p_214601_2_, int p_214601_3_, MutableBoundingBox p_214601_4_, Set<BlockPos> changedBlocks) {
      int i = 2;

      for(int j = -2; j <= 0; ++j) {
         this.func_222839_a(worldIn, p_214601_2_.up(j), p_214601_3_ + 1 - j, p_214601_4_, changedBlocks);
      }

   }
}
package net.minecraft.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HorseModel<T extends AbstractHorseEntity> extends AgeableModel<T> {
   protected final ModelRenderer field_217127_a;
   protected final ModelRenderer field_217128_b;
   private final ModelRenderer field_228262_f_;
   private final ModelRenderer field_228263_g_;
   private final ModelRenderer field_228264_h_;
   private final ModelRenderer field_228265_i_;
   private final ModelRenderer field_228266_j_;
   private final ModelRenderer field_228267_k_;
   private final ModelRenderer field_228268_l_;
   private final ModelRenderer field_228269_m_;
   private final ModelRenderer field_217133_j;
   private final ModelRenderer[] field_217134_k;
   private final ModelRenderer[] field_217135_l;

   public HorseModel(float p_i51065_1_) {
      super(true, 16.2F, 1.36F, 2.7272F, 2.0F, 20.0F);
      this.textureWidth = 64;
      this.textureHeight = 64;
      this.field_217127_a = new ModelRenderer(this, 0, 32);
      this.field_217127_a.func_228301_a_(-5.0F, -8.0F, -17.0F, 10.0F, 10.0F, 22.0F, 0.05F);
      this.field_217127_a.setRotationPoint(0.0F, 11.0F, 5.0F);
      this.field_217128_b = new ModelRenderer(this, 0, 35);
      this.field_217128_b.func_228300_a_(-2.05F, -6.0F, -2.0F, 4.0F, 12.0F, 7.0F);
      this.field_217128_b.rotateAngleX = ((float)Math.PI / 6F);
      ModelRenderer modelrenderer = new ModelRenderer(this, 0, 13);
      modelrenderer.func_228301_a_(-3.0F, -11.0F, -2.0F, 6.0F, 5.0F, 7.0F, p_i51065_1_);
      ModelRenderer modelrenderer1 = new ModelRenderer(this, 56, 36);
      modelrenderer1.func_228301_a_(-1.0F, -11.0F, 5.01F, 2.0F, 16.0F, 2.0F, p_i51065_1_);
      ModelRenderer modelrenderer2 = new ModelRenderer(this, 0, 25);
      modelrenderer2.func_228301_a_(-2.0F, -11.0F, -7.0F, 4.0F, 5.0F, 5.0F, p_i51065_1_);
      this.field_217128_b.addChild(modelrenderer);
      this.field_217128_b.addChild(modelrenderer1);
      this.field_217128_b.addChild(modelrenderer2);
      this.func_199047_a(this.field_217128_b);
      this.field_228262_f_ = new ModelRenderer(this, 48, 21);
      this.field_228262_f_.mirror = true;
      this.field_228262_f_.func_228301_a_(-3.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, p_i51065_1_);
      this.field_228262_f_.setRotationPoint(4.0F, 14.0F, 7.0F);
      this.field_228263_g_ = new ModelRenderer(this, 48, 21);
      this.field_228263_g_.func_228301_a_(-1.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, p_i51065_1_);
      this.field_228263_g_.setRotationPoint(-4.0F, 14.0F, 7.0F);
      this.field_228264_h_ = new ModelRenderer(this, 48, 21);
      this.field_228264_h_.mirror = true;
      this.field_228264_h_.func_228301_a_(-3.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, p_i51065_1_);
      this.field_228264_h_.setRotationPoint(4.0F, 6.0F, -12.0F);
      this.field_228265_i_ = new ModelRenderer(this, 48, 21);
      this.field_228265_i_.func_228301_a_(-1.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, p_i51065_1_);
      this.field_228265_i_.setRotationPoint(-4.0F, 6.0F, -12.0F);
      float f = 5.5F;
      this.field_228266_j_ = new ModelRenderer(this, 48, 21);
      this.field_228266_j_.mirror = true;
      this.field_228266_j_.func_228302_a_(-3.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, p_i51065_1_, p_i51065_1_ + 5.5F, p_i51065_1_);
      this.field_228266_j_.setRotationPoint(4.0F, 14.0F, 7.0F);
      this.field_228267_k_ = new ModelRenderer(this, 48, 21);
      this.field_228267_k_.func_228302_a_(-1.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, p_i51065_1_, p_i51065_1_ + 5.5F, p_i51065_1_);
      this.field_228267_k_.setRotationPoint(-4.0F, 14.0F, 7.0F);
      this.field_228268_l_ = new ModelRenderer(this, 48, 21);
      this.field_228268_l_.mirror = true;
      this.field_228268_l_.func_228302_a_(-3.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, p_i51065_1_, p_i51065_1_ + 5.5F, p_i51065_1_);
      this.field_228268_l_.setRotationPoint(4.0F, 6.0F, -12.0F);
      this.field_228269_m_ = new ModelRenderer(this, 48, 21);
      this.field_228269_m_.func_228302_a_(-1.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, p_i51065_1_, p_i51065_1_ + 5.5F, p_i51065_1_);
      this.field_228269_m_.setRotationPoint(-4.0F, 6.0F, -12.0F);
      this.field_217133_j = new ModelRenderer(this, 42, 36);
      this.field_217133_j.func_228301_a_(-1.5F, 0.0F, 0.0F, 3.0F, 14.0F, 4.0F, p_i51065_1_);
      this.field_217133_j.setRotationPoint(0.0F, -5.0F, 2.0F);
      this.field_217133_j.rotateAngleX = ((float)Math.PI / 6F);
      this.field_217127_a.addChild(this.field_217133_j);
      ModelRenderer modelrenderer3 = new ModelRenderer(this, 26, 0);
      modelrenderer3.func_228301_a_(-5.0F, -8.0F, -9.0F, 10.0F, 9.0F, 9.0F, 0.5F);
      this.field_217127_a.addChild(modelrenderer3);
      ModelRenderer modelrenderer4 = new ModelRenderer(this, 29, 5);
      modelrenderer4.func_228301_a_(2.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, p_i51065_1_);
      this.field_217128_b.addChild(modelrenderer4);
      ModelRenderer modelrenderer5 = new ModelRenderer(this, 29, 5);
      modelrenderer5.func_228301_a_(-3.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, p_i51065_1_);
      this.field_217128_b.addChild(modelrenderer5);
      ModelRenderer modelrenderer6 = new ModelRenderer(this, 32, 2);
      modelrenderer6.func_228301_a_(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, p_i51065_1_);
      modelrenderer6.rotateAngleX = (-(float)Math.PI / 6F);
      this.field_217128_b.addChild(modelrenderer6);
      ModelRenderer modelrenderer7 = new ModelRenderer(this, 32, 2);
      modelrenderer7.func_228301_a_(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, p_i51065_1_);
      modelrenderer7.rotateAngleX = (-(float)Math.PI / 6F);
      this.field_217128_b.addChild(modelrenderer7);
      ModelRenderer modelrenderer8 = new ModelRenderer(this, 1, 1);
      modelrenderer8.func_228301_a_(-3.0F, -11.0F, -1.9F, 6.0F, 5.0F, 6.0F, 0.2F);
      this.field_217128_b.addChild(modelrenderer8);
      ModelRenderer modelrenderer9 = new ModelRenderer(this, 19, 0);
      modelrenderer9.func_228301_a_(-2.0F, -11.0F, -4.0F, 4.0F, 5.0F, 2.0F, 0.2F);
      this.field_217128_b.addChild(modelrenderer9);
      this.field_217134_k = new ModelRenderer[]{modelrenderer3, modelrenderer4, modelrenderer5, modelrenderer8, modelrenderer9};
      this.field_217135_l = new ModelRenderer[]{modelrenderer6, modelrenderer7};
   }

   protected void func_199047_a(ModelRenderer p_199047_1_) {
      ModelRenderer modelrenderer = new ModelRenderer(this, 19, 16);
      modelrenderer.func_228301_a_(0.55F, -13.0F, 4.0F, 2.0F, 3.0F, 1.0F, -0.001F);
      ModelRenderer modelrenderer1 = new ModelRenderer(this, 19, 16);
      modelrenderer1.func_228301_a_(-2.55F, -13.0F, 4.0F, 2.0F, 3.0F, 1.0F, -0.001F);
      p_199047_1_.addChild(modelrenderer);
      p_199047_1_.addChild(modelrenderer1);
   }

   public void func_225597_a_(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
      boolean flag = p_225597_1_.isHorseSaddled();
      boolean flag1 = p_225597_1_.isBeingRidden();

      for(ModelRenderer modelrenderer : this.field_217134_k) {
         modelrenderer.showModel = flag;
      }

      for(ModelRenderer modelrenderer1 : this.field_217135_l) {
         modelrenderer1.showModel = flag1 && flag;
      }

      this.field_217127_a.rotationPointY = 11.0F;
   }

   public Iterable<ModelRenderer> func_225602_a_() {
      return ImmutableList.of(this.field_217128_b);
   }

   protected Iterable<ModelRenderer> func_225600_b_() {
      return ImmutableList.of(this.field_217127_a, this.field_228262_f_, this.field_228263_g_, this.field_228264_h_, this.field_228265_i_, this.field_228266_j_, this.field_228267_k_, this.field_228268_l_, this.field_228269_m_);
   }

   public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
      super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
      float f = MathHelper.func_226167_j_(entityIn.prevRenderYawOffset, entityIn.renderYawOffset, partialTick);
      float f1 = MathHelper.func_226167_j_(entityIn.prevRotationYawHead, entityIn.rotationYawHead, partialTick);
      float f2 = MathHelper.lerp(partialTick, entityIn.prevRotationPitch, entityIn.rotationPitch);
      float f3 = f1 - f;
      float f4 = f2 * ((float)Math.PI / 180F);
      if (f3 > 20.0F) {
         f3 = 20.0F;
      }

      if (f3 < -20.0F) {
         f3 = -20.0F;
      }

      if (limbSwingAmount > 0.2F) {
         f4 += MathHelper.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
      }

      float f5 = entityIn.getGrassEatingAmount(partialTick);
      float f6 = entityIn.getRearingAmount(partialTick);
      float f7 = 1.0F - f6;
      float f8 = entityIn.getMouthOpennessAngle(partialTick);
      boolean flag = entityIn.tailCounter != 0;
      float f9 = (float)entityIn.ticksExisted + partialTick;
      this.field_217128_b.rotationPointY = 4.0F;
      this.field_217128_b.rotationPointZ = -12.0F;
      this.field_217127_a.rotateAngleX = 0.0F;
      this.field_217128_b.rotateAngleX = ((float)Math.PI / 6F) + f4;
      this.field_217128_b.rotateAngleY = f3 * ((float)Math.PI / 180F);
      float f10 = entityIn.isInWater() ? 0.2F : 1.0F;
      float f11 = MathHelper.cos(f10 * limbSwing * 0.6662F + (float)Math.PI);
      float f12 = f11 * 0.8F * limbSwingAmount;
      float f13 = (1.0F - Math.max(f6, f5)) * (((float)Math.PI / 6F) + f4 + f8 * MathHelper.sin(f9) * 0.05F);
      this.field_217128_b.rotateAngleX = f6 * (0.2617994F + f4) + f5 * (2.1816616F + MathHelper.sin(f9) * 0.05F) + f13;
      this.field_217128_b.rotateAngleY = f6 * f3 * ((float)Math.PI / 180F) + (1.0F - Math.max(f6, f5)) * this.field_217128_b.rotateAngleY;
      this.field_217128_b.rotationPointY = f6 * -4.0F + f5 * 11.0F + (1.0F - Math.max(f6, f5)) * this.field_217128_b.rotationPointY;
      this.field_217128_b.rotationPointZ = f6 * -4.0F + f5 * -12.0F + (1.0F - Math.max(f6, f5)) * this.field_217128_b.rotationPointZ;
      this.field_217127_a.rotateAngleX = f6 * (-(float)Math.PI / 4F) + f7 * this.field_217127_a.rotateAngleX;
      float f14 = 0.2617994F * f6;
      float f15 = MathHelper.cos(f9 * 0.6F + (float)Math.PI);
      this.field_228264_h_.rotationPointY = 2.0F * f6 + 14.0F * f7;
      this.field_228264_h_.rotationPointZ = -6.0F * f6 - 10.0F * f7;
      this.field_228265_i_.rotationPointY = this.field_228264_h_.rotationPointY;
      this.field_228265_i_.rotationPointZ = this.field_228264_h_.rotationPointZ;
      float f16 = ((-(float)Math.PI / 3F) + f15) * f6 + f12 * f7;
      float f17 = ((-(float)Math.PI / 3F) - f15) * f6 - f12 * f7;
      this.field_228262_f_.rotateAngleX = f14 - f11 * 0.5F * limbSwingAmount * f7;
      this.field_228263_g_.rotateAngleX = f14 + f11 * 0.5F * limbSwingAmount * f7;
      this.field_228264_h_.rotateAngleX = f16;
      this.field_228265_i_.rotateAngleX = f17;
      this.field_217133_j.rotateAngleX = ((float)Math.PI / 6F) + limbSwingAmount * 0.75F;
      this.field_217133_j.rotationPointY = -5.0F + limbSwingAmount;
      this.field_217133_j.rotationPointZ = 2.0F + limbSwingAmount * 2.0F;
      if (flag) {
         this.field_217133_j.rotateAngleY = MathHelper.cos(f9 * 0.7F);
      } else {
         this.field_217133_j.rotateAngleY = 0.0F;
      }

      this.field_228266_j_.rotationPointY = this.field_228262_f_.rotationPointY;
      this.field_228266_j_.rotationPointZ = this.field_228262_f_.rotationPointZ;
      this.field_228266_j_.rotateAngleX = this.field_228262_f_.rotateAngleX;
      this.field_228267_k_.rotationPointY = this.field_228263_g_.rotationPointY;
      this.field_228267_k_.rotationPointZ = this.field_228263_g_.rotationPointZ;
      this.field_228267_k_.rotateAngleX = this.field_228263_g_.rotateAngleX;
      this.field_228268_l_.rotationPointY = this.field_228264_h_.rotationPointY;
      this.field_228268_l_.rotationPointZ = this.field_228264_h_.rotationPointZ;
      this.field_228268_l_.rotateAngleX = this.field_228264_h_.rotateAngleX;
      this.field_228269_m_.rotationPointY = this.field_228265_i_.rotationPointY;
      this.field_228269_m_.rotationPointZ = this.field_228265_i_.rotationPointZ;
      this.field_228269_m_.rotateAngleX = this.field_228265_i_.rotateAngleX;
      boolean flag1 = entityIn.isChild();
      this.field_228262_f_.showModel = !flag1;
      this.field_228263_g_.showModel = !flag1;
      this.field_228264_h_.showModel = !flag1;
      this.field_228265_i_.showModel = !flag1;
      this.field_228266_j_.showModel = flag1;
      this.field_228267_k_.showModel = flag1;
      this.field_228268_l_.showModel = flag1;
      this.field_228269_m_.showModel = flag1;
      this.field_217127_a.rotationPointY = flag1 ? 10.8F : 0.0F;
   }
}
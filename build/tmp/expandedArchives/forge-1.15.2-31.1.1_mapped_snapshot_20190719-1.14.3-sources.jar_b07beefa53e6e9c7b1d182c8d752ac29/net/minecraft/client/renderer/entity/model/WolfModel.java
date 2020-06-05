package net.minecraft.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WolfModel<T extends WolfEntity> extends TintedAgeableModel<T> {
   private final ModelRenderer head;
   private final ModelRenderer field_228298_b_;
   private final ModelRenderer body;
   private final ModelRenderer legBackRight;
   private final ModelRenderer legBackLeft;
   private final ModelRenderer legFrontRight;
   private final ModelRenderer legFrontLeft;
   private final ModelRenderer tail;
   private final ModelRenderer field_228299_l_;
   private final ModelRenderer mane;

   public WolfModel() {
      float f = 0.0F;
      float f1 = 13.5F;
      this.head = new ModelRenderer(this, 0, 0);
      this.head.setRotationPoint(-1.0F, 13.5F, -7.0F);
      this.field_228298_b_ = new ModelRenderer(this, 0, 0);
      this.field_228298_b_.func_228301_a_(-2.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F);
      this.head.addChild(this.field_228298_b_);
      this.body = new ModelRenderer(this, 18, 14);
      this.body.func_228301_a_(-3.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, 0.0F);
      this.body.setRotationPoint(0.0F, 14.0F, 2.0F);
      this.mane = new ModelRenderer(this, 21, 0);
      this.mane.func_228301_a_(-3.0F, -3.0F, -3.0F, 8.0F, 6.0F, 7.0F, 0.0F);
      this.mane.setRotationPoint(-1.0F, 14.0F, 2.0F);
      this.legBackRight = new ModelRenderer(this, 0, 18);
      this.legBackRight.func_228301_a_(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
      this.legBackRight.setRotationPoint(-2.5F, 16.0F, 7.0F);
      this.legBackLeft = new ModelRenderer(this, 0, 18);
      this.legBackLeft.func_228301_a_(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
      this.legBackLeft.setRotationPoint(0.5F, 16.0F, 7.0F);
      this.legFrontRight = new ModelRenderer(this, 0, 18);
      this.legFrontRight.func_228301_a_(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
      this.legFrontRight.setRotationPoint(-2.5F, 16.0F, -4.0F);
      this.legFrontLeft = new ModelRenderer(this, 0, 18);
      this.legFrontLeft.func_228301_a_(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
      this.legFrontLeft.setRotationPoint(0.5F, 16.0F, -4.0F);
      this.tail = new ModelRenderer(this, 9, 18);
      this.tail.setRotationPoint(-1.0F, 12.0F, 8.0F);
      this.field_228299_l_ = new ModelRenderer(this, 9, 18);
      this.field_228299_l_.func_228301_a_(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
      this.tail.addChild(this.field_228299_l_);
      this.field_228298_b_.setTextureOffset(16, 14).func_228301_a_(-2.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F);
      this.field_228298_b_.setTextureOffset(16, 14).func_228301_a_(2.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F);
      this.field_228298_b_.setTextureOffset(0, 10).func_228301_a_(-0.5F, 0.0F, -5.0F, 3.0F, 3.0F, 4.0F, 0.0F);
   }

   protected Iterable<ModelRenderer> func_225602_a_() {
      return ImmutableList.of(this.head);
   }

   protected Iterable<ModelRenderer> func_225600_b_() {
      return ImmutableList.of(this.body, this.legBackRight, this.legBackLeft, this.legFrontRight, this.legFrontLeft, this.tail, this.mane);
   }

   public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
      if (entityIn.isAngry()) {
         this.tail.rotateAngleY = 0.0F;
      } else {
         this.tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
      }

      if (entityIn.isSitting()) {
         this.mane.setRotationPoint(-1.0F, 16.0F, -3.0F);
         this.mane.rotateAngleX = 1.2566371F;
         this.mane.rotateAngleY = 0.0F;
         this.body.setRotationPoint(0.0F, 18.0F, 0.0F);
         this.body.rotateAngleX = ((float)Math.PI / 4F);
         this.tail.setRotationPoint(-1.0F, 21.0F, 6.0F);
         this.legBackRight.setRotationPoint(-2.5F, 22.7F, 2.0F);
         this.legBackRight.rotateAngleX = ((float)Math.PI * 1.5F);
         this.legBackLeft.setRotationPoint(0.5F, 22.7F, 2.0F);
         this.legBackLeft.rotateAngleX = ((float)Math.PI * 1.5F);
         this.legFrontRight.rotateAngleX = 5.811947F;
         this.legFrontRight.setRotationPoint(-2.49F, 17.0F, -4.0F);
         this.legFrontLeft.rotateAngleX = 5.811947F;
         this.legFrontLeft.setRotationPoint(0.51F, 17.0F, -4.0F);
      } else {
         this.body.setRotationPoint(0.0F, 14.0F, 2.0F);
         this.body.rotateAngleX = ((float)Math.PI / 2F);
         this.mane.setRotationPoint(-1.0F, 14.0F, -3.0F);
         this.mane.rotateAngleX = this.body.rotateAngleX;
         this.tail.setRotationPoint(-1.0F, 12.0F, 8.0F);
         this.legBackRight.setRotationPoint(-2.5F, 16.0F, 7.0F);
         this.legBackLeft.setRotationPoint(0.5F, 16.0F, 7.0F);
         this.legFrontRight.setRotationPoint(-2.5F, 16.0F, -4.0F);
         this.legFrontLeft.setRotationPoint(0.5F, 16.0F, -4.0F);
         this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
         this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
         this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
         this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
      }

      this.field_228298_b_.rotateAngleZ = entityIn.getInterestedAngle(partialTick) + entityIn.getShakeAngle(partialTick, 0.0F);
      this.mane.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.08F);
      this.body.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.16F);
      this.field_228299_l_.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.2F);
   }

   public void func_225597_a_(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
      this.head.rotateAngleX = p_225597_6_ * ((float)Math.PI / 180F);
      this.head.rotateAngleY = p_225597_5_ * ((float)Math.PI / 180F);
      this.tail.rotateAngleX = p_225597_4_;
   }
}
package net.minecraft.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Matrix3f;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class ArrowRenderer<T extends AbstractArrowEntity> extends EntityRenderer<T> {
   public ArrowRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn);
   }

   public void func_225623_a_(T p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
      p_225623_4_.func_227860_a_();
      p_225623_4_.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(MathHelper.lerp(p_225623_3_, p_225623_1_.prevRotationYaw, p_225623_1_.rotationYaw) - 90.0F));
      p_225623_4_.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(MathHelper.lerp(p_225623_3_, p_225623_1_.prevRotationPitch, p_225623_1_.rotationPitch)));
      int i = 0;
      float f = 0.0F;
      float f1 = 0.5F;
      float f2 = 0.0F;
      float f3 = 0.15625F;
      float f4 = 0.0F;
      float f5 = 0.15625F;
      float f6 = 0.15625F;
      float f7 = 0.3125F;
      float f8 = 0.05625F;
      float f9 = (float)p_225623_1_.arrowShake - p_225623_3_;
      if (f9 > 0.0F) {
         float f10 = -MathHelper.sin(f9 * 3.0F) * f9;
         p_225623_4_.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(f10));
      }

      p_225623_4_.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(45.0F));
      p_225623_4_.func_227862_a_(0.05625F, 0.05625F, 0.05625F);
      p_225623_4_.func_227861_a_(-4.0D, 0.0D, 0.0D);
      IVertexBuilder ivertexbuilder = p_225623_5_.getBuffer(RenderType.func_228638_b_(this.getEntityTexture(p_225623_1_)));
      MatrixStack.Entry matrixstack$entry = p_225623_4_.func_227866_c_();
      Matrix4f matrix4f = matrixstack$entry.func_227870_a_();
      Matrix3f matrix3f = matrixstack$entry.func_227872_b_();
      this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, p_225623_6_);
      this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, p_225623_6_);
      this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, -7, 2, 2, 0.15625F, 0.3125F, -1, 0, 0, p_225623_6_);
      this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, -7, 2, -2, 0.0F, 0.3125F, -1, 0, 0, p_225623_6_);
      this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, -7, 2, -2, 0.0F, 0.15625F, 1, 0, 0, p_225623_6_);
      this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, -7, 2, 2, 0.15625F, 0.15625F, 1, 0, 0, p_225623_6_);
      this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, -7, -2, 2, 0.15625F, 0.3125F, 1, 0, 0, p_225623_6_);
      this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, -7, -2, -2, 0.0F, 0.3125F, 1, 0, 0, p_225623_6_);

      for(int j = 0; j < 4; ++j) {
         p_225623_4_.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(90.0F));
         this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, p_225623_6_);
         this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, 8, -2, 0, 0.5F, 0.0F, 0, 1, 0, p_225623_6_);
         this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, 8, 2, 0, 0.5F, 0.15625F, 0, 1, 0, p_225623_6_);
         this.func_229039_a_(matrix4f, matrix3f, ivertexbuilder, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, p_225623_6_);
      }

      p_225623_4_.func_227865_b_();
      super.func_225623_a_(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
   }

   public void func_229039_a_(Matrix4f p_229039_1_, Matrix3f p_229039_2_, IVertexBuilder p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
      p_229039_3_.func_227888_a_(p_229039_1_, (float)p_229039_4_, (float)p_229039_5_, (float)p_229039_6_).func_225586_a_(255, 255, 255, 255).func_225583_a_(p_229039_7_, p_229039_8_).func_227891_b_(OverlayTexture.field_229196_a_).func_227886_a_(p_229039_12_).func_227887_a_(p_229039_2_, (float)p_229039_9_, (float)p_229039_11_, (float)p_229039_10_).endVertex();
   }
}
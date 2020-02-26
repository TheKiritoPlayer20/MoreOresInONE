package net.minecraft.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.layers.WitherAuraLayer;
import net.minecraft.client.renderer.entity.model.WitherModel;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WitherRenderer extends MobRenderer<WitherEntity, WitherModel<WitherEntity>> {
   private static final ResourceLocation INVULNERABLE_WITHER_TEXTURES = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
   private static final ResourceLocation WITHER_TEXTURES = new ResourceLocation("textures/entity/wither/wither.png");

   public WitherRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new WitherModel<>(0.0F), 1.0F);
      this.addLayer(new WitherAuraLayer(this));
   }

   protected int func_225624_a_(WitherEntity p_225624_1_, float p_225624_2_) {
      return 15;
   }

   public ResourceLocation getEntityTexture(WitherEntity entity) {
      int i = entity.getInvulTime();
      return i > 0 && (i > 80 || i / 5 % 2 != 1) ? INVULNERABLE_WITHER_TEXTURES : WITHER_TEXTURES;
   }

   protected void func_225620_a_(WitherEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
      float f = 2.0F;
      int i = p_225620_1_.getInvulTime();
      if (i > 0) {
         f -= ((float)i - p_225620_3_) / 220.0F * 0.5F;
      }

      p_225620_2_.func_227862_a_(f, f, f);
   }
}
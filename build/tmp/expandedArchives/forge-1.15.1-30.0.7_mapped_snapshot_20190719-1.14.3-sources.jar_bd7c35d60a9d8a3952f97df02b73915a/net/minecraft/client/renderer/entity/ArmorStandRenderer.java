package net.minecraft.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.ArmorStandArmorModel;
import net.minecraft.client.renderer.entity.model.ArmorStandModel;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArmorStandRenderer extends LivingRenderer<ArmorStandEntity, ArmorStandArmorModel> {
   public static final ResourceLocation TEXTURE_ARMOR_STAND = new ResourceLocation("textures/entity/armorstand/wood.png");

   public ArmorStandRenderer(EntityRendererManager manager) {
      super(manager, new ArmorStandModel(), 0.0F);
      this.addLayer(new BipedArmorLayer<>(this, new ArmorStandArmorModel(0.5F), new ArmorStandArmorModel(1.0F)));
      this.addLayer(new HeldItemLayer<>(this));
      this.addLayer(new ElytraLayer<>(this));
      this.addLayer(new HeadLayer<>(this));
   }

   public ResourceLocation getEntityTexture(ArmorStandEntity entity) {
      return TEXTURE_ARMOR_STAND;
   }

   protected void func_225621_a_(ArmorStandEntity p_225621_1_, MatrixStack p_225621_2_, float p_225621_3_, float p_225621_4_, float p_225621_5_) {
      p_225621_2_.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(180.0F - p_225621_4_));
      float f = (float)(p_225621_1_.world.getGameTime() - p_225621_1_.punchCooldown) + p_225621_5_;
      if (f < 5.0F) {
         p_225621_2_.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(MathHelper.sin(f / 1.5F * (float)Math.PI) * 3.0F));
      }

   }

   protected boolean canRenderName(ArmorStandEntity entity) {
      double d0 = this.renderManager.func_229099_b_(entity);
      float f = entity.isCrouching() ? 32.0F : 64.0F;
      return d0 >= (double)(f * f) ? false : entity.isCustomNameVisible();
   }

   protected boolean func_225622_a_(ArmorStandEntity p_225622_1_, boolean p_225622_2_) {
      return !p_225622_1_.isInvisible();
   }
}
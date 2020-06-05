package net.minecraft.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PufferFishBigModel<T extends Entity> extends SegmentedModel<T> {
   private final ModelRenderer field_203741_a;
   private final ModelRenderer field_203742_b;
   private final ModelRenderer field_203743_c;
   private final ModelRenderer field_203744_d;
   private final ModelRenderer field_203745_e;
   private final ModelRenderer field_203746_f;
   private final ModelRenderer field_203747_g;
   private final ModelRenderer field_203748_h;
   private final ModelRenderer field_203749_i;
   private final ModelRenderer field_203750_j;
   private final ModelRenderer field_203751_k;
   private final ModelRenderer field_203752_l;
   private final ModelRenderer field_203753_m;

   public PufferFishBigModel() {
      this.textureWidth = 32;
      this.textureHeight = 32;
      int i = 22;
      this.field_203741_a = new ModelRenderer(this, 0, 0);
      this.field_203741_a.func_228300_a_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F);
      this.field_203741_a.setRotationPoint(0.0F, 22.0F, 0.0F);
      this.field_203742_b = new ModelRenderer(this, 24, 0);
      this.field_203742_b.func_228300_a_(-2.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F);
      this.field_203742_b.setRotationPoint(-4.0F, 15.0F, -2.0F);
      this.field_203743_c = new ModelRenderer(this, 24, 3);
      this.field_203743_c.func_228300_a_(0.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F);
      this.field_203743_c.setRotationPoint(4.0F, 15.0F, -2.0F);
      this.field_203744_d = new ModelRenderer(this, 15, 17);
      this.field_203744_d.func_228300_a_(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 0.0F);
      this.field_203744_d.setRotationPoint(0.0F, 14.0F, -4.0F);
      this.field_203744_d.rotateAngleX = ((float)Math.PI / 4F);
      this.field_203745_e = new ModelRenderer(this, 14, 16);
      this.field_203745_e.func_228300_a_(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 1.0F);
      this.field_203745_e.setRotationPoint(0.0F, 14.0F, 0.0F);
      this.field_203746_f = new ModelRenderer(this, 23, 18);
      this.field_203746_f.func_228300_a_(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 0.0F);
      this.field_203746_f.setRotationPoint(0.0F, 14.0F, 4.0F);
      this.field_203746_f.rotateAngleX = (-(float)Math.PI / 4F);
      this.field_203747_g = new ModelRenderer(this, 5, 17);
      this.field_203747_g.func_228300_a_(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F);
      this.field_203747_g.setRotationPoint(-4.0F, 22.0F, -4.0F);
      this.field_203747_g.rotateAngleY = (-(float)Math.PI / 4F);
      this.field_203748_h = new ModelRenderer(this, 1, 17);
      this.field_203748_h.func_228300_a_(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F);
      this.field_203748_h.setRotationPoint(4.0F, 22.0F, -4.0F);
      this.field_203748_h.rotateAngleY = ((float)Math.PI / 4F);
      this.field_203749_i = new ModelRenderer(this, 15, 20);
      this.field_203749_i.func_228300_a_(-4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 0.0F);
      this.field_203749_i.setRotationPoint(0.0F, 22.0F, -4.0F);
      this.field_203749_i.rotateAngleX = (-(float)Math.PI / 4F);
      this.field_203751_k = new ModelRenderer(this, 15, 20);
      this.field_203751_k.func_228300_a_(-4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 0.0F);
      this.field_203751_k.setRotationPoint(0.0F, 22.0F, 0.0F);
      this.field_203750_j = new ModelRenderer(this, 15, 20);
      this.field_203750_j.func_228300_a_(-4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 0.0F);
      this.field_203750_j.setRotationPoint(0.0F, 22.0F, 4.0F);
      this.field_203750_j.rotateAngleX = ((float)Math.PI / 4F);
      this.field_203752_l = new ModelRenderer(this, 9, 17);
      this.field_203752_l.func_228300_a_(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F);
      this.field_203752_l.setRotationPoint(-4.0F, 22.0F, 4.0F);
      this.field_203752_l.rotateAngleY = ((float)Math.PI / 4F);
      this.field_203753_m = new ModelRenderer(this, 9, 17);
      this.field_203753_m.func_228300_a_(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F);
      this.field_203753_m.setRotationPoint(4.0F, 22.0F, 4.0F);
      this.field_203753_m.rotateAngleY = (-(float)Math.PI / 4F);
   }

   public Iterable<ModelRenderer> func_225601_a_() {
      return ImmutableList.of(this.field_203741_a, this.field_203742_b, this.field_203743_c, this.field_203744_d, this.field_203745_e, this.field_203746_f, this.field_203747_g, this.field_203753_m, this.field_203749_i, this.field_203751_k, this.field_203750_j, this.field_203752_l, this.field_203753_m);
   }

   public void func_225597_a_(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
      this.field_203742_b.rotateAngleZ = -0.2F + 0.4F * MathHelper.sin(p_225597_4_ * 0.2F);
      this.field_203743_c.rotateAngleZ = 0.2F - 0.4F * MathHelper.sin(p_225597_4_ * 0.2F);
   }
}
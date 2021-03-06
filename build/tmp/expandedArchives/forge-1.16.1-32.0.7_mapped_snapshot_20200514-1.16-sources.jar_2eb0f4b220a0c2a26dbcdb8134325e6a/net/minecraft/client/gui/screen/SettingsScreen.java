package net.minecraft.client.gui.screen;

import net.minecraft.client.GameSettings;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SettingsScreen extends Screen {
   protected final Screen parentScreen;
   protected final GameSettings gameSettings;

   public SettingsScreen(Screen p_i225930_1_, GameSettings p_i225930_2_, ITextComponent p_i225930_3_) {
      super(p_i225930_3_);
      this.parentScreen = p_i225930_1_;
      this.gameSettings = p_i225930_2_;
   }

   public void func_231164_f_() {
      this.field_230706_i_.gameSettings.saveOptions();
   }

   public void func_231175_as__() {
      this.field_230706_i_.displayGuiScreen(this.parentScreen);
   }
}
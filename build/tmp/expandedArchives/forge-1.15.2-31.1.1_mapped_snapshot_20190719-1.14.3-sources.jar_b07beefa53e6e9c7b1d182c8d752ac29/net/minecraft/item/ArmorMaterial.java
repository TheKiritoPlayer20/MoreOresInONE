package net.minecraft.item;

import java.util.function.Supplier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ArmorMaterial implements IArmorMaterial {
   LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {
      return Ingredient.fromItems(Items.LEATHER);
   }),
   CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, () -> {
      return Ingredient.fromItems(Items.IRON_INGOT);
   }),
   IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
      return Ingredient.fromItems(Items.IRON_INGOT);
   }),
   GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, () -> {
      return Ingredient.fromItems(Items.GOLD_INGOT);
   }),
   DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
      return Ingredient.fromItems(Items.DIAMOND);
   }),
   TURTLE("turtle", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0F, () -> {
      return Ingredient.fromItems(Items.SCUTE);
   });

   private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
   private final String name;
   private final int maxDamageFactor;
   private final int[] damageReductionAmountArray;
   private final int enchantability;
   private final SoundEvent soundEvent;
   private final float toughness;
   private final LazyValue<Ingredient> repairMaterial;

   private ArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float p_i48533_8_, Supplier<Ingredient> repairMaterialSupplier) {
      this.name = nameIn;
      this.maxDamageFactor = maxDamageFactorIn;
      this.damageReductionAmountArray = damageReductionAmountsIn;
      this.enchantability = enchantabilityIn;
      this.soundEvent = equipSoundIn;
      this.toughness = p_i48533_8_;
      this.repairMaterial = new LazyValue<>(repairMaterialSupplier);
   }

   public int getDurability(EquipmentSlotType slotIn) {
      return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
   }

   public int getDamageReductionAmount(EquipmentSlotType slotIn) {
      return this.damageReductionAmountArray[slotIn.getIndex()];
   }

   public int getEnchantability() {
      return this.enchantability;
   }

   public SoundEvent getSoundEvent() {
      return this.soundEvent;
   }

   public Ingredient getRepairMaterial() {
      return this.repairMaterial.getValue();
   }

   @OnlyIn(Dist.CLIENT)
   public String getName() {
      return this.name;
   }

   public float getToughness() {
      return this.toughness;
   }
}
package me.KG20.moreoresinone.Armor;

import me.KG20.moreoresinone.Init.RegisterItems;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class BasisArmorMaterial {

    public final static IArmorMaterial ruby = new ArmorMaterial(Constants.modid + ":ruby",33, new int[]{3, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F,() -> Ingredient.fromItems(RegisterItems.ruby));
    public final static IArmorMaterial sapphire = new ArmorMaterial(Constants.modid + ":sapphire", 33, new int[]{3, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F,() -> Ingredient.fromItems(RegisterItems.sapphire));
    public final static IArmorMaterial topaz = new ArmorMaterial(Constants.modid + ":topaz", 35, new int[]{3, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F,() -> Ingredient.fromItems(RegisterItems.topaz));
    public final static IArmorMaterial amethyst = new ArmorMaterial(Constants.modid + ":amethyst",40, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3F,() -> Ingredient.fromItems(RegisterItems.amethyst));

    private static class ArmorMaterial implements IArmorMaterial{

        private static final int[] Max_Damage_Array = new int[] {13,15,16,11};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyLoadBase<Ingredient> repairMaterial;

        public ArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> supplier) {
            this.name = name;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.toughness = toughness;
            this.repairMaterial = new LazyLoadBase<Ingredient>(supplier);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return Max_Damage_Array[slotIn.getIndex()] * maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }
    }


}

package me.KG20.moreoresinone.Armor;

import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Init.RegisterItems;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class BasisArmorMaterial {
                                                                                                                        //Boots,Leggings,Chestplate,Helmet
    public final static IArmorMaterial ruby = new ArmorMaterial(Constants.modid + ":ruby",33, new int[]{Config.ruby_boots_protection.get(), Config.ruby_leggings_protection.get(), Config.ruby_chestplate_protection.get(), Config.ruby_helmet_protection.get()}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Config.ruby_toughness.get(),0.0F, () -> Ingredient.fromItems(RegisterItems.ruby));
    public final static IArmorMaterial sapphire = new ArmorMaterial(Constants.modid + ":sapphire", 33, new int[]{Config.sapphire_boots_protection.get(), Config.sapphire_leggings_protection.get(), Config.sapphire_chestplate_protection.get(), Config.sapphire_helmet_protection.get()}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Config.sapphire_toughness.get(),0.0F,() -> Ingredient.fromItems(RegisterItems.sapphire));
    public final static IArmorMaterial topaz = new ArmorMaterial(Constants.modid + ":topaz", 35, new int[]{Config.topaz_boots_protection.get(), Config.topaz_leggings_protection.get(), Config.topaz_chestplate_protection.get(), Config.topaz_helmet_protection.get()}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Config.topaz_toughness.get(),0.0F,() -> Ingredient.fromItems(RegisterItems.topaz));
    public final static IArmorMaterial amethyst = new ArmorMaterial(Constants.modid + ":amethyst",40, new int[]{Config.amethyst_boots_protection.get(), Config.amethyst_leggings_protection.get(), Config.amethyst_chestplate_protection.get(), Config.amethyst_helmet_protection.get()}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Config.amethyst_toughness.get(),0.1F,() -> Ingredient.fromItems(RegisterItems.amethyst));
    public final static IArmorMaterial cryorite = new ArmorMaterial(Constants.modid + ":cryorite",17, new int[]{Config.cryorite_boots_protection.get(), Config.cryorite_leggings_protection.get(), Config.cryorite_chestplate_protection.get(), Config.cryorite_helmet_protection.get()}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, Config.cryorite_toughness.get(),0.0F,() -> Ingredient.fromItems(RegisterItems.cryorite));

    private static class ArmorMaterial implements IArmorMaterial{

        private static final int[] Max_Damage_Array = new int[] {13,15,16,11};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final float knockbackResistance;
        private final LazyValue<Ingredient> repairMaterial;

        public ArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, double toughness, float knockbackResistance, Supplier<Ingredient> supplier) {
            this.name = name;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.toughness = (float)toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairMaterial = new LazyValue<Ingredient>(supplier);
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

        @Override
        public float getKnockbackResistance() {
            return this.knockbackResistance;
        }
    }


}

package me.KG20.moreoresinone.Armor;

import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Init.RegisterItems;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class BasisArmorMaterial {
                                                                                                                        //Boots,Leggings,Chestplate,Helmet
    public final static ArmorMaterial ruby = new MaterialBasis(Constants.modid + ":ruby",33, new int[]{Config.ruby_boots_protection.get(), Config.ruby_leggings_protection.get(), Config.ruby_chestplate_protection.get(), Config.ruby_helmet_protection.get()}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, Config.ruby_toughness.get(),0.0F, () -> Ingredient.of(RegisterItems.ruby));
    public final static ArmorMaterial sapphire = new MaterialBasis(Constants.modid + ":sapphire", 33, new int[]{Config.sapphire_boots_protection.get(), Config.sapphire_leggings_protection.get(), Config.sapphire_chestplate_protection.get(), Config.sapphire_helmet_protection.get()}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, Config.sapphire_toughness.get(),0.0F,() -> Ingredient.of(RegisterItems.sapphire));
    public final static ArmorMaterial topaz = new MaterialBasis(Constants.modid + ":topaz", 35, new int[]{Config.topaz_boots_protection.get(), Config.topaz_leggings_protection.get(), Config.topaz_chestplate_protection.get(), Config.topaz_helmet_protection.get()}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, Config.topaz_toughness.get(),0.0F,() -> Ingredient.of(RegisterItems.topaz));
    public final static ArmorMaterial corundum = new MaterialBasis(Constants.modid + ":corundum",40, new int[]{Config.corundum_boots_protection.get(), Config.corundum_leggings_protection.get(), Config.corundum_chestplate_protection.get(), Config.corundum_helmet_protection.get()}, 15, SoundEvents.ARMOR_EQUIP_DIAMOND, Config.corundum_toughness.get(),0.1F,() -> Ingredient.of(RegisterItems.corundum));
    public final static ArmorMaterial cryorite = new MaterialBasis(Constants.modid + ":cryorite",17, new int[]{Config.cryorite_boots_protection.get(), Config.cryorite_leggings_protection.get(), Config.cryorite_chestplate_protection.get(), Config.cryorite_helmet_protection.get()}, 15, SoundEvents.ARMOR_EQUIP_IRON, Config.cryorite_toughness.get(),0.0F,() -> Ingredient.of(RegisterItems.cryorite));

    private static class MaterialBasis implements ArmorMaterial {

        private static final int[] HEALTH_PER_SLOT = new int[] {13,15,16,11};
        private final String name;
        private final int durabilityMultiplier;
        private final int[] slotProtections;
        private final int enchantmentValue;
        private final SoundEvent sound;
        private final float toughness;
        private final float knockbackResistance;
        private final LazyLoadedValue<Ingredient> repairIngredient;

        public MaterialBasis(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, double toughness, float knockbackResistance, Supplier<Ingredient> supplier) {
            this.name = name;
            this.durabilityMultiplier = maxDamageFactor;
            this.slotProtections = damageReductionAmountArray;
            this.enchantmentValue = enchantability;
            this.sound = soundEvent;
            this.toughness = (float)toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairIngredient = new LazyLoadedValue(supplier);
        }

        @Override
        public int getDurabilityForSlot(EquipmentSlot p_40484_) {
            return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
        }

        @Override
        public int getDefenseForSlot(EquipmentSlot slotIn) {
            return this.slotProtections[slotIn.getIndex()];
        }

        @Override
        public int getEnchantmentValue() {
            return enchantmentValue;
        }

        @Override
        public SoundEvent getEquipSound() {
            return sound;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return (Ingredient)this.repairIngredient.get();
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

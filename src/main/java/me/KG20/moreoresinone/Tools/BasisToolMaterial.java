package me.KG20.moreoresinone.Tools;


import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Init.RegisterItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

import java.util.function.Supplier;

public class BasisToolMaterial {

    public static final IItemTier ruby = new ToolMaterial(3, Config.durabilitiy_ruby.get(), 9.5F, 3.5F, 10, () -> Ingredient.fromItems(RegisterItems.ruby));
    public static final IItemTier sapphire = new ToolMaterial(3, Config.durabilitiy_sapphire.get(), 9.5F, 3.5F, 10, () -> Ingredient.fromItems(RegisterItems.sapphire));
    public static final IItemTier topaz = new ToolMaterial(4, Config.durabilitiy_topaz.get(),10F, 4F, 12, () -> Ingredient.fromItems(RegisterItems.topaz));
    public static final IItemTier amethyst = new ToolMaterial(4, Config.durabilitiy_amethyst.get(), 24F, 4.5F, 15, () -> Ingredient.fromItems(RegisterItems.amethyst));


    private static class ToolMaterial implements IItemTier{

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyLoadBase<Ingredient> repair;

        public ToolMaterial(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> supplier) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repair = new LazyLoadBase<Ingredient>(supplier);
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repair.getValue();
        }
    }


}

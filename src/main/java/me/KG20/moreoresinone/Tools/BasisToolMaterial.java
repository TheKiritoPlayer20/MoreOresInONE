package me.KG20.moreoresinone.Tools;

import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Init.RegisterItems;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import java.util.function.Supplier;

public class BasisToolMaterial {

    public static final Tier ruby = new ToolMaterial(3, Config.durabilitiy_ruby.get(), 9.5F, Config.attackdamage_ruby.get(), 10, () -> Ingredient.of(RegisterItems.ruby));
    public static final Tier sapphire = new ToolMaterial(3, Config.durabilitiy_sapphire.get(), 9.5F, Config.attackdamage_sapphire.get(), 10, () -> Ingredient.of(RegisterItems.sapphire));
    public static final Tier cryorite = new ToolMaterial(2, Config.durabilitiy_cryorite.get(), 7.0F, Config.attackdamage_cryorite.get(), 15, () -> Ingredient.of(RegisterItems.cryorite));
    public static final Tier topaz = new ToolMaterial(4, Config.durabilitiy_topaz.get(),10F, Config.attackdamage_topaz.get(), 12, () -> Ingredient.of(RegisterItems.topaz));
    public static final Tier amethyst = new ToolMaterial(4, Config.durabilitiy_amethyst.get(), 24F, Config.attackdamage_amethyst.get(), 15, () -> Ingredient.of(RegisterItems.amethyst));


    private static class ToolMaterial implements Tier {

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyLoadedValue<Ingredient> repair;

        public ToolMaterial(int harvestLevel, int maxUses, float efficiency, double attackDamage, int enchantability, Supplier<Ingredient> supplier) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = (float)attackDamage;
            this.enchantability = enchantability;
            this.repair = new LazyLoadedValue<Ingredient>(supplier);
        }

        @Override
        public int getUses() {
            return maxUses;
        }

        @Override
        public float getSpeed() {
            return efficiency;
        }

        @Override
        public float getAttackDamageBonus() {
            return attackDamage;
        }

        @Override
        public int getLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantmentValue() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return (Ingredient)this.repair.get();
        }
    }


}

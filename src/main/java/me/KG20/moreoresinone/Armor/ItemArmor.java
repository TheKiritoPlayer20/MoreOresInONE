package me.KG20.moreoresinone.Armor;

import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Init.RegisterArmor;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemArmor extends ArmorItem {


    public ItemArmor(ArmorMaterial materialIn, EquipmentSlot slots, Properties properties) {
        super(materialIn, slots, properties);

    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        ItemArmor topaz_Helmet = RegisterArmor.topazHelmet;
        ItemArmor topaz_Chestplate = RegisterArmor.topazChestplate;
        ItemArmor topaz_Leggings = RegisterArmor.topazLeggings;
        ItemArmor topaz_Boots = RegisterArmor.topazBoots;
        Player player;
        if(wearer instanceof  Player){
            player = (Player) wearer;
        }else{
            return false;
        }
        if (player.getItemBySlot(EquipmentSlot.FEET).getItem().equals(topaz_Boots) && player.getItemBySlot(EquipmentSlot.LEGS).getItem().equals(topaz_Leggings) &&
                player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(topaz_Chestplate) && player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(topaz_Helmet)) {
            return true;
        }else{
            return false;
        }
    }



    @Override
    public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
        return stack.getItem() == RegisterArmor.amethystHelmet ? true : false;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        ItemArmor amethyst_Helmet = RegisterArmor.amethystHelmet;
        ItemArmor amethyst_Chestplate = RegisterArmor.amethystChestplate;
        ItemArmor amethyst_Leggings = RegisterArmor.amethystLeggings;
        ItemArmor amethyst_Boots = RegisterArmor.amethystBoots;

        ItemArmor topaz_Helmet = RegisterArmor.topazHelmet;
        ItemArmor topaz_Chestplate = RegisterArmor.topazChestplate;
        ItemArmor topaz_Leggings = RegisterArmor.topazLeggings;
        ItemArmor topaz_Boots = RegisterArmor.topazBoots;

        if(Config.enable_statuseffects.get()) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem().equals(amethyst_Boots) && player.getItemBySlot(EquipmentSlot.LEGS).getItem().equals(amethyst_Leggings) &&
                    player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(amethyst_Chestplate) && player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(amethyst_Helmet)) {
                player.addEffect(new MobEffectInstance(MobEffect.byId(12), 20, 0));
                player.addEffect(new MobEffectInstance(MobEffect.byId(11), 20, 0));
            }

            if (player.getItemBySlot(EquipmentSlot.FEET).getItem().equals(topaz_Boots) && player.getItemBySlot(EquipmentSlot.LEGS).getItem().equals(topaz_Leggings) &&
                    player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(topaz_Chestplate) && player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(topaz_Helmet)) {
                player.addEffect(new MobEffectInstance(MobEffect.byId(12), 20, 0));
            }
        }

    }

}

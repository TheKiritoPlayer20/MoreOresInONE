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
        return stack.getItem() == RegisterArmor.corundumHelmet;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        ItemArmor corundum_Helmet = RegisterArmor.corundumHelmet;
        ItemArmor corundum_Chestplate = RegisterArmor.corundumChestplate;
        ItemArmor corundum_Leggings = RegisterArmor.corundumLeggings;
        ItemArmor corundum_Boots = RegisterArmor.corundumBoots;

        ItemArmor topaz_Helmet = RegisterArmor.topazHelmet;
        ItemArmor topaz_Chestplate = RegisterArmor.topazChestplate;
        ItemArmor topaz_Leggings = RegisterArmor.topazLeggings;
        ItemArmor topaz_Boots = RegisterArmor.topazBoots;

        if(Config.enable_statuseffects.get()) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem().equals(corundum_Boots) && player.getItemBySlot(EquipmentSlot.LEGS).getItem().equals(corundum_Leggings) &&
                    player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(corundum_Chestplate) && player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(corundum_Helmet)) {
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

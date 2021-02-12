package me.KG20.moreoresinone.Armor;

import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Init.RegisterArmor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.*;
import net.minecraft.world.World;

public class ItemArmor extends ArmorItem {


    public ItemArmor(IArmorMaterial materialIn, EquipmentSlotType slots, Properties properties) {
        super(materialIn, slots, properties);

    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        ItemArmor topaz_Helmet = RegisterArmor.topazHelmet;
        ItemArmor topaz_Chestplate = RegisterArmor.topazChestplate;
        ItemArmor topaz_Leggings = RegisterArmor.topazLeggings;
        ItemArmor topaz_Boots = RegisterArmor.topazBoots;
        PlayerEntity player;
        if(wearer instanceof  PlayerEntity){
            player = (PlayerEntity) wearer;
        }else{
            return false;
        }
        if (player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(topaz_Boots) && player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(topaz_Leggings) &&
                player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(topaz_Chestplate) && player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(topaz_Helmet)) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isEnderMask(ItemStack stack, PlayerEntity player, EndermanEntity endermanEntity) {
        return stack.getItem() == RegisterArmor.amethystHelmet ? true : false;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        ItemArmor amethyst_Helmet = RegisterArmor.amethystHelmet;
        ItemArmor amethyst_Chestplate = RegisterArmor.amethystChestplate;
        ItemArmor amethyst_Leggings = RegisterArmor.amethystLeggings;
        ItemArmor amethyst_Boots = RegisterArmor.amethystBoots;

        ItemArmor topaz_Helmet = RegisterArmor.topazHelmet;
        ItemArmor topaz_Chestplate = RegisterArmor.topazChestplate;
        ItemArmor topaz_Leggings = RegisterArmor.topazLeggings;
        ItemArmor topaz_Boots = RegisterArmor.topazBoots;

        if(Config.enable_statuseffects.get()) {
            if (player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(amethyst_Boots) && player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(amethyst_Leggings) &&
                    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(amethyst_Chestplate) && player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(amethyst_Helmet)) {
                player.addPotionEffect(new EffectInstance(Effect.get(12), 20, 0));
                player.addPotionEffect(new EffectInstance(Effect.get(11), 20, 0));
            }

            if (player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(topaz_Boots) && player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(topaz_Leggings) &&
                    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(topaz_Chestplate) && player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(topaz_Helmet)) {
                player.addPotionEffect(new EffectInstance(Effect.get(12), 20, 0));
            }
        }

    }

}

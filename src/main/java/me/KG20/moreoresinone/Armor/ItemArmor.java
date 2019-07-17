package me.KG20.moreoresinone.Armor;

import me.KG20.moreoresinone.Init.CreativeTabs;
import me.KG20.moreoresinone.Init.RegisterItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.*;
import net.minecraft.world.World;

public class ItemArmor extends ArmorItem {


    public ItemArmor(IArmorMaterial materialIn, EquipmentSlotType slots) {
        super(materialIn, slots, new Properties());
    }

}

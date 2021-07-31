package me.KG20.moreoresinone.Tools;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ToolType;

public class Pickaxe extends PickaxeItem {

    public Pickaxe(Tier material, Properties properties) {
        super(material, 1, -2.8F, properties.addToolType(ToolType.PICKAXE, material.getLevel()));
    }

}

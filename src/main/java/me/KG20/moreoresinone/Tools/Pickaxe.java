package me.KG20.moreoresinone.Tools;

import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;

public class Pickaxe extends PickaxeItem {

    public Pickaxe(IItemTier material, Properties properties) {
        super(material, 1, -2.8F, properties.addToolType(ToolType.PICKAXE, material.getHarvestLevel()));
    }

}

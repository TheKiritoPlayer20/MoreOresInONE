package me.KG20.moreoresinone.Tools;

import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;

public class Axe extends AxeItem {

    public Axe(IItemTier material, Properties properties) {
        super(material, 6, -3.1F, properties.addToolType(ToolType.AXE, material.getHarvestLevel()));
    }
}

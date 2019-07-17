package me.KG20.moreoresinone.Tools;

import me.KG20.moreoresinone.Init.CreativeTabs;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class Shovel extends ShovelItem {

    public Shovel(IItemTier material, Properties properties) {
        super(material, 1.5F, -3F, properties.addToolType(ToolType.SHOVEL, material.getHarvestLevel()));
    }

}

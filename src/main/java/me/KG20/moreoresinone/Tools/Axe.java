package me.KG20.moreoresinone.Tools;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ToolType;

public class Axe extends AxeItem {

    public Axe(Tier material, Properties properties) {
        super(material, 6, -3.1F, properties.addToolType(ToolType.AXE, material.getLevel()));
    }
}

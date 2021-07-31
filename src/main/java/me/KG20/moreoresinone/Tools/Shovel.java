package me.KG20.moreoresinone.Tools;


import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ToolType;

public class Shovel extends ShovelItem {

    public Shovel(Tier material, Properties properties) {
        super(material, 1.5F, -3F, properties.addToolType(ToolType.SHOVEL, material.getLevel()));
    }

}

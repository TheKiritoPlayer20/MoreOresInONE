package me.KG20.moreoresinone.Tools;

import me.KG20.moreoresinone.Init.CreativeTabs;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;
import org.omg.CORBA.SystemException;

import java.util.ArrayList;
import java.util.Random;

public class Pickaxe extends PickaxeItem {

    public Pickaxe(IItemTier material, Properties properties) {
        super(material, 1, -2.8F, properties.addToolType(ToolType.PICKAXE, material.getHarvestLevel()));
    }

}

package me.KG20.moreoresinone.CreativeTabs;

import me.KG20.moreoresinone.Init.RegisterBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CreativeTabEnd extends CreativeModeTab {


    public CreativeTabEnd(){
        super("moi_end");
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack makeIcon(){
        return new ItemStack(RegisterBlocks.corundumOre);
    }
}

package me.KG20.moreoresinone.CreativeTabs;

import me.KG20.moreoresinone.Init.RegisterBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CreativeTabOverworld extends ItemGroup {

    public CreativeTabOverworld(){
        super("moi_overworld");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack createIcon(){
        return new ItemStack(RegisterBlocks.rubyOre);
    }

}

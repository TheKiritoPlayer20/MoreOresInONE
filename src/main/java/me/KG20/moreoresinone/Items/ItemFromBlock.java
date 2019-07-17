package me.KG20.moreoresinone.Items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class ItemFromBlock extends BlockItem {

    public ItemFromBlock(Block block, Properties properties){
        super(block, properties);
        setRegistryName(block.getRegistryName());
    }
}

package me.KG20.moreoresinone.Items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class ItemFromBlock extends BlockItem {

    public ItemFromBlock(Block block, Properties properties){
        super(block, properties);
        setRegistryName(block.getRegistryName());
    }
}

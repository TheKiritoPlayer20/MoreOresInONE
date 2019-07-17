package me.KG20.moreoresinone.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class ItemBlocks extends Block {


    public ItemBlocks(){
        super(Properties.create(Material.ROCK).hardnessAndResistance(5F,6F).sound(SoundType.METAL));
    }


    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 2;
    }


}
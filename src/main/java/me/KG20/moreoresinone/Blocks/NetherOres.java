package me.KG20.moreoresinone.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class NetherOres extends Block {


    public NetherOres(){
        super(Properties.create(Material.ROCK).hardnessAndResistance(3F,3F).sound(SoundType.STONE));
    }


    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 3;
    }


}

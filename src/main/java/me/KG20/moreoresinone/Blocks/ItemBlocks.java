package me.KG20.moreoresinone.Blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nullable;

public class ItemBlocks extends Block {


    public ItemBlocks(MaterialColor color){
        super(Properties.of(Material.STONE, color).strength(5F,6F).sound(SoundType.METAL).requiresCorrectToolForDrops());
    }

    /*
    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 2;
    }
    */

}
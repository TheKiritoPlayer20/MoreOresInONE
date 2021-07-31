package me.KG20.moreoresinone.Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class OverworldOres extends Block {


    public OverworldOres(){
        super(Properties.of(Material.STONE, MaterialColor.STONE).strength(3.0F,3.0F).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops());
    }

    public OverworldOres(Properties properties){
        super(properties.requiresCorrectToolForDrops());
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


    @Override
    public int getExpDrop(BlockState state, LevelReader world, BlockPos pos, int fortune, int silktouch) {
       return silktouch == 0 ? 7 : 0;
    }
}

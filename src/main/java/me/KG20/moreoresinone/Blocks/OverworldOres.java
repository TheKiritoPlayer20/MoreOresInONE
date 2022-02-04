package me.KG20.moreoresinone.Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nullable;

public class OverworldOres extends Block {


    public OverworldOres(){
        super(Properties.of(Material.STONE, MaterialColor.STONE).strength(3.0F,3.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());
    }

    public OverworldOres(Properties properties){
        super(properties.requiresCorrectToolForDrops());
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader world, BlockPos pos, int fortune, int silktouch) {
       return silktouch == 0 ? 7 : 0;
    }
}

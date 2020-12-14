package me.KG20.moreoresinone.Blocks;

import me.KG20.moreoresinone.Init.RegisterBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class OverworldOres extends Block {


    public OverworldOres(){
        super(Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3F,3F).sound(SoundType.STONE));
    }

    public OverworldOres(Properties properties){
        super(properties);
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
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
       return silktouch == 0 ? 7 : 0;
    }
}

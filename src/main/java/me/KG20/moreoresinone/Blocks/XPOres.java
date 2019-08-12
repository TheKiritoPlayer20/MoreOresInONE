package me.KG20.moreoresinone.Blocks;

import me.KG20.moreoresinone.Init.RegisterBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.Random;

public class XPOres  extends Block {

    public XPOres(MaterialColor color){
        super(Properties.create(Material.ROCK, color).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE));
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 1;
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        Random random = new Random();
        if(silktouch == 0){
            if(state.getBlock() == RegisterBlocks.overworldXPOre){
                if(fortune != 0) {
                    if (random.nextInt(101) >= 50) {
                        return 20 * fortune * 3;
                    }else{
                        return 1;
                    }
                }else{
                    return 20;
                }

            }else if(state.getBlock() == RegisterBlocks.netherXPOre) {
                if(fortune != 0) {
                    if (random.nextInt(100) >= 50) {
                        return 30 * fortune * 3;
                    }else{
                        return 1;
                    }
                }else{
                    return random.nextInt(5) + 5;
                }
            }else if(state.getBlock() == RegisterBlocks.endXPOre){
                if(fortune != 0) {
                    if (random.nextInt(100) >= 50) {
                        return 40 * fortune * 3;
                    }else{
                        return 1;
                    }
                }else{
                    return random.nextInt(5) + 5;
                }
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

}

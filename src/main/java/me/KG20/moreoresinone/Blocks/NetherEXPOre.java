package me.KG20.moreoresinone.Blocks;

import me.KG20.moreoresinone.Config.Config;
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

public class NetherEXPOre extends Block {

    public NetherEXPOre(MaterialColor color){
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
                if(fortune != 0 && Config.enableFortune.get()) {
                    if (random.nextInt(101) >= 50) {
                        int experience = MathHelper.nextInt(random, Config.min_exp_nether.get(),Config.max_exp_nether.get());
                        return experience + (experience * fortune / 2);
                    }else{
                        return 1;
                    }
                }else{
                    if (random.nextInt(101) >= 50) {
                        return MathHelper.nextInt(random, Config.min_exp_nether.get(),Config.max_exp_nether.get());
                    }else{
                        return 1;
                    }
                }
        }else{
            return 0;
        }
    }



}

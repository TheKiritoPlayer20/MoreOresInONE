package me.KG20.moreoresinone.Blocks;

import me.KG20.moreoresinone.Config.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.Random;

public class OverworldEXPOre extends Block {

    public OverworldEXPOre(MaterialColor color){
        super(Properties.of(Material.STONE, color).strength(3.0F,3.0F).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops());
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
    public int getExpDrop(BlockState state, LevelReader world, BlockPos pos, int fortune, int silktouch) {
        Random random = new Random();
        if(silktouch == 0){
            if(fortune != 0 && Config.enableFortune.get()) {
                if (random.nextInt(101) >= 50) {
                    int experience = Mth.nextInt(random, Config.min_exp_overworld.get(),Config.max_exp_overworld.get());
                    return experience + (experience * fortune / 2);
                }else{
                    return 1;
                }
            }else{
                if (random.nextInt(101) >= 50) {
                    return Mth.nextInt(random, Config.min_exp_overworld.get(),Config.max_exp_overworld.get());
                }else{
                    return 1;
                }
            }
        }else{
            return 0;
        }
    }



}

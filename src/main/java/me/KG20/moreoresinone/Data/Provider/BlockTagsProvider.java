package me.KG20.moreoresinone.Data.Provider;

import me.KG20.moreoresinone.Init.ModTags;
import me.KG20.moreoresinone.Init.RegisterBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;

public class BlockTagsProvider extends net.minecraft.data.BlockTagsProvider {

    public BlockTagsProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerTags() {
        getBuilder(ModTags.Blocks.Test).add(RegisterBlocks.endEXPOre);
    }
}

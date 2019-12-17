package me.KG20.moreoresinone.Data.Provider;

import me.KG20.moreoresinone.Init.ModTags;
import me.KG20.moreoresinone.Init.RegisterBlocks;
import net.minecraft.data.DataGenerator;

public class ItemTagsProvider extends net.minecraft.data.ItemTagsProvider {

    public ItemTagsProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerTags() {
        getBuilder(ModTags.Items.Test).add(RegisterBlocks.endEXPOre.asItem());

    }
}

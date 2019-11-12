package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ModTags {

    public static class Items{

        public static final Tag<Item> Test = makeTag(Constants.modid, "test");

        private static Tag<Item> makeTag(String modid, String name){
            return new ItemTags.Wrapper(new ResourceLocation(modid, name));
        }

    }

    public static class Blocks{

        public static final Tag<Block> Test = makeTag(Constants.modid, "test");

        private static Tag<Block> makeTag(String modid, String name){
            return new BlockTags.Wrapper(new ResourceLocation(modid, name));
        }

    }

}

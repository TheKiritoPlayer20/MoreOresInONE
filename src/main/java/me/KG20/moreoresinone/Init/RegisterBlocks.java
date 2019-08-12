package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Blocks.*;
import me.KG20.moreoresinone.Items.ItemFromBlock;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Constants.modid, bus = Bus.MOD)
public class RegisterBlocks {

    public static final Block rubyOre = new OverworldOres();
    public static final Block rubyBlock = new ItemBlocks(MaterialColor.RED);
    public static final Block sapphireOre = new OverworldOres();
    public static final Block sapphireBlock = new ItemBlocks(MaterialColor.BLUE);
    public static final Block topazOre = new NetherOres();
    public static final Block topazBlock = new ItemBlocks(MaterialColor.ADOBE);
    public static final Block amethystOre = new EndOres();
    public static final Block amethystBlock = new ItemBlocks(MaterialColor.PURPLE_TERRACOTTA);
    public static final Block overworldEXPOre = new EXPOres(MaterialColor.STONE);
    public static final Block netherEXPOre = new EXPOres(MaterialColor.NETHERRACK);
    public static final Block endEXPOre = new EXPOres(MaterialColor.SAND);

    @SubscribeEvent
    public static void register(Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        rubyOre.setRegistryName(Constants.modid, "ruby_ore");
        rubyBlock.setRegistryName(Constants.modid, "ruby_block");
        registry.registerAll(rubyOre,rubyBlock);

        sapphireOre.setRegistryName(Constants.modid, "sapphire_ore");
        sapphireBlock.setRegistryName(Constants.modid, "sapphire_block");
        registry.registerAll(sapphireOre,sapphireBlock);

        topazOre.setRegistryName(Constants.modid, "topaz_ore");
        topazBlock.setRegistryName(Constants.modid, "topaz_block");
        registry.registerAll(topazOre,topazBlock);

        amethystOre.setRegistryName(Constants.modid, "amethyst_ore");
        amethystBlock.setRegistryName(Constants.modid, "amethyst_block");
        registry.registerAll(amethystOre,amethystBlock);

        overworldEXPOre.setRegistryName(Constants.modid, "overworld_exp_ore");
        netherEXPOre.setRegistryName(Constants.modid, "nether_exp_ore");
        endEXPOre.setRegistryName(Constants.modid, "end_exp_ore");
        registry.registerAll(overworldEXPOre,netherEXPOre,endEXPOre);

    }

    @SubscribeEvent
    public static void registerItem(Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(new ItemFromBlock(rubyOre, new Item.Properties().group(CreativeTabs.overworld)));
        registry.register(new ItemFromBlock(rubyBlock, new Item.Properties().group(CreativeTabs.overworld)));

        registry.register(new ItemFromBlock(sapphireOre, new Item.Properties().group(CreativeTabs.overworld)));
        registry.register(new ItemFromBlock(sapphireBlock, new Item.Properties().group(CreativeTabs.overworld)));

        registry.register(new ItemFromBlock(topazOre, new Item.Properties().group(CreativeTabs.nether)));
        registry.register(new ItemFromBlock(topazBlock, new Item.Properties().group(CreativeTabs.nether)));

        registry.register(new ItemFromBlock(amethystOre, new Item.Properties().group(CreativeTabs.end)));
        registry.register(new ItemFromBlock(amethystBlock, new Item.Properties().group(CreativeTabs.end)));

        registry.register(new ItemFromBlock(overworldEXPOre, new Item.Properties().group(CreativeTabs.overworld)));
        registry.register(new ItemFromBlock(netherEXPOre, new Item.Properties().group(CreativeTabs.nether)));
        registry.register(new ItemFromBlock(endEXPOre, new Item.Properties().group(CreativeTabs.end)));
    }
}


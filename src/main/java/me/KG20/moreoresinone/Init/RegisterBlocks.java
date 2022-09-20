package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Blocks.*;
import me.KG20.moreoresinone.Items.ItemFromBlock;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegisterEvent;

//@EventBusSubscriber(modid = Constants.modid, bus = Bus.MOD)
public class RegisterBlocks {

    public static final Block rubyOre = new OverworldOres();
    public static final Block rubyBlock = new ItemBlocks(MaterialColor.COLOR_RED);
    public static final Block deepslateRubyOre = new OverworldOres(Block.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE));
    public static final Block sapphireOre = new OverworldOres();
    public static final Block sapphireBlock = new ItemBlocks(MaterialColor.COLOR_BLUE);
    public static final Block deepslateSapphireOre = new OverworldOres(Block.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE));
    public static final Block cryoriteOre = new OverworldOres(Block.Properties.of(Material.ICE_SOLID, MaterialColor.ICE).friction(0.98F).strength(3.0F,3.0F).sound(SoundType.GLASS));
    public static final Block packedcryoriteOre = new OverworldOres(Block.Properties.of(Material.ICE_SOLID, MaterialColor.ICE).friction(0.98F).strength(3.0F,3.0F).sound(SoundType.GLASS));
    public static final Block cryoriteBlock = new ItemBlocks(MaterialColor.ICE);
    public static final Block topazOre = new NetherOres();
    public static final Block topazBlock = new ItemBlocks(MaterialColor.TERRACOTTA_ORANGE);
    public static final Block corundumOre = new EndOres();
    public static final Block corundumBlock = new ItemBlocks(MaterialColor.TERRACOTTA_PURPLE);
    public static final Block overworldEXPOre = new OverworldEXPOre(MaterialColor.STONE);
    public static final Block deepslateOverworldEXPOre = new OverworldEXPOre(Block.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE));
    public static final Block netherEXPOre = new NetherEXPOre(MaterialColor.NETHER);
    public static final Block endEXPOre = new EndEXPOre(MaterialColor.SAND);

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.BLOCKS, helper ->{
            registerBlockHelper(rubyOre, "ruby_ore", helper);
            registerBlockHelper(rubyBlock, "ruby_block", helper);
            registerBlockHelper(deepslateRubyOre, "deepslate_ruby_ore", helper);

            registerBlockHelper(sapphireOre, "sapphire_ore", helper);
            registerBlockHelper(sapphireBlock, "sapphire_block", helper);
            registerBlockHelper(deepslateSapphireOre, "deepslate_sapphire_ore", helper);

            registerBlockHelper(cryoriteOre, "cryorite_ore", helper);
            registerBlockHelper(packedcryoriteOre, "packed_cryorite_ore", helper);
            registerBlockHelper(cryoriteBlock, "cryorite_block", helper);

            registerBlockHelper(topazOre, "topaz_ore", helper);
            registerBlockHelper(topazBlock, "topaz_block", helper);

            registerBlockHelper(corundumOre, "corundum_ore", helper);
            registerBlockHelper(corundumBlock, "corundum_block", helper);

            registerBlockHelper(overworldEXPOre, "overworld_exp_ore", helper);
            registerBlockHelper(deepslateOverworldEXPOre, "deepslate_overworld_exp_ore", helper);
            registerBlockHelper(netherEXPOre, "nether_exp_ore", helper);
            registerBlockHelper(endEXPOre, "end_exp_ore", helper);
        });

    }

    @SubscribeEvent
    public static void registerItem(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ITEMS, helper ->{
            registerItemHelper(new ItemFromBlock(rubyOre, new Item.Properties().tab(CreativeTabs.overworld)), "ruby_ore", helper);
            registerItemHelper(new ItemFromBlock(rubyBlock, new Item.Properties().tab(CreativeTabs.overworld)), "ruby_block", helper);
            registerItemHelper(new ItemFromBlock(deepslateRubyOre, new Item.Properties().tab(CreativeTabs.overworld)), "deepslate_ruby_ore", helper);

            registerItemHelper(new ItemFromBlock(sapphireOre, new Item.Properties().tab(CreativeTabs.overworld)), "sapphire_ore", helper);
            registerItemHelper(new ItemFromBlock(sapphireBlock, new Item.Properties().tab(CreativeTabs.overworld)), "sapphire_block", helper);
            registerItemHelper(new ItemFromBlock(deepslateSapphireOre, new Item.Properties().tab(CreativeTabs.overworld)), "deepslate_sapphire_ore", helper);

            registerItemHelper(new ItemFromBlock(cryoriteOre, new Item.Properties().tab(CreativeTabs.overworld)), "cryorite_ore", helper);
            registerItemHelper(new ItemFromBlock(packedcryoriteOre, new Item.Properties().tab(CreativeTabs.overworld)), "packed_cryorite_ore", helper);
            registerItemHelper(new ItemFromBlock(cryoriteBlock, new Item.Properties().tab(CreativeTabs.overworld)), "cryorite_block", helper);

            registerItemHelper(new ItemFromBlock(topazOre, new Item.Properties().tab(CreativeTabs.nether).fireResistant()), "topaz_ore", helper);
            registerItemHelper(new ItemFromBlock(topazBlock, new Item.Properties().tab(CreativeTabs.nether).fireResistant()), "topaz_block", helper);

            registerItemHelper(new ItemFromBlock(corundumOre, new Item.Properties().tab(CreativeTabs.end).fireResistant()), "corundum_ore", helper);
            registerItemHelper(new ItemFromBlock(corundumBlock, new Item.Properties().tab(CreativeTabs.end).fireResistant()), "corundum_block", helper);

            registerItemHelper(new ItemFromBlock(overworldEXPOre, new Item.Properties().tab(CreativeTabs.overworld)), "overworld_exp_ore", helper);
            registerItemHelper(new ItemFromBlock(deepslateOverworldEXPOre, new Item.Properties().tab(CreativeTabs.overworld)), "deepslate_overworld_exp_ore", helper);
            registerItemHelper(new ItemFromBlock(netherEXPOre, new Item.Properties().tab(CreativeTabs.nether)), "nether_exp_ore", helper);
            registerItemHelper(new ItemFromBlock(endEXPOre, new Item.Properties().tab(CreativeTabs.end)), "end_exp_ore", helper);
        });
    }

    private static void registerBlockHelper(Block blockToRegister, String itemName, RegisterEvent.RegisterHelper<Block> registry){
        registry.register(new ResourceLocation(Constants.modid, itemName), blockToRegister);
    }

    private static void registerItemHelper(Item itemToRegister, String itemName, RegisterEvent.RegisterHelper<Item> registry){
        registry.register(new ResourceLocation(Constants.modid, itemName), itemToRegister);
    }
}


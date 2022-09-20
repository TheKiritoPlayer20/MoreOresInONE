package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Items.OreItems;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegisterEvent;

//@EventBusSubscriber(modid = Constants.modid, bus = Bus.MOD)
public class RegisterItems {

    public static final OreItems ruby = new OreItems(new Item.Properties().tab(CreativeTabs.overworld));
    public static final OreItems sapphire = new OreItems(new Item.Properties().tab(CreativeTabs.overworld));
    public static final OreItems cryorite = new OreItems(new Item.Properties().tab(CreativeTabs.overworld));
    public static final OreItems topaz = new OreItems(new Item.Properties().tab(CreativeTabs.nether).fireResistant());
    public static final OreItems corundum = new OreItems(new Item.Properties().tab(CreativeTabs.end).fireResistant());

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ITEMS, helper ->{
            registerItem(ruby, "ruby", helper);
            registerItem(sapphire, "sapphire", helper);
            registerItem(cryorite, "cryorite", helper);
            registerItem(topaz, "topaz", helper);
            registerItem(corundum, "corundum", helper);
        });
    }

    private static void registerItem(Item itemToRegister, String itemName, RegisterEvent.RegisterHelper<Item> registry){
        registry.register(new ResourceLocation(Constants.modid, itemName), itemToRegister);
    }


}


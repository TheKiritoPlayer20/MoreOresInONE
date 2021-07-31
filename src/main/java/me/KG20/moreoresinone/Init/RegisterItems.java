package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Items.OreItems;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Constants.modid, bus = Bus.MOD)
public class RegisterItems {

    public static final OreItems ruby = new OreItems(new Item.Properties().tab(CreativeTabs.overworld));
    public static final OreItems sapphire = new OreItems(new Item.Properties().tab(CreativeTabs.overworld));
    public static final OreItems cryorite = new OreItems(new Item.Properties().tab(CreativeTabs.overworld));
    public static final OreItems topaz = new OreItems(new Item.Properties().tab(CreativeTabs.nether).fireResistant());
    public static final OreItems amethyst = new OreItems(new Item.Properties().tab(CreativeTabs.end).fireResistant());


    @SubscribeEvent
    public static void register(Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        ruby.setRegistryName(Constants.modid, "ruby");
        registry.register(ruby);
        sapphire.setRegistryName(Constants.modid, "sapphire");
        registry.register(sapphire);
        cryorite.setRegistryName(Constants.modid, "cryorite");
        registry.register(cryorite);
        topaz.setRegistryName(Constants.modid, "topaz");
        registry.register(topaz);
        amethyst.setRegistryName(Constants.modid, "amethyst");
        registry.register(amethyst);
    }


}


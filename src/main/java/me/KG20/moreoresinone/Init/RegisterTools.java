package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Main.Constants;
import me.KG20.moreoresinone.Tools.*;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Constants.modid, bus = Bus.MOD)
public class RegisterTools {

    public static final Hoe rubyHoe = new Hoe(BasisToolMaterial.ruby,-3, 0.0F, new Item.Properties().group(CreativeTabs.overworld));
    public static final Axe rubyAxe = new Axe(BasisToolMaterial.ruby, new Item.Properties().group(CreativeTabs.overworld));
    public static final Pickaxe rubyPickaxe = new Pickaxe(BasisToolMaterial.ruby, new Item.Properties().group(CreativeTabs.overworld));
    public static final Shovel rubyShovel = new Shovel(BasisToolMaterial.ruby, new Item.Properties().group(CreativeTabs.overworld));
    public static final Sword rubySword = new Sword(BasisToolMaterial.ruby, new Item.Properties().group(CreativeTabs.overworld));
    public static final Sickle rubySickle = new Sickle(new Item.Properties().group(CreativeTabs.overworld).maxDamage(Config.durabilitiy_ruby.get()));

    public static final Hoe sapphireHoe = new Hoe(BasisToolMaterial.sapphire,-3, 0.0F, new Item.Properties().group(CreativeTabs.overworld));
    public static final Axe sapphireAxe = new Axe(BasisToolMaterial.sapphire, new Item.Properties().group(CreativeTabs.overworld));
    public static final Pickaxe sapphirePickaxe = new Pickaxe(BasisToolMaterial.sapphire, new Item.Properties().group(CreativeTabs.overworld));
    public static final Shovel sapphireShovel = new Shovel(BasisToolMaterial.sapphire, new Item.Properties().group(CreativeTabs.overworld));
    public static final Sword sapphireSword = new Sword(BasisToolMaterial.sapphire, new Item.Properties().group(CreativeTabs.overworld));
    public static final Sickle sapphireSickle = new Sickle(new Item.Properties().group(CreativeTabs.overworld).maxDamage(Config.durabilitiy_sapphire.get()));

    public static final Hoe topazHoe = new Hoe(BasisToolMaterial.topaz,-3, 0.0F, new Item.Properties().group(CreativeTabs.nether));
    public static final Axe topazAxe = new Axe(BasisToolMaterial.topaz, new Item.Properties().group(CreativeTabs.nether));
    public static final Pickaxe topazPickaxe = new Pickaxe(BasisToolMaterial.topaz, new Item.Properties().group(CreativeTabs.nether));
    public static final Shovel topazShovel = new Shovel(BasisToolMaterial.topaz, new Item.Properties().group(CreativeTabs.nether));
    public static final Sword topazSword = new Sword(BasisToolMaterial.topaz, new Item.Properties().group(CreativeTabs.nether));
    public static final Sickle topazSickle = new Sickle(new Item.Properties().group(CreativeTabs.nether).maxDamage(Config.durabilitiy_topaz.get()));

    public static final Hoe amethystHoe = new Hoe(BasisToolMaterial.amethyst,-3, 0.0F, new Item.Properties().group(CreativeTabs.end));
    public static final Axe amethystAxe = new Axe(BasisToolMaterial.amethyst, new Item.Properties().group(CreativeTabs.end));
    public static final Pickaxe amethystPickaxe = new Pickaxe(BasisToolMaterial.amethyst, new Item.Properties().group(CreativeTabs.end));
    public static final Shovel amethystShovel = new Shovel(BasisToolMaterial.amethyst, new Item.Properties().group(CreativeTabs.end));
    public static final Sword amethystSword = new Sword(BasisToolMaterial.amethyst, new Item.Properties().group(CreativeTabs.end));
    public static final Sickle amethystSickle = new Sickle(new Item.Properties().group(CreativeTabs.end).maxDamage(Config.durabilitiy_amethyst.get()));


    @SubscribeEvent
    public static void register(Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        rubyHoe.setRegistryName(Constants.modid, "ruby_hoe");
        rubyAxe.setRegistryName(Constants.modid, "ruby_axe");
        rubyPickaxe.setRegistryName(Constants.modid, "ruby_pickaxe");
        rubyShovel.setRegistryName(Constants.modid, "ruby_shovel");
        rubySword.setRegistryName(Constants.modid, "ruby_sword");
        rubySickle.setRegistryName(Constants.modid, "ruby_sickle");
        registry.registerAll(rubyHoe,rubyAxe,rubyPickaxe,rubyShovel,rubySword,rubySickle);

        sapphireHoe.setRegistryName(Constants.modid, "sapphire_hoe");
        sapphireAxe.setRegistryName(Constants.modid, "sapphire_axe");
        sapphirePickaxe.setRegistryName(Constants.modid, "sapphire_pickaxe");
        sapphireShovel.setRegistryName(Constants.modid, "sapphire_shovel");
        sapphireSword.setRegistryName(Constants.modid, "sapphire_sword");
        sapphireSickle.setRegistryName(Constants.modid, "sapphire_sickle");
        registry.registerAll(sapphireHoe,sapphireAxe,sapphirePickaxe,sapphireShovel,sapphireSword,sapphireSickle);

        topazHoe.setRegistryName(Constants.modid, "topaz_hoe");
        topazAxe.setRegistryName(Constants.modid, "topaz_axe");
        topazPickaxe.setRegistryName(Constants.modid, "topaz_pickaxe");
        topazShovel.setRegistryName(Constants.modid, "topaz_shovel");
        topazSword.setRegistryName(Constants.modid, "topaz_sword");
        topazSickle.setRegistryName(Constants.modid, "topaz_sickle");
        registry.registerAll(topazHoe,topazAxe,topazPickaxe,topazShovel,topazSword,topazSickle);

        amethystHoe.setRegistryName(Constants.modid, "amethyst_hoe");
        amethystAxe.setRegistryName(Constants.modid, "amethyst_axe");
        amethystPickaxe.setRegistryName(Constants.modid, "amethyst_pickaxe");
        amethystShovel.setRegistryName(Constants.modid, "amethyst_shovel");
        amethystSword.setRegistryName(Constants.modid, "amethyst_sword");
        amethystSickle.setRegistryName(Constants.modid, "amethyst_sickle");
        registry.registerAll(amethystHoe,amethystAxe,amethystPickaxe,amethystShovel,amethystSword,amethystSickle);
    }



    }


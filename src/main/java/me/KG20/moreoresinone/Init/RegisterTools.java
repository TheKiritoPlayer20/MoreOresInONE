package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Main.Constants;
import me.KG20.moreoresinone.Tools.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

//@EventBusSubscriber(modid = Constants.modid, bus = Bus.MOD)
public class RegisterTools {

    public static final Hoe rubyHoe = new Hoe(BasisToolMaterial.ruby,-3, 0.0F, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Axe rubyAxe = new Axe(BasisToolMaterial.ruby, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Pickaxe rubyPickaxe = new Pickaxe(BasisToolMaterial.ruby, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Shovel rubyShovel = new Shovel(BasisToolMaterial.ruby, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Sword rubySword = new Sword(BasisToolMaterial.ruby, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Sickle rubySickle = new Sickle(new Item.Properties().tab(CreativeTabs.overworld).durability(Config.durabilitiy_ruby.get()));

    public static final Hoe sapphireHoe = new Hoe(BasisToolMaterial.sapphire,-3, 0.0F, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Axe sapphireAxe = new Axe(BasisToolMaterial.sapphire, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Pickaxe sapphirePickaxe = new Pickaxe(BasisToolMaterial.sapphire, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Shovel sapphireShovel = new Shovel(BasisToolMaterial.sapphire, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Sword sapphireSword = new Sword(BasisToolMaterial.sapphire, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Sickle sapphireSickle = new Sickle(new Item.Properties().tab(CreativeTabs.overworld).durability(Config.durabilitiy_sapphire.get()));

    public static final Hoe cryoriteHoe = new Hoe(BasisToolMaterial.cryorite,-3, 0.0F, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Axe cryoriteAxe = new Axe(BasisToolMaterial.cryorite, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Pickaxe cryoritePickaxe = new Pickaxe(BasisToolMaterial.cryorite, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Shovel cryoriteShovel = new Shovel(BasisToolMaterial.cryorite, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Sword cryoriteSword = new Sword(BasisToolMaterial.cryorite, new Item.Properties().tab(CreativeTabs.overworld));
    public static final Sickle cryoriteSickle = new Sickle(new Item.Properties().tab(CreativeTabs.overworld).durability(Config.durabilitiy_sapphire.get()));

    public static final Hoe topazHoe = new Hoe(BasisToolMaterial.topaz,-3, 0.0F, new Item.Properties().tab(CreativeTabs.nether).fireResistant());
    public static final Axe topazAxe = new Axe(BasisToolMaterial.topaz, new Item.Properties().tab(CreativeTabs.nether).fireResistant());
    public static final Pickaxe topazPickaxe = new Pickaxe(BasisToolMaterial.topaz, new Item.Properties().tab(CreativeTabs.nether).fireResistant());
    public static final Shovel topazShovel = new Shovel(BasisToolMaterial.topaz, new Item.Properties().tab(CreativeTabs.nether).fireResistant());
    public static final Sword topazSword = new Sword(BasisToolMaterial.topaz, new Item.Properties().tab(CreativeTabs.nether).fireResistant());
    public static final Sickle topazSickle = new Sickle(new Item.Properties().tab(CreativeTabs.nether).durability(Config.durabilitiy_topaz.get()).fireResistant());

    public static final Hoe corundumHoe = new Hoe(BasisToolMaterial.corundum,-3, 0.0F, new Item.Properties().tab(CreativeTabs.end).fireResistant());
    public static final Axe corundumAxe = new Axe(BasisToolMaterial.corundum, new Item.Properties().tab(CreativeTabs.end).fireResistant());
    public static final Pickaxe corundumPickaxe = new Pickaxe(BasisToolMaterial.corundum, new Item.Properties().tab(CreativeTabs.end).fireResistant());
    public static final Shovel corundumShovel = new Shovel(BasisToolMaterial.corundum, new Item.Properties().tab(CreativeTabs.end).fireResistant());
    public static final Sword corundumSword = new Sword(BasisToolMaterial.corundum, new Item.Properties().tab(CreativeTabs.end).fireResistant());
    public static final Sickle corundumSickle = new Sickle(new Item.Properties().tab(CreativeTabs.end).durability(Config.durabilitiy_corundum.get()).fireResistant());


    @SubscribeEvent
    public static void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ITEMS, helper -> {
            registerTools(rubyHoe, "ruby_hoe", helper);
            registerTools(rubyAxe, "ruby_axe", helper);
            registerTools(rubyPickaxe, "ruby_pickaxe", helper);
            registerTools(rubyShovel, "ruby_shovel", helper);
            registerTools(rubySword, "ruby_sword", helper);
            registerTools(rubySickle, "ruby_sickle", helper);

            registerTools(sapphireHoe, "sapphire_hoe", helper);
            registerTools(sapphireAxe, "sapphire_axe", helper);
            registerTools(sapphirePickaxe, "sapphire_pickaxe", helper);
            registerTools(sapphireShovel, "sapphire_shovel", helper);
            registerTools(sapphireSword, "sapphire_sword", helper);
            registerTools(sapphireSickle, "sapphire_sickle", helper);

            registerTools(cryoriteHoe, "cryorite_hoe", helper);
            registerTools(cryoriteAxe, "cryorite_axe", helper);
            registerTools(cryoritePickaxe, "cryorite_pickaxe", helper);
            registerTools(cryoriteShovel, "cryorite_shovel", helper);
            registerTools(cryoriteSword, "cryorite_sword", helper);
            registerTools(cryoriteSickle, "cryorite_sickle", helper);

            registerTools(topazHoe, "topaz_hoe", helper);
            registerTools(topazAxe, "topaz_axe", helper);
            registerTools(topazPickaxe, "topaz_pickaxe", helper);
            registerTools(topazShovel, "topaz_shovel", helper);
            registerTools(topazSword, "topaz_sword", helper);
            registerTools(topazSickle, "topaz_sickle", helper);

            registerTools(corundumHoe, "corundum_hoe", helper);
            registerTools(corundumAxe, "corundum_axe", helper);
            registerTools(corundumPickaxe, "corundum_pickaxe", helper);
            registerTools(corundumShovel, "corundum_shovel", helper);
            registerTools(corundumSword, "corundum_sword", helper);
            registerTools(corundumSickle, "corundum_sickle", helper);
        });
    }

    private static void registerTools(Item toolToRegister, String toolName, RegisterEvent.RegisterHelper<Item> registry){
        registry.register(new ResourceLocation(Constants.modid, toolName), toolToRegister);
    }


    }


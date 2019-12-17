package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Armor.BasisArmorMaterial;
import me.KG20.moreoresinone.Armor.ItemArmor;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Constants.modid, bus = Bus.MOD)
public class RegisterArmor {

    public static final ItemArmor rubyHelmet = new ItemArmor(BasisArmorMaterial.ruby, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTabs.overworld));
    public static final ItemArmor rubyChestplate = new ItemArmor(BasisArmorMaterial.ruby, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTabs.overworld));
    public static final ItemArmor rubyLeggings = new ItemArmor(BasisArmorMaterial.ruby, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTabs.overworld));
    public static final ItemArmor rubyBoots = new ItemArmor(BasisArmorMaterial.ruby, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTabs.overworld));

    public static final ItemArmor sapphireHelmet = new ItemArmor(BasisArmorMaterial.sapphire, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTabs.overworld));
    public static final ItemArmor sapphireChestplate = new ItemArmor(BasisArmorMaterial.sapphire, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTabs.overworld));
    public static final ItemArmor sapphireLeggings = new ItemArmor(BasisArmorMaterial.sapphire, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTabs.overworld));
    public static final ItemArmor sapphireBoots = new ItemArmor(BasisArmorMaterial.sapphire, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTabs.overworld));

    public static final ItemArmor topazHelmet = new ItemArmor(BasisArmorMaterial.topaz, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTabs.nether));
    public static final ItemArmor topazChestplate = new ItemArmor(BasisArmorMaterial.topaz, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTabs.nether));
    public static final ItemArmor topazLeggings = new ItemArmor(BasisArmorMaterial.topaz, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTabs.nether));
    public static final ItemArmor topazBoots = new ItemArmor(BasisArmorMaterial.topaz, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTabs.nether));

    public static final ItemArmor amethystHelmet = new ItemArmor(BasisArmorMaterial.amethyst, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTabs.end));
    public static final ItemArmor amethystChestplate = new ItemArmor(BasisArmorMaterial.amethyst, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTabs.end));
    public static final ItemArmor amethystLeggings = new ItemArmor(BasisArmorMaterial.amethyst, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTabs.end));
    public static final ItemArmor amethystBoots = new ItemArmor(BasisArmorMaterial.amethyst, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTabs.end));

    @SubscribeEvent
    public static void register(Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        rubyHelmet.setRegistryName(Constants.modid, "ruby_helmet");
        rubyChestplate.setRegistryName(Constants.modid, "ruby_chestplate");
        rubyLeggings.setRegistryName(Constants.modid, "ruby_leggings");
        rubyBoots.setRegistryName(Constants.modid, "ruby_boots");
        registry.registerAll(rubyHelmet,rubyChestplate,rubyLeggings,rubyBoots);

        sapphireHelmet.setRegistryName(Constants.modid, "sapphire_helmet");
        sapphireChestplate.setRegistryName(Constants.modid, "sapphire_chestplate");
        sapphireLeggings.setRegistryName(Constants.modid, "sapphire_leggings");
        sapphireBoots.setRegistryName(Constants.modid, "sapphire_boots");
        registry.registerAll(sapphireHelmet,sapphireChestplate,sapphireLeggings,sapphireBoots);

        topazHelmet.setRegistryName(Constants.modid, "topaz_helmet");
        topazChestplate.setRegistryName(Constants.modid, "topaz_chestplate");
        topazLeggings.setRegistryName(Constants.modid, "topaz_leggings");
        topazBoots.setRegistryName(Constants.modid, "topaz_boots");
        registry.registerAll(topazHelmet,topazChestplate,topazLeggings,topazBoots);

        amethystHelmet.setRegistryName(Constants.modid, "amethyst_helmet");
        amethystChestplate.setRegistryName(Constants.modid, "amethyst_chestplate");
        amethystLeggings.setRegistryName(Constants.modid, "amethyst_leggings");
        amethystBoots.setRegistryName(Constants.modid, "amethyst_boots");
        registry.registerAll(amethystHelmet,amethystChestplate,amethystLeggings,amethystBoots);


    }



    }


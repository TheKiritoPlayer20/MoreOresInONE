package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Armor.BasisArmorMaterial;
import me.KG20.moreoresinone.Armor.ItemArmor;
import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

//@EventBusSubscriber(modid = Constants.modid, bus = Bus.MOD)
public class RegisterArmor {

    public static final ItemArmor rubyHelmet = new ItemArmor(BasisArmorMaterial.ruby, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.overworld));
    public static final ItemArmor rubyChestplate = new ItemArmor(BasisArmorMaterial.ruby, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTabs.overworld));
    public static final ItemArmor rubyLeggings = new ItemArmor(BasisArmorMaterial.ruby, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTabs.overworld));
    public static final ItemArmor rubyBoots = new ItemArmor(BasisArmorMaterial.ruby, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTabs.overworld));

    public static final ItemArmor sapphireHelmet = new ItemArmor(BasisArmorMaterial.sapphire, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.overworld));
    public static final ItemArmor sapphireChestplate = new ItemArmor(BasisArmorMaterial.sapphire, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTabs.overworld));
    public static final ItemArmor sapphireLeggings = new ItemArmor(BasisArmorMaterial.sapphire, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTabs.overworld));
    public static final ItemArmor sapphireBoots = new ItemArmor(BasisArmorMaterial.sapphire, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTabs.overworld));

    public static final ItemArmor cryoriteHelmet = new ItemArmor(BasisArmorMaterial.cryorite, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.overworld));
    public static final ItemArmor cryoriteChestplate = new ItemArmor(BasisArmorMaterial.cryorite, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTabs.overworld));
    public static final ItemArmor cryoriteLeggings = new ItemArmor(BasisArmorMaterial.cryorite, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTabs.overworld));
    public static final ItemArmor cryoriteBoots = new ItemArmor(BasisArmorMaterial.cryorite, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTabs.overworld));

    public static final ItemArmor topazHelmet = new ItemArmor(BasisArmorMaterial.topaz, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.nether).fireResistant());
    public static final ItemArmor topazChestplate = new ItemArmor(BasisArmorMaterial.topaz, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTabs.nether).fireResistant());
    public static final ItemArmor topazLeggings = new ItemArmor(BasisArmorMaterial.topaz, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTabs.nether).fireResistant());
    public static final ItemArmor topazBoots = new ItemArmor(BasisArmorMaterial.topaz, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTabs.nether).fireResistant());

    public static final ItemArmor corundumHelmet = new ItemArmor(BasisArmorMaterial.corundum, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.end).fireResistant());
    public static final ItemArmor corundumChestplate = new ItemArmor(BasisArmorMaterial.corundum, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTabs.end).fireResistant());
    public static final ItemArmor corundumLeggings = new ItemArmor(BasisArmorMaterial.corundum, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTabs.end).fireResistant());
    public static final ItemArmor corundumBoots = new ItemArmor(BasisArmorMaterial.corundum, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTabs.end).fireResistant());

    public static final HorseArmorItem rubyHorseArmor = new HorseArmorItem(Config.ruby_horse_armor.get(), new ResourceLocation("moreoresinone:textures/entity/horse/armor/ruby_horse_armor.png"), new Item.Properties().stacksTo(1).tab(CreativeTabs.overworld));
    public static final HorseArmorItem sapphireHorseArmor = new HorseArmorItem(Config.sapphire_horse_armor.get(), new ResourceLocation("moreoresinone:textures/entity/horse/armor/sapphire_horse_armor.png"), new Item.Properties().stacksTo(1).tab(CreativeTabs.overworld));
    public static final HorseArmorItem cryoriteHorseArmor = new HorseArmorItem(Config.cryorite_horse_armor.get(), new ResourceLocation("moreoresinone:textures/entity/horse/armor/cryorite_horse_armor.png"), new Item.Properties().stacksTo(1).tab(CreativeTabs.overworld));
    public static final HorseArmorItem topazHorseArmor = new HorseArmorItem(Config.topaz_horse_armor.get(), new ResourceLocation("moreoresinone:textures/entity/horse/armor/topaz_horse_armor.png"), new Item.Properties().stacksTo(1).tab(CreativeTabs.nether).fireResistant());
    public static final HorseArmorItem corundumHorseArmor = new HorseArmorItem(Config.corundum_horse_armor.get(), new ResourceLocation("moreoresinone:textures/entity/horse/armor/corundum_horse_armor.png"), new Item.Properties().stacksTo(1).tab(CreativeTabs.end).fireResistant());

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

        cryoriteHelmet.setRegistryName(Constants.modid, "cryorite_helmet");
        cryoriteChestplate.setRegistryName(Constants.modid, "cryorite_chestplate");
        cryoriteLeggings.setRegistryName(Constants.modid, "cryorite_leggings");
        cryoriteBoots.setRegistryName(Constants.modid, "cryorite_boots");
        registry.registerAll(cryoriteHelmet,cryoriteChestplate,cryoriteLeggings,cryoriteBoots);

        topazHelmet.setRegistryName(Constants.modid, "topaz_helmet");
        topazChestplate.setRegistryName(Constants.modid, "topaz_chestplate");
        topazLeggings.setRegistryName(Constants.modid, "topaz_leggings");
        topazBoots.setRegistryName(Constants.modid, "topaz_boots");
        registry.registerAll(topazHelmet,topazChestplate,topazLeggings,topazBoots);

        corundumHelmet.setRegistryName(Constants.modid, "corundum_helmet");
        corundumChestplate.setRegistryName(Constants.modid, "corundum_chestplate");
        corundumLeggings.setRegistryName(Constants.modid, "corundum_leggings");
        corundumBoots.setRegistryName(Constants.modid, "corundum_boots");
        registry.registerAll(corundumHelmet,corundumChestplate,corundumLeggings,corundumBoots);

        rubyHorseArmor.setRegistryName(Constants.modid, "ruby_horse_armor");
        sapphireHorseArmor.setRegistryName(Constants.modid, "sapphire_horse_armor");
        cryoriteHorseArmor.setRegistryName(Constants.modid, "cryorite_horse_armor");
        topazHorseArmor.setRegistryName(Constants.modid, "topaz_horse_armor");
        corundumHorseArmor.setRegistryName(Constants.modid, "corundum_horse_armor");
        registry.registerAll(rubyHorseArmor,sapphireHorseArmor,cryoriteHorseArmor,topazHorseArmor,corundumHorseArmor);

    }



    }


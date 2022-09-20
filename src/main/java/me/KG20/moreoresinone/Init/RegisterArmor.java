package me.KG20.moreoresinone.Init;

import me.KG20.moreoresinone.Armor.BasisArmorMaterial;
import me.KG20.moreoresinone.Armor.ItemArmor;
import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

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
    public static void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ITEMS, helper ->{
            registerArmor(rubyHelmet, "ruby_helmet", helper);
            registerArmor(rubyChestplate, "ruby_chestplate", helper);
            registerArmor(rubyLeggings, "ruby_leggings", helper);
            registerArmor(rubyBoots, "ruby_boots", helper);

            registerArmor(sapphireHelmet, "sapphire_helmet", helper);
            registerArmor(sapphireChestplate, "sapphire_chestplate", helper);
            registerArmor(sapphireLeggings, "sapphire_leggings", helper);
            registerArmor(sapphireBoots, "sapphire_boots", helper);

            registerArmor(cryoriteHelmet, "cryorite_helmet", helper);
            registerArmor(cryoriteChestplate, "cryorite_chestplate", helper);
            registerArmor(cryoriteLeggings, "cryorite_leggings", helper);
            registerArmor(cryoriteBoots, "cryorite_boots", helper);

            registerArmor(topazHelmet, "topaz_helmet", helper);
            registerArmor(topazChestplate, "topaz_chestplate", helper);
            registerArmor(topazLeggings, "topaz_leggings", helper);
            registerArmor(topazBoots, "topaz_boots", helper);

            registerArmor(corundumHelmet, "corundum_helmet", helper);
            registerArmor(corundumChestplate, "corundum_chestplate", helper);
            registerArmor(corundumLeggings, "corundum_leggings", helper);
            registerArmor(corundumBoots, "corundum_boots", helper);

            registerArmor(rubyHorseArmor, "ruby_horse_armor", helper);
            registerArmor(sapphireHorseArmor, "sapphire_horse_armor", helper);
            registerArmor(cryoriteHorseArmor, "cryorite_horse_armor", helper);
            registerArmor(topazHorseArmor, "topaz_horse_armor", helper);
            registerArmor(corundumHorseArmor, "corundum_horse_armor", helper);
        });
    }

    private static void registerArmor(Item armorToRegister, String armorName, RegisterEvent.RegisterHelper<Item> registry){
        registry.register(new ResourceLocation(Constants.modid, armorName), armorToRegister);
    }



    }


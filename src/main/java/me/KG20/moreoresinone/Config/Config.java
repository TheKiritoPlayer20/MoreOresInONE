package me.KG20.moreoresinone.Config;

import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.common.ForgeConfigSpec;

public class Config {


    //Overworld
    public static ForgeConfigSpec.BooleanValue every_biome;


    //Ruby
    public static ForgeConfigSpec.BooleanValue generate_ruby;
    public static ForgeConfigSpec.IntValue durabilitiy_ruby;
    public static ForgeConfigSpec.IntValue veinsize_ruby;
    public static ForgeConfigSpec.IntValue count_ruby;
    public static ForgeConfigSpec.IntValue minheight_ruby;
    public static ForgeConfigSpec.IntValue maxheight_ruby;
    //Sapphire

    public static ForgeConfigSpec.BooleanValue generate_sapphire;
    public static ForgeConfigSpec.IntValue durabilitiy_sapphire;
    public static ForgeConfigSpec.IntValue veinsize_sapphire;
    public static ForgeConfigSpec.IntValue count_sapphire;
    public static ForgeConfigSpec.IntValue minheight_sapphire;
    public static ForgeConfigSpec.IntValue maxheight_sapphire;

    //Nether

    //Topaz
    public static ForgeConfigSpec.BooleanValue generate_topaz;
    public static ForgeConfigSpec.IntValue durabilitiy_topaz;
    public static ForgeConfigSpec.IntValue veinsize_topaz;
    public static ForgeConfigSpec.IntValue count_topaz;
    public static ForgeConfigSpec.IntValue minheight_topaz;
    public static ForgeConfigSpec.IntValue maxheight_topaz;

    //End

    //Amethyst
    public static ForgeConfigSpec.BooleanValue generate_amethyst;
    public static ForgeConfigSpec.IntValue durabilitiy_amethyst;
    public static ForgeConfigSpec.IntValue count_amethyst;
    public static ForgeConfigSpec.IntValue minheight_amethyst;
    public static ForgeConfigSpec.IntValue maxheight_amethyst;

    //Experience
    public static ForgeConfigSpec.BooleanValue generate_Overworld_EXP_ORE;
    public static ForgeConfigSpec.BooleanValue generate_Nether_EXP_ORE;
    public static ForgeConfigSpec.BooleanValue generate_End_EXP_ORE;
    public static ForgeConfigSpec.BooleanValue enableFortune;
    public static ForgeConfigSpec.IntValue count_overworld_experience;
    public static ForgeConfigSpec.IntValue minheight_overworld_experience;
    public static ForgeConfigSpec.IntValue maxheight_overworld_experience;
    public static ForgeConfigSpec.IntValue count_nether_experience;
    public static ForgeConfigSpec.IntValue minheight_nether_experience;
    public static ForgeConfigSpec.IntValue maxheight_nether_experience;
    public static ForgeConfigSpec.IntValue count_end_experience;
    public static ForgeConfigSpec.IntValue minheight_end_experience;
    public static ForgeConfigSpec.IntValue maxheight_end_experience;
    public static ForgeConfigSpec.IntValue min_exp_overworld;
    public static ForgeConfigSpec.IntValue max_exp_overworld;
    public static ForgeConfigSpec.IntValue min_exp_nether;
    public static ForgeConfigSpec.IntValue max_exp_nether;
    public static ForgeConfigSpec.IntValue min_exp_end;
    public static ForgeConfigSpec.IntValue max_exp_end;

    //Armor
    public static ForgeConfigSpec.BooleanValue enable_statuseffects;

    public static void init(ForgeConfigSpec.Builder Builder){

        Builder.push("Ore Generation");
        Builder.push("Experience");
        Builder.push("Overworld");
        generate_Overworld_EXP_ORE = Builder.comment("Enable the Generation of the Overworld Experience Ore(Default: true).").define("generate_overworld_experience", true);
        count_overworld_experience = Builder.comment("Set the Count of the Experience Ore how much can spawn per Chunk in the Overworld.(Default: 5)").defineInRange("count_overworld_experience", 5, 1, 255);
        minheight_overworld_experience = Builder.comment("Set the Min Height of the Experience Ore in the Overworld (Default: 0).").defineInRange("min_height_overworld_experience", 0, 0, 128);
        maxheight_overworld_experience = Builder.comment("Set the Max Height of the Experience Ore in the Overworld (Default: 128).").defineInRange("max_height_overworld_experience", 128, 0, 256);
        Builder.pop();

        Builder.push("Nether");
        generate_Nether_EXP_ORE = Builder.comment("Enable the Generation of the Nether Experience Ore (Default: true).").define("generate_nether_experience", true);
        count_nether_experience = Builder.comment("Set the Count of the Experience Ore how much can spawn per Chunk in the Nether(Default: 5).").defineInRange("count_nether_experience", 5, 1, 255);
        minheight_nether_experience = Builder.comment("Set the Min Height of the Experience Ore in the Nether (Default: 0).").defineInRange("min_height_nether_experience", 0, 0, 128);
        maxheight_nether_experience = Builder.comment("Set the Max Height of the Experience Ore in the Nether (Default: 128).").defineInRange("max_height_nether_experience", 128, 0, 128);
        Builder.pop();

        Builder.push("End");
        generate_End_EXP_ORE = Builder.comment("Enable the Generation of the End Experience Ore (Default: true).").define("generate_end_experience", true);
        count_end_experience = Builder.comment("Set the Count of the Experience Ore how much can spawn per Chunk in  the End (Default: 5).").defineInRange("count_end_experience", 5, 1, 255);
        minheight_end_experience = Builder.comment("Set the Min Height of the Experience Ore in  the End (Default: 0).").defineInRange("min_height_end_experience", 0, 0, 128);
        maxheight_end_experience = Builder.comment("Set the Max Height of the Experience Ore in  the End (Default: 128).").defineInRange("max_height_end_experience", 128, 0, 128);
        Builder.pop();

        Builder.push("Points");
        Builder.push("Overworld");
        min_exp_overworld = Builder.comment("Set the Min Experience you can get out of the Experience Overworld Ore (Default: 10).").defineInRange("min_exp_overworld", 10, 0, 999999999);
        max_exp_overworld = Builder.comment("Set the Max Experience you can get out of the Experience Overworld Ore (Default: 20).").defineInRange("max_exp_overworld", 20, 0, 999999999);
        Builder.pop();

        Builder.push("Nether");
        min_exp_nether = Builder.comment("Set the Min Experience you can get out of the Experience Nether Ore (Default: 20).").defineInRange("min_exp_nether", 20, 0, 999999999);
        max_exp_nether = Builder.comment("Set the Max Experience you can get out of the Experience Nether Ore (Default: 30).").defineInRange("max_exp_nether", 30, 0, 999999999);
        Builder.pop();

        Builder.push("End");
        min_exp_end = Builder.comment("Set the Min Experience you can get out of the Experience End Ore (Default: 30).").defineInRange("min_exp_end", 30, 0, 999999999);
        max_exp_end = Builder.comment("Set the Max Experience you can get out of the Experience End Ore (Default: 40).").defineInRange("max_exp_end", 40, 0, 999999999);
        Builder.pop();

        Builder.pop();
        enableFortune = Builder.comment("Enable that fortune boosts the experience that you can get from mining(Default: true).").define("enable_fortune", true);

        Builder.pop();
        Builder.push("Overworld");
        every_biome = Builder.comment("Enable that Rubies and Sapphire's generate in every biome(Default: false).").define("every_biome", false);
        Builder.push("Sapphire Generation");
        generate_sapphire = Builder.comment("Enable the Generation of Sapphire Ore (Default: true).").define("generate_sapphire", true);
        veinsize_sapphire = Builder.comment("Set the Vein Size of the Sapphire Ore (Default: 8).").defineInRange("veinsize_sapphire", 8, 4, 255);
        count_sapphire = Builder.comment("Set the Count of the Sapphire Ore how much can spawn per Chunk (Default: 1).").defineInRange("count_sapphire", 1, 1, 255);
        minheight_sapphire = Builder.comment("Set the Min Height of the Sapphire Ore (Default: 0).").defineInRange("minheight_sapphire", 0, 0, 256);
        maxheight_sapphire = Builder.comment("Set the Max Height of the Sapphire Ore (Default: 16).").defineInRange("maxheight_sapphire", 16, 0, 256);

        Builder.pop();
        Builder.push("Ruby Generation");
        generate_ruby = Builder.comment("Enable the Generation of Ruby Ore (Default: true).").define("generate_ruby", true);
        veinsize_ruby = Builder.comment("Set the Vein Size of the Ruby Ore (Default: 8).").defineInRange("veinsize_ruby", 8, 4, 255);
        count_ruby = Builder.comment("Set the Count of the Ruby Ore how much can spawn per Chunk (Default: 1).").defineInRange("count_ruby", 1, 1, 255);
        minheight_ruby = Builder.comment("Set the Min Height of the Ruby Ore (Default: 0).").defineInRange("minheight_ruby", 0, 0, 256);
        maxheight_ruby = Builder.comment("Set the Max  Height of the Ruby Ore (Default: 16).").defineInRange("maxheight_ruby", 16, 0, 256);
        Builder.pop();

        Builder.pop();
        Builder.push("Nether");
        Builder.push("Topaz Generation");
        generate_topaz = Builder.comment("Enable the Generation of Topaz Ore (Default: true).").define("generate_topaz", true);
        veinsize_topaz = Builder.comment("Set the Vein Size of the Topaz Ore (Default: 4).").defineInRange("veinsize_topaz", 4, 4, 255);
        count_topaz = Builder.comment("Set the Count of the Topaz Ore how much can spawn per Chunk (Default: 20).").defineInRange("count_topaz", 20, 1, 255);
        minheight_topaz = Builder.comment("Set the Min Height of the Topaz Ore (Default: 0).").defineInRange("minheight_topaz", 0, 0, 128);
        maxheight_topaz = Builder.comment("Set the Max Height of the Topaz Ore (Default: 128).").defineInRange("maxheight_topaz", 128, 0, 128);
        Builder.pop();

        Builder.pop();
        Builder.push("End");
        Builder.push("Amethyst Generation");
        generate_amethyst = Builder.comment("Enable the Generation of Amethyst Ore (Default: true).").define("generate_amethyst", true);
        count_amethyst = Builder.comment("Set the Count of the Amethyst Ore how much can spawn per Chunk (Default: 10).").defineInRange("count_amethyst", 10, 1, 255);
        minheight_amethyst = Builder.comment("Set the Min Height of the Amethyst Ore (Default: 0).").defineInRange("minheight_amethyst", 0, 0, 128);
        maxheight_amethyst = Builder.comment("Set the Max Height of the Amethyst Ore (Default: 128).").defineInRange("maxheight_amethyst", 128, 0, 128);
        Builder.pop();

        Builder.pop();
        Builder.pop();

        Builder.push("Tool Durabilities");
        Builder.push("Ruby");
        durabilitiy_ruby = Builder.comment("Set the Durability of Ruby Tools(Default: 1700).").defineInRange("durability_ruby", 1700, 0, 999999999);

        Builder.pop();
        Builder.push("Sapphire");
        durabilitiy_sapphire = Builder.comment("Set the Durability of Sapphire Tools(Default: 1700).").defineInRange("durability_sapphire", 1700, 0, 999999999);

        Builder.pop();
        Builder.push("Topaz");
        durabilitiy_topaz = Builder.comment("Set the Durability of Topaz Tools(Default: 1800).").defineInRange("durability_topaz", 1800, 0, 999999999);

        Builder.pop();
        Builder.push("Amethyst");
        durabilitiy_amethyst = Builder.comment("Set the Durability of Amethyst Tools(Default: 2000).").defineInRange("durability_amethyst", 2000, 0, 999999999);
        Builder.pop();
        Builder.pop();

        Builder.comment("Config File of the More Ores In ONE mod.");
        Builder.push("Armor");
        Builder.push("Status Effect");

        enable_statuseffects = Builder.comment("Enable if full Armor sets should give Potion Effects or not(Default: true).").define("enable_statuseffects", true);
        Builder.pop();
        Builder.pop();

    }



}

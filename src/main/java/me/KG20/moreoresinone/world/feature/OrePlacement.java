package me.KG20.moreoresinone.world.feature;

import com.google.common.base.Suppliers;
import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Init.RegisterBlocks;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class OrePlacement {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Constants.modid);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_EXPERIENCE_ORE_REPLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RegisterBlocks.overworldEXPOre.defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RegisterBlocks.deepslateOverworldEXPOre.defaultBlockState())
            )
    );

    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_EXPERIENCE_ORE_REPLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, RegisterBlocks.netherEXPOre.defaultBlockState())
            )
    );

    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_EXPERIENCE_ORE_REPLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), RegisterBlocks.endEXPOre.defaultBlockState())
            )
    );

    public static final Supplier<List<OreConfiguration.TargetBlockState>> RUBY_ORE_REPLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RegisterBlocks.rubyOre.defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RegisterBlocks.deepslateRubyOre.defaultBlockState())
            )
    );

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SAPPHIRE_ORE_REPLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RegisterBlocks.sapphireOre.defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RegisterBlocks.deepslateSapphireOre.defaultBlockState())
            )
    );

    public static final Supplier<List<OreConfiguration.TargetBlockState>> CRYORITE_ORE_REPLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(new BlockMatchTest(Blocks.BLUE_ICE), RegisterBlocks.cryoriteOre.defaultBlockState()),
                    OreConfiguration.target(new BlockMatchTest(Blocks.PACKED_ICE), RegisterBlocks.packedcryoriteOre.defaultBlockState())
            )
    );

    public static final Supplier<List<OreConfiguration.TargetBlockState>> TOPAZ_ORE_REPLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, RegisterBlocks.topazOre.defaultBlockState())
            )
    );

    public static final Supplier<List<OreConfiguration.TargetBlockState>> CORUNDUM_ORE_REPLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), RegisterBlocks.corundumOre.defaultBlockState())
            )
    );

    public static final RegistryObject<ConfiguredFeature<? , ?>> OVERWORLD_EXPERIENCE_ORE = CONFIGURED_FEATURES.register("overworld_experience_ore", () ->
            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_EXPERIENCE_ORE_REPLACEMENT.get(), Config.veinsize_overworld_experience.get())));

    public static final RegistryObject<ConfiguredFeature<? , ?>> NETHER_EXPERIENCE_ORE = CONFIGURED_FEATURES.register("nether_experience_ore", () ->
            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_EXPERIENCE_ORE_REPLACEMENT.get(), Config.veinsize_nether_experience.get())));

    public static final RegistryObject<ConfiguredFeature<? , ?>> END_EXPERIENCE_ORE = CONFIGURED_FEATURES.register("end_experience_ore", () ->
            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_EXPERIENCE_ORE_REPLACEMENT.get(), Config.veinsize_end_experience.get())));

    public static final RegistryObject<ConfiguredFeature<? , ?>> RUBY_ORE = CONFIGURED_FEATURES.register("ruby_ore", () ->
            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(RUBY_ORE_REPLACEMENT.get(), Config.veinsize_ruby.get())));

    public static final RegistryObject<ConfiguredFeature<? , ?>> SAPPHIRE_ORE = CONFIGURED_FEATURES.register("sapphire_ore", () ->
            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPPHIRE_ORE_REPLACEMENT.get(), Config.veinsize_sapphire.get())));

    public static final RegistryObject<ConfiguredFeature<? , ?>> CRYORITE_ORE = CONFIGURED_FEATURES.register("cryorite_ore", () ->
            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CRYORITE_ORE_REPLACEMENT.get(), Config.veinsize_cryorite.get())));

    public static final RegistryObject<ConfiguredFeature<? , ?>> TOPAZ_ORE = CONFIGURED_FEATURES.register("topaz_ore", () ->
            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(TOPAZ_ORE_REPLACEMENT.get(), Config.veinsize_topaz.get())));

    public static final RegistryObject<ConfiguredFeature<? , ?>> CORUNDUM_ORE = CONFIGURED_FEATURES.register("corundum_ore", () ->
            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CORUNDUM_ORE_REPLACEMENT.get(), Config.veinsize_corundum.get())));

}

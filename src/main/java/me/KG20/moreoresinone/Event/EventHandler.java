package me.KG20.moreoresinone.Event;

import me.KG20.moreoresinone.Armor.ItemArmor;
import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Init.RegisterArmor;
import me.KG20.moreoresinone.Init.RegisterTools;
import me.KG20.moreoresinone.Init.WorldGenerator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {


    @SubscribeEvent
    public static void LivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            PlayerEntity attackerIsPlayer = null;
            Entity attackerIsEntity = null;

            if (event.getSource().getTrueSource() instanceof PlayerEntity) {
                attackerIsPlayer = (PlayerEntity) event.getSource().getTrueSource();
            } else {
                attackerIsEntity = event.getSource().getTrueSource();
            }

            if (player != null) {
                ItemArmor topaz_Helmet = RegisterArmor.topazHelmet;
                ItemArmor topaz_Chestplate = RegisterArmor.topazChestplate;
                ItemArmor topaz_Leggings = RegisterArmor.topazLeggings;
                ItemArmor topaz_Boots = RegisterArmor.topazBoots;

                if (player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(topaz_Boots) && player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(topaz_Leggings) &&
                        player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(topaz_Chestplate) && player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(topaz_Helmet)) {

                    if (attackerIsPlayer == null && attackerIsEntity != null) {
                        attackerIsEntity.setFire(3);
                    } else if (attackerIsPlayer != null && attackerIsEntity == null) {
                        if (!attackerIsPlayer.getActivePotionEffects().toString().contains("effect.minecraft.fire_resistance")) {
                            if (!attackerIsPlayer.isCreative()) {
                                attackerIsPlayer.setFire(3);
                            }
                        }

                    }
                }
            }
        }

    }

    @SubscribeEvent
    public static void TopazSwordHitEntity(LivingHurtEvent event) {
        if (event.getSource().getTrueSource() instanceof PlayerEntity) {
            LivingEntity target = event.getEntityLiving();
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);

            if(RegisterTools.topazSword.equals(stack.getItem())){
                if(target instanceof PlayerEntity){
                    PlayerEntity playerTarget = (PlayerEntity)event.getEntityLiving();
                    if(!playerTarget.getActivePotionEffects().toString().contains("effect.minecraft.fire_resistance")){
                        if(!playerTarget.isCreative()){
                            playerTarget.setFire(3);
                        }
                    }
                }else{
                    target.setFire(3);
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void BiomeLoadingEvent(BiomeLoadingEvent event){
        if(event.getCategory() == Biome.Category.NETHER) {
            if (Config.generate_topaz.get()) {
                for (int i = 0; i < Config.count_topaz.get(); i++){
                    event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.TOPAZ_ORE);
                }
            }
            if(Config.generate_Nether_EXP_ORE.get()){
                for (int i = 0; i < Config.count_nether_experience.get(); i++){
                    event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.NETHER_EXPIERENCE_ORE);
                }
            }
        }
        else if(event.getCategory() == Biome.Category.THEEND){
            if(Config.generate_amethyst.get()) {
                System.out.println("Generiere Amethyst");
                for (int i = 0; i < Config.count_amethyst.get(); i++){
                    event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.AMETHYST_ORE);
                }
            }
            if(Config.generate_End_EXP_ORE.get()){
                for (int i = 0; i < Config.count_end_experience.get(); i++){
                    event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.END_EXPIERENCE_ORE);
                }
            }
        }
        else{
            if(Config.every_biome.get()){
                if(Config.generate_ruby.get()){
                    for (int i = 0; i < Config.count_ruby.get(); i++){
                        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.RUBY_ORE);
                    }
                }
                if(Config.generate_sapphire.get()) {
                    for (int i = 0; i < Config.count_sapphhire.get(); i++){
                        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.SAPPHIRE_ORE);
                    }
                }
            }else{
                if(Config.ruby_temperature.get() == 1D){
                    if((event.getCategory() == Biome.Category.SAVANNA || event.getCategory() == Biome.Category.DESERT || event.getCategory() == Biome.Category.MESA || event.getClimate().temperature > 1D) && Config.generate_ruby.get()){
                        for (int i = 0; i < Config.count_ruby.get(); i++){
                            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.RUBY_ORE);
                        }
                    }
                }else{
                    if(event.getClimate().temperature <= Config.ruby_temperature.get()){
                        for (int i = 0; i < Config.count_ruby.get(); i++){
                            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.RUBY_ORE);
                        }
                    }
                }
                if(Config.sapphire_temperature.get() == 0.2D){
                    if((event.getCategory() == Biome.Category.TAIGA || event.getCategory() == Biome.Category.OCEAN || event.getCategory() == Biome.Category.ICY || event.getClimate().temperature < 0.2D) && Config.generate_sapphire.get()){
                        for (int i = 0; i < Config.count_sapphhire.get(); i++){
                            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.SAPPHIRE_ORE);
                        }
                    }
                }else{
                    if(event.getClimate().temperature <= Config.sapphire_temperature.get()){
                        for (int i = 0; i < Config.count_sapphhire.get(); i++){
                            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.SAPPHIRE_ORE);
                        }
                    }
                }
                if(Config.generate_cryorite.get()){
                    for (int i = 0; i < Config.count_cryorite.get(); i++){
                        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.CRYORITE_ORE);
                    }
                }
            }
            if(Config.generate_Overworld_EXP_ORE.get()){
                for (int i = 0; i < Config.count_overworld_experience.get(); i++){
                    event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenerator.OVERWORLD_EXPIERENCE_ORE);
                }
            }
        }
    }
}


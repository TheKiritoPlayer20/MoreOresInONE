package me.KG20.moreoresinone.Event;

import me.KG20.moreoresinone.Armor.ItemArmor;
import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Init.RegisterArmor;
import me.KG20.moreoresinone.Init.RegisterTools;
import me.KG20.moreoresinone.world.feature.OrePlacement;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
public class EventHandler {



    @SubscribeEvent
    public static void LivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            Player attackerIsPlayer = null;
            Entity attackerIsEntity = null;

            if (event.getSource().getEntity() instanceof Player) {
                attackerIsPlayer = (Player) event.getSource().getEntity();
            } else {
                attackerIsEntity = event.getSource().getEntity();
            }

            ItemArmor topaz_Helmet = RegisterArmor.topazHelmet;
            ItemArmor topaz_Chestplate = RegisterArmor.topazChestplate;
            ItemArmor topaz_Leggings = RegisterArmor.topazLeggings;
            ItemArmor topaz_Boots = RegisterArmor.topazBoots;

            if (player.getItemBySlot(EquipmentSlot.FEET).getItem().equals(topaz_Boots) && player.getItemBySlot(EquipmentSlot.LEGS).getItem().equals(topaz_Leggings) &&
                    player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(topaz_Chestplate) && player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(topaz_Helmet)) {

                if (attackerIsPlayer == null && attackerIsEntity != null) {
                    attackerIsEntity.setSecondsOnFire(3);
                } else if (attackerIsPlayer != null) {
                    if (!attackerIsPlayer.getActiveEffects().toString().contains("effect.minecraft.fire_resistance")) {
                        if (!attackerIsPlayer.isCreative()) {
                            attackerIsPlayer.setSecondsOnFire(3);
                        }
                    }

                }
            }
        }
    }

    @SubscribeEvent
    public static void TopazSwordHitEntity(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            LivingEntity target = event.getEntity();
            ItemStack stack = player.getMainHandItem();

            if(RegisterTools.topazSword.equals(stack.getItem())){
                if(target instanceof Player){
                    Player playerTarget = (Player)event.getEntity();
                    if(!playerTarget.getActiveEffects().toString().contains("effect.minecraft.fire_resistance")){
                        if(!playerTarget.isCreative()){
                            playerTarget.setSecondsOnFire(3);
                        }
                    }
                }else{
                    target.setSecondsOnFire(3);
                }
            }
        }
    }

    /*
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void BiomeLoadingEvent(BiomeLoadingEvent event){
        GenerationStep.Decoration oreDecoration = GenerationStep.Decoration.UNDERGROUND_ORES;
        Biome.BiomeCategory biome = event.getCategory();
        if(biome.equals(Biome.BiomeCategory.NETHER)){
            if(Config.generate_topaz.get()){
                event.getGeneration().addFeature(oreDecoration, OrePlacement.TOPAZ_ORE);
            }
            if(Config.generate_Nether_EXP_ORE.get()){
                event.getGeneration().addFeature(oreDecoration, OrePlacement.NETHER_EXPIERENCE_ORE);
            }
        }else if(biome.equals(Biome.BiomeCategory.THEEND)){
            if(Config.generate_corundum.get()){
                event.getGeneration().addFeature(oreDecoration, OrePlacement.CORUNDUM_ORE);
            }
            if(Config.generate_End_EXP_ORE.get()){
                event.getGeneration().addFeature(oreDecoration, OrePlacement.END_EXPIERENCE_ORE);
            }
        }else{
            if(Config.every_biome.get()){
                if(Config.generate_ruby.get()){
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.RUBY_ORE);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.DEEPSLATE_RUBY_ORE);
                }
                if(Config.generate_sapphire.get()) {
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.SAPPHIRE_ORE);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.DEEPSLATE_SAPPHIRE_ORE);
                }
            }else{
                if(Config.ruby_temperature.get() == 1D){
                    if((event.getCategory() == Biome.BiomeCategory.SAVANNA || event.getCategory() == Biome.BiomeCategory.DESERT || event.getCategory() == Biome.BiomeCategory.MESA || event.getClimate().temperature > 1D) && Config.generate_ruby.get()){
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.RUBY_ORE);
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.DEEPSLATE_RUBY_ORE);
                    }
                }else{
                    if(event.getClimate().temperature <= Config.ruby_temperature.get()){
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.RUBY_ORE);
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.DEEPSLATE_RUBY_ORE);
                    }
                }
                if(Config.sapphire_temperature.get() == 0.2D){
                    if((event.getCategory() == Biome.BiomeCategory.TAIGA || event.getCategory() == Biome.BiomeCategory.OCEAN || event.getCategory() == Biome.BiomeCategory.ICY || event.getClimate().temperature < 0.2D) && Config.generate_sapphire.get()){
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.SAPPHIRE_ORE);
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.DEEPSLATE_SAPPHIRE_ORE);
                    }
                }else{
                    if(event.getClimate().temperature <= Config.sapphire_temperature.get()){
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.SAPPHIRE_ORE);
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.DEEPSLATE_SAPPHIRE_ORE);
                    }
                }
                if(Config.generate_cryorite.get()){
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.CRYORITE_ORE);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.PACKED_CRYORITE_ORE);
                }
            }
            if(Config.generate_Overworld_EXP_ORE.get()){
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.OVERWORLD_EXPIERENCE_ORE);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacement.DEEPSLATE_OVERWORLD_EXPIERENCE_ORE);
            }
        }
    }
    */

}


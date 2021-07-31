package me.KG20.moreoresinone.Event;

import me.KG20.moreoresinone.Armor.ItemArmor;
import me.KG20.moreoresinone.Config.Config;
import me.KG20.moreoresinone.Init.RegisterArmor;
import me.KG20.moreoresinone.Init.RegisterTools;
import me.KG20.moreoresinone.Init.WorldGenerator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {


    @SubscribeEvent
    public static void LivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            Player attackerIsPlayer = null;
            Entity attackerIsEntity = null;

            if (event.getSource().getEntity() instanceof Player) {
                attackerIsPlayer = (Player) event.getSource().getEntity();
            } else {
                attackerIsEntity = event.getSource().getEntity();
            }

            if (player != null) {
                ItemArmor topaz_Helmet = RegisterArmor.topazHelmet;
                ItemArmor topaz_Chestplate = RegisterArmor.topazChestplate;
                ItemArmor topaz_Leggings = RegisterArmor.topazLeggings;
                ItemArmor topaz_Boots = RegisterArmor.topazBoots;

                if (player.getItemBySlot(EquipmentSlot.FEET).getItem().equals(topaz_Boots) && player.getItemBySlot(EquipmentSlot.LEGS).getItem().equals(topaz_Leggings) &&
                        player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(topaz_Chestplate) && player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(topaz_Helmet)) {

                    if (attackerIsPlayer == null && attackerIsEntity != null) {
                        attackerIsEntity.setSecondsOnFire(3);
                    } else if (attackerIsPlayer != null && attackerIsEntity == null) {
                        if (!attackerIsPlayer.getActiveEffects().toString().contains("effect.minecraft.fire_resistance")) {
                            if (!attackerIsPlayer.isCreative()) {
                                attackerIsPlayer.setSecondsOnFire(3);
                            }
                        }

                    }
                }
            }
        }

    }

    @SubscribeEvent
    public static void TopazSwordHitEntity(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Player) {
            LivingEntity target = event.getEntityLiving();
            Player player = (Player) event.getSource().getEntity();
            ItemStack stack = player.getMainHandItem();

            if(RegisterTools.topazSword.equals(stack.getItem())){
                if(target instanceof Player){
                    Player playerTarget = (Player)event.getEntityLiving();
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

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void BiomeLoadingEvent(BiomeLoadingEvent event){
        if(event.getCategory() == Biome.BiomeCategory.NETHER) {
            if (Config.generate_topaz.get()) {
                for (int i = 0; i < Config.count_topaz.get(); i++){
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.TOPAZ_ORE);
                }
            }
            if(Config.generate_Nether_EXP_ORE.get()){
                for (int i = 0; i < Config.count_nether_experience.get(); i++){
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.NETHER_EXPIERENCE_ORE);
                }
            }
        }
        else if(event.getCategory() == Biome.BiomeCategory.THEEND){
            if(Config.generate_amethyst.get()) {
                for (int i = 0; i < Config.count_amethyst.get(); i++){
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.AMETHYST_ORE);
                }
            }
            if(Config.generate_End_EXP_ORE.get()){
                for (int i = 0; i < Config.count_end_experience.get(); i++){
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.END_EXPIERENCE_ORE);
                }
            }
        }
        else{
            if(Config.every_biome.get()){
                if(Config.generate_ruby.get()){
                    for (int i = 0; i < Config.count_ruby.get(); i++){
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.RUBY_ORE);
                    }
                }
                if(Config.generate_sapphire.get()) {
                    for (int i = 0; i < Config.count_sapphhire.get(); i++){
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.SAPPHIRE_ORE);
                    }
                }
            }else{

                if(Config.ruby_temperature.get() == 1D){
                    if((event.getCategory() == Biome.BiomeCategory.SAVANNA || event.getCategory() == Biome.BiomeCategory.DESERT || event.getCategory() == Biome.BiomeCategory.MESA || event.getClimate().temperature > 1D) && Config.generate_ruby.get()){
                        for (int i = 0; i < Config.count_ruby.get(); i++){
                            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.RUBY_ORE);
                        }
                    }
                }else{
                    if(event.getClimate().temperature <= Config.ruby_temperature.get()){
                        for (int i = 0; i < Config.count_ruby.get(); i++){
                            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.RUBY_ORE);
                        }
                    }
                }
                if(Config.sapphire_temperature.get() == 0.2D){
                    if((event.getCategory() == Biome.BiomeCategory.TAIGA || event.getCategory() == Biome.BiomeCategory.OCEAN || event.getCategory() == Biome.BiomeCategory.ICY || event.getClimate().temperature < 0.2D) && Config.generate_sapphire.get()){
                        for (int i = 0; i < Config.count_sapphhire.get(); i++){
                            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.SAPPHIRE_ORE);
                        }
                    }
                }else{
                    if(event.getClimate().temperature <= Config.sapphire_temperature.get()){
                        for (int i = 0; i < Config.count_sapphhire.get(); i++){
                            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.SAPPHIRE_ORE);
                        }
                    }
                }
                if(Config.generate_cryorite.get()){
                    for (int i = 0; i < Config.count_cryorite.get(); i++){
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.CRYORITE_ORE);
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.PACKED_CRYORITE_ORE);
                    }
                }
            }
            if(Config.generate_Overworld_EXP_ORE.get()){
                for (int i = 0; i < Config.count_overworld_experience.get(); i++){
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenerator.OVERWORLD_EXPIERENCE_ORE);
                }
            }
        }
    }
}


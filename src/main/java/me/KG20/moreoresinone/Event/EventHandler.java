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
}


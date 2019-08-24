package me.KG20.moreoresinone.Event;

import me.KG20.moreoresinone.Armor.ItemArmor;
import me.KG20.moreoresinone.Init.RegisterArmor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void LivingHurt(LivingHurtEvent event){
        if(event.getEntity() instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) event.getEntity();
            PlayerEntity attackerIsPlayer = null;
            Entity attackerIsEntity = null;

            if(event.getSource().getTrueSource() instanceof PlayerEntity){
                attackerIsPlayer = (PlayerEntity)event.getSource().getTrueSource();
            }else{
                attackerIsEntity = event.getSource().getTrueSource();
            }

            if(player !=null){
                ItemArmor topaz_Helmet = RegisterArmor.topazHelmet;
                ItemArmor topaz_Chestplate = RegisterArmor.topazChestplate;
                ItemArmor topaz_Leggings = RegisterArmor.topazLeggings;
                ItemArmor topaz_Boots = RegisterArmor.topazBoots;

                if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(topaz_Boots) && player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(topaz_Leggings) &&
                        player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(topaz_Chestplate) && player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(topaz_Helmet)) {

                    if(attackerIsPlayer == null && attackerIsEntity != null){
                        attackerIsEntity.setFire(3);
                    }else if(attackerIsPlayer != null && attackerIsEntity == null){
                        if(!attackerIsPlayer.getActivePotionEffects().toString().contains("effect.minecraft.fire_resistance")){
                            if(!attackerIsPlayer.isCreative()){
                                attackerIsPlayer.setFire(3);
                            }
                        }

                    }
                }
            }
        }

    }

}

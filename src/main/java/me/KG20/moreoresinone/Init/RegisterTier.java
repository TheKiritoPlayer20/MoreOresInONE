package me.KG20.moreoresinone.Init;

import com.google.common.eventbus.Subscribe;
import me.KG20.moreoresinone.Main.Constants;
import me.KG20.moreoresinone.Tools.BasisToolMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

//@Mod.EventBusSubscriber(modid = Constants.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterTier {

    public RegisterTier(){
        var stone = new ResourceLocation("stone");
        var iron = new ResourceLocation("iron");
        var diamond = new ResourceLocation("diamond");
        var cryorite = new ResourceLocation("cryorite");
        var ruby = new ResourceLocation("ruby");
        var sapphire = new ResourceLocation("sapphire");
        var topaz = new ResourceLocation("topaz");
        var corundum = new ResourceLocation("corundum");


        TierSortingRegistry.registerTier(BasisToolMaterial.cryorite, cryorite, List.of(stone), List.of(ruby, sapphire));
        TierSortingRegistry.registerTier(BasisToolMaterial.ruby, ruby, List.of(cryorite, iron), List.of(topaz));
        TierSortingRegistry.registerTier(BasisToolMaterial.sapphire, sapphire, List.of(cryorite, iron), List.of(topaz));
        TierSortingRegistry.registerTier(BasisToolMaterial.topaz, topaz, List.of(sapphire, ruby, diamond), List.of());
        TierSortingRegistry.registerTier(BasisToolMaterial.corundum, corundum, List.of(sapphire, ruby, diamond), List.of());
    }

}

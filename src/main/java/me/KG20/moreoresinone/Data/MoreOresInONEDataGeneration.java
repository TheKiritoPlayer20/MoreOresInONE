package me.KG20.moreoresinone.Data;

import me.KG20.moreoresinone.Data.Provider.BlockTagsProvider;
import me.KG20.moreoresinone.Data.Provider.ItemTagsProvider;
import me.KG20.moreoresinone.Main.Constants;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Constants.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreOresInONEDataGeneration {

    @SubscribeEvent
    public static void data(GatherDataEvent event){
        final DataGenerator dataGenerator = event.getGenerator();

        if (event.includeServer()) {
            dataGenerator.addProvider(new BlockTagsProvider(dataGenerator));
            dataGenerator.addProvider(new ItemTagsProvider(dataGenerator));
        }

    }

}

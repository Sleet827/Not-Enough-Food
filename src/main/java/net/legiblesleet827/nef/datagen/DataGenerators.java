package net.legiblesleet827.nef.datagen;

import net.legiblesleet827.nef.NotEnoughFood;
import net.legiblesleet827.nef.datagen.client.ModBlockStateProvider;
import net.legiblesleet827.nef.datagen.client.ModItemModelProvider;
import net.legiblesleet827.nef.datagen.client.ModLanguageProviderEN;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = NotEnoughFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            gen.addProvider(new ModLanguageProviderEN(gen));
            gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
            gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));
        }

        if (event.includeServer()) {
            gen.addProvider(new ModItemTagsProvider(gen, existingFileHelper));

            gen.addProvider(new ModRecipeProvider(gen));
            gen.addProvider(new ModLootTableProvider(gen));
        }
    }
}

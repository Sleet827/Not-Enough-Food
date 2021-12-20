package net.legiblesleet827.nef.datagen;

import net.legiblesleet827.nef.NotEnoughFood;
import net.legiblesleet827.nef.datagen.client.ModBlockStateGenerator;
import net.legiblesleet827.nef.datagen.client.ModItemModelGenerator;
import net.legiblesleet827.nef.datagen.client.ModLanguageGenerator;
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
            gen.addProvider(new ModLanguageGenerator(gen));
            gen.addProvider(new ModBlockStateGenerator(gen, existingFileHelper));
            gen.addProvider(new ModItemModelGenerator(gen, existingFileHelper));
        }

        if (event.includeServer()) {
            gen.addProvider(new ModItemTagsGenerator(gen, existingFileHelper));

            gen.addProvider(new ModRecipeGenerator(gen));
            gen.addProvider(new ModLootTableGenerator(gen));
        }
    }
}

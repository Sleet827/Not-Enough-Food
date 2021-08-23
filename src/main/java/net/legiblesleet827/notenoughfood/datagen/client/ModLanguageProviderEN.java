package net.legiblesleet827.notenoughfood.datagen.client;

import net.legiblesleet827.notenoughfood.NotEnoughFood;
import net.legiblesleet827.notenoughfood.setup.ModBlocks;
import net.legiblesleet827.notenoughfood.setup.ModEntities;
import net.legiblesleet827.notenoughfood.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProviderEN extends LanguageProvider {
    public ModLanguageProviderEN(DataGenerator gen) {
        super(gen, NotEnoughFood.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Blocks
        this.add(ModBlocks.PIZZA.get(), "Pizza");

        // Entities
        this.add(ModEntities.TURKEY.get(), "Turkey");

        // Items
        this.add(ModItems.CHICKEN_NUGGET.get(), "Chicken Nugget");
        this.add(ModItems.COOKED_CHICKEN_NUGGET.get(), "Cooked Chicken Nugget");
        this.add(ModItems.TURKEY.get(), "Raw Turkey");
        this.add(ModItems.COOKED_TURKEY.get(), "Cooked Turkey");
        this.add(ModItems.CHEESE.get(), "Cheese");
        this.add(ModItems.BURGER_BUN.get(), "Burger Bun");
        this.add(ModItems.BURGER.get(), "Burger");
        this.addSpawnEgg(ModItems.TURKEY_SPAWN_EGG.get(), "Turkey");
    }

    private void addSpawnEgg(Item spawnEgg, String name){
        this.add(spawnEgg, name.concat(" Spawn Egg"));
    }
}

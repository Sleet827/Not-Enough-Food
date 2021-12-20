package net.legiblesleet827.nef.datagen.client;

import net.legiblesleet827.nef.NotEnoughFood;
import net.legiblesleet827.nef.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageGenerator extends LanguageProvider {
    public ModLanguageGenerator(DataGenerator gen) {
        super(gen, NotEnoughFood.MODID, "en_gb");
    }

    @Override
    protected void addTranslations() {
        // Blocks
        this.add(Registration.PIZZA.get(), "Pizza");

        // Items
        this.add(Registration.BURGER.get(), "Burger");
        this.add(Registration.BURGER_BUN.get(), "Burger Bun");
        this.add(Registration.CHEESE.get(), "Cheese");
        this.add(Registration.CHICKEN_NUGGET.get(), "Chicken Nugget");
        this.add(Registration.COOKED_CHICKEN_NUGGET.get(), "Cooked Chicken Nugget");
        this.add(Registration.RAW_TURKEY.get(), "Raw Turkey");
        this.add(Registration.COOKED_TURKEY.get(), "Cooked Turkey");
        this.addSpawnEgg(Registration.TURKEY_SPAWN_EGG.get(), "Turkey");

        // Entities
        this.add(Registration.TURKEY.get(), "Turkey");
    }

    private void addSpawnEgg(Item spawnEgg, String name){
        this.add(spawnEgg, name.concat(" Spawn Egg"));
    }
}

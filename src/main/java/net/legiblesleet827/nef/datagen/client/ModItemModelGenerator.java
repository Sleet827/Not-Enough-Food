package net.legiblesleet827.nef.datagen.client;

import net.legiblesleet827.nef.NotEnoughFood;
import net.legiblesleet827.nef.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static net.legiblesleet827.nef.setup.ClientSetup.SIDE_PROPERTY;

public class ModItemModelGenerator extends ItemModelProvider {
    public ModItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, NotEnoughFood.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture(Registration.CHICKEN_NUGGET.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/chicken_nugget"));

        singleTexture(Registration.COOKED_CHICKEN_NUGGET.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/cooked_chicken_nugget"));

        singleTexture(Registration.RAW_TURKEY.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/turkey"));

        singleTexture(Registration.COOKED_TURKEY.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/cooked_turkey"));

        singleTexture(Registration.CHEESE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/cheese"));

        getBuilder(Registration.BURGER_BUN.get().getRegistryName().getPath())
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/burger_bun_top")
                .override().predicate(SIDE_PROPERTY, 0).model(createBurgerBunModel("top")).end()
                .override().predicate(SIDE_PROPERTY, 1).model(createBurgerBunModel("bottom")).end();

        singleTexture(Registration.BURGER.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/burger"));

        singleTexture(Registration.PIZZA.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/pizza"));

        getBuilder(Registration.TURKEY_SPAWN_EGG.get().getRegistryName().getPath())
                .parent(getExistingFile(mcLoc("item/template_spawn_egg")));
    }

    private ItemModelBuilder createBurgerBunModel(String suffix) {
        return getBuilder("burger_bun_" + suffix).parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/burger_bun_" + suffix);
    }
}

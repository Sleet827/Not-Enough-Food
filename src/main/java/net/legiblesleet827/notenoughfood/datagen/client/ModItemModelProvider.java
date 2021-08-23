package net.legiblesleet827.notenoughfood.datagen.client;

import net.legiblesleet827.notenoughfood.NotEnoughFood;
import net.legiblesleet827.notenoughfood.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static net.legiblesleet827.notenoughfood.setup.ClientSetup.SIDE_PROPERTY;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, NotEnoughFood.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture(ModItems.CHICKEN_NUGGET.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/chicken_nugget"));

        singleTexture(ModItems.COOKED_CHICKEN_NUGGET.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/cooked_chicken_nugget"));

        singleTexture(ModItems.TURKEY.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/turkey"));

        singleTexture(ModItems.COOKED_TURKEY.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/cooked_turkey"));

        singleTexture(ModItems.CHEESE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/cheese"));

        getBuilder(ModItems.BURGER_BUN.get().getRegistryName().getPath())
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/burger_bun_top")
                .override().predicate(SIDE_PROPERTY, 0).model(createBurgerBunModel("top")).end()
                .override().predicate(SIDE_PROPERTY, 1).model(createBurgerBunModel("bottom")).end();

        singleTexture(ModItems.BURGER.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/burger"));

        singleTexture(ModItems.PIZZA.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/pizza"));

        getBuilder(ModItems.TURKEY_SPAWN_EGG.get().getRegistryName().getPath())
                .parent(getExistingFile(mcLoc("item/template_spawn_egg")));
    }

    private ItemModelBuilder createBurgerBunModel(String suffix) {
        return getBuilder("burger_bun_" + suffix).parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/burger_bun_" + suffix);
    }
}

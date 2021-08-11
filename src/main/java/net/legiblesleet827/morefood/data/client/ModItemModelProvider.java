package net.legiblesleet827.morefood.data.client;

import net.legiblesleet827.morefood.MoreFood;
import net.legiblesleet827.morefood.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static net.legiblesleet827.morefood.setup.ClientSetup.SIDE_PROPERTY;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MoreFood.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        getBuilder(ModItems.BURGER_BUN.get().getRegistryName().getPath())
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/burger_bun_top")
                .override().predicate(SIDE_PROPERTY, 0).model(createBurgerBunModel("top")).end()
                .override().predicate(SIDE_PROPERTY, 1).model(createBurgerBunModel("bottom")).end();

        singleTexture(ModItems.BURGER.get().getRegistryName().getPath(),
                new ResourceLocation("item/generated"),
                "layer0",
                new ResourceLocation(MoreFood.MODID, "item/burger"));

        singleTexture(ModItems.PIZZA_ITEM.get().getRegistryName().getPath(),
                new ResourceLocation("item/generated"),
                "layer0",
                new ResourceLocation(MoreFood.MODID, "item/pizza"));
    }

    private ItemModelBuilder createBurgerBunModel(String suffix) {
        return getBuilder("burger_bun_" + suffix).parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/burger_bun_" + suffix);
    }
}

package net.legiblesleet827.morefood.data;

import net.legiblesleet827.morefood.MoreFood;
import net.legiblesleet827.morefood.setup.ModItems;
import net.legiblesleet827.morefood.setup.ModRecipes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ModItems.BURGER_BUN.get(), 2)
                .requires(Items.BREAD)
                .unlockedBy("has_bread", has(Items.BREAD))
                .group("morefood")
                .save(consumer);

        SpecialRecipeBuilder.special(ModRecipes.Serializers.BURGER_CRAFTING.get()).save(consumer, modId("burger_crafting").toString());
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(MoreFood.MODID, path);
    }
}

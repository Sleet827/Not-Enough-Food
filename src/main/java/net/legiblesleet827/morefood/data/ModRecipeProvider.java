package net.legiblesleet827.morefood.data;

import net.legiblesleet827.morefood.MoreFood;
import net.legiblesleet827.morefood.setup.ModItems;
import net.legiblesleet827.morefood.setup.ModRecipes;
import net.legiblesleet827.morefood.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModItems.PIZZA_ITEM.get())
                .define('C', ModTags.Items.COOKED_MEAT)
                .define('c', ModItems.CHEESE.get())
                .define('b', Items.BREAD)
                .pattern("C")
                .pattern("c")
                .pattern("b")
                .unlockedBy("has_cheese", has(ModItems.CHEESE.get()))
                .group("morefood")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Items.CHICKEN)
                .define('n', ModTags.Items.NUGGETS_CHICKEN)
                .pattern("nnn")
                .pattern("nnn")
                .pattern("nnn")
                .unlockedBy("has_chicken_nugget", has(ModTags.Items.NUGGETS_CHICKEN))
                .group("morefood")
                .save(consumer, modId("chicken_from_nuggets"));

        ShapedRecipeBuilder.shaped(Items.COOKED_CHICKEN)
                .define('n', ModItems.COOKED_CHICKEN_NUGGET.get())
                .pattern("nnn")
                .pattern("nnn")
                .pattern("nnn")
                .unlockedBy("has_cooked_chicken_nugget", has(ModItems.COOKED_CHICKEN_NUGGET.get()))
                .group("morefood")
                .save(consumer, modId("cooked_chicken_from_nuggets"));

        ShapelessRecipeBuilder.shapeless(ModItems.CHICKEN_NUGGET.get())
                .requires(Items.CHICKEN)
                .unlockedBy("has_chicken", has(Items.CHICKEN))
                .group("morefood")
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.COOKED_CHICKEN_NUGGET.get())
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy("has_cooked_chicken", has(Items.COOKED_CHICKEN))
                .group("morefood")
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CHEESE.get())
                .requires(Items.MILK_BUCKET)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .group("morefood")
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.BURGER_BUN.get(), 2)
                .requires(Items.BREAD)
                .unlockedBy("has_bread", has(Items.BREAD))
                .group("morefood")
                .save(consumer);

        SpecialRecipeBuilder.special(ModRecipes.Serializers.BURGER_CRAFTING.get()).save(consumer, modId("burger_crafting").toString());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.CHICKEN_NUGGET.get()), ModItems.COOKED_CHICKEN_NUGGET.get(), 0.7F, 200)
                .unlockedBy("has_chicken_nugget", has(ModTags.Items.NUGGETS_CHICKEN))
                .group("morefood")
                .save(consumer, modId("cooked_chicken_nugget_smelting"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.CHICKEN_NUGGET.get()), ModItems.COOKED_CHICKEN_NUGGET.get(), 0.7F, 100)
                .unlockedBy("has_chicken_nugget", has(ModTags.Items.NUGGETS_CHICKEN))
                .group("morefood")
                .save(consumer, modId("cooked_chicken_nugget_smoking"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ModItems.CHICKEN_NUGGET.get()), ModItems.COOKED_CHICKEN_NUGGET.get(), 0.7F, 100)
                .unlockedBy("has_chicken_nugget", has(ModTags.Items.NUGGETS_CHICKEN))
                .group("morefood")
                .save(consumer, modId("cooked_chicken_nugget_campfire_cooking"));
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(MoreFood.MODID, path);
    }
}

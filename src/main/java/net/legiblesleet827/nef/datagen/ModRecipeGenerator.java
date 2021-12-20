package net.legiblesleet827.nef.datagen;

import net.legiblesleet827.nef.NotEnoughFood;
import net.legiblesleet827.nef.setup.ModTags;
import net.legiblesleet827.nef.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class ModRecipeGenerator extends RecipeProvider {
    public ModRecipeGenerator(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(Registration.PIZZA.get())
                .define('C', ModTags.Items.COOKED_MEAT)
                .define('c', Registration.CHEESE.get())
                .define('b', Items.BREAD)
                .pattern("C")
                .pattern("c")
                .pattern("b")
                .unlockedBy("has_cheese", has(Registration.CHEESE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Items.CHICKEN)
                .define('n', ModTags.Items.NUGGETS_CHICKEN)
                .pattern("nnn")
                .pattern("nnn")
                .pattern("nnn")
                .unlockedBy("has_chicken_nugget", has(ModTags.Items.NUGGETS_CHICKEN))
                .save(consumer, modId("chicken_from_nuggets"));

        ShapedRecipeBuilder.shaped(Items.COOKED_CHICKEN)
                .define('n', Registration.COOKED_CHICKEN_NUGGET.get())
                .pattern("nnn")
                .pattern("nnn")
                .pattern("nnn")
                .unlockedBy("has_cooked_chicken_nugget", has(Registration.COOKED_CHICKEN_NUGGET.get()))
                .save(consumer, modId("cooked_chicken_from_nuggets"));

        ShapelessRecipeBuilder.shapeless(Registration.BURGER_BUN.get(), 2)
                .requires(Items.BREAD)
                .unlockedBy("has_bread", has(Items.BREAD))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(Registration.CHEESE.get())
                .requires(Items.MILK_BUCKET)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(Registration.CHICKEN_NUGGET.get(), 9)
                .requires(Items.CHICKEN)
                .unlockedBy("has_chicken", has(Items.CHICKEN))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(Registration.COOKED_CHICKEN_NUGGET.get(), 9)
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy("has_cooked_chicken", has(Items.COOKED_CHICKEN))
                .save(consumer);

        SpecialRecipeBuilder.special(Registration.BURGER_CRAFTING.get()).save(consumer, modId("burger").toString());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.CHICKEN_NUGGET.get()), Registration.COOKED_CHICKEN_NUGGET.get(), 0.7F, 200)
                .unlockedBy("has_chicken_nugget", has(ModTags.Items.NUGGETS_CHICKEN))
                .save(consumer, modId("chicken_nugget_smelting"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Registration.CHICKEN_NUGGET.get()), Registration.COOKED_CHICKEN_NUGGET.get(), 0.7F, 100)
                .unlockedBy("has_chicken_nugget", has(ModTags.Items.NUGGETS_CHICKEN))
                .save(consumer, modId("chicken_nugget_smoking"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Registration.CHICKEN_NUGGET.get()), Registration.COOKED_CHICKEN_NUGGET.get(), 0.7F, 100)
                .unlockedBy("has_chicken_nugget", has(ModTags.Items.NUGGETS_CHICKEN))
                .save(consumer, modId("chicken_nugget_campfire_cooking"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_TURKEY.get()), Registration.COOKED_TURKEY.get(), 0.7F, 200)
                .unlockedBy("has_turkey", has(Registration.RAW_TURKEY.get()))
                .save(consumer, modId("turkey_smelting"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Registration.RAW_TURKEY.get()), Registration.COOKED_TURKEY.get(), 0.7F, 100)
                .unlockedBy("has_turkey", has(Registration.RAW_TURKEY.get()))
                .save(consumer, modId("turkey_smoking"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Registration.RAW_TURKEY.get()), Registration.COOKED_TURKEY.get(), 0.7F, 100)
                .unlockedBy("has_turkey", has(Registration.RAW_TURKEY.get()))
                .save(consumer, modId("turkey_campfire_cooking"));
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(NotEnoughFood.MODID, path);
    }
}

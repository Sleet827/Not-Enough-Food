package net.legiblesleet827.morefood.setup;

import net.legiblesleet827.morefood.item.crafting.BurgerCrafting;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModRecipes {
    public static class Serializers {
        public static final RegistryObject<SimpleRecipeSerializer<BurgerCrafting>> BURGER_CRAFTING = Registration.RECIPE_SERIALIZERS.register("crafting_special_burger", () ->
                new SimpleRecipeSerializer<>(BurgerCrafting::new));
    }

    static void init() {}
}

package net.legiblesleet827.nef.setup;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_CHICKEN_NUGGET = new FoodProperties.Builder().nutrition(1).saturationMod(1).build();
    public static final FoodProperties COOKED_CHICKEN_NUGGET = new FoodProperties.Builder().nutrition(2).saturationMod(2).build();
    public static final FoodProperties TURKEY = new FoodProperties.Builder().nutrition(3).saturationMod(0.4F).meat().build();
    public static final FoodProperties COOKED_TURKEY = new FoodProperties.Builder().nutrition(7).saturationMod(0.7F).meat().build();
    public static final FoodProperties FRENCH_FRIES = new FoodProperties.Builder().nutrition(8).saturationMod(1.0F).build();
    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(1).saturationMod(1).build();
    public static final FoodProperties BURGER = new FoodProperties.Builder().nutrition(16).saturationMod(4).build();
}

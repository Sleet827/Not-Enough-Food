package net.legiblesleet827.notenoughfood.setup;

import net.legiblesleet827.notenoughfood.item.BurgerBun;
import net.legiblesleet827.notenoughfood.item.TurkeySpawnEggItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> CHICKEN_NUGGET = Registration.ITEMS.register("chicken_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.RAW_CHICKEN_NUGGET)));
    public static final RegistryObject<Item> COOKED_CHICKEN_NUGGET = Registration.ITEMS.register("cooked_chicken_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.COOKED_CHICKEN_NUGGET)));
    public static final RegistryObject<Item> TURKEY = Registration.ITEMS.register("turkey", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.TURKEY)));
    public static final RegistryObject<Item> COOKED_TURKEY = Registration.ITEMS.register("cooked_turkey", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.COOKED_TURKEY)));
    public static final RegistryObject<Item> CHEESE = Registration.ITEMS.register("cheese", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.CHEESE)));
    public static final RegistryObject<BurgerBun> BURGER_BUN = Registration.ITEMS.register("burger_bun", BurgerBun::new);
    public static final RegistryObject<Item> BURGER = Registration.ITEMS.register("burger", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.BURGER)));
    public static final RegistryObject<BlockItem> PIZZA = Registration.ITEMS.register("pizza", () ->
            new BlockItem(ModBlocks.PIZZA.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> TURKEY_SPAWN_EGG = Registration.ITEMS.register("turkey_spawn_egg", TurkeySpawnEggItem::new);

    static void init() {}
}

package net.legiblesleet827.morefood.setup;

import net.legiblesleet827.morefood.item.BurgerBun;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> CHICKEN_NUGGET = Registration.ITEMS.register("chicken_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.RAW_CHICKEN_NUGGET)));
    public static final RegistryObject<Item> COOKED_CHICKEN_NUGGET = Registration.ITEMS.register("cooked_chicken_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.COOKED_CHICKEN_NUGGET)));
    public static final RegistryObject<Item> CHEESE = Registration.ITEMS.register("cheese", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.CHEESE)));
    public static final RegistryObject<BurgerBun> BURGER_BUN = Registration.ITEMS.register("burger_bun", BurgerBun::new);
    public static final RegistryObject<Item> BURGER = Registration.ITEMS.register("burger", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.BURGER)));
    public static final RegistryObject<BlockItem> PIZZA_ITEM = Registration.ITEMS.register("pizza", () ->
            new BlockItem(ModBlocks.PIZZA.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));

    static void init() {}
}

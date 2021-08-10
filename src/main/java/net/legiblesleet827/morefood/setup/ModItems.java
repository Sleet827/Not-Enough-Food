package net.legiblesleet827.morefood.setup;

import net.legiblesleet827.morefood.item.BurgerBun;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModItems {
    public static final RegistryObject<BurgerBun> BURGER_BUN = Registration.ITEMS.register("burger_bun", BurgerBun::new);
    public static final RegistryObject<Item> BURGER = Registration.ITEMS.register("burger", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.BURGER)));
    public static final RegistryObject<BlockItem> PIZZA_ITEM = Registration.ITEMS.register("pizza", () ->
            new BlockItem(ModBlocks.PIZZA_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));

    static void init() {}
}

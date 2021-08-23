package net.legiblesleet827.notenoughfood.setup;

import net.legiblesleet827.notenoughfood.block.PizzaBlock;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModBlocks {
    public static final RegistryObject<PizzaBlock> PIZZA = Registration.BLOCKS.register("pizza", PizzaBlock::new);

    static void init() {}
}

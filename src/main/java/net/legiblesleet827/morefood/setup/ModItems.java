package net.legiblesleet827.morefood.setup;

import net.legiblesleet827.morefood.item.BurgerBun;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModItems {
    public static final RegistryObject<BurgerBun> BURGER_BUN = Registration.ITEMS.register("burger_bun", BurgerBun::new);

    static void register() {}
}

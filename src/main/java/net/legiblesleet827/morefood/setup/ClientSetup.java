package net.legiblesleet827.morefood.setup;

import net.legiblesleet827.morefood.MoreFood;
import net.legiblesleet827.morefood.item.BurgerBun;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {
    public static final ResourceLocation SIDE_PROPERTY = new ResourceLocation(MoreFood.MODID, "side");
    public static void setup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            initBurgerBunOverrides();
        });
    }

    private static void initBurgerBunOverrides() {
        BurgerBun item = ModItems.BURGER_BUN.get();
        ItemProperties.register(item, SIDE_PROPERTY,
                (stack, level, entity, damage) -> item.getSide(stack));
    }
}

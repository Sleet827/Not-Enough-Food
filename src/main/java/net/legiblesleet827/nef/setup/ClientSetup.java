package net.legiblesleet827.nef.setup;

import net.legiblesleet827.nef.NotEnoughFood;
import net.legiblesleet827.nef.entity.turkey.TurkeyRenderer;
import net.legiblesleet827.nef.item.BurgerBun;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = NotEnoughFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static final ResourceLocation SIDE_PROPERTY = new ResourceLocation(NotEnoughFood.MODID, "side");
    public static void setup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            initBurgerBunOverrides();
        });
    }

    private static void initBurgerBunOverrides() {
        BurgerBun item = Registration.BURGER_BUN.get();
        ItemProperties.register(item, SIDE_PROPERTY,
                (stack, level, entity, damage) -> item.getSide(stack));
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Registration.TURKEY.get(), TurkeyRenderer::new);
    }
}

package net.legiblesleet827.morefood.setup;

import net.legiblesleet827.morefood.MoreFood;
import net.legiblesleet827.morefood.entity.turkey.TurkeyModel;
import net.legiblesleet827.morefood.entity.turkey.TurkeyRenderer;
import net.legiblesleet827.morefood.item.BurgerBun;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = MoreFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
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

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TurkeyModel.TURKEY_LAYER, TurkeyModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.TURKEY.get(), TurkeyRenderer::new);
    }
}

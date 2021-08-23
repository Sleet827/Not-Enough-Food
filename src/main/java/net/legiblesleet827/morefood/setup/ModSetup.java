package net.legiblesleet827.morefood.setup;

import net.legiblesleet827.morefood.MoreFood;
import net.legiblesleet827.morefood.entity.turkey.Turkey;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TURKEY.get(), Turkey.createAttributes().build());
    }
}

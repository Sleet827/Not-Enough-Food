package net.legiblesleet827.nef.setup;

import net.legiblesleet827.nef.NotEnoughFood;
import net.legiblesleet827.nef.entity.turkey.Turkey;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NotEnoughFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(Registration.TURKEY.get(), Turkey.createAttributes().build());
    }
}

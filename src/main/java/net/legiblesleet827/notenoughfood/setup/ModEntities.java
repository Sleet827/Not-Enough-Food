package net.legiblesleet827.notenoughfood.setup;

import net.legiblesleet827.notenoughfood.entity.turkey.Turkey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModEntities {
    public static final RegistryObject<EntityType<Turkey>> TURKEY = Registration.ENTITIES.register("turkey", () -> EntityType.Builder.of(Turkey::new, MobCategory.CREATURE)
            .sized(.5f, .8f)
            .setShouldReceiveVelocityUpdates(false)
            .build("turkey"));

    static void init() {
    }
}

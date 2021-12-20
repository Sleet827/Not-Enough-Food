package net.legiblesleet827.nef.setup;

import net.legiblesleet827.nef.entity.turkey.Turkey;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class WorldSetup {
    public static void setup(final BiomeLoadingEvent event) {
        SpawnPlacements.register(Registration.TURKEY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Turkey::checkAnimalSpawnRules);
    }
}

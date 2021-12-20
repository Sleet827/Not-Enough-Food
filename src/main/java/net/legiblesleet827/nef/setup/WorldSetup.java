package net.legiblesleet827.nef.setup;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class WorldSetup {
    public static void setup(final BiomeLoadingEvent event) {
        event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(Registration.TURKEY.get(), 10, 4, 4));
    }
}
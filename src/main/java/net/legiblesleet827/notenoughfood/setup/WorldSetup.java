package net.legiblesleet827.notenoughfood.setup;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class WorldSetup {
    public static void setup(final BiomeLoadingEvent event) {
        event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.TURKEY.get(), 10, 4, 4));
    }
}

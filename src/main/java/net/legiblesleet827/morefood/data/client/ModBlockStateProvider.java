package net.legiblesleet827.morefood.data.client;

import net.legiblesleet827.morefood.MoreFood;
import net.legiblesleet827.morefood.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, MoreFood.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        getVariantBuilder(ModBlocks.PIZZA_BLOCK.get())
                .forAllStates(state -> {
                    int bites = state.getValue(BlockStateProperties.BITES);
                    if (bites != 0) {
                        return ConfiguredModel.builder()
                                .modelFile(models().getExistingFile(modLoc("block/pizza_slice" + bites)))
                                .build();
                    } else {
                        return ConfiguredModel.builder()
                                .modelFile(models().getExistingFile(modLoc("block/pizza")))
                                .build();
                    }
                });
    }
}

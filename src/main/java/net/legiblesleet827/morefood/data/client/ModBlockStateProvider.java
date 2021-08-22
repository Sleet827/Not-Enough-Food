package net.legiblesleet827.morefood.data.client;

import net.legiblesleet827.morefood.MoreFood;
import net.legiblesleet827.morefood.setup.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, MoreFood.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        getVariantBuilder(ModBlocks.PIZZA.get())
                .forAllStates(state -> {
                    int bites = state.getValue(BlockStateProperties.BITES);
                    return ConfiguredModel.builder().modelFile(createPizzaSliceModel(bites)).build();
                });
    }

    private BlockModelBuilder createPizzaSliceModel(int bites) {
        return models().getBuilder(ModBlocks.PIZZA.get().getRegistryName().getPath() + "_slice" + bites)
                .texture("particle", modLoc("block/pizza_side"))
                .texture("bottom", modLoc("block/pizza_bottom"))
                .texture("top", modLoc("block/pizza_top"))
                .texture("side", modLoc("block/pizza_side"))
                .texture("inside", modLoc("block/pizza_inner"))
                .element().from((bites + (bites + 1)), 0, 1)
                .to(15, 1, 15)
                .face(Direction.DOWN).texture("#bottom").cullface(Direction.DOWN).end()
                .face(Direction.UP).texture("#top").end()
                .face(Direction.NORTH).texture("#side").end()
                .face(Direction.SOUTH).texture("#side").end()
                .face(Direction.WEST).texture(bites > 0 ? "#inside" : "#side").end()
                .face(Direction.EAST).texture("#side").end().end();
    }
}

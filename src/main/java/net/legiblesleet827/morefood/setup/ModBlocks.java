package net.legiblesleet827.morefood.setup;

import net.legiblesleet827.morefood.block.PizzaBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModBlocks {
    public static final RegistryObject<PizzaBlock> PIZZA = Registration.BLOCKS.register("pizza", PizzaBlock::new);

    static void init() {}
}

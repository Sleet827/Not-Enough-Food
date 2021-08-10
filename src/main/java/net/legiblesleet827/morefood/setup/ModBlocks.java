package net.legiblesleet827.morefood.setup;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModBlocks {
    public static final RegistryObject<Block> PIZZA_BLOCK = Registration.BLOCKS.register("pizza", () ->
            new CakeBlock(BlockBehaviour.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)));

    static void register() {}
}

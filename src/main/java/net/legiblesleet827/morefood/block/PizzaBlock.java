package net.legiblesleet827.morefood.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PizzaBlock extends Block {
    public static final int MAX_BITES = 6;
    public static final IntegerProperty BITES = BlockStateProperties.BITES;
    protected static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]{Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D), Block.box(3.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D), Block.box(5.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D), Block.box(7.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D), Block.box(9.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D), Block.box(11.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D), Block.box(13.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D)};

    public PizzaBlock() {
        super(BlockBehaviour.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL));
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, Integer.valueOf(0)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51220_) {
        p_51220_.add(new Property[]{BITES});
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE_BY_BITE[blockState.getValue(BITES)];
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (level.isClientSide) {
            if (eat(level, blockPos, blockState, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat(level, blockPos, blockState, player);
    }

    protected static InteractionResult eat(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.getFoodData().eat(2, 1F);
            int i = blockState.getValue(BITES);
            levelAccessor.gameEvent(player, GameEvent.EAT, blockPos);
            if (i < 6) {
                levelAccessor.setBlock(blockPos, blockState.setValue(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                levelAccessor.removeBlock(blockPos, false);
                levelAccessor.gameEvent(player, GameEvent.BLOCK_DESTROY, blockPos);
            }

            return InteractionResult.SUCCESS;
        }
    }
}

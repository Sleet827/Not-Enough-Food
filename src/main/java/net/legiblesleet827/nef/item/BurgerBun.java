package net.legiblesleet827.nef.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BurgerBun extends Item {
    public BurgerBun() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD));
        new ItemStack(this).getOrCreateTag().putInt("side", 0);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        int side = stack.getOrCreateTag().getInt("side");
        if (side == 0) {
            side = 1;
        } else {
            side = 0;
        }
        stack.getTag().putInt("side", side);
        return InteractionResultHolder.success(stack);
    }

    public int getSide(ItemStack stack) {
        return stack.hasTag() ? stack.getTag().getInt("side") : 0;
    }


}
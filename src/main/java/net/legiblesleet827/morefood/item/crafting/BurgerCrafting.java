package net.legiblesleet827.morefood.item.crafting;

import net.legiblesleet827.morefood.setup.ModItems;
import net.legiblesleet827.morefood.setup.ModRecipes;
import net.legiblesleet827.morefood.setup.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class BurgerCrafting extends CustomRecipe {
    public BurgerCrafting(ResourceLocation path) {
        super(path);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;

        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack itemstack = container.getItem(i);
            if (!itemstack.isEmpty()) {
                if (itemstack.is(ModItems.BURGER_BUN.get()) && itemstack.getTag().getInt("side") == 0 && !flag) {
                    flag = true;
                } else if (itemstack.is(ModTags.Items.COOKED_MEAT) && !flag1) {
                    flag1 = true;
                } else if (itemstack.is(ModItems.BURGER_BUN.get()) && itemstack.getTag().getInt("side") == 1 && !flag2) {
                    flag2 = true;
                }
            }
        }

        return flag && flag1 && flag2;
    }

    @Override
    public ItemStack assemble(CraftingContainer container) {
        return new ItemStack(ModItems.BURGER.get());
    }

    @Override
    public boolean canCraftInDimensions(int int1, int int2) {
        return int1 >= 3 && int2 >= 3;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.Serializers.BURGER_CRAFTING.get();
    }
}

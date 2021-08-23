package net.legiblesleet827.notenoughfood.item.crafting;

import net.legiblesleet827.notenoughfood.NotEnoughFood;
import net.legiblesleet827.notenoughfood.setup.ModItems;
import net.legiblesleet827.notenoughfood.setup.ModRecipes;
import net.legiblesleet827.notenoughfood.setup.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

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
                if (itemstack.is(ModItems.BURGER_BUN.get()) && !flag) {
                    if (itemstack.hasTag()) {
                        if (itemstack.getTag().getInt("side") == 0) {
                            try {
                                ItemStack itemBelow = container.getItem(i + 3);
                                if (itemBelow.is(ModTags.Items.COOKED_MEAT)) {
                                    flag = true;
                                }
                            } catch (Exception e) {
                                NotEnoughFood.LOGGER.error(e);
                            }
                        }
                    } else {
                        ItemStack itemBelow = container.getItem(i + 3);
                        if (itemBelow.is(ModTags.Items.COOKED_MEAT)) {
                            flag = true;
                        }
                    }
                } else if (itemstack.is(ModTags.Items.COOKED_MEAT) && !flag1) {
                    try {
                        ItemStack itemAbove = container.getItem(i - 3);
                        ItemStack itemBelow = container.getItem(i + 3);
                        if (itemAbove.is(ModItems.BURGER_BUN.get()) && itemBelow.is(ModItems.BURGER_BUN.get())) {
                            flag1 = true;
                        }
                    } catch (Exception e) {
                        NotEnoughFood.LOGGER.error(e);
                    }
                } else if (itemstack.is(ModItems.BURGER_BUN.get()) && !flag2) {
                    if (itemstack.hasTag()) {
                        if (itemstack.getTag().getInt("side") == 1) {
                            try {
                                ItemStack itemAbove = container.getItem(i - 3);
                                if (itemAbove.is(ModTags.Items.COOKED_MEAT)) {
                                    flag2 = true;
                                }
                            } catch (Exception e) {
                                NotEnoughFood.LOGGER.error(e);
                            }
                        }
                    }
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

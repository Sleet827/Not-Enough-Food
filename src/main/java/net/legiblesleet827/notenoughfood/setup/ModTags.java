package net.legiblesleet827.notenoughfood.setup;

import net.legiblesleet827.notenoughfood.NotEnoughFood;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {
        public static final Tag.Named<Item> NUGGETS_CHICKEN = forge("nuggets/chicken");
        public static final Tag.Named<Item> COOKED_MEAT = mod("cooked_meat");

        private static Tag.Named<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static Tag.Named<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(NotEnoughFood.MODID, path).toString());
        }
    }
}

package net.legiblesleet827.notenoughfood.data;

import net.legiblesleet827.notenoughfood.NotEnoughFood;
import net.legiblesleet827.notenoughfood.setup.ModItems;
import net.legiblesleet827.notenoughfood.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider{
    public ModItemTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, new BlockTagsProvider(generator, NotEnoughFood.MODID, existingFileHelper), NotEnoughFood.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Items.NUGGETS_CHICKEN).add(ModItems.CHICKEN_NUGGET.get());
        tag(Tags.Items.NUGGETS).addTags(ModTags.Items.NUGGETS_CHICKEN);
        tag(ModTags.Items.COOKED_MEAT).add(Items.COOKED_BEEF).add(Items.COOKED_COD).add(Items.COOKED_CHICKEN).add(ModItems.COOKED_TURKEY.get()).add(Items.COOKED_MUTTON).add(Items.COOKED_RABBIT).add(Items.COOKED_PORKCHOP).add(Items.COOKED_SALMON);
    }
}

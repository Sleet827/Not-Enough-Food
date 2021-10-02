package net.legiblesleet827.nef.setup;

import net.legiblesleet827.nef.NotEnoughFood;
import net.legiblesleet827.nef.block.PizzaBlock;
import net.legiblesleet827.nef.entity.turkey.Turkey;
import net.legiblesleet827.nef.item.BurgerBun;
import net.legiblesleet827.nef.item.TurkeySpawnEggItem;
import net.legiblesleet827.nef.item.crafting.BurgerCrafting;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
    public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
    public static final DeferredRegister<EntityType<?>> ENTITIES = create(ForgeRegistries.ENTITIES);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = create(ForgeRegistries.RECIPE_SERIALIZERS);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        ENTITIES.register(bus);
        RECIPE_SERIALIZERS.register(bus);
    }

    private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, NotEnoughFood.MODID);
    }

    public static final RegistryObject<PizzaBlock> PIZZA = BLOCKS.register("pizza", PizzaBlock::new);

    public static final RegistryObject<Item> CHICKEN_NUGGET = ITEMS.register("chicken_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.RAW_CHICKEN_NUGGET)));
    public static final RegistryObject<Item> COOKED_CHICKEN_NUGGET = ITEMS.register("cooked_chicken_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.COOKED_CHICKEN_NUGGET)));
    public static final RegistryObject<Item> RAW_TURKEY = ITEMS.register("turkey", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.TURKEY)));
    public static final RegistryObject<Item> COOKED_TURKEY = ITEMS.register("cooked_turkey", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.COOKED_TURKEY)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.CHEESE)));
    public static final RegistryObject<BurgerBun> BURGER_BUN = ITEMS.register("burger_bun", BurgerBun::new);
    public static final RegistryObject<Item> BURGER = ITEMS.register("burger", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.BURGER)));
    public static final RegistryObject<BlockItem> PIZZA_ITEM = ITEMS.register("pizza", () ->
            new BlockItem(PIZZA.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> TURKEY_SPAWN_EGG = ITEMS.register("turkey_spawn_egg", TurkeySpawnEggItem::new);

    public static final RegistryObject<SimpleRecipeSerializer<BurgerCrafting>> BURGER_CRAFTING = RECIPE_SERIALIZERS.register("crafting_special_burger", () ->
            new SimpleRecipeSerializer<>(BurgerCrafting::new));

    public static final RegistryObject<EntityType<Turkey>> TURKEY = ENTITIES.register("turkey", () -> EntityType.Builder.of(Turkey::new, MobCategory.CREATURE)
            .sized(.5f, .8f)
            .setShouldReceiveVelocityUpdates(false)
            .build("turkey"));
}

package net.necrokochou.testmod.item;

import net.minecraft.world.item.Item;
import net.necrokochou.testmod.TestMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register(
            "bismuth",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register(
            "raw_bismuth",
            () -> new Item(new Item.Properties()));

    public static void Register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package net.necrokochou.testmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.necrokochou.testmod.TestMod;
import net.necrokochou.testmod.item.custom.ChiselItem;
import net.necrokochou.testmod.item.custom.FuelItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register(
            "bismuth",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register(
            "raw_bismuth",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> CHISEL = ITEMS.register(
            "chisel",
            () -> new ChiselItem(new Item.Properties().durability(32))
    );
    public static final DeferredItem<Item> RADISH = ITEMS.register(
            "radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.testmod.radish"));

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }
    );

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register(
            "frostfire_ice",
            () -> new FuelItem(new Item.Properties(), 800)
    );

    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register(
            "starlight_ashes",
            () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

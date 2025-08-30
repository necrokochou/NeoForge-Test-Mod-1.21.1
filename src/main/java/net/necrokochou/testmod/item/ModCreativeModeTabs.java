package net.necrokochou.testmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.necrokochou.testmod.TestMod;
import net.necrokochou.testmod.block.ModBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register(
            "bismuth_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.testmod.bismuth_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.RADISH);
                        output.accept(ModItems.FROSTFIRE_ICE);
                        output.accept(ModItems.STARLIGHT_ASHES);
                    }).build()
    );
    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB = CREATIVE_MODE_TAB.register(
            "bismuth_blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "bismuth_items_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
                    .title(Component.translatable("creativetab.testmod.bismuth_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                        output.accept(ModBlocks.BISMUTH_STAIRS);
                        output.accept(ModBlocks.BISMUTH_SLAB);
                        output.accept(ModBlocks.BISMUTH_PRESSURE_PLATE);
                        output.accept(ModBlocks.BISMUTH_BUTTON);
                        output.accept(ModBlocks.BISMUTH_FENCE);
                        output.accept(ModBlocks.BISMUTH_FENCE_GATE);
                        output.accept(ModBlocks.BISMUTH_WALL);
                        output.accept(ModBlocks.BISMUTH_DOOR);
                        output.accept(ModBlocks.BISMUTH_TRAPDOOR);
                        output.accept(ModBlocks.BISMUTH_LAMP);
                    }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

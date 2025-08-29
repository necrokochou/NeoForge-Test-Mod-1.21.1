package net.necrokochou.testmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.necrokochou.testmod.TestMod;
import net.necrokochou.testmod.block.ModBlocks;
import net.necrokochou.testmod.item.ModItems;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BISMUTH.get());
        basicItem(ModItems.RAW_BISMUTH.get());
        basicItem(ModItems.RADISH.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.CHISEL.get());

        buttonItem(ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_BLOCK);
        fenceItem(ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_BLOCK);
        wallItem(ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_BLOCK);

        basicItem(ModBlocks.BISMUTH_DOOR.get().asItem());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        buttonInventory(block.getId().getPath(), modLoc("block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        fenceInventory(block.getId().getPath(), modLoc("block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        wallInventory(block.getId().getPath(), modLoc("block/" + baseBlock.getId().getPath()));
    }

//    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
//        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
//                .texture("particle", ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID,
//                        "block/" + baseBlock.getId().getPath()));
//    }
//
//    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
//        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
//                .texture("texture", ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID,
//                        "block/" + baseBlock.getId().getPath()));
//    }
//
//    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
//        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
//                .texture("wall", ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID,
//                        "block/" + baseBlock.getId().getPath()));
//    }
}

package net.necrokochou.testmod.datagen;

import net.minecraft.data.PackOutput;
import net.necrokochou.testmod.TestMod;
import net.necrokochou.testmod.block.ModBlocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BISMUTH_BLOCK);
        blockWithItem(ModBlocks.BISMUTH_ORE);
        blockWithItem(ModBlocks.BISMUTH_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(ModBlocks.BISMUTH_STAIRS.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        slabBlock(ModBlocks.BISMUTH_SLAB.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        pressurePlateBlock(ModBlocks.BISMUTH_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        buttonBlock(ModBlocks.BISMUTH_BUTTON.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        fenceBlock(ModBlocks.BISMUTH_FENCE.get(),  blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        fenceGateBlock(ModBlocks.BISMUTH_FENCE_GATE.get(),  blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        wallBlock(ModBlocks.BISMUTH_WALL.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        doorBlockWithRenderType(ModBlocks.BISMUTH_DOOR.get(),
                modLoc("block/bismuth_door_bottom"),
                modLoc("block/bismuth_door_top"),
                "cutout");
        trapdoorBlockWithRenderType(ModBlocks.BISMUTH_TRAPDOOR.get(),
                modLoc("block/bismuth_trapdoor"),
                true,
                "cutout");

        blockItem(ModBlocks.BISMUTH_STAIRS);
        blockItem(ModBlocks.BISMUTH_SLAB);
        blockItem(ModBlocks.BISMUTH_PRESSURE_PLATE);
//        blockItem(ModBlocks.BISMUTH_BUTTON);
//        blockItem(ModBlocks.BISMUTH_FENCE);
        blockItem(ModBlocks.BISMUTH_FENCE_GATE);
//        blockItem(ModBlocks.BISMUTH_WALL);
//        blockItem(ModBlocks.BISMUTH_DOOR);
        blockItem(ModBlocks.BISMUTH_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(DeferredBlock<?> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void blockItem(DeferredBlock<?> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile("testmod:block/" + block.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> block, String appendix) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile("testmod:block/" + block.getId().getPath() + appendix));
    }
}

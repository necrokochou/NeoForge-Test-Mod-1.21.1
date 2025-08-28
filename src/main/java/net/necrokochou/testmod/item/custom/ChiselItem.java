package net.necrokochou.testmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.necrokochou.testmod.block.ModBlocks;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP = Map.of(
            Blocks.STONE, Blocks.STONE_BRICKS,
            Blocks.STONE_BRICKS, Blocks.STONE,
            Blocks.END_STONE, Blocks.END_STONE_BRICKS,
            Blocks.END_STONE_BRICKS, Blocks.END_STONE,
            Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
            Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE,
            Blocks.OBSIDIAN, ModBlocks.BISMUTH_BLOCK.get(),
            ModBlocks.BISMUTH_BLOCK.get(), Blocks.OBSIDIAN
    );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block interactedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (CHISEL_MAP.containsKey(interactedBlock)) {
            if (level.isClientSide())
                return InteractionResult.PASS;

            level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(interactedBlock).defaultBlockState());

            context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                    item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

            level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
        }

        return super.useOn(context);
    }
}

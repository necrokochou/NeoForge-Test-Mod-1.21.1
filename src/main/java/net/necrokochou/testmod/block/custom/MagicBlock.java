package net.necrokochou.testmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.necrokochou.testmod.item.ModItems;
import net.necrokochou.testmod.util.ModTags;

import java.util.List;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (isValidItem(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(Items.NETHERITE_INGOT, itemEntity.getItem().getCount()));
            }

//            if (itemEntity.getItem().getItem() == ModItems.BISMUTH.get()) {
//                itemEntity.setItem(new ItemStack(Items.NETHERITE_INGOT, itemEntity.getItem().getCount()));
//            }

//            if (itemEntity.getItem().getItem() == Items.NETHERITE_INGOT) {
//                itemEntity.setItem(new ItemStack(ModItems.BISMUTH.get(), itemEntity.getItem().getCount()));
//            }
        }

        super.stepOn(level, pos, state, entity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.testmod.magic_block"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}

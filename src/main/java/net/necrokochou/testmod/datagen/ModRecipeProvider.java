package net.necrokochou.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.necrokochou.testmod.TestMod;
import net.necrokochou.testmod.block.ModBlocks;
import net.necrokochou.testmod.item.ModItems;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BISMUTH_SMELTABLES = List.of(
                ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_ORE, ModBlocks.BISMUTH_DEEPSLATE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK)
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BISMUTH)
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH, 9)
                .requires(ModBlocks.BISMUTH_BLOCK)
                .unlockedBy("has_bismuth_block", has(ModBlocks.BISMUTH_BLOCK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH, 18)
                .requires(ModBlocks.MAGIC_BLOCK)
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK))
                .save(recipeOutput, "testmod:bismuth_from_magic_block");

        oreSmelting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH, 0.25f, 200, "bismuth");
        oreBlasting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH, 0.25f, 100, "bismuth");

        stairBuilder(ModBlocks.BISMUTH_STAIRS, Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_SLAB, ModItems.BISMUTH);

        buttonBuilder(ModBlocks.BISMUTH_BUTTON, Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);

        pressurePlate(recipeOutput, ModBlocks.BISMUTH_PRESSURE_PLATE, ModItems.BISMUTH);

        fenceBuilder(ModBlocks.BISMUTH_FENCE, Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);

        fenceGateBuilder(ModBlocks.BISMUTH_FENCE_GATE, Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_WALL, ModItems.BISMUTH);

        doorBuilder(ModBlocks.BISMUTH_DOOR, Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);

        trapdoorBuilder(ModBlocks.BISMUTH_TRAPDOOR, Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category,
                                      ItemLike result, float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result,
                experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category,
                                      ItemLike result, float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result,
                experience, cookingTime, group, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput recipeOutput, RecipeSerializer<T> recipeSerializer, AbstractCookingRecipe.Factory<T> factory,
            List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime,
            String group, String recipeName) {
        for (ItemLike ingredient : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(ingredient), category, result, experience, cookingTime, recipeSerializer, factory)
                    .group(group)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(recipeOutput, TestMod.MOD_ID + ':' + getItemName(result) + recipeName + '_' + getItemName(ingredient));
        }
    }
}

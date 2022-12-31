package com.dreamtea.wild_blocks.utils;

import com.dreamtea.wild_blocks.registry.BlockAlts;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SingleItemRecipeJsonBuilder;
import net.minecraft.recipe.Ingredient;

import java.util.function.Consumer;

import static net.minecraft.data.server.RecipeProvider.conditionsFromItem;
import static net.minecraft.data.server.RecipeProvider.hasItem;

public class RecipeUtils {

    @FunctionalInterface
    public interface RecipeProducer{
        ShapedRecipeJsonBuilder make(Block base, Block output);
    }

    public static void registerStoneCutter(Consumer<RecipeJsonProvider> exporter, Block base, Block output, String blockName, BlockAlts.BlockType type){
        SingleItemRecipeJsonBuilder.createStonecutting(
                        Ingredient.ofItems(base),
                        output,
                        type.stonecutterOutput
                ).criterion(hasItem(base), conditionsFromItem(base))
                .offerTo(exporter, String.format("%s_%s_from_stonecutter", blockName, type.lowerCaseName));
    }

    public static ShapedRecipeJsonBuilder makeStair(Block base, Block output){
        return ShapedRecipeJsonBuilder.create(output, 6)
                .input('#', base)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###");
    }

    public static ShapedRecipeJsonBuilder makeSlab(Block base, Block output){
        return ShapedRecipeJsonBuilder.create(output, 6)
                .input('#', base)
                .pattern("###");
    }

    public static ShapedRecipeJsonBuilder makeWall(Block base, Block output){
        return ShapedRecipeJsonBuilder.create(output, 6)
                .input('#', base)
                .pattern("###")
                .pattern("###");
    }
}

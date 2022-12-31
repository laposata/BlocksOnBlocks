package com.dreamtea.wild_blocks.datagen;

import com.dreamtea.wild_blocks.registry.BlockAlts;
import com.dreamtea.wild_blocks.registry.AltList;
import com.dreamtea.wild_blocks.utils.OnAlts;
import com.dreamtea.wild_blocks.utils.RecipeUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.function.Consumer;

public class Recipes extends FabricRecipeProvider {

    public Recipes(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }



    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        AltList.SIMPLE_ALTS.forEach(alts -> {
            register(alts, exporter);
        });
    }

    private void register(BlockAlts blocks, Consumer<RecipeJsonProvider> exporter){
        registerShapedRecipes(blocks, exporter);
        registerStoneCutterRecipes(blocks, exporter);
    }
    private void registerStoneCutterRecipes(BlockAlts blocks, Consumer<RecipeJsonProvider> exporter){
        blocks.doOnEach((block, type) ->
            RecipeUtils.registerStoneCutter(exporter, blocks.base(), block, blocks.blockName(), type));
    }

    private void registerShapedRecipes(BlockAlts blocks, Consumer<RecipeJsonProvider> exporter){
        if(blocks.fallen()) return;
        blocks.doOnEach((block, type) ->
               type.makeRecipe(blocks.base(), block)
                        .criterion(hasItem(blocks.base()), conditionsFromItem(blocks.base()))
                        .offerTo(exporter));
    }
}

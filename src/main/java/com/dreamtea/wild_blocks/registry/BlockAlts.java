package com.dreamtea.wild_blocks.registry;

import com.dreamtea.wild_blocks.blocks.*;
import com.dreamtea.wild_blocks.utils.AltModelGen;
import com.dreamtea.wild_blocks.utils.OnAlts;
import com.dreamtea.wild_blocks.utils.RecipeUtils;
import net.minecraft.block.*;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public record BlockAlts(
        Block base,
        String blockName,
        TexturedModel.Factory modelType,
        WallBlock wallBlock,
        StairsBlock stairBlock,
        SlabBlock slabBlock,
        boolean fallen,
        String baseNameInWords
) {
    public BlockAlts(Block base, TexturedModel.Factory modelType, boolean wall, boolean slab, boolean stair, List<AltModelGen.BlockPropertyForAlts> props) {
        this(
                base,
                (Registry.BLOCK.getId(base).getPath() +
                        (props.contains(AltModelGen.BlockPropertyForAlts.FALLEN) ? "_fallen" : "")),
                modelType,
                makeWallOrNull(base, wall, props),
                makeStairOrNull(base, stair, props),
                makeSlabOrNull(base, slab, props),
                props.contains(AltModelGen.BlockPropertyForAlts.FALLEN),
                base.getName().getString()
        );
    }

    public BlockAlts(Block base, boolean wall, boolean slab, boolean stair, List<AltModelGen.BlockPropertyForAlts> props) {
        this(base, TexturedModel.CUBE_ALL, wall, slab, stair, props);
    }
    public BlockAlts(Block base, boolean wall, boolean slab, boolean stair) {
        this(base, TexturedModel.CUBE_ALL, wall, slab, stair, List.of());
    }

    public BlockAlts(Block base,  List<AltModelGen.BlockPropertyForAlts> props) {
        this(base, true, true, true, props);
    }

    public BlockAlts(Block base) {
        this(base, true, true, true);
    }

    public BlockAlts withAltBaseName(String name) {
        return new BlockAlts(base, blockName, modelType, wallBlock, stairBlock, slabBlock, fallen, name);
    }

    public BlockAlts model(TexturedModel.Factory model) {
        return new BlockAlts(base, blockName, model, wallBlock, stairBlock, slabBlock, fallen, baseNameInWords);
    }

    public void doOnEach(OnAlts doOnEachBlock){
        if(wallBlock != null){
            doOnEachBlock.apply(wallBlock, BlockType.WALL);
        }
        if(slabBlock != null){
            doOnEachBlock.apply(slabBlock, BlockType.SLAB);
        }
        if(stairBlock != null){
            doOnEachBlock.apply(stairBlock, BlockType.STAIR);
        }
    }

    private static WallBlock makeWallOrNull(Block base, boolean make, List<AltModelGen.BlockPropertyForAlts> props) {
        if (make) {
            WallBlock wallBlock;
            if (props.contains(AltModelGen.BlockPropertyForAlts.FACING)) {
                wallBlock = new FacingWall(AbstractBlock.Settings.copy(base), props.contains(AltModelGen.BlockPropertyForAlts.GLAZED));
            } else {
                wallBlock = new WallBlock(AbstractBlock.Settings.copy(base));
            }
            return wallBlock;
        }
        return null;
    }

    private static StairsBlock makeStairOrNull(Block base, boolean make, List<AltModelGen.BlockPropertyForAlts> props) {
        if (make) {
            StairsBlock stairBlock;
            if (props.contains(AltModelGen.BlockPropertyForAlts.FACING)) {
                stairBlock = new FacingStair(base.getDefaultState(),
                        AbstractBlock.Settings.copy(base),
                        props.contains(AltModelGen.BlockPropertyForAlts.GLAZED));
            } else if (props.contains(AltModelGen.BlockPropertyForAlts.DIRECTIONAL)) {
                stairBlock = new DirectionalStair(base.getDefaultState(), AbstractBlock.Settings.copy(base));
            } else {
                stairBlock = new StairsBlock(base.getDefaultState(), AbstractBlock.Settings.copy(base));
            }
            return stairBlock;
        }
        return null;
    }

    private static SlabBlock makeSlabOrNull(Block base, boolean make, List<AltModelGen.BlockPropertyForAlts> props) {
        if (make) {
            SlabBlock slabBlock;
            if (props.contains(AltModelGen.BlockPropertyForAlts.FACING)) {
                slabBlock = new FacingSlab(AbstractBlock.Settings.copy(base), props.contains(AltModelGen.BlockPropertyForAlts.GLAZED));
            } else if (props.contains(AltModelGen.BlockPropertyForAlts.DIRECTIONAL)) {
                slabBlock = new DirectionalSlab(AbstractBlock.Settings.copy(base));
            } else {
                slabBlock = new SlabBlock(AbstractBlock.Settings.copy(base));
            }
            return slabBlock;
        }
        return null;
    }

    public enum BlockType {
        WALL("Wall", RecipeUtils::makeWall, 1),
        SLAB("Slab", RecipeUtils::makeSlab, 2),
        STAIR("Stair", RecipeUtils::makeStair, 1);

        public final String name;
        public final String lowerCaseName;
        public final int stonecutterOutput;
        public final RecipeUtils.RecipeProducer recipeProducer;

        BlockType(String name, RecipeUtils.RecipeProducer recipe, int stonecutterOutput){
            this.name = name;
            this.recipeProducer = recipe;
            this.lowerCaseName = name.toLowerCase();
            this.stonecutterOutput = stonecutterOutput;
        }

        public ShapedRecipeJsonBuilder makeRecipe(Block base, Block output){
            return recipeProducer.make(base, output);
        }
    }
}

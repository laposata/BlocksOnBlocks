package com.dreamtea.wild_blocks.utils;

import net.minecraft.block.Block;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.block.enums.StairShape;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.*;

import static com.dreamtea.wild_blocks.WildBlocks.NAMESPACE;
import static com.dreamtea.wild_blocks.utils.Utils.DIRECTION;
import static com.dreamtea.wild_blocks.utils.Utils.ROTATION;

public class AltModelGen {
    public static final List<BlockPropertyForAlts> FALLEN_PROPS = List.of(BlockPropertyForAlts.DIRECTIONAL, BlockPropertyForAlts.FALLEN);
    public static final List<BlockPropertyForAlts> GLAZED_PROPS = List.of(BlockPropertyForAlts.FACING, BlockPropertyForAlts.GLAZED);
    public enum BlockPropertyForAlts {
        DIRECTIONAL,
        GLAZED,
        FACING,
        FALLEN
    }

    public static Map<Block, Map<Model, Identifier>> knownModels = new HashMap<>();

    private static Identifier ensureModel(Model model, Block block, BlockStateModelGenerator bsmg, TextureMap textures) {
        return knownModels.computeIfAbsent(block, map -> new HashMap<>())
                .computeIfAbsent(model, newModel -> newModel.upload(block, textures, bsmg.modelCollector));
    }

    public static <T extends Comparable<T>> BlockStateSupplier stairs(Block stairBlock, TextureMap textures, BlockStateModelGenerator bsmg, Property<T> by, Map<T, BlockStateVariant> subMaps){
        Identifier innerStair = ensureModel(Models.INNER_STAIRS, stairBlock, bsmg, textures);
        Identifier stair =  ensureModel(Models.STAIRS, stairBlock, bsmg, textures);
        Identifier outerStair =  ensureModel(Models.OUTER_STAIRS, stairBlock, bsmg, textures);
        bsmg.registerParentedItemModel(stairBlock, stair);
        return stairSupplier(stairBlock, by, subMaps, BaseModels.stairBase(stair, outerStair, innerStair));
    }

    public static BlockStateSupplier stairs(Block stairBlock, TextureMap textures, BlockStateModelGenerator bsmg){
        Identifier innerStair = ensureModel(Models.INNER_STAIRS, stairBlock, bsmg, textures);
        Identifier stair = ensureModel(Models.STAIRS, stairBlock, bsmg, textures);
        Identifier outerStair = ensureModel(Models.OUTER_STAIRS, stairBlock, bsmg, textures);
        bsmg.registerParentedItemModel(stairBlock, stair);
        VariantsBlockStateSupplier supplier = VariantsBlockStateSupplier.create(stairBlock);
        BlockStateVariantMap.TripleProperty<Direction, BlockHalf, StairShape> stateMap =
                BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, Properties.BLOCK_HALF, Properties.STAIR_SHAPE);
        BaseModels.stairBase(stair, outerStair, innerStair).forEach((states, variant) ->
                stateMap.register(
                        (Direction) states.get(0),
                        (BlockHalf) states.get(1),
                        (StairShape) states.get(2),
                        variant
                )
        );
        return supplier.coordinate(stateMap);
    }

    public static BlockStateVariantMap slab(Block slabBlock, TextureMap textures, BlockStateModelGenerator bsmg, Block orig, boolean fallen){
        Identifier bottomId, topId;
        if(fallen){
            bottomId = FALLEN_SLAB.upload(slabBlock, textures, bsmg.modelCollector);
            topId = FALLEN_SLAB_TOP.upload(slabBlock, textures, bsmg.modelCollector);
        } else {
            bottomId = Models.SLAB.upload(slabBlock, textures, bsmg.modelCollector);
            topId = Models.SLAB_TOP.upload(slabBlock, textures, bsmg.modelCollector);
        }
        return BlockStateVariantMap.create(Properties.SLAB_TYPE)
                        .register(SlabType.BOTTOM,
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, bottomId)
                        ).register(SlabType.TOP,
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, topId)
                        ).register(SlabType.DOUBLE,
                                BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, ModelIds.getBlockModelId(orig)));
    }

    public static <T extends Comparable<T>> BlockStateSupplier wall(Block wallBlock, TextureMap textures, BlockStateModelGenerator bsmg, Property<T> by, Map<T, BlockStateVariant> subMaps){
        Identifier postModelId = ensureModel(Models.TEMPLATE_WALL_POST, wallBlock, bsmg, textures);
        Identifier lowSideModelId = ensureModel(Models.TEMPLATE_WALL_SIDE, wallBlock, bsmg, textures);
        Identifier tallSideModelId = ensureModel(Models.TEMPLATE_WALL_SIDE_TALL, wallBlock, bsmg, textures);
        Identifier parent = ensureModel(Models.WALL_INVENTORY, wallBlock, bsmg, textures);
        bsmg.registerParentedItemModel(wallBlock, parent);
        return wallSupplier(wallBlock, BaseModels.wallWith(postModelId, lowSideModelId, tallSideModelId, by, subMaps));
    }

    public static <T extends Comparable<T>> BlockStateSupplier wall(Block wallBlock, TextureMap textures, BlockStateModelGenerator bsmg){
        Identifier postModelId = ensureModel(Models.TEMPLATE_WALL_POST, wallBlock, bsmg, textures);
        Identifier lowSideModelId = ensureModel(Models.TEMPLATE_WALL_SIDE, wallBlock, bsmg, textures);
        Identifier tallSideModelId = ensureModel(Models.TEMPLATE_WALL_SIDE_TALL, wallBlock, bsmg, textures);
        Identifier parent = ensureModel(Models.WALL_INVENTORY, wallBlock, bsmg, textures);
        bsmg.registerParentedItemModel(wallBlock, parent);
        return wallSupplier(wallBlock, BaseModels.wallBase(postModelId, lowSideModelId, tallSideModelId));
    }

    public static BlockStateVariantMap rotation(){
        BlockStateVariantMap.SingleProperty<Direction> rotations = BlockStateVariantMap.create(ROTATION);
        BaseModels.rotation().forEach(rotations::register);
        return rotations;
    }

    public static void combineAndUploadVariantMaps(BlockStateModelGenerator bsmg,
                                                   Block block,
                                                   BlockStateVariantMap ... maps){
        VariantsBlockStateSupplier supplier =
               VariantsBlockStateSupplier.create(block);
        Arrays.stream(maps).forEach(supplier::coordinate);
        bsmg.blockStateCollector.accept(supplier);
    }

    public static BlockStateVariantMap directional(){
        BlockStateVariantMap.SingleProperty<Utils.HorizontalFacing> states = BlockStateVariantMap.create(DIRECTION);
        BaseModels.direction().forEach(states::register);
        return states;
    }

    public static MultipartBlockStateSupplier wallSupplier(Block wallBlock, Map<When, BlockStateVariant> map){
        MultipartBlockStateSupplier states = MultipartBlockStateSupplier.create(wallBlock);
        map.forEach(states::with);
        return states;
    }

    public static <T extends Comparable<T>> VariantsBlockStateSupplier stairSupplier(Block stairBlock, Property<T> by, Map<T, BlockStateVariant> map, Map<List<Comparable<?>>, BlockStateVariant> orig){
        VariantsBlockStateSupplier supplier = VariantsBlockStateSupplier.create(stairBlock);
        BlockStateVariantMap.QuadrupleProperty<T, Direction, BlockHalf, StairShape> stateMap =
                BlockStateVariantMap.create(by, Properties.HORIZONTAL_FACING, Properties.BLOCK_HALF, Properties.STAIR_SHAPE);
        map.forEach((val, variantAdded) ->
            orig.forEach((states, variant) ->
                stateMap.register(
                    val,
                    (Direction) states.get(0),
                    (BlockHalf) states.get(1),
                    (StairShape) states.get(2),
                    BlockStateVariant.union(variantAdded, variant)
                )
            )
        );
        return supplier.coordinate(stateMap);
    }

    public static final Model FALLEN_SLAB = block("slab_fallen", TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP);
    public static final Model FALLEN_SLAB_TOP = block("slab_fallen_top", TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP);

    private static Model block(String parent, TextureKey ... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(NAMESPACE, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

}

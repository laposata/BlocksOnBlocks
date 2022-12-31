package com.dreamtea.wild_blocks.utils;

import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.block.enums.WallShape;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseModels {
    public static final Property<Direction> ROTATION_PROPERTY = Utils.ROTATION;
    public static final Property<Utils.HorizontalFacing> DIRECTION_PROPERTY = Utils.DIRECTION;
    public static Map<List<Comparable<?>>, BlockStateVariant> stairBase(Identifier regularModelId, Identifier outerModelId, Identifier innerModelId){
        Map<List<Comparable<?>>, BlockStateVariant> states = new HashMap<>();
        addToStairsMap(states, Direction.EAST, BlockHalf.BOTTOM, StairShape.STRAIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, regularModelId));
        addToStairsMap(states, Direction.WEST, BlockHalf.BOTTOM, StairShape.STRAIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, regularModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.SOUTH, BlockHalf.BOTTOM, StairShape.STRAIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, regularModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.NORTH, BlockHalf.BOTTOM, StairShape.STRAIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, regularModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.EAST, BlockHalf.BOTTOM, StairShape.OUTER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId));
        addToStairsMap(states, Direction.WEST, BlockHalf.BOTTOM, StairShape.OUTER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.SOUTH, BlockHalf.BOTTOM, StairShape.OUTER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.NORTH, BlockHalf.BOTTOM, StairShape.OUTER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.EAST, BlockHalf.BOTTOM, StairShape.OUTER_LEFT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.WEST, BlockHalf.BOTTOM, StairShape.OUTER_LEFT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.SOUTH, BlockHalf.BOTTOM, StairShape.OUTER_LEFT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId));
        addToStairsMap(states, Direction.NORTH, BlockHalf.BOTTOM, StairShape.OUTER_LEFT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.EAST, BlockHalf.BOTTOM, StairShape.INNER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, innerModelId));
        addToStairsMap(states, Direction.WEST, BlockHalf.BOTTOM, StairShape.INNER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, innerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.SOUTH, BlockHalf.BOTTOM, StairShape.INNER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, innerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.NORTH, BlockHalf.BOTTOM, StairShape.INNER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, innerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.EAST, BlockHalf.BOTTOM, StairShape.INNER_LEFT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, innerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.WEST, BlockHalf.BOTTOM, StairShape.INNER_LEFT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, innerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.SOUTH, BlockHalf.BOTTOM, StairShape.INNER_LEFT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, innerModelId));
        addToStairsMap(states, Direction.NORTH, BlockHalf.BOTTOM, StairShape.INNER_LEFT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, innerModelId)
                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.EAST, BlockHalf.TOP, StairShape.STRAIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, regularModelId)
                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.WEST, BlockHalf.TOP, StairShape.STRAIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, regularModelId)
                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.SOUTH, BlockHalf.TOP, StairShape.STRAIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, regularModelId)
                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.NORTH, BlockHalf.TOP, StairShape.STRAIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, regularModelId)
                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.EAST, BlockHalf.TOP, StairShape.OUTER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.WEST, BlockHalf.TOP, StairShape.OUTER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.SOUTH, BlockHalf.TOP, StairShape.OUTER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.NORTH, BlockHalf.TOP, StairShape.OUTER_RIGHT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.EAST, BlockHalf.TOP, StairShape.OUTER_LEFT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.WEST, BlockHalf.TOP, StairShape.OUTER_LEFT, BlockStateVariant.create()
                .put(VariantSettings.MODEL, outerModelId)
                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.SOUTH, BlockHalf.TOP, StairShape.OUTER_LEFT,
                BlockStateVariant.create()
                        .put(VariantSettings.MODEL, outerModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.NORTH, BlockHalf.TOP, StairShape.OUTER_LEFT,
                BlockStateVariant.create()
                        .put(VariantSettings.MODEL, outerModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                        .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.EAST, BlockHalf.TOP, StairShape.INNER_RIGHT,
                BlockStateVariant.create().put(VariantSettings.MODEL, innerModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.WEST, BlockHalf.TOP, StairShape.INNER_RIGHT,
                BlockStateVariant.create().put(VariantSettings.MODEL, innerModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                        .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.SOUTH, BlockHalf.TOP, StairShape.INNER_RIGHT,
                BlockStateVariant.create()
                        .put(VariantSettings.MODEL, innerModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                        .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.NORTH, BlockHalf.TOP, StairShape.INNER_RIGHT,
                BlockStateVariant.create()
                        .put(VariantSettings.MODEL, innerModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.EAST, BlockHalf.TOP, StairShape.INNER_LEFT,
                BlockStateVariant.create()
                        .put(VariantSettings.MODEL, innerModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.WEST, BlockHalf.TOP, StairShape.INNER_LEFT,
                BlockStateVariant.create()
                        .put(VariantSettings.MODEL, innerModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                        .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.SOUTH, BlockHalf.TOP, StairShape.INNER_LEFT,
                BlockStateVariant.create()
                        .put(VariantSettings.MODEL, innerModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.UVLOCK, true));
        addToStairsMap(states, Direction.NORTH, BlockHalf.TOP, StairShape.INNER_LEFT,
                BlockStateVariant.create()
                        .put(VariantSettings.MODEL, innerModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                        .put(VariantSettings.UVLOCK, true));
        return states;
    }
    public static Map<When, BlockStateVariant> wallBase(Identifier postModelId, Identifier lowSideModelId, Identifier tallSideModelId){
        Map<When, BlockStateVariant> stateMap = new HashMap<>();
        stateMap.put(When.allOf(When.create().set(Properties.UP, true)),
                BlockStateVariant.create().put(VariantSettings.MODEL, postModelId));
        stateMap.put(When.create().set(Properties.NORTH_WALL_SHAPE, WallShape.LOW),
                BlockStateVariant.create().put(VariantSettings.MODEL, lowSideModelId)
                        .put(VariantSettings.UVLOCK, true));
        stateMap.put(When.create().set(Properties.EAST_WALL_SHAPE, WallShape.LOW),
                BlockStateVariant.create().put(VariantSettings.MODEL, lowSideModelId)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.UVLOCK, true));
        stateMap.put(When.create().set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW),
                BlockStateVariant.create().put(VariantSettings.MODEL, lowSideModelId)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, true));
        stateMap.put(When.create().set(Properties.WEST_WALL_SHAPE, WallShape.LOW),
                BlockStateVariant.create().put(VariantSettings.MODEL, lowSideModelId)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                        .put(VariantSettings.UVLOCK, true));
        stateMap.put(When.create().set(Properties.NORTH_WALL_SHAPE, WallShape.TALL),
                BlockStateVariant.create().put(VariantSettings.MODEL, tallSideModelId)
                        .put(VariantSettings.UVLOCK, true));
        stateMap.put(When.create().set(Properties.EAST_WALL_SHAPE, WallShape.TALL),
                BlockStateVariant.create().put(VariantSettings.MODEL, tallSideModelId)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.UVLOCK, true));
        stateMap.put(When.create().set(Properties.SOUTH_WALL_SHAPE, WallShape.TALL),
                BlockStateVariant.create().put(VariantSettings.MODEL, tallSideModelId)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                        .put(VariantSettings.UVLOCK, true));
        stateMap.put(When.create().set(Properties.WEST_WALL_SHAPE, WallShape.TALL),
                BlockStateVariant.create().put(VariantSettings.MODEL, tallSideModelId)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                        .put(VariantSettings.UVLOCK, true));
        return stateMap;
    }

    public static Map<Utils.HorizontalFacing, BlockStateVariant> direction(){
        return Map.of(
                Utils.HorizontalFacing.Z,
                BlockStateVariant.create()
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90),
                Utils.HorizontalFacing.X,
                BlockStateVariant.create()
        );
    }

    public static Map<Direction, BlockStateVariant> rotation(){
        return Map.of(
                Direction.SOUTH, BlockStateVariant.create(),
                Direction.WEST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R90),
                Direction.NORTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R180),
                Direction.EAST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R270)
        );
    }

    public static <T extends Comparable<T>> Map<When, BlockStateVariant> wallWith(Identifier postModelId, Identifier lowSideModelId, Identifier tallSideModelId, Property<T> by, Map<T, BlockStateVariant> variants){
        Map<When, BlockStateVariant> stateMap = new HashMap<>();
        Map<When, BlockStateVariant> base = BaseModels.wallBase(postModelId, lowSideModelId, tallSideModelId);
        base.forEach((when, blockState) ->
                variants.forEach((cond, variant) ->
                        stateMap.put(When.allOf(when, When.create().set(by, cond)), 
                                BlockStateVariant.union(variant, blockState))));
        return stateMap;
    }

    private static void addToStairsMap(Map<List<Comparable<?>>, BlockStateVariant> map, Direction first, BlockHalf second, StairShape third, BlockStateVariant variant){
        map.put(Arrays.asList(first, second, third), variant);
    }
}

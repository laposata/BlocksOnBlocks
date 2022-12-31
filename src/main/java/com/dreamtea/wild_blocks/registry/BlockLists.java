package com.dreamtea.wild_blocks.registry;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class BlockLists {
    public static final List<Block> TERRACOTTA = new ArrayList<>();
    public static final List<Block> GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<Block> ADD_ALL_TYPES = new ArrayList<>();
    public static final List<Block> ADD_WALL = new ArrayList<>();

    static {
        ADD_ALL_TYPES.add(Blocks.SMOOTH_BASALT);
        ADD_ALL_TYPES.add(Blocks.CALCITE);
        ADD_ALL_TYPES.add(Blocks.TUFF);
        ADD_ALL_TYPES.add(Blocks.DEEPSLATE);
        ADD_ALL_TYPES.add(Blocks.END_STONE);

        ADD_WALL.add(Blocks.POLISHED_ANDESITE);
        ADD_WALL.add(Blocks.POLISHED_GRANITE);
        ADD_WALL.add(Blocks.POLISHED_DIORITE);
        ADD_WALL.add(Blocks.PRISMARINE_BRICKS);
        ADD_WALL.add(Blocks.DARK_PRISMARINE);
        ADD_WALL.add(Blocks.SMOOTH_QUARTZ);
        ADD_WALL.add(Blocks.PURPUR_BLOCK);
        ADD_WALL.add(Blocks.SMOOTH_SANDSTONE);
        ADD_WALL.add(Blocks.SMOOTH_RED_SANDSTONE);
        
        TERRACOTTA.add(Blocks.TERRACOTTA);
        TERRACOTTA.add(Blocks.BLACK_TERRACOTTA);
        TERRACOTTA.add(Blocks.WHITE_TERRACOTTA);
        TERRACOTTA.add(Blocks.GRAY_TERRACOTTA);
        TERRACOTTA.add(Blocks.LIGHT_GRAY_TERRACOTTA);
        TERRACOTTA.add(Blocks.BLUE_TERRACOTTA);
        TERRACOTTA.add(Blocks.LIGHT_BLUE_TERRACOTTA);
        TERRACOTTA.add(Blocks.CYAN_TERRACOTTA);
        TERRACOTTA.add(Blocks.BROWN_TERRACOTTA);
        TERRACOTTA.add(Blocks.RED_TERRACOTTA);
        TERRACOTTA.add(Blocks.PINK_TERRACOTTA);
        TERRACOTTA.add(Blocks.ORANGE_TERRACOTTA);
        TERRACOTTA.add(Blocks.YELLOW_TERRACOTTA);
        TERRACOTTA.add(Blocks.PURPLE_TERRACOTTA);
        TERRACOTTA.add(Blocks.MAGENTA_TERRACOTTA);
        TERRACOTTA.add(Blocks.LIME_TERRACOTTA);
        TERRACOTTA.add(Blocks.GREEN_TERRACOTTA);

        ADD_ALL_TYPES.addAll(TERRACOTTA);
        
        GLAZED_TERRACOTTA.add(Blocks.BLACK_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.WHITE_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.GRAY_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.BLUE_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.CYAN_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.BROWN_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.RED_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.PINK_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.ORANGE_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.YELLOW_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.PURPLE_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.MAGENTA_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.LIME_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Blocks.GREEN_GLAZED_TERRACOTTA);
    }
}

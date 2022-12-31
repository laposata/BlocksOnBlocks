package com.dreamtea.wild_blocks.registry;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.TexturedModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.dreamtea.wild_blocks.registry.BlockLists.*;
import static com.dreamtea.wild_blocks.utils.AltModelGen.GLAZED_PROPS;

public class AltList {

    public final static List<BlockAlts> SIMPLE_ALTS = new ArrayList<>();

    public static void add(BlockAlts block){
        SIMPLE_ALTS.add(block);
    }

    public static void add(Stream<BlockAlts> blocks){
        blocks.forEach(SIMPLE_ALTS::add);
    }

    public static void add(List<Block> blocks){
        blocks.forEach(b -> add(new BlockAlts(b)));
    }

    public static void addWall(Block block){
        SIMPLE_ALTS.add(new BlockAlts(block, true, false, false));
    }

    public static void addWall(List<Block> blocks){
        blocks.forEach(AltList::addWall);
    }

    static {
        add(ADD_ALL_TYPES);
        addWall(ADD_WALL);
        add(GLAZED_TERRACOTTA.stream().map(gt -> new BlockAlts(gt,false, true, false, GLAZED_PROPS)));

        add(new BlockAlts(Blocks.AMETHYST_BLOCK).withAltBaseName("Amethyst"));
        add(new BlockAlts(Blocks.POLISHED_BASALT,false, true, true).model(TexturedModel.CUBE_COLUMN));
        add(new BlockAlts(Blocks.BASALT,false, true, true).model(TexturedModel.CUBE_COLUMN));

        Register.register(SIMPLE_ALTS);
    }
}

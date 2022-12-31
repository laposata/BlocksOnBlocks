package com.dreamtea.wild_blocks.utils;

import com.dreamtea.wild_blocks.registry.BlockAlts;
import net.minecraft.block.Block;

@FunctionalInterface
public interface OnAlts {
    void apply(Block block, BlockAlts.BlockType type);
}

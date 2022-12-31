package com.dreamtea.wild_blocks.datagen;

import com.dreamtea.wild_blocks.registry.BlockAlts;
import com.dreamtea.wild_blocks.registry.AltList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;

import java.util.Objects;

public class Tags extends FabricTagProvider.BlockTagProvider {

    public Tags(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        FabricTagProvider<Block>.FabricTagBuilder<Block> tagBuilderWall = getOrCreateTagBuilder(BlockTags.WALLS);
        FabricTagProvider<Block>.FabricTagBuilder<Block> tagBuilderStairs = getOrCreateTagBuilder(BlockTags.STAIRS);
        FabricTagProvider<Block>.FabricTagBuilder<Block> tagBuilderSlabs = getOrCreateTagBuilder(BlockTags.SLABS);
        AltList.SIMPLE_ALTS.stream().map(BlockAlts::wallBlock)
                .filter(Objects::nonNull)
                .forEach(tagBuilderWall::add);
        AltList.SIMPLE_ALTS.stream().map(BlockAlts::stairBlock)
                .filter(Objects::nonNull)
                .forEach(tagBuilderStairs::add);
        AltList.SIMPLE_ALTS.stream().map(BlockAlts::slabBlock)
                .filter(Objects::nonNull)
                .forEach(tagBuilderSlabs::add);
    }
}

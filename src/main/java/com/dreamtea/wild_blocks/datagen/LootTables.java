package com.dreamtea.wild_blocks.datagen;

import com.dreamtea.wild_blocks.registry.BlockAlts;
import com.dreamtea.wild_blocks.registry.AltList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class LootTables extends FabricBlockLootTableProvider {
    protected LootTables(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {
        AltList.SIMPLE_ALTS.forEach(this::register);
    }

    public void register(BlockAlts blocks){
        blocks.doOnEach((block, type) -> addDrop(block));
    }
}

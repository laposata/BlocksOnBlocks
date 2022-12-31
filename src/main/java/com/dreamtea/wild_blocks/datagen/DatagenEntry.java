package com.dreamtea.wild_blocks.datagen;

import com.dreamtea.wild_blocks.WildBlocks;
import com.dreamtea.wild_blocks.registry.AltList;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DatagenEntry implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        WildBlocks.LOGGER.info(String.format("Registering %s types of blocks", AltList.SIMPLE_ALTS.size()));
        fabricDataGenerator.addProvider(LootTables::new);
        fabricDataGenerator.addProvider(Models::new);
        fabricDataGenerator.addProvider(Recipes::new);
        fabricDataGenerator.addProvider(Tags::new);
        fabricDataGenerator.addProvider(Language::new);
    }
}

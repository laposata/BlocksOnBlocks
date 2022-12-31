package com.dreamtea.wild_blocks;

import com.dreamtea.wild_blocks.registry.AltList;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WildBlocks implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String NAMESPACE = "wild_blocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAMESPACE);

	@Override
	public void onInitialize() {
		LOGGER.info("Blocking the wilderness");
		LOGGER.info(String.format("Registering %s types of blocks", AltList.SIMPLE_ALTS.size()));
	}
}

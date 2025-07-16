package grool.example;

import grool.example.block.ModBlocks;
import grool.example.item.ModItems;
import grool.example.sound.ModSounds;
import grool.example.util.GroolCustomTrades;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Grool implements ModInitializer {
	public static final String MOD_ID = "grool";  //this is the modID that you use all over the place

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("ENGAGING GROOLING. PREPARE FOR GROOLING RESURRECTION!");


		//Initialize functions here
		ModItems.initialize();
		ModBlocks.initialize();

		GroolCustomTrades.registerCustomTrades();
		ModSounds.registerSounds();
	}
}
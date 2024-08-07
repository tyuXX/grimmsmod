package grimmsmod.procedures;

import net.minecraft.nbt.StringTag;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.configuration.ServerConfigConfiguration;

import grimmsmod.GrimmsMod;

public class InitCraftingsCacheProcedure {
	public static void execute() {
		GrimmsMod.LOGGER.info("Initializing hardcoded Grimm's mod crafting cache.");
		GrimmsMod.LOGGER.info("Initializing custom Grimm's mod crafting cache.");
		for (String stringiterator : ServerConfigConfiguration.CCVALUES.get()) {
			GrimmsModVariables.craftingscache.put("key", StringTag.valueOf("key"));
		}
		GrimmsMod.LOGGER.info("Initialized Grimm's mod crafting cache.");
	}
}

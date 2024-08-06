package grimmsmod.procedures;

import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.GrimmsMod;

public class InitCraftingsCacheProcedure {
	public static void execute() {
		ListTag tmp;
		GrimmsMod.LOGGER.info("Initializing hardcoded Grimm's mod crafting cache.");
		tmp = new ListTag();
		tmp.addTag(0, StringTag.valueOf(""));
		GrimmsMod.LOGGER.info("Initializing custom Grimm's mod crafting cache.");
		GrimmsModVariables.craftingscache = tmp;
		GrimmsMod.LOGGER.info("Initialized Grimm's mod crafting cache.");
	}
}

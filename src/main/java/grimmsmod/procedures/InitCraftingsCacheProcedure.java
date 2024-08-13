package grimmsmod.procedures;

import net.minecraft.nbt.StringTag;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.configuration.ServerConfigConfiguration;

import grimmsmod.GrimmsMod;

public class InitCraftingsCacheProcedure {
	public static void execute() {
		double id = 0;
		double regi = 0;
		GrimmsMod.LOGGER.info("Initializing Grimm's mod crafting cache.");
		for (String stringiterator : ServerConfigConfiguration.CVALUES.get()) {
			if (stringiterator.contains(":") && stringiterator.contains(">") && stringiterator.contains("$")) {
				id = 0;
				for (int index0 = 0; index0 < (int) (stringiterator).length(); index0++) {
					if ((stringiterator.substring(0, (int) id)).contains(">")) {
						GrimmsModVariables.cache.put(("craft:" + stringiterator.substring(0, (int) (id - 1))), StringTag.valueOf((stringiterator.substring((int) id, (int) (stringiterator).length()))));
						regi = regi + 1;
						break;
					}
					id = id + 1;
				}
			}
		}
		GrimmsMod.LOGGER.info(("Initialized " + new java.text.DecimalFormat("##").format(regi) + " crafting recipes."));
	}
}

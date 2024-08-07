package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.DoubleTag;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.GrimmsMod;

public class InitPlayerDatamapProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double init = 0;
		GrimmsMod.LOGGER.info(("Initializing Datamap for " + entity.getStringUUID()));
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("prestige:keepinventory")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("prestige:keepinventory", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("max:prestige:keepinventory")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("max:prestige:keepinventory", DoubleTag.valueOf(10));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("name:prestige:keepinventory")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("name:prestige:keepinventory", StringTag.valueOf("Keep inventory upgrade, only works when L10"));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("0")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("0", StringTag.valueOf("prestige:keepinventory"));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("prestige:dexterious")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("prestige:dexterious", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("name:prestige:dexterious")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("name:prestige:dexterious", StringTag.valueOf("Dexterious hands (Unbreaking) [WIP]"));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("max:prestige:dexterious")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("max:prestige:dexterious", DoubleTag.valueOf(5));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("1")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("1", StringTag.valueOf("prestige:dexterious"));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("prestige:powerful")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("prestige:powerful", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("name:prestige:powerful")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("name:prestige:powerful", StringTag.valueOf("Powerful (+0.1 per level)"));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("max:prestige:powerful")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("max:prestige:powerful", DoubleTag.valueOf(15));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("2")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("2", StringTag.valueOf("prestige:powerful"));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("prestige:cure")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("prestige:cure", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("name:prestige:cure")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("name:prestige:cure", StringTag.valueOf("Cure (Removes bad potion effects)"));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("max:presige:cure")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("max:presige:cure", DoubleTag.valueOf(1));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("3")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("3", StringTag.valueOf("presige:cure"));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.contains("grimm:level")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.put("grimm:level", DoubleTag.valueOf(1));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.contains("grimm:xp")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.put("grimm:xp", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.contains("grimm:prestige")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.put("grimm:prestige", DoubleTag.valueOf(1));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.contains("grimm:prestigepoints")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.put("grimm:prestigepoints", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.contains("kills")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.put("kills", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.contains("deaths")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.put("deaths", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.contains("grimm:money")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.put("grimm:money", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.contains("grimm:totaltv")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.put("grimm:totaltv", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (init < 1) {
			GrimmsMod.LOGGER.info((entity.getStringUUID() + " already initialized, skipping."));
		} else {
			GrimmsMod.LOGGER.info(("Done! Initialized " + new java.text.DecimalFormat("##").format(init) + " variables of the player"));
		}
	}
}

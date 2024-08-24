package grimm.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.DoubleTag;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.GrimmsMod;

public class InitPlayerDatamapProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
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
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("prestige:forger")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("prestige:forger", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("name:prestige:forger")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("name:prestige:forger", StringTag.valueOf("Unlocks the forgery block"));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("max:prestige:forger")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("max:prestige:forger", DoubleTag.valueOf(1));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("prestige:keepxp")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("prestige:keepxp", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("name:prestige:keepxp")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("name:prestige:keepxp", StringTag.valueOf("Keep xp on death 10% per level"));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains("max:prestige:keepxp")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.put("max:prestige:keepxp", DoubleTag.valueOf(10));
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
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.contains("grimm:mentalstability")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.put("grimm:mentalstability", DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.contains("grimm:lastdeathxp")) {
			entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.put("grimm:lastdeathxp", DoubleTag.valueOf(0));
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
		if (!GrimmsModVariables.MapVariables.get(world).mapstats.contains((entity.getStringUUID() + "/grimm:totaltv"))) {
			GrimmsModVariables.MapVariables.get(world).mapstats.put((entity.getStringUUID() + "/grimm:totaltv"), DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (!GrimmsModVariables.MapVariables.get(world).mapstats.contains((entity.getStringUUID() + "/grimm:money"))) {
			GrimmsModVariables.MapVariables.get(world).mapstats.put((entity.getStringUUID() + "/grimm:money"), DoubleTag.valueOf(0));
			init = init + 1;
		}
		if (init < 1) {
			GrimmsMod.LOGGER.info((entity.getStringUUID() + " already initialized, skipping."));
		} else {
			GrimmsMod.LOGGER.info(("Done! Initialized " + new java.text.DecimalFormat("##").format(init) + " variables of the player"));
		}
	}
}

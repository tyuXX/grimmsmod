package grimm.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.GrimmsMod;

public class InitPlayerDatamapProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double init = 0;
		GrimmsMod.LOGGER.info(("Initializing Datamap for " + entity.getStringUUID()));
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

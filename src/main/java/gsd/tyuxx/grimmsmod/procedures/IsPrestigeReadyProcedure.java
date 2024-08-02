package gsd.tyuxx.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

import gsd.tyuxx.grimmsmod.network.GrimmsmodModVariables;

public class IsPrestigeReadyProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES).level >= Math.round(Math.pow(entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES).prestige * 10, 1.2))) {
			return true;
		}
		return false;
	}
}

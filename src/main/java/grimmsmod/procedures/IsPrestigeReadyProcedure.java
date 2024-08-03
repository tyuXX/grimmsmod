package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

import grimmsmod.network.GrimmsModVariables;

public class IsPrestigeReadyProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(GrimmsModVariables.PLAYER_VARIABLES).level >= Math.round(Math.pow(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).prestige * 10, 1.2))) {
			return true;
		}
		return false;
	}
}

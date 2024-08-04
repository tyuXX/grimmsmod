package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

import grimmsmod.network.GrimmsModVariables;

public class MoneyTextValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Money: " + entity.getData(GrimmsModVariables.PLAYER_VARIABLES).money + "$";
	}
}

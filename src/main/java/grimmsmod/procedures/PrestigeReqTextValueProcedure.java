package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

import grimmsmod.network.GrimmsModVariables;

public class PrestigeReqTextValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(Math.round(Math.pow(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).prestige * 10, 1.2)));
	}
}

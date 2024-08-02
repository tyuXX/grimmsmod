package gsd.tyuxx.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

import gsd.tyuxx.grimmsmod.network.GrimmsmodModVariables;

public class XpReqTextValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(Math.round(Math.pow(entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES).level * 10, 1.3)));
	}
}

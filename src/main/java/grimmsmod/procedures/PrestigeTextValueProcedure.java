package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

import grimmsmod.network.GrimmsModVariables;

public class PrestigeTextValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).prestige);
	}
}

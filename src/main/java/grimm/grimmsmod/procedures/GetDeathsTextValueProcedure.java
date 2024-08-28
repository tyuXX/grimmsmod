package grimm.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;

import grimm.grimmsmod.network.GrimmsModVariables;

public class GetDeathsTextValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Deaths: " + (new java.text.DecimalFormat("##").format((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("deaths")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D));
	}
}

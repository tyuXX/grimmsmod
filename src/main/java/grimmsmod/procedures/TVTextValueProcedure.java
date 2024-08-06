package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;

import grimmsmod.network.GrimmsModVariables;

public class TVTextValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:totaltv")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D);
	}
}
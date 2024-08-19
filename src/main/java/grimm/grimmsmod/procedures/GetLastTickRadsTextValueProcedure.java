package grimm.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;

import grimm.grimmsmod.network.GrimmsModVariables;

public class GetLastTickRadsTextValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (new java.text.DecimalFormat("##.##").format((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats.get("grimm:radslasttick")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)) + "/t";
	}
}

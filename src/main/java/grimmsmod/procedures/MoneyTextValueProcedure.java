package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;

import grimmsmod.network.GrimmsModVariables;

public class MoneyTextValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Money: " + ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:money")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) + "$";
	}
}

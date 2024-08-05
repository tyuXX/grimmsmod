package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;

import grimmsmod.network.GrimmsModVariables;

public class PrestigepointsTextValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Prestige Points (PP):" + (new java.text.DecimalFormat("##").format((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:prestigepoints")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D));
	}
}

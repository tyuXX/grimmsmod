package grimm.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.configuration.ServerConfigConfiguration;

public class GetRadiationTextValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (new java.text.DecimalFormat("##.##").format((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats.get("grimm:rads")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)) + "/"
				+ new java.text.DecimalFormat("##").format((double) ServerConfigConfiguration.RADPOISLIM.get()) + " Rads";
	}
}

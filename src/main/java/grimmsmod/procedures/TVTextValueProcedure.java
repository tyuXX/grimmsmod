package grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;

import grimmsmod.network.GrimmsModVariables;

public class TVTextValueProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format((GrimmsModVariables.MapVariables.get(world).mapstats.get((entity.getStringUUID() + "/grimm:totaltv"))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D);
	}
}

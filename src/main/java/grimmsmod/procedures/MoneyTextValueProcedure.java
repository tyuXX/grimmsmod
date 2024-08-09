package grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;

import grimmsmod.network.GrimmsModVariables;

public class MoneyTextValueProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		return "Money: " + ((GrimmsModVariables.MapVariables.get(world).mapstats.get((entity.getStringUUID() + "/grimm:money"))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) + "$";
	}
}

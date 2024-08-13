package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.ByteTag;

import grimmsmod.network.GrimmsModVariables;

public class InitLifetimeStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats.put("grimm:lobotomized", ByteTag.valueOf(false));
		entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats.put("grimm:rads", DoubleTag.valueOf(0));
	}
}

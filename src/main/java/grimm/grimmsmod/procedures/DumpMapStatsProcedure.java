package grimm.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import grimm.grimmsmod.network.GrimmsModVariables;

public class DumpMapStatsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		DumpDatamapProcedure.execute(GrimmsModVariables.MapVariables.get(world).mapstats, entity);
	}
}

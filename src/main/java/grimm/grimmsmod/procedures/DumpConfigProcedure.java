package grimm.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

import grimm.grimmsmod.network.GrimmsModVariables;

public class DumpConfigProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		DumpDatamapProcedure.execute(GrimmsModVariables.config, entity);
	}
}

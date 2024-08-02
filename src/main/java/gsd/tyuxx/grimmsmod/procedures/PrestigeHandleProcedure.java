package gsd.tyuxx.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

import gsd.tyuxx.grimmsmod.network.GrimmsmodModVariables;

public class PrestigeHandleProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (IsPrestigeReadyProcedure.execute(entity)) {
			{
				GrimmsmodModVariables.PlayerVariables _vars = entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES);
				_vars.prestige = entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES).prestige + 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				GrimmsmodModVariables.PlayerVariables _vars = entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES);
				_vars.level = 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				GrimmsmodModVariables.PlayerVariables _vars = entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES);
				_vars.xp = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}

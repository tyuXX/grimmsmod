package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

import grimmsmod.network.GrimmsModVariables;

public class PrestigeHandleProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (IsPrestigeReadyProcedure.execute(entity)) {
			{
				GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.level = 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.xp = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.prestige = entity.getData(GrimmsModVariables.PLAYER_VARIABLES).prestige + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}

package gsd.tyuxx.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

import gsd.tyuxx.grimmsmod.network.GrimmsmodModVariables;

public class XpHandleProcedure {
	public static void execute(Entity entity, double xpamount) {
		if (entity == null)
			return;
		{
			GrimmsmodModVariables.PlayerVariables _vars = entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES);
			_vars.xp = entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES).xp + xpamount;
			_vars.syncPlayerVariables(entity);
		}
		if (entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES).xp >= Math.round(Math.pow(entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES).level * 10, 1.3))) {
			{
				GrimmsmodModVariables.PlayerVariables _vars = entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES);
				_vars.level = entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES).level + 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				GrimmsmodModVariables.PlayerVariables _vars = entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES);
				_vars.xp = entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES).xp - Math.round(Math.pow(entity.getData(GrimmsmodModVariables.PLAYER_VARIABLES).level * 10, 1.3));
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}

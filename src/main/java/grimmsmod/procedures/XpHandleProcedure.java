package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.configuration.ServerConfigConfiguration;

public class XpHandleProcedure {
	public static void execute(Entity entity, double xpamount) {
		if (entity == null)
			return;
		{
			GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
			_vars.xp = entity.getData(GrimmsModVariables.PLAYER_VARIABLES).xp + xpamount;
			_vars.syncPlayerVariables(entity);
		}
		while (ServerConfigConfiguration.INSTLEVELUP.get() && entity.getData(GrimmsModVariables.PLAYER_VARIABLES).xp >= Math.round(Math.pow(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).level * 10, 1.3))) {
			{
				GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.xp = entity.getData(GrimmsModVariables.PLAYER_VARIABLES).xp - Math.round(Math.pow(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).level * 10, 1.3));
				_vars.syncPlayerVariables(entity);
			}
			{
				GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.level = entity.getData(GrimmsModVariables.PLAYER_VARIABLES).level + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}

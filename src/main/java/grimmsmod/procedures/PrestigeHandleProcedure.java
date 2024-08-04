package grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.configuration.ServerConfigConfiguration;

public class PrestigeHandleProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
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
			{
				GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.prestigepoints = entity.getData(GrimmsModVariables.PLAYER_VARIABLES).prestigepoints + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (ServerConfigConfiguration.SPRESTIGE.get()) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(
							Component.literal((entity.getDisplayName().getString() + " has prestiged to prestige " + new java.text.DecimalFormat("##").format(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).prestige))), false);
			}
		}
	}
}

package grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.DoubleTag;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.configuration.ServerConfigConfiguration;

public class XpHandleProcedure {
	public static void execute(LevelAccessor world, Entity entity, double xpamount) {
		if (entity == null)
			return;
		ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false, xpamount, "grimm:xp");
		while (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:xp")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= Math
				.round(Math.pow(((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) * 10, 1.3))) {
			ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false,
					(-1) * Math.round(Math.pow(((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) * 10, 1.3)), "grimm:xp");
			ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false, 1, "grimm:level");
			ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false,
					((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:prestige")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)
							* ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D),
					"grimm:money");
			if (ServerConfigConfiguration.SLEVEL.get()
					&& Math.round((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) % (double) ServerConfigConfiguration.SNLEVEL.get() == 0) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList()
							.broadcastSystemMessage(
									Component.literal((entity.getDisplayName().getString() + " has reached level "
											+ (new java.text.DecimalFormat("##").format((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)))),
									false);
			}
			if (!ServerConfigConfiguration.INSTLEVELUP.get()) {
				break;
			}
		}
		{
			GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
			_vars.placeholder = 0;
			_vars.syncPlayerVariables(entity);
		}
	}
}

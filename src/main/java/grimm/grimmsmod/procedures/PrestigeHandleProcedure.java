package grimm.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.init.GrimmsModGameRules;

public class PrestigeHandleProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (IsPrestigeReadyProcedure.execute(entity)) {
			SetDataElementProcedure.execute(DoubleTag.valueOf(1), entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false, "grimm:level");
			SetDataElementProcedure.execute(DoubleTag.valueOf(0), entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false, "grimm:xp");
			ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false, 1, "grimm:prestige");
			ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, true, 1, "grimm:prestigepoints");
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:prestige"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
			if (world.getLevelData().getGameRules().getBoolean(GrimmsModGameRules.SHOUT_PRESTIGE)) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList()
							.broadcastSystemMessage(
									Component.literal((entity.getDisplayName().getString() + " has prestiged to prestige "
											+ (new java.text.DecimalFormat("##").format((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:prestige")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)))),
									false);
			}
		}
	}
}

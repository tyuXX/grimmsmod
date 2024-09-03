package grimm.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.ByteTag;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.init.GrimmsModGameRules;

public class XpHandleProcedure {
	public static void execute(LevelAccessor world, Entity entity, double xpamount) {
		if (entity == null)
			return;
		boolean leveledup = false;
		ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false, xpamount, "grimm:xp");
		while (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:xp")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= Math
				.round(Math.pow(((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) * 10, 1.3))) {
			ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false,
					(-1) * Math.round(Math.pow(((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) * 10, 1.3)), "grimm:xp");
			ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false, 1, "grimm:level");
			ChangeNumberDataElementProcedure.execute(GrimmsModVariables.MapVariables.get(world).mapstats, entity, false,
					((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:prestige")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)
							* ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D),
					entity.getStringUUID() + "/grimm:money");
			if (((GrimmsModVariables.config.get("common:instlvlup")) instanceof ByteTag _byteTag ? _byteTag.getAsByte() == 1 : false)
					&& Math.round((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)
							% (world.getLevelData().getGameRules().getInt(GrimmsModGameRules.SHOUT_LEVEL)) == 0) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList()
							.broadcastSystemMessage(
									Component.literal((entity.getDisplayName().getString() + " has reached level "
											+ (new java.text.DecimalFormat("##").format((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)))),
									false);
			}
			leveledup = true;
			if (!((GrimmsModVariables.config.get("common:instlvlup")) instanceof ByteTag _byteTag ? _byteTag.getAsByte() == 1 : false)) {
				break;
			}
		}
		if (leveledup) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:level_up"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
			if (35 < ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:level_up_2"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
		{
			GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
			_vars.placeholder = 0;
			_vars.syncPlayerVariables(entity);
		}
	}
}

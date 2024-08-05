package grimmsmod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ByteTag;

import grimmsmod.network.GrimmsModVariables;

public class InitPlayerDatamapProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		CompoundTag tmp;
		CompoundTag tmp2;
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).isplayerinitialized) {
			tmp2 = new CompoundTag();
			tmp2.put("prestige:keepinventory", ByteTag.valueOf(false));
			if (entity instanceof Player _player) {
				GrimmsModVariables.PlayerVariables _vars = _player.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.persistentabilities = tmp2;
				_vars.syncPlayerVariables(_player);
			}
			tmp = new CompoundTag();
			tmp.put("grimm:level", DoubleTag.valueOf(1));
			tmp.put("grimm:xp", DoubleTag.valueOf(0));
			tmp.put("grimm:prestige", DoubleTag.valueOf(1));
			tmp.put("grimm:prestigepoints", DoubleTag.valueOf(0));
			tmp.put("kills", DoubleTag.valueOf(0));
			tmp.put("deaths", DoubleTag.valueOf(0));
			tmp.put("grimm:money", DoubleTag.valueOf(0));
			tmp.put("grimm:lobotomized", ByteTag.valueOf(false));
			if (entity instanceof Player _player) {
				GrimmsModVariables.PlayerVariables _vars = _player.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.persistentstats = tmp;
				_vars.syncPlayerVariables(_player);
			}
			{
				GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.isplayerinitialized = true;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}

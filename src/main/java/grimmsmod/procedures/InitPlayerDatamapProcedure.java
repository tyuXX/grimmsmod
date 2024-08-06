package grimmsmod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ByteTag;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.GrimmsMod;

public class InitPlayerDatamapProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		CompoundTag tmp;
		CompoundTag tmp2;
		if (!entity.getData(GrimmsModVariables.PLAYER_VARIABLES).isplayerinitialized) {
			GrimmsMod.LOGGER.info(("Initializing Datamap for " + entity.getStringUUID()));
			tmp2 = new CompoundTag();
			tmp2.put("prestige:keepinventory", DoubleTag.valueOf(0));
			tmp2.put("max:prestige:keepinventory", DoubleTag.valueOf(10));
			tmp2.put("name:prestige:keepinventory", StringTag.valueOf("Keep inventory upgrade, only works when L10"));
			tmp2.put("0", StringTag.valueOf("prestige:keepinventory"));
			tmp2.put("prestige:dexterious", DoubleTag.valueOf(0));
			tmp2.put("name:prestige:dexterious", StringTag.valueOf("Dexterious hands (Unbreaking) [WIP]"));
			tmp2.put("max:prestige:dexterious", DoubleTag.valueOf(5));
			tmp2.put("1", StringTag.valueOf("prestige:dexterious"));
			tmp2.put("prestige:powerful", DoubleTag.valueOf(0));
			tmp2.put("name:prestige:powerful", StringTag.valueOf("Powerful (+0.1 per level)"));
			tmp2.put("max:prestige:powerful", DoubleTag.valueOf(15));
			tmp2.put("2", StringTag.valueOf("prestige:powerful"));
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
			tmp.put("grimm:totaltv", DoubleTag.valueOf(0));
			if (entity instanceof Player _player) {
				GrimmsModVariables.PlayerVariables _vars = _player.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.persistentstats = tmp;
				_vars.syncPlayerVariables(_player);
			}
			GrimmsMod.LOGGER.info("Done!");
			{
				GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.isplayerinitialized = true;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			GrimmsMod.LOGGER.info((entity.getStringUUID() + " already initialized, skipping."));
		}
	}
}

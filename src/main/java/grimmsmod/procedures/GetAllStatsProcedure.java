package grimmsmod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ByteTag;

import grimmsmod.network.GrimmsModVariables;

public class GetAllStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Tag tmp;
		for (String keyiterator : entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.getAllKeys()) {
			if ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get(keyiterator)).getId() == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((keyiterator + " is " + ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get(keyiterator)) instanceof ByteTag _byteTag ? _byteTag.getAsByte() == 1 : false))),
							false);
			} else if ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get(keyiterator)).getId() == 8) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((keyiterator + " is " + ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get(keyiterator)) instanceof StringTag _stringTag ? _stringTag.getAsString() : ""))),
							false);
			}
		}
	}
}

package grimm.grimmsmod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.StringTag;

import grimm.grimmsmod.network.GrimmsModVariables;

public class DumpCacheProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		for (String keyiterator : GrimmsModVariables.cache.getAllKeys()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((keyiterator + ":" + ((GrimmsModVariables.cache.get(keyiterator)) instanceof StringTag _stringTag ? _stringTag.getAsString() : ""))), false);
		}
	}
}

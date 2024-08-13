package grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.StringTag;

import grimmsmod.network.GrimmsModVariables;

public class DumpMapStatsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		for (String keyiterator : GrimmsModVariables.MapVariables.get(world).mapstats.getAllKeys()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((keyiterator + ":" + ((GrimmsModVariables.MapVariables.get(world).mapstats.get(keyiterator)) instanceof StringTag _stringTag ? _stringTag.getAsString() : ""))), false);
		}
	}
}

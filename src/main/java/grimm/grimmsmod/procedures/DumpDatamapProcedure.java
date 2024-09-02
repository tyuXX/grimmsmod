package grimm.grimmsmod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ByteTag;

public class DumpDatamapProcedure {
	public static void execute(CompoundTag datamap, Entity entity) {
		if (datamap == null || entity == null)
			return;
		for (String keyiterator : datamap.getAllKeys()) {
			if ((datamap.get(keyiterator)).getId() == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((keyiterator + " is " + ((datamap.get(keyiterator)) instanceof ByteTag _byteTag ? _byteTag.getAsByte() == 1 : false))), false);
			} else if ((datamap.get(keyiterator)).getId() == 6) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((keyiterator + " is " + (new java.text.DecimalFormat("##.##").format((datamap.get(keyiterator)) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)))), false);
			} else if ((datamap.get(keyiterator)).getId() == 8) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((keyiterator + " is " + ((datamap.get(keyiterator)) instanceof StringTag _stringTag ? _stringTag.getAsString() : ""))), false);
			} else if ((datamap.get(keyiterator)).getId() == 10) {
				DumpDatamapProcedure.execute((datamap.get(keyiterator)) instanceof CompoundTag _compoundTag ? _compoundTag.copy() : new CompoundTag(), entity);
			}
		}
	}
}

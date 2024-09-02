package grimm.grimmsmod.procedures;

import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.CompoundTag;

public class ChangeNumberDataElementNoSyncProcedure {
	public static void execute(CompoundTag datamap, double value, String key) {
		if (datamap == null || key == null)
			return;
		SetDataElementNoSyncProcedure.execute(DoubleTag.valueOf((((datamap.get(key)) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) + value)), datamap, key);
	}
}

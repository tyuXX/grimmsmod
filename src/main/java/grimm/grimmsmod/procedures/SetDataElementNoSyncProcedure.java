package grimm.grimmsmod.procedures;

import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;

public class SetDataElementNoSyncProcedure {
	public static void execute(Tag dataelement, CompoundTag datamap, String key) {
		if (dataelement == null || datamap == null || key == null)
			return;
		datamap.put(key, dataelement);
	}
}

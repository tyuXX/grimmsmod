package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;

import grimmsmod.network.GrimmsModVariables;

public class SetDataElementProcedure {
	public static void execute(Tag dataelement, CompoundTag datamap, Entity entity, boolean sync, String key) {
		if (dataelement == null || datamap == null || entity == null || key == null)
			return;
		if (datamap.contains(key)) {
			datamap.remove(key);
		}
		datamap.put(key, dataelement);
		if (sync) {
			{
				GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.placeholder = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}

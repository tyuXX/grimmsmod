package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.CompoundTag;

import grimmsmod.network.GrimmsModVariables;

public class ChangeNumberDataElementProcedure {
	public static void execute(CompoundTag datamap, Entity entity, boolean sync, double value, String key) {
		if (datamap == null || entity == null || key == null)
			return;
		if (datamap.contains(key)) {
			SetDataElementProcedure.execute(DoubleTag.valueOf((((datamap.get(key)) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) + value)), datamap, entity, sync, key);
		} else {
			{
				GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.placeholder = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}

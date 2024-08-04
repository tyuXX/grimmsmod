package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;

public class GetPlayerAsEntityProcedure {
	public static Entity execute(Entity entity) {
		if (entity == null)
			return null;
		return entity;
	}
}

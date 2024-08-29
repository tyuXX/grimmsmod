package grimm.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class ClearItemsProcedure {
	public static void execute(LevelAccessor world) {
		if (world instanceof ServerLevel _server) {
			for (Entity entityiterator : _server.getAllEntities()) {
				if (entityiterator instanceof ItemEntity) {
					if (!entityiterator.level().isClientSide())
						entityiterator.discard();
				}
			}
		}
	}
}

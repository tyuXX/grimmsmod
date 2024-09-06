package grimm.grimmsmod.procedures;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

import grimm.grimmsmod.network.GrimmsModVariables;

@EventBusSubscriber
public class OnMapUnloadProcedure {
	@SubscribeEvent
	public static void onWorldUnload(net.neoforged.neoforge.event.level.LevelEvent.Unload event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		if (GrimmsModVariables.cache.contains("init")) {
			GrimmsModVariables.cache.remove("init");
		}
	}
}

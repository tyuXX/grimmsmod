package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

import grimm.grimmsmod.network.GrimmsModVariables;

@EventBusSubscriber
public class OnWorldTickProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		GrimmsModVariables.WorldVariables.get(world).worldtick = GrimmsModVariables.WorldVariables.get(world).worldtick + 1;
		GrimmsModVariables.WorldVariables.get(world).syncData(world);
		GrimmsModVariables.MapVariables.get(world).maptick = GrimmsModVariables.MapVariables.get(world).maptick + 1;
		GrimmsModVariables.MapVariables.get(world).syncData(world);
	}
}

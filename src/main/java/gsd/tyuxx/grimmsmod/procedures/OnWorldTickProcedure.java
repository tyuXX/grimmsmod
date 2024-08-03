package gsd.tyuxx.grimmsmod.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

import gsd.tyuxx.grimmsmod.network.GrimmsmodModVariables;

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
		GrimmsmodModVariables.MapVariables.get(world).worldtick = GrimmsmodModVariables.MapVariables.get(world).worldtick + 1;
		GrimmsmodModVariables.MapVariables.get(world).syncData(world);
	}
}

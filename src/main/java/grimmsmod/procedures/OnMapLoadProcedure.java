package grimmsmod.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import grimmsmod.GrimmsMod;

@EventBusSubscriber
public class OnMapLoadProcedure {
	@SubscribeEvent
	public static void onWorldLoad(net.neoforged.neoforge.event.level.LevelEvent.Load event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		InitCraftingsCacheProcedure.execute();
		InitTransmutationValuesProcedure.execute();
		GrimmsMod.LOGGER
				.info(("Grimm's mod succsessfully loaded in World:" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())));
	}
}

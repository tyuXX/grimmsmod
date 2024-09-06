package grimm.grimmsmod.procedures;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import javax.annotation.Nullable;

import java.io.File;

import grimm.grimmsmod.GrimmsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class OnClientLoadedProcedure {
	@SubscribeEvent
	public static void init(FMLClientSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File tmp = new File("");
		com.google.gson.JsonObject tmp2 = new com.google.gson.JsonObject();
		CreateClientConfigProcedure.execute();
		ReloadClientConfigProcedure.execute();
		GrimmsMod.LOGGER.info("Grimm's Mod Client side loaded.");
	}
}

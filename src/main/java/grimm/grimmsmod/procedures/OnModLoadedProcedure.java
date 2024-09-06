package grimm.grimmsmod.procedures;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

import java.io.File;

import grimm.grimmsmod.GrimmsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OnModLoadedProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File tmp = new File("");
		com.google.gson.JsonObject tmp2 = new com.google.gson.JsonObject();
		CreateCommonConfigProcedure.execute();
		CreateCustomRegistryProcedure.execute();
		InitCacheProcedure.execute();
		ReloadCommonConfigProcedure.execute();
		GrimmsMod.LOGGER.info("Grimm's mod loaded.");
	}
}

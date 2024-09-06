package grimm.grimmsmod.procedures;

import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import javax.annotation.Nullable;

import java.io.File;

import grimm.grimmsmod.GrimmsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.DEDICATED_SERVER})
public class OnServerLoadedProcedure {
	@SubscribeEvent
	public static void init(FMLDedicatedServerSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File tmp = new File("");
		com.google.gson.JsonObject tmp2 = new com.google.gson.JsonObject();
		CreateServerConfigProcedure.execute();
		GrimmsMod.LOGGER.info("Grimm's Mod Server side loaded.");
	}
}

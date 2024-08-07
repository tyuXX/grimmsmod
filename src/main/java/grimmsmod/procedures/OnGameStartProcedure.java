package grimmsmod.procedures;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

import grimmsmod.GrimmsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OnGameStartProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		if (!ModList.get().isLoaded("jei")) {
			GrimmsMod.LOGGER.info("JEI is recommended for use with this mod, currently JEI is not installed.");
		}
		GrimmsMod.LOGGER.info("Grimm's Mod loaded succsesfully!");
	}
}

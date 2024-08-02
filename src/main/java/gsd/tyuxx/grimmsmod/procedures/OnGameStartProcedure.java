package gsd.tyuxx.grimmsmod.procedures;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

import gsd.tyuxx.grimmsmod.GrimmsmodMod;

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
		GrimmsmodMod.LOGGER.info("Grimm's Mod loaded succsesfully!");
		GrimmsmodMod.LOGGER.fatal("Prepare to die!");
	}
}

package gsd.tyuxx.grimmsmod.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.bus.api.SubscribeEvent;

import gsd.tyuxx.grimmsmod.configuration.ServerConfigConfiguration;
import gsd.tyuxx.grimmsmod.configuration.CommonConfigConfiguration;
import gsd.tyuxx.grimmsmod.configuration.ClientConfigConfiguration;
import gsd.tyuxx.grimmsmod.GrimmsmodMod;

@EventBusSubscriber(modid = GrimmsmodMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GrimmsmodModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfigConfiguration.SPEC, "grimmsmod_common.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigConfiguration.SPEC, "grimmsmod_client.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfigConfiguration.SPEC, "grimmsmod_server.toml");
		});
	}
}

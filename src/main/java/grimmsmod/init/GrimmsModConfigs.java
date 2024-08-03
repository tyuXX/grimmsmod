package grimmsmod.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.bus.api.SubscribeEvent;

import grimmsmod.configuration.ServerConfigConfiguration;
import grimmsmod.configuration.CommonConfigConfiguration;
import grimmsmod.configuration.ClientConfigConfiguration;

import grimmsmod.GrimmsMod;

@EventBusSubscriber(modid = GrimmsMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GrimmsModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfigConfiguration.SPEC, "grimmsmod_common.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigConfiguration.SPEC, "grimmsmod_client.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfigConfiguration.SPEC, "grimmsmod_server.toml");
		});
	}
}

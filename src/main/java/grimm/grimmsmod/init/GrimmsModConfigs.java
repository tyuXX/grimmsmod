package grimm.grimmsmod.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.bus.api.SubscribeEvent;

import grimm.grimmsmod.configuration.ServerConfigConfiguration;
import grimm.grimmsmod.configuration.CommonConfigConfiguration;
import grimm.grimmsmod.configuration.ClientConfigConfiguration;
import grimm.grimmsmod.GrimmsMod;

@EventBusSubscriber(modid = GrimmsMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GrimmsModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfigConfiguration.SPEC, "grimm\\grimmsmod_common.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigConfiguration.SPEC, "grimm\\grimmsmod_client.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfigConfiguration.SPEC, "grimm\\grimmsmod_server.toml");
		});
	}
}

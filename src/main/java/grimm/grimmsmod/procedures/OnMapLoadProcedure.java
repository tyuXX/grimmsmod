package grimm.grimmsmod.procedures;

import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.util.List;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.GrimmsMod;

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
		if (!(new Object() {
			String getValue(String modid) {
				String val = "";
				List<IModInfo> mods = ModList.get().getMods();
				for (IModInfo mod : mods) {
					if (mod.getModId().equals(modid.toLowerCase())) {
						val = mod.getVersion().toString();
						break;
					}
				}
				return val;
			}
		}.getValue("grimms")).equals(GrimmsModVariables.MapVariables.get(world).mapversion)) {
			GrimmsModVariables.MapVariables.get(world).mapversion = new Object() {
				String getValue(String modid) {
					String val = "";
					List<IModInfo> mods = ModList.get().getMods();
					for (IModInfo mod : mods) {
						if (mod.getModId().equals(modid.toLowerCase())) {
							val = mod.getVersion().toString();
							break;
						}
					}
					return val;
				}
			}.getValue("grimms");
			GrimmsModVariables.MapVariables.get(world).syncData(world);
		}
		if (!GrimmsModVariables.cache.contains("init")) {
			InitCacheProcedure.execute();
		}
		GrimmsMod.LOGGER
				.info(("Grimm's mod succsessfully loaded in World [" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
						+ "/" + ((Level) world).dimension().location().toString() + "]"));
	}
}

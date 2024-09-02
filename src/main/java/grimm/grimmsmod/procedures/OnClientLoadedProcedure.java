package grimm.grimmsmod.procedures;

import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.nbt.ByteTag;

import javax.annotation.Nullable;

import java.util.List;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import grimm.grimmsmod.network.GrimmsModVariables;
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
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/config/"), File.separator + "client.json");
		if (!tmp.exists()) {
			try {
				tmp.getParentFile().mkdirs();
				tmp.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			tmp2.addProperty("version", new Object() {
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
			}.getValue("grimms"));
			tmp2.addProperty("Enable Main menu HUD", true);
			tmp2.addProperty("Enable Ingame HUD Comment", "Completely disable or enable the Grimm's HUD.");
			tmp2.addProperty("Enable Ingame HUD", true);
			tmp2.addProperty("Enable Money HUD Comment", "Enables the HUD that shows your money on the top left corner.");
			tmp2.addProperty("Enable Money HUD", true);
			tmp2.addProperty("Enable Player HUD Comment", "Shows the player on the top right corner.");
			tmp2.addProperty("Enable Player HUD", true);
			tmp2.addProperty("Enable Coordinates HUD Comment", "Shows your coordinates below the money. HUD.");
			tmp2.addProperty("Enable Coordinates HUD", true);
			tmp2.addProperty("Enable Day Counter HUD comment", "Shows the current day in the top left corner.");
			tmp2.addProperty("Enable Day Counter HUD", true);
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(tmp);
					fileWriter.write(mainGSONBuilderVariable.toJson(tmp2));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(tmp));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				tmp2 = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				GrimmsModVariables.config.put("client:menuhud", ByteTag.valueOf(tmp2.get("Enable Main menu HUD").getAsBoolean()));
				GrimmsModVariables.config.put("client:gamehud", ByteTag.valueOf(tmp2.get("Enable Ingame HUD").getAsBoolean()));
				GrimmsModVariables.config.put("client:moneyhud", ByteTag.valueOf(tmp2.get("Enable Money HUD").getAsBoolean()));
				GrimmsModVariables.config.put("client:playerhud", ByteTag.valueOf(tmp2.get("Enable Player HUD").getAsBoolean()));
				GrimmsModVariables.config.put("client:coordshud", ByteTag.valueOf(tmp2.get("Enable Coordinates HUD").getAsBoolean()));
				GrimmsModVariables.config.put("client:daychud", ByteTag.valueOf(tmp2.get("Enable Day Counter HUD").getAsBoolean()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		GrimmsMod.LOGGER.info("Grimm's mod Client side loaded.");
	}
}

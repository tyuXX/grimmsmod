package grimm.grimmsmod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.nbt.ByteTag;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.GrimmsMod;

public class ReloadClientConfigProcedure {
	public static void execute() {
		File tmp = new File("");
		com.google.gson.JsonObject tmp2 = new com.google.gson.JsonObject();
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/config/"), File.separator + "client.json");
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
		GrimmsMod.LOGGER.info("Grimm's Mod Client config reloaded.");
	}
}

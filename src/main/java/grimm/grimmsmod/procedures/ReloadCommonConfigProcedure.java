package grimm.grimmsmod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.nbt.ByteTag;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.GrimmsMod;

public class ReloadCommonConfigProcedure {
	public static void execute() {
		File tmp = new File("");
		com.google.gson.JsonObject tmp2 = new com.google.gson.JsonObject();
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/config/"), File.separator + "common.json");
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
				GrimmsModVariables.config.put("common:instwand", ByteTag.valueOf(tmp2.get("Instant wand placement").getAsBoolean()));
				GrimmsModVariables.config.put("common:instlvlup", ByteTag.valueOf(tmp2.get("Instant LevelUp").getAsBoolean()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		GrimmsMod.LOGGER.info("Grimm's Mod Common config reloaded.");
	}
}

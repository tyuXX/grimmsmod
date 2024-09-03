package grimm.grimmsmod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.nbt.DoubleTag;
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
				GrimmsModVariables.config.put("common:enabrad", ByteTag.valueOf(tmp2.get("Enable radiation").getAsBoolean()));
				GrimmsModVariables.config.put("common:radlim", DoubleTag.valueOf(tmp2.get("Radiation limit").getAsDouble()));
				GrimmsModVariables.config.put("common:enabthirst", ByteTag.valueOf(tmp2.get("Enable thirst").getAsBoolean()));
				GrimmsModVariables.config.put("common:enabtemp", ByteTag.valueOf(tmp2.get("Enable tempenture").getAsBoolean()));
				GrimmsModVariables.config.put("common:enabrot", ByteTag.valueOf(tmp2.get("Enable rotting").getAsBoolean()));
				GrimmsModVariables.config.put("common:rottime", DoubleTag.valueOf(tmp2.get("Rot time").getAsDouble()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		GrimmsMod.LOGGER.info("Grimm's Mod Common config reloaded.");
	}
}

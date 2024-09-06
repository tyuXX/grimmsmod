package grimm.grimmsmod.procedures;

import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.ModList;

import java.util.List;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class CreateClientConfigProcedure {
	public static void execute() {
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
			tmp2.addProperty("Enable looked block HUD", true);
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
	}
}

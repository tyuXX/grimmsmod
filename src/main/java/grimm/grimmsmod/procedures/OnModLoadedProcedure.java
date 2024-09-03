package grimm.grimmsmod.procedures;

import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

import java.util.List;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;

import grimm.grimmsmod.GrimmsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OnModLoadedProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File tmp = new File("");
		com.google.gson.JsonObject tmp2 = new com.google.gson.JsonObject();
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/config/"), File.separator + "common.json");
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
			tmp2.addProperty("Instant wand placement", false);
			tmp2.addProperty("Instant LevelUp", true);
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
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/custom/"), File.separator + "craft");
		if (!tmp.exists()) {
			try {
				tmp.getParentFile().mkdirs();
				tmp.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			try {
				FileWriter tmpwriter = new FileWriter(tmp, false);
				BufferedWriter tmpbw = new BufferedWriter(tmpwriter);
				{
					tmpbw.write("string");
					tmpbw.newLine();
				}
				{
					tmpbw.write("forgery$minecraft:air/minecraft:air/minecraft:air/grimms:steel/grimms:steel/minecraft:stick/minecraft:air/minecraft:air/minecraft:air>grimms:katana");
					tmpbw.newLine();
				}
				{
					tmpbw.write("forgery$minecraft:air/minecraft:air/minecraft:air/grimms:tempered_steel/grimms:tempered_steel/grimms:tempered_steel/minecraft:air/minecraft:air/minecraft:air>grimms:heavy_metal_pipe");
					tmpbw.newLine();
				}
				{
					tmpbw.write("distillery$minecraft:water_bucket>grimms:salt_bucket");
					tmpbw.newLine();
				}
				{
					tmpbw.write("heavyblaster$grimms:steel>grimms:tempered_steel");
					tmpbw.newLine();
				}
				{
					tmpbw.write("heavyblaster$grimms:tempered_steel>grimms:galvanized_steel");
					tmpbw.newLine();
				}
				{
					tmpbw.write("forgery$grimms:iridium_ingot/grimms:iridium_ingot/minecraft:air/grimms:iridium_ingot/minecraft:stick/minecraft:stick/grimms:iridium_ingot/grimms:iridium_ingot/minecraft:air>grimms:iridium_hammer");
					tmpbw.newLine();
				}
				{
					tmpbw.write("heavyblaster$grimms:tungsten_ingot>grimms:tungsten_carbide_ingot");
					tmpbw.newLine();
				}
				tmpbw.close();
				tmpwriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/custom/"), File.separator + "rad");
		if (!tmp.exists()) {
			try {
				tmp.getParentFile().mkdirs();
				tmp.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			try {
				FileWriter tmpwriter = new FileWriter(tmp, false);
				BufferedWriter tmpbw = new BufferedWriter(tmpwriter);
				{
					tmpbw.write("double");
					tmpbw.newLine();
				}
				{
					tmpbw.write("grimms:uranium_ingot>0.01");
					tmpbw.newLine();
				}
				{
					tmpbw.write("grimms:plutonium_block>0.9");
					tmpbw.newLine();
				}
				{
					tmpbw.write("grimms:thorium_block>0.18");
					tmpbw.newLine();
				}
				{
					tmpbw.write("grimms:uranium_block>0.09");
					tmpbw.newLine();
				}
				{
					tmpbw.write("grimms:plutonium_ingot>0.1");
					tmpbw.newLine();
				}
				{
					tmpbw.write("grimms:thorium_ingot>0.02");
					tmpbw.newLine();
				}
				tmpbw.close();
				tmpwriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/custom/"), File.separator + "tv");
		if (!tmp.exists()) {
			try {
				tmp.getParentFile().mkdirs();
				tmp.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			try {
				FileWriter tmpwriter = new FileWriter(tmp, false);
				BufferedWriter tmpbw = new BufferedWriter(tmpwriter);
				{
					tmpbw.write("double");
					tmpbw.newLine();
				}
				{
					tmpbw.write("minecraft:oak_planks>1");
					tmpbw.newLine();
				}
				{
					tmpbw.write("minecraft:oak_log>4");
					tmpbw.newLine();
				}
				{
					tmpbw.write("minecraft:stone>1");
					tmpbw.newLine();
				}
				{
					tmpbw.write("minecraft:cobblestone>1");
					tmpbw.newLine();
				}
				tmpbw.close();
				tmpwriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/custom/"), File.separator + "prestigemenu");
		if (!tmp.exists()) {
			try {
				tmp.getParentFile().mkdirs();
				tmp.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			try {
				FileWriter tmpwriter = new FileWriter(tmp, false);
				BufferedWriter tmpbw = new BufferedWriter(tmpwriter);
				{
					tmpbw.write("list");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:keepinventory");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:dexterious");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:powerful");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:cure");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:forger");
					tmpbw.newLine();
				}
				tmpbw.close();
				tmpwriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		InitCacheProcedure.execute();
		ReloadCommonConfigProcedure.execute();
		GrimmsMod.LOGGER.info("Grimm's mod loaded.");
	}
}

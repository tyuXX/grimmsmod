package grimm.grimmsmod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;

public class CreateCustomRegistryProcedure {
	public static void execute() {
		File tmp = new File("");
		com.google.gson.JsonObject tmp2 = new com.google.gson.JsonObject();
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
				{
					tmpbw.write("prestige:keepxp");
					tmpbw.newLine();
				}
				tmpbw.close();
				tmpwriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/custom/"), File.separator + "ability");
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
					tmpbw.write("prestige:keepinventory>0");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:keepxp>0");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:dexterious>0");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:powerful>0");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:cure>0");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:forger>0");
					tmpbw.newLine();
				}
				tmpbw.close();
				tmpwriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/custom/"), File.separator + "maxability");
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
					tmpbw.write("prestige:keepinventory>1");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:keepxp>10");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:dexterious>8");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:powerful>15");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:cure>1");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:forger>1");
					tmpbw.newLine();
				}
				tmpbw.close();
				tmpwriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/custom/"), File.separator + "nameability");
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
					tmpbw.write("prestige:keepinventory>Keeps your items safe on death");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:keepxp>Keep xp on death, 10% per level");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:dexterious>Dexterious hands (Unbreaking) [WIP]");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:powerful>Powerful (+0.1 damage per player level)");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:cure>Cure (Removes bad potion effects) [WIP]");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:forger>Unlocks the forgery table block");
					tmpbw.newLine();
				}
				tmpbw.close();
				tmpwriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		tmp = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/custom/"), File.separator + "costability");
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
					tmpbw.write("prestige:keepinventory>5");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:keepxp>1");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:dexterious>1");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:powerful>1");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:cure>3");
					tmpbw.newLine();
				}
				{
					tmpbw.write("prestige:forger>1");
					tmpbw.newLine();
				}
				tmpbw.close();
				tmpwriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}

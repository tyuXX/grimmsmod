package grimm.grimmsmod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.DoubleTag;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.GrimmsMod;

public class InitCacheFileProcedure {
	public static void execute(String filepath) {
		if (filepath == null)
			return;
		double id = 0;
		double regi = 0;
		File tmp = new File("");
		String valuetype = "";
		boolean init = false;
		ListTag tmp2;
		tmp2 = new ListTag();
		tmp = new File(filepath);
		try {
			BufferedReader tmpReader = new BufferedReader(new FileReader(tmp));
			String stringiterator = "";
			while ((stringiterator = tmpReader.readLine()) != null) {
				if (!init) {
					valuetype = stringiterator;
					if (!((valuetype).equals("list") || (valuetype).equals("double") || (valuetype).equals("string"))) {
						GrimmsMod.LOGGER.info(("File with invalid type [" + filepath + "] with type set as " + valuetype));
					}
					init = true;
				} else {
					if ((valuetype).equals("list")) {
						tmp2.addTag(0, StringTag.valueOf(stringiterator));
						regi = regi + 1;
					} else {
						if (stringiterator.contains(">")) {
							id = 0;
							for (int index0 = 0; index0 < (int) (stringiterator).length(); index0++) {
								if ((stringiterator.substring(0, (int) id)).contains(">")) {
									if ((valuetype).equals("string")) {
										GrimmsModVariables.cache.put((tmp.getName() + ":" + stringiterator.substring(0, (int) (id - 1))), StringTag.valueOf((stringiterator.substring((int) id, (int) (stringiterator).length()))));
									} else if ((valuetype).equals("double")) {
										GrimmsModVariables.cache.put((tmp.getName() + ":" + stringiterator.substring(0, (int) (id - 1))), DoubleTag.valueOf(new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(stringiterator.substring((int) id, (int) (stringiterator).length()))));
									}
									regi = regi + 1;
									break;
								}
								id = id + 1;
							}
						}
					}
				}
			}
			tmpReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if ((valuetype).equals("list")) {
			GrimmsModVariables.cache.put(tmp.getName(), tmp2);
		}
		GrimmsMod.LOGGER.info(("Initialized " + new java.text.DecimalFormat("##").format(regi) + " " + tmp.getName() + " values."));
	}
}

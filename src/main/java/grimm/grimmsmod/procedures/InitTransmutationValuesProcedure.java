package grimm.grimmsmod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.nbt.DoubleTag;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.configuration.ServerConfigConfiguration;
import grimm.grimmsmod.GrimmsMod;

public class InitTransmutationValuesProcedure {
	public static void execute() {
		double id = 0;
		double regi = 0;
		GrimmsMod.LOGGER.info("Initializing transmutation values");
		for (String stringiterator : ServerConfigConfiguration.TVVALUES.get()) {
			if (stringiterator.contains("/")) {
				id = 0;
				for (int index0 = 0; index0 < (int) (stringiterator).length(); index0++) {
					if ((stringiterator.substring(0, (int) id)).contains("/")) {
						GrimmsModVariables.cache.put(("tv:" + stringiterator.substring(0, (int) (id - 1))), DoubleTag.valueOf(new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(stringiterator.substring((int) id, (int) (stringiterator).length()))));
						regi = regi + 1;
						break;
					}
					id = id + 1;
				}
			}
		}
		GrimmsMod.LOGGER.info(("Initialized " + new java.text.DecimalFormat("##").format(regi) + " transmutation values."));
	}
}

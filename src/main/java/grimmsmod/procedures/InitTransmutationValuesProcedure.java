package grimmsmod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.configuration.ServerConfigConfiguration;

import grimmsmod.GrimmsMod;

public class InitTransmutationValuesProcedure {
	public static void execute() {
		double id = 0;
		GrimmsMod.LOGGER.info("Initializing hardcoded transmutation values");
		GrimmsModVariables.ctvalues = new CompoundTag();
		GrimmsModVariables.ctvalues.put((BuiltInRegistries.ITEM.getKey(Blocks.DIRT.asItem()).toString()), DoubleTag.valueOf(1));
		GrimmsModVariables.ctvalues.put((BuiltInRegistries.ITEM.getKey(Blocks.COBBLESTONE.asItem()).toString()), DoubleTag.valueOf(1));
		GrimmsModVariables.ctvalues.put((BuiltInRegistries.ITEM.getKey(Blocks.STONE.asItem()).toString()), DoubleTag.valueOf(2));
		GrimmsModVariables.ctvalues.put((BuiltInRegistries.ITEM.getKey(Blocks.OAK_LOG.asItem()).toString()), DoubleTag.valueOf(4));
		GrimmsModVariables.ctvalues.put((BuiltInRegistries.ITEM.getKey(Blocks.OAK_PLANKS.asItem()).toString()), DoubleTag.valueOf(1));
		GrimmsMod.LOGGER.info("Initializing custom transmutation values");
		for (String stringiterator : ServerConfigConfiguration.CTVALUES.get()) {
			if (stringiterator.contains("/")) {
				for (int index0 = 0; index0 < (int) (stringiterator).length(); index0++) {
					if ((stringiterator.substring(0, (int) id)).contains("/")) {
						GrimmsModVariables.ctvalues.put((stringiterator.substring(0, (int) (id - 1))), DoubleTag.valueOf(new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(stringiterator.substring((int) id, (int) (stringiterator).length()))));
						break;
					}
					id = id + 1;
				}
			}
		}
		GrimmsMod.LOGGER.info("Initialized transmutation values!");
	}
}

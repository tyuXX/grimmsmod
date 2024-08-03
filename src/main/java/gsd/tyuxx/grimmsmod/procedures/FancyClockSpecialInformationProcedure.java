package gsd.tyuxx.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;

public class FancyClockSpecialInformationProcedure {
	public static String execute(LevelAccessor world) {
		return "World Ticks:" + world.dayTime() + " World Secs:" + world.dayTime() / 20 + " World Mins:" + world.dayTime() / 1200;
	}
}

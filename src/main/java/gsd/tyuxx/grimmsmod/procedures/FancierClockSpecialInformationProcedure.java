package gsd.tyuxx.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;

import gsd.tyuxx.grimmsmod.network.GrimmsmodModVariables;

public class FancierClockSpecialInformationProcedure {
	public static String execute(LevelAccessor world) {
		return FancyClockSpecialInformationProcedure.execute(world) + " World days:" + Math.round(world.dayTime() / 28800) + " Moon Phase F:" + world.dimensionType().moonPhase(world.dayTime()) + " Grimm's Tick:"
				+ GrimmsmodModVariables.MapVariables.get(world).worldtick + " Grimm's Secs:" + GrimmsmodModVariables.MapVariables.get(world).worldtick / 20;
	}
}

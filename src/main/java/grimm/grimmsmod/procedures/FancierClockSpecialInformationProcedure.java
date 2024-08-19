package grimm.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;

import grimm.grimmsmod.network.GrimmsModVariables;

public class FancierClockSpecialInformationProcedure {
	public static String execute(LevelAccessor world) {
		return FancyClockSpecialInformationProcedure.execute(world) + " World days:" + Math.round(world.dayTime() / 28800) + " Moon Phase F:" + world.dimensionType().moonPhase(world.dayTime()) + " Grimm's Tick:"
				+ GrimmsModVariables.MapVariables.get(world).worldtick + " Grimm's Secs:" + GrimmsModVariables.MapVariables.get(world).worldtick / 20;
	}
}

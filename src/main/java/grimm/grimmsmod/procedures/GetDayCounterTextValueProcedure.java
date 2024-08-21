package grimm.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GetDayCounterTextValueProcedure {
	public static String execute(LevelAccessor world) {
		return "Day " + new java.text.DecimalFormat("##").format(world.dayTime() / 24000);
	}
}

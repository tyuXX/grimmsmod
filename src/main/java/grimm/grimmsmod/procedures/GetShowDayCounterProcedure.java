package grimm.grimmsmod.procedures;

import grimm.grimmsmod.configuration.ClientConfigConfiguration;

public class GetShowDayCounterProcedure {
	public static boolean execute() {
		return ClientConfigConfiguration.DAYHUD.get();
	}
}

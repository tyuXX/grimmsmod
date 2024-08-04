package grimmsmod.procedures;

import grimmsmod.configuration.ClientConfigConfiguration;

public class GetShowMoneyHUDProcedure {
	public static boolean execute() {
		return ClientConfigConfiguration.MHUD.get();
	}
}

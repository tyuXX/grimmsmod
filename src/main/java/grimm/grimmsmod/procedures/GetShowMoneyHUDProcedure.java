package grimm.grimmsmod.procedures;

import grimm.grimmsmod.configuration.ClientConfigConfiguration;

public class GetShowMoneyHUDProcedure {
	public static boolean execute() {
		return ClientConfigConfiguration.MHUD.get();
	}
}

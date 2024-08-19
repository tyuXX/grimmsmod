package grimm.grimmsmod.procedures;

import grimm.grimmsmod.configuration.ClientConfigConfiguration;

public class GetShowPlayerHUDProcedure {
	public static boolean execute() {
		return ClientConfigConfiguration.PHUD.get();
	}
}

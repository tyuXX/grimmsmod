package grimmsmod.procedures;

import grimmsmod.configuration.ClientConfigConfiguration;

public class GetShowPlayerHUDProcedure {
	public static boolean execute() {
		return ClientConfigConfiguration.PHUD.get();
	}
}

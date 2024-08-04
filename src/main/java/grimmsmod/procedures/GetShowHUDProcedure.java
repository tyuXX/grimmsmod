package grimmsmod.procedures;

import grimmsmod.configuration.ClientConfigConfiguration;

public class GetShowHUDProcedure {
	public static boolean execute() {
		return ClientConfigConfiguration.HUD.get();
	}
}

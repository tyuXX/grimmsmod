package grimm.grimmsmod.procedures;

import grimm.grimmsmod.configuration.ClientConfigConfiguration;

public class GetShowHUDProcedure {
	public static boolean execute() {
		return ClientConfigConfiguration.HUD.get();
	}
}

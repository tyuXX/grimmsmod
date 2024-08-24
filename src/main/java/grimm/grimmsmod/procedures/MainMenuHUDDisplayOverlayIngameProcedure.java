package grimm.grimmsmod.procedures;

import grimm.grimmsmod.configuration.ClientConfigConfiguration;

public class MainMenuHUDDisplayOverlayIngameProcedure {
	public static boolean execute() {
		return ClientConfigConfiguration.MENUHUD.get();
	}
}

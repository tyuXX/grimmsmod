package grimm.grimmsmod.procedures;

import grimm.grimmsmod.configuration.ClientConfigConfiguration;

public class GetShowCorHUDProcedure {
	public static boolean execute() {
		return ClientConfigConfiguration.CORHUD.get();
	}
}

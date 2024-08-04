package grimmsmod.procedures;

import grimmsmod.configuration.ClientConfigConfiguration;

public class GetShowCorHUDProcedure {
	public static boolean execute() {
		return ClientConfigConfiguration.CORHUD.get();
	}
}

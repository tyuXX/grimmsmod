package grimm.grimmsmod.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CommonConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	static {

		SPEC = BUILDER.build();
	}

}

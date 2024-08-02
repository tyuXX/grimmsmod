package gsd.tyuxx.grimmsmod.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CommonConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Boolean> INSTLEVELUP;
	static {
		BUILDER.push("leveling");
		INSTLEVELUP = BUILDER.define("Instant Level Up", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}

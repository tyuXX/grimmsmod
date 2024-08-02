package gsd.tyuxx.grimmsmod.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Boolean> INSTLEVELUP;
	public static final ModConfigSpec.ConfigValue<Boolean> INSTWAND;
	static {
		BUILDER.push("performance");
		INSTLEVELUP = BUILDER.comment("Use a while loop so no leftover xp is left").define("Instant Level Up", true);
		INSTWAND = BUILDER.comment("Wands don't run on ticks but are instant").define("Instant wands", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}

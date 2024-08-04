package grimmsmod.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Boolean> INSTLEVELUP;
	public static final ModConfigSpec.ConfigValue<Boolean> INSTWAND;
	public static final ModConfigSpec.ConfigValue<Double> LVLMULT;
	public static final ModConfigSpec.ConfigValue<Double> LVLEXPO;
	static {
		BUILDER.push("performance");
		INSTLEVELUP = BUILDER.comment("Use a while loop so no leftover xp is left").define("Instant Level Up", true);
		INSTWAND = BUILDER.comment("Wands don't run on ticks but are instant").define("Instant wands", false);
		BUILDER.pop();
		BUILDER.push("itemleveling");
		LVLMULT = BUILDER.comment("Item level xp requirement multiplier.").define("Item LvL Mult", (double) 100);
		LVLEXPO = BUILDER.comment("Item level xp requirement multiplier.").define("Item LvL Expo", (double) 1.1);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}

package grimmsmod.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class ServerConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Boolean> INSTLEVELUP;
	public static final ModConfigSpec.ConfigValue<Boolean> INSTWAND;
	public static final ModConfigSpec.ConfigValue<Double> LVLMULT;
	public static final ModConfigSpec.ConfigValue<Double> LVLEXPO;
	public static final ModConfigSpec.ConfigValue<Boolean> SPRESTIGE;
	public static final ModConfigSpec.ConfigValue<Boolean> SLEVEL;
	public static final ModConfigSpec.ConfigValue<Double> SNLEVEL;
	public static final ModConfigSpec.ConfigValue<List<? extends String>> CTVALUES;
	public static final ModConfigSpec.ConfigValue<List<? extends String>> CCVALUES;
	static {
		BUILDER.push("Performance");
		INSTLEVELUP = BUILDER.comment("Use a while loop so no leftover xp is left").define("Instant Level Up", true);
		INSTWAND = BUILDER.comment("Wands don't run on ticks but are instant").define("Instant wands", false);
		BUILDER.pop();
		BUILDER.push("Item Leveling");
		LVLMULT = BUILDER.comment("Item level xp requirement multiplier.").define("Item LvL Mult", (double) 100);
		LVLEXPO = BUILDER.comment("Item level xp requirement multiplier.").define("Item LvL Expo", (double) 1.1);
		BUILDER.pop();
		BUILDER.push("Shoutouts");
		SPRESTIGE = BUILDER.comment("Sends chat message to all players when someone prestiges.").define("Shout Prestige", true);
		SLEVEL = BUILDER.comment("Sends chat message to all players when someone levels up.").define("Shout Level", true);
		SNLEVEL = BUILDER.comment("Shouts every <value> levels").define("Level for shout", (double) 10);
		BUILDER.pop();
		BUILDER.push("Caches");
		CTVALUES = BUILDER.comment("Use format {registry name}/{TV}").defineList("Custom TV's", List.of(), entry -> true);
		CCVALUES = BUILDER.comment("Use format {recipe type}${registry name}/{registry name}/{registry name}/{registry name}/{registry name}/{registry name}/{registry name}/{registry name}/{registry name}:{output registry name}")
				.defineList("Custom Crafting's", List.of(), entry -> true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}

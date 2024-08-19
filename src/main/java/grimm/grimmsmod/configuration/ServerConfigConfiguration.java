package grimm.grimmsmod.configuration;

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
	public static final ModConfigSpec.ConfigValue<List<? extends String>> TVVALUES;
	public static final ModConfigSpec.ConfigValue<List<? extends String>> CVALUES;
	public static final ModConfigSpec.ConfigValue<List<? extends String>> RADVALUES;
	public static final ModConfigSpec.ConfigValue<Boolean> RADENABLE;
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
		TVVALUES = BUILDER.comment("Use format {registry name}/{value}").defineList("TV's", List.of("minecraft:cobblestone/1", "minecraft:stone/1", "minecraft:oak_log/4", "minecraft:oak_planks/1"), entry -> true);
		CVALUES = BUILDER.comment("Use format {recipe type}${supported number of {input registry name}/{input registry name}}>{output registry name}").defineList("Crafting's",
				List.of("forgery$minecraft:air/minecraft:air/minecraft:air/grimms:steel/grimms:steel/minecraft:stick/minecraft:air/minecraft:air/minecraft:air>grimms:katana",
						"forgery$minecraft:air/minecraft:air/minecraft:air/grimms:tempered_steel/grimms:tempered_steel/grimms:tempered_steel/minecraft:air/minecraft:air/minecraft:air>grimms:heavy_metal_pipe",
						"distillery$minecraft:water_bucket>grimms:salt_bucket", "heavyblaster$grimms:steel>grimms:tempered_steel", "heavyblaster$grimms:tempered_steel>grimms:galvanized_steel",
						"forgery$grimms:iridium_ingot/grimms:iridium_ingot/minecraft:air/grimms:iridium_ingot/minecraft:stick/minecraft:stick/grimms:iridium_ingot/grimms:iridium_ingot/minecraft:air>grimms:iridium_hammer",
						"heavyblaster$grimms:tungsten_ingot>grimms:tungsten_carbide_ingot"),
				entry -> true);
		RADVALUES = BUILDER.comment("Use format {registry name}/{value}").defineList("Radiation Value's",
				List.of("grimms:uranium_ingot/0.01", "grimms:thorium_ingot/0.02", "grimms:plutonium_ingot/0.1", "grimms:uranium_block/0.09", "grimms:thorium_block/0.18", "grimms:plutonium_block/0.9"), entry -> true);
		BUILDER.pop();
		BUILDER.push("Modules");
		RADENABLE = BUILDER.define("Enable Radiation", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}

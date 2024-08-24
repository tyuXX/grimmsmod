package grimm.grimmsmod.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Boolean> MHUD;
	public static final ModConfigSpec.ConfigValue<Boolean> PHUD;
	public static final ModConfigSpec.ConfigValue<Boolean> CORHUD;
	public static final ModConfigSpec.ConfigValue<Boolean> HUD;
	public static final ModConfigSpec.ConfigValue<Boolean> DAYHUD;
	public static final ModConfigSpec.ConfigValue<Boolean> MENUHUD;
	static {
		BUILDER.push("HUD");
		MHUD = BUILDER.comment("Enables the HUD that shows your money on the top left corner.").define("Money HUD", true);
		PHUD = BUILDER.comment("Shows the player on the top right corner.").define("Player HUD", true);
		CORHUD = BUILDER.comment("Shows your coordinates below the money. HUD.").define("Coordinates HUD", true);
		HUD = BUILDER.define("Show HUD", true);
		DAYHUD = BUILDER.comment("Shows the current day in the top left corner.").define("Day counter HUD", true);
		MENUHUD = BUILDER.define("Main menu HUD", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}

package grimm.grimmsmod.procedures;

import net.minecraft.nbt.StringTag;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimm.grimmsmod.network.GrimmsModVariables;

public class PrestigeUpgradeNameTextValueProcedure {
	public static String execute(HashMap guistate) {
		if (guistate == null)
			return "";
		if (GrimmsModVariables.cache.contains(("nameability:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) {
			return "Name:" + ((GrimmsModVariables.cache.get(("nameability:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) instanceof StringTag _stringTag
					? _stringTag.getAsString()
					: "");
		}
		return "N/A";
	}
}

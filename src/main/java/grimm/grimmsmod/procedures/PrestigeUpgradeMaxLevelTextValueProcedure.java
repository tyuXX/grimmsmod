package grimm.grimmsmod.procedures;

import net.minecraft.nbt.DoubleTag;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimm.grimmsmod.network.GrimmsModVariables;

public class PrestigeUpgradeMaxLevelTextValueProcedure {
	public static String execute(HashMap guistate) {
		if (guistate == null)
			return "";
		if (GrimmsModVariables.cache.contains(("maxability:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) {
			return "Max Level:" + (new java.text.DecimalFormat("##")
					.format((GrimmsModVariables.cache.get(("maxability:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) instanceof DoubleTag _doubleTag
							? _doubleTag.getAsDouble()
							: 0.0D));
		}
		return "N/A";
	}
}

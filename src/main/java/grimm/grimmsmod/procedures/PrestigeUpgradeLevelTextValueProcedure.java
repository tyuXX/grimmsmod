package grimm.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimm.grimmsmod.network.GrimmsModVariables;

public class PrestigeUpgradeLevelTextValueProcedure {
	public static String execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return "";
		if (GrimmsModVariables.cache.contains(("ability:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) {
			if (entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains((guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : ""))) {
				return "Level:" + (new java.text.DecimalFormat("##").format((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities
						.get((guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : ""))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D));
			}
			return "Level:0";
		}
		return "N/A";
	}
}

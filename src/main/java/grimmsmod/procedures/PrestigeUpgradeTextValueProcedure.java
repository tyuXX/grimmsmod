package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.StringTag;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimmsmod.network.GrimmsModVariables;

public class PrestigeUpgradeTextValueProcedure {
	public static String execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return "";
		if (entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains((guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : ""))) {
			return "Name:"
					+ ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities
							.get(("name:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) instanceof StringTag _stringTag ? _stringTag.getAsString() : "")
					+ " Level:" + ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities
							.get((guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : ""))) instanceof StringTag _stringTag ? _stringTag.getAsString() : "");
		}
		return "N/A";
	}
}

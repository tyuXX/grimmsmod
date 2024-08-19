package grimm.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.StringTag;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimm.grimmsmod.network.GrimmsModVariables;

public class PrestigeUpgradeTextValueProcedure {
	public static String execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return "";
		if (entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains((guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : ""))) {
			return "Name:"
					+ ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities
							.get(("name:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) instanceof StringTag _stringTag ? _stringTag.getAsString() : "")
					+ " Level:" + entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.get((guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")) + " Max Level:"
					+ entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.get(("max:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")));
		}
		return "N/A";
	}
}

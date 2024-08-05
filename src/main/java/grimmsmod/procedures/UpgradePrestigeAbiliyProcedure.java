package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimmsmod.network.GrimmsModVariables;

public class UpgradePrestigeAbiliyProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:prestigepoints")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= 1) {
			ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false, 1,
					guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "");
			ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, true, -1, "grimm:prestigepoints");
		}
	}
}

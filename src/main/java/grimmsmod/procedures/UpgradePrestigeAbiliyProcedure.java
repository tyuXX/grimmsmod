package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.GrimmsMod;

public class UpgradePrestigeAbiliyProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:prestigepoints")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= 1) {
			if (entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains((guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : ""))) {
				if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.get((guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : ""))) instanceof DoubleTag _doubleTag
						? _doubleTag.getAsDouble()
						: 0.0D) < ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities
								.get(("max:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)) {
					ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities, entity, false, 1,
							guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "");
					ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, true, -1, "grimm:prestigepoints");
					GrimmsMod.LOGGER.info("3");
				}
				GrimmsMod.LOGGER.info("2");
			}
			GrimmsMod.LOGGER.info("1");
		}
		GrimmsMod.LOGGER.info("0");
	}
}

package grimm.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimm.grimmsmod.network.GrimmsModVariables;

public class UpgradePrestigeAbiliyProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (GrimmsModVariables.cache.contains(("ability:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) {
			if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:prestigepoints")) instanceof DoubleTag _doubleTag
					? _doubleTag.getAsDouble()
					: 0.0D) >= ((GrimmsModVariables.cache.get(("costability:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) instanceof DoubleTag _doubleTag
							? _doubleTag.getAsDouble()
							: 0.0D)) {
				if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.get((guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : ""))) instanceof DoubleTag _doubleTag
						? _doubleTag.getAsDouble()
						: 0.0D) < ((GrimmsModVariables.cache.get(("maxability:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) instanceof DoubleTag _doubleTag
								? _doubleTag.getAsDouble()
								: 0.0D)) {
					ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities, entity, false, 1,
							guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "");
					ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, true,
							(-1) * ((GrimmsModVariables.cache.get(("costability:" + (guistate.containsKey("text:prestigeupgradeid") ? ((EditBox) guistate.get("text:prestigeupgradeid")).getValue() : "")))) instanceof DoubleTag _doubleTag
									? _doubleTag.getAsDouble()
									: 0.0D),
							"grimm:prestigepoints");
				}
			}
		}
	}
}

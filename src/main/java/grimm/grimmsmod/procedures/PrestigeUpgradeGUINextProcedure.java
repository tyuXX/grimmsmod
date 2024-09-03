package grimm.grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimm.grimmsmod.network.GrimmsModVariables;

public class PrestigeUpgradeGUINextProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats, entity, false, 1, "menu:prestigeid");
		if (!(((GrimmsModVariables.cache.get("prestigemenu")) instanceof ListTag _listTag ? _listTag.copy() : new ListTag())
				.size() > ((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats.get("menu:prestigeid")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D))) {
			SetDataElementProcedure.execute(DoubleTag.valueOf(0), entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats, entity, false, "menu:prestigeid");
		}
		if (guistate.get("text:prestigeupgradeid") instanceof EditBox _tf)
			_tf.setValue(((((GrimmsModVariables.cache.get("prestigemenu")) instanceof ListTag _listTag ? _listTag.copy() : new ListTag())
					.get((int) Math.round((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats.get("menu:prestigeid")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D))) instanceof StringTag _stringTag
							? _stringTag.getAsString()
							: ""));
	}
}

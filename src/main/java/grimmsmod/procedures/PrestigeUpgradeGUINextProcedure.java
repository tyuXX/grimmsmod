package grimmsmod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.StringTag;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimmsmod.network.GrimmsModVariables;

public class PrestigeUpgradeGUINextProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.contains((new java.text.DecimalFormat("##").format(new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:sid") ? ((EditBox) guistate.get("text:sid")).getValue() : "") + 1)))) {
			if (guistate.get("text:sid") instanceof EditBox _tf)
				_tf.setValue((new java.text.DecimalFormat("##").format(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:sid") ? ((EditBox) guistate.get("text:sid")).getValue() : "") + 1)));
			if (guistate.get("text:ability") instanceof EditBox _tf)
				_tf.setValue(((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.get((new java.text.DecimalFormat("##").format(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:sid") ? ((EditBox) guistate.get("text:sid")).getValue() : "") + 1)))) instanceof StringTag _stringTag ? _stringTag.getAsString() : ""));
		}
	}
}

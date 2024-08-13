package grimmsmod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimmsmod.network.GrimmsModVariables;

public class PrestigeUpgradeGUINextProcedure {
	public static void execute(HashMap guistate) {
		if (guistate == null)
			return;
		if (((GrimmsModVariables.cache.get("menu:prestige")) instanceof ListTag _listTag ? _listTag.copy() : new ListTag()).size() > new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:sid") ? ((EditBox) guistate.get("text:sid")).getValue() : "") + 1) {
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
				_tf.setValue(((((GrimmsModVariables.cache.get("menu:prestige")) instanceof ListTag _listTag ? _listTag.copy() : new ListTag()).get((int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##").format(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:sid") ? ((EditBox) guistate.get("text:sid")).getValue() : "") + 1)))) instanceof StringTag _stringTag ? _stringTag.getAsString() : ""));
		} else {
			if (guistate.get("text:sid") instanceof EditBox _tf)
				_tf.setValue((new java.text.DecimalFormat("##").format(0)));
		}
	}
}

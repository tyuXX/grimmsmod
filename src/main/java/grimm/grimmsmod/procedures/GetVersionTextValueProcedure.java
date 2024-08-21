package grimm.grimmsmod.procedures;

import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.fml.ModList;

import java.util.List;

public class GetVersionTextValueProcedure {
	public static String execute() {
		return "Grimm's Mod Version " + new Object() {
			String getValue(String modid) {
				String val = "";
				List<IModInfo> mods = ModList.get().getMods();
				for (IModInfo mod : mods) {
					if (mod.getModId().equals(modid.toLowerCase())) {
						val = mod.getVersion().toString();
						break;
					}
				}
				return val;
			}
		}.getValue("grimms");
	}
}

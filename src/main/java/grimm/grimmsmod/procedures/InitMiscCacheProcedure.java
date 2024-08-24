package grimm.grimmsmod.procedures;

import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;

import grimm.grimmsmod.network.GrimmsModVariables;

public class InitMiscCacheProcedure {
	public static void execute() {
		ListTag tmp;
		tmp = new ListTag();
		tmp.addTag(0, StringTag.valueOf("prestige:keepinventory"));
		tmp.addTag(1, StringTag.valueOf("prestige:dexterious"));
		tmp.addTag(2, StringTag.valueOf("prestige:powerful"));
		tmp.addTag(3, StringTag.valueOf("prestige:cure"));
		tmp.addTag(4, StringTag.valueOf("prestige:forger"));
		GrimmsModVariables.cache.put("menu:prestige", tmp);
	}
}

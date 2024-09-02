package grimm.grimmsmod.procedures;

import net.minecraft.nbt.ByteTag;

import grimm.grimmsmod.network.GrimmsModVariables;

public class MainMenuHUDDisplayOverlayIngameProcedure {
	public static boolean execute() {
		return (GrimmsModVariables.config.get("client:menuhud")) instanceof ByteTag _byteTag ? _byteTag.getAsByte() == 1 : false;
	}
}

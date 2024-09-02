package grimm.grimmsmod.procedures;

import net.minecraft.nbt.ByteTag;

import grimm.grimmsmod.network.GrimmsModVariables;

public class GetShowHUDProcedure {
	public static boolean execute() {
		return (GrimmsModVariables.config.get("client:gamehud")) instanceof ByteTag _byteTag ? _byteTag.getAsByte() == 1 : false;
	}
}

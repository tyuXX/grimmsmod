package grimm.grimmsmod.procedures;

import net.minecraft.nbt.ByteTag;

import grimm.grimmsmod.network.GrimmsModVariables;

public class GetShowPlayerHUDProcedure {
	public static boolean execute() {
		return (GrimmsModVariables.config.get("client:playerhud")) instanceof ByteTag _byteTag ? _byteTag.getAsByte() == 1 : false;
	}
}

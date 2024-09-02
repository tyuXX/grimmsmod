package grimm.grimmsmod.procedures;

import net.minecraft.nbt.ByteTag;

import grimm.grimmsmod.network.GrimmsModVariables;

public class GetShowCorHUDProcedure {
	public static boolean execute() {
		return (GrimmsModVariables.config.get("client:coordshud")) instanceof ByteTag _byteTag ? _byteTag.getAsByte() == 1 : false;
	}
}

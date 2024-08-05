package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.ByteTag;
import net.minecraft.commands.CommandSourceStack;

import grimmsmod.network.GrimmsModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class SetAbilitiesCommandLogicProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		SetDataElementProcedure.execute(ByteTag.valueOf((BoolArgumentType.getBool(arguments, "value"))), entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities, entity, true, StringArgumentType.getString(arguments, "ability"));
	}
}

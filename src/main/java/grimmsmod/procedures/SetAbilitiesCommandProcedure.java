package grimmsmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.IntTag;
import net.minecraft.commands.CommandSourceStack;

import grimmsmod.network.GrimmsModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetAbilitiesCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		SetDataElementProcedure.execute(IntTag.valueOf((int) DoubleArgumentType.getDouble(arguments, "value")), entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities, entity, true,
				StringArgumentType.getString(arguments, "ability"));
	}
}

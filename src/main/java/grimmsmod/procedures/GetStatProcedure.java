package grimmsmod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ByteTag;
import net.minecraft.commands.CommandSourceStack;

import grimmsmod.network.GrimmsModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class GetStatProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		Tag tmp;
		tmp = entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get((StringArgumentType.getString(arguments, "stat")));
		if (tmp.getId() == 1) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((StringArgumentType.getString(arguments, "stat") + " is " + (tmp instanceof ByteTag _byteTag ? _byteTag.getAsByte() == 1 : false))), false);
		} else if (tmp.getId() == 8) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((StringArgumentType.getString(arguments, "stat") + " is " + (tmp instanceof StringTag _stringTag ? _stringTag.getAsString() : ""))), false);
		}
	}
}

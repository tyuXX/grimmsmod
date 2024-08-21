package grimm.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import grimm.grimmsmod.network.GrimmsModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class TransferMoneyProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "player");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player
				&& ((GrimmsModVariables.MapVariables.get(world).mapstats.get((entity.getStringUUID() + "/grimm:money"))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) > DoubleArgumentType.getDouble(arguments, "amount")) {
			ChangeNumberDataElementProcedure.execute(GrimmsModVariables.MapVariables.get(world).mapstats, entity, false, (-1) * DoubleArgumentType.getDouble(arguments, "amount"), entity.getStringUUID() + "/grimm:money");
			ChangeNumberDataElementProcedure.execute(GrimmsModVariables.MapVariables.get(world).mapstats, entity, true, DoubleArgumentType.getDouble(arguments, "amount"), (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getStringUUID() + "/grimm:money");
		}
	}
}


package grimm.grimmsmod.command;

import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import grimm.grimmsmod.procedures.ReloadClientConfigProcedure;

@EventBusSubscriber(value = Dist.CLIENT)
public class ReloadClientConfigCommandCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterClientCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("g_reloadclientconfig")

				.executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					ReloadClientConfigProcedure.execute();
					return 0;
				}));
	}
}

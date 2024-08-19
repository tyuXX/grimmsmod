
package grimm.grimmsmod.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import grimm.grimmsmod.procedures.PlayerHasDosimeterProcedure;
import grimm.grimmsmod.procedures.GetRadiationTextValueProcedure;
import grimm.grimmsmod.procedures.GetLastTickRadsTextValueProcedure;

@EventBusSubscriber({Dist.CLIENT})
public class GameplayHUDOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			if (PlayerHasDosimeterProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						GetRadiationTextValueProcedure.execute(entity), 6, h - 16, -10040320, false);
			if (PlayerHasDosimeterProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						GetLastTickRadsTextValueProcedure.execute(entity), 6, h - 25, -10040320, false);
		}
	}
}

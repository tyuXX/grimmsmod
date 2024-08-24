
package grimm.grimmsmod.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.Minecraft;

import grimm.grimmsmod.procedures.MainMenuHUDDisplayOverlayIngameProcedure;
import grimm.grimmsmod.procedures.GetVersionTextValueProcedure;
import grimm.grimmsmod.procedures.GetMainMenuTextValueProcedure;

@EventBusSubscriber({Dist.CLIENT})
public class MainMenuHUDOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof TitleScreen) {
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
			if (MainMenuHUDDisplayOverlayIngameProcedure.execute()) {
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						GetVersionTextValueProcedure.execute(), 6, 8, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						GetMainMenuTextValueProcedure.execute(), 6, 17, -1, false);
			}
		}
	}
}

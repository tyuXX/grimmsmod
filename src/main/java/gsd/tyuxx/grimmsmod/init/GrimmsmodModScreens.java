
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package gsd.tyuxx.grimmsmod.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import gsd.tyuxx.grimmsmod.client.gui.StatsGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GrimmsmodModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(GrimmsmodModMenus.STATS_GUI.get(), StatsGUIScreen::new);
	}
}

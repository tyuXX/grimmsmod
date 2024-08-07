
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package grimmsmod.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import grimmsmod.client.gui.TransmutationGUIScreen;
import grimmsmod.client.gui.StatsGUIScreen;
import grimmsmod.client.gui.RefineryGUIScreen;
import grimmsmod.client.gui.PrestigeUpgradesGUIScreen;
import grimmsmod.client.gui.ForgeryTableGUIScreen;
import grimmsmod.client.gui.DistilleryGUIScreen;
import grimmsmod.client.gui.DeathPackageGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GrimmsModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(GrimmsModMenus.STATS_GUI.get(), StatsGUIScreen::new);
		event.register(GrimmsModMenus.DEATH_PACKAGE_GUI.get(), DeathPackageGUIScreen::new);
		event.register(GrimmsModMenus.PRESTIGE_UPGRADES_GUI.get(), PrestigeUpgradesGUIScreen::new);
		event.register(GrimmsModMenus.TRANSMUTATION_GUI.get(), TransmutationGUIScreen::new);
		event.register(GrimmsModMenus.FORGERY_TABLE_GUI.get(), ForgeryTableGUIScreen::new);
		event.register(GrimmsModMenus.REFINERY_GUI.get(), RefineryGUIScreen::new);
		event.register(GrimmsModMenus.DISTILLERY_GUI.get(), DistilleryGUIScreen::new);
	}
}

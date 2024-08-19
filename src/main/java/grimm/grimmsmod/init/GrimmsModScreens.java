
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import grimm.grimmsmod.client.gui.TransmutationGUIScreen;
import grimm.grimmsmod.client.gui.TVLiquidatorGUIScreen;
import grimm.grimmsmod.client.gui.StatsGUIScreen;
import grimm.grimmsmod.client.gui.RefineryGUIScreen;
import grimm.grimmsmod.client.gui.PrestigeUpgradesGUIScreen;
import grimm.grimmsmod.client.gui.MathExamGUIScreen;
import grimm.grimmsmod.client.gui.ItemAttributionMenuGUIScreen;
import grimm.grimmsmod.client.gui.HeavyBlasterGUIScreen;
import grimm.grimmsmod.client.gui.ForgeryTableGUIScreen;
import grimm.grimmsmod.client.gui.DistilleryGUIScreen;
import grimm.grimmsmod.client.gui.DeathPackageGUIScreen;
import grimm.grimmsmod.client.gui.BasicCobblestoneGeneratorGUIScreen;

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
		event.register(GrimmsModMenus.TV_LIQUIDATOR_GUI.get(), TVLiquidatorGUIScreen::new);
		event.register(GrimmsModMenus.BASIC_COBBLESTONE_GENERATOR_GUI.get(), BasicCobblestoneGeneratorGUIScreen::new);
		event.register(GrimmsModMenus.ITEM_ATTRIBUTION_MENU_GUI.get(), ItemAttributionMenuGUIScreen::new);
		event.register(GrimmsModMenus.HEAVY_BLASTER_GUI.get(), HeavyBlasterGUIScreen::new);
		event.register(GrimmsModMenus.MATH_EXAM_GUI.get(), MathExamGUIScreen::new);
	}
}

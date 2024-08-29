
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import grimm.grimmsmod.client.gui.WrittenPaperGUIScreen;
import grimm.grimmsmod.client.gui.VoidpackGUIScreen;
import grimm.grimmsmod.client.gui.VaultGUIScreen;
import grimm.grimmsmod.client.gui.TransmutationGUIScreen;
import grimm.grimmsmod.client.gui.TVLiquidatorGUIScreen;
import grimm.grimmsmod.client.gui.StatsGUIScreen;
import grimm.grimmsmod.client.gui.StatisticsGUIScreen;
import grimm.grimmsmod.client.gui.RefineryGUIScreen;
import grimm.grimmsmod.client.gui.PrestigeUpgradesGUIScreen;
import grimm.grimmsmod.client.gui.MathExamGUIScreen;
import grimm.grimmsmod.client.gui.KeyGUIScreen;
import grimm.grimmsmod.client.gui.ItemAttributionMenuGUIScreen;
import grimm.grimmsmod.client.gui.HeavyBlasterGUIScreen;
import grimm.grimmsmod.client.gui.ForgeryTableGUIScreen;
import grimm.grimmsmod.client.gui.DistilleryGUIScreen;
import grimm.grimmsmod.client.gui.DevelopmentChamberGUIScreen;
import grimm.grimmsmod.client.gui.DeathPackageGUIScreen;
import grimm.grimmsmod.client.gui.BasicCobblestoneGeneratorGUIScreen;
import grimm.grimmsmod.client.gui.BackpackT6GUIScreen;
import grimm.grimmsmod.client.gui.BackpackT5GUIScreen;
import grimm.grimmsmod.client.gui.BackpackT4GUIScreen;
import grimm.grimmsmod.client.gui.BackpackT3GUIScreen;
import grimm.grimmsmod.client.gui.BackpackT2GUIScreen;
import grimm.grimmsmod.client.gui.BackpackT1GUIScreen;

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
		event.register(GrimmsModMenus.BACKPACK_T_1_GUI.get(), BackpackT1GUIScreen::new);
		event.register(GrimmsModMenus.BACKPACK_T_2_GUI.get(), BackpackT2GUIScreen::new);
		event.register(GrimmsModMenus.BACKPACK_T_3_GUI.get(), BackpackT3GUIScreen::new);
		event.register(GrimmsModMenus.VOIDPACK_GUI.get(), VoidpackGUIScreen::new);
		event.register(GrimmsModMenus.BACKPACK_T_4_GUI.get(), BackpackT4GUIScreen::new);
		event.register(GrimmsModMenus.BACKPACK_T_5_GUI.get(), BackpackT5GUIScreen::new);
		event.register(GrimmsModMenus.BACKPACK_T_6_GUI.get(), BackpackT6GUIScreen::new);
		event.register(GrimmsModMenus.STATISTICS_GUI.get(), StatisticsGUIScreen::new);
		event.register(GrimmsModMenus.DEVELOPMENT_CHAMBER_GUI.get(), DevelopmentChamberGUIScreen::new);
		event.register(GrimmsModMenus.VAULT_GUI.get(), VaultGUIScreen::new);
		event.register(GrimmsModMenus.KEY_GUI.get(), KeyGUIScreen::new);
		event.register(GrimmsModMenus.WRITTEN_PAPER_GUI.get(), WrittenPaperGUIScreen::new);
	}
}

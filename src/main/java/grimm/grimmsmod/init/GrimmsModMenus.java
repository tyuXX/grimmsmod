
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import grimm.grimmsmod.world.inventory.TransmutationGUIMenu;
import grimm.grimmsmod.world.inventory.TVLiquidatorGUIMenu;
import grimm.grimmsmod.world.inventory.StatsGUIMenu;
import grimm.grimmsmod.world.inventory.RefineryGUIMenu;
import grimm.grimmsmod.world.inventory.PrestigeUpgradesGUIMenu;
import grimm.grimmsmod.world.inventory.MathExamGUIMenu;
import grimm.grimmsmod.world.inventory.ItemAttributionMenuGUIMenu;
import grimm.grimmsmod.world.inventory.HeavyBlasterGUIMenu;
import grimm.grimmsmod.world.inventory.ForgeryTableGUIMenu;
import grimm.grimmsmod.world.inventory.DistilleryGUIMenu;
import grimm.grimmsmod.world.inventory.DeathPackageGUIMenu;
import grimm.grimmsmod.world.inventory.BasicCobblestoneGeneratorGUIMenu;
import grimm.grimmsmod.GrimmsMod;

public class GrimmsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, GrimmsMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<StatsGUIMenu>> STATS_GUI = REGISTRY.register("stats_gui", () -> IMenuTypeExtension.create(StatsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeathPackageGUIMenu>> DEATH_PACKAGE_GUI = REGISTRY.register("death_package_gui", () -> IMenuTypeExtension.create(DeathPackageGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PrestigeUpgradesGUIMenu>> PRESTIGE_UPGRADES_GUI = REGISTRY.register("prestige_upgrades_gui", () -> IMenuTypeExtension.create(PrestigeUpgradesGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TransmutationGUIMenu>> TRANSMUTATION_GUI = REGISTRY.register("transmutation_gui", () -> IMenuTypeExtension.create(TransmutationGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ForgeryTableGUIMenu>> FORGERY_TABLE_GUI = REGISTRY.register("forgery_table_gui", () -> IMenuTypeExtension.create(ForgeryTableGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RefineryGUIMenu>> REFINERY_GUI = REGISTRY.register("refinery_gui", () -> IMenuTypeExtension.create(RefineryGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DistilleryGUIMenu>> DISTILLERY_GUI = REGISTRY.register("distillery_gui", () -> IMenuTypeExtension.create(DistilleryGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TVLiquidatorGUIMenu>> TV_LIQUIDATOR_GUI = REGISTRY.register("tv_liquidator_gui", () -> IMenuTypeExtension.create(TVLiquidatorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BasicCobblestoneGeneratorGUIMenu>> BASIC_COBBLESTONE_GENERATOR_GUI = REGISTRY.register("basic_cobblestone_generator_gui",
			() -> IMenuTypeExtension.create(BasicCobblestoneGeneratorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ItemAttributionMenuGUIMenu>> ITEM_ATTRIBUTION_MENU_GUI = REGISTRY.register("item_attribution_menu_gui", () -> IMenuTypeExtension.create(ItemAttributionMenuGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyBlasterGUIMenu>> HEAVY_BLASTER_GUI = REGISTRY.register("heavy_blaster_gui", () -> IMenuTypeExtension.create(HeavyBlasterGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MathExamGUIMenu>> MATH_EXAM_GUI = REGISTRY.register("math_exam_gui", () -> IMenuTypeExtension.create(MathExamGUIMenu::new));
}


/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import grimm.grimmsmod.world.inventory.WrittenPaperGUIMenu;
import grimm.grimmsmod.world.inventory.VoidpackGUIMenu;
import grimm.grimmsmod.world.inventory.VaultGUIMenu;
import grimm.grimmsmod.world.inventory.TransmutationGUIMenu;
import grimm.grimmsmod.world.inventory.TVLiquidatorGUIMenu;
import grimm.grimmsmod.world.inventory.StatsGUIMenu;
import grimm.grimmsmod.world.inventory.StatisticsGUIMenu;
import grimm.grimmsmod.world.inventory.RefineryGUIMenu;
import grimm.grimmsmod.world.inventory.PrestigeUpgradesGUIMenu;
import grimm.grimmsmod.world.inventory.MathExamGUIMenu;
import grimm.grimmsmod.world.inventory.KeyGUIMenu;
import grimm.grimmsmod.world.inventory.ItemAttributionMenuGUIMenu;
import grimm.grimmsmod.world.inventory.HeavyBlasterGUIMenu;
import grimm.grimmsmod.world.inventory.ForgeryTableGUIMenu;
import grimm.grimmsmod.world.inventory.DistilleryGUIMenu;
import grimm.grimmsmod.world.inventory.DevelopmentChamberGUIMenu;
import grimm.grimmsmod.world.inventory.DeathPackageGUIMenu;
import grimm.grimmsmod.world.inventory.BasicCobblestoneGeneratorGUIMenu;
import grimm.grimmsmod.world.inventory.BackpackT6GUIMenu;
import grimm.grimmsmod.world.inventory.BackpackT5GUIMenu;
import grimm.grimmsmod.world.inventory.BackpackT4GUIMenu;
import grimm.grimmsmod.world.inventory.BackpackT3GUIMenu;
import grimm.grimmsmod.world.inventory.BackpackT2GUIMenu;
import grimm.grimmsmod.world.inventory.BackpackT1GUIMenu;
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
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackT1GUIMenu>> BACKPACK_T_1_GUI = REGISTRY.register("backpack_t_1_gui", () -> IMenuTypeExtension.create(BackpackT1GUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackT2GUIMenu>> BACKPACK_T_2_GUI = REGISTRY.register("backpack_t_2_gui", () -> IMenuTypeExtension.create(BackpackT2GUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackT3GUIMenu>> BACKPACK_T_3_GUI = REGISTRY.register("backpack_t_3_gui", () -> IMenuTypeExtension.create(BackpackT3GUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<VoidpackGUIMenu>> VOIDPACK_GUI = REGISTRY.register("voidpack_gui", () -> IMenuTypeExtension.create(VoidpackGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackT4GUIMenu>> BACKPACK_T_4_GUI = REGISTRY.register("backpack_t_4_gui", () -> IMenuTypeExtension.create(BackpackT4GUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackT5GUIMenu>> BACKPACK_T_5_GUI = REGISTRY.register("backpack_t_5_gui", () -> IMenuTypeExtension.create(BackpackT5GUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackT6GUIMenu>> BACKPACK_T_6_GUI = REGISTRY.register("backpack_t_6_gui", () -> IMenuTypeExtension.create(BackpackT6GUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<StatisticsGUIMenu>> STATISTICS_GUI = REGISTRY.register("statistics_gui", () -> IMenuTypeExtension.create(StatisticsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DevelopmentChamberGUIMenu>> DEVELOPMENT_CHAMBER_GUI = REGISTRY.register("development_chamber_gui", () -> IMenuTypeExtension.create(DevelopmentChamberGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<VaultGUIMenu>> VAULT_GUI = REGISTRY.register("vault_gui", () -> IMenuTypeExtension.create(VaultGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<KeyGUIMenu>> KEY_GUI = REGISTRY.register("key_gui", () -> IMenuTypeExtension.create(KeyGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<WrittenPaperGUIMenu>> WRITTEN_PAPER_GUI = REGISTRY.register("written_paper_gui", () -> IMenuTypeExtension.create(WrittenPaperGUIMenu::new));
}

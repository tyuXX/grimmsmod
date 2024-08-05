
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import grimmsmod.world.inventory.StatsGUIMenu;
import grimmsmod.world.inventory.DeathPackageGUIMenu;

import grimmsmod.GrimmsMod;

public class GrimmsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, GrimmsMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<StatsGUIMenu>> STATS_GUI = REGISTRY.register("stats_gui", () -> IMenuTypeExtension.create(StatsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeathPackageGUIMenu>> DEATH_PACKAGE_GUI = REGISTRY.register("death_package_gui", () -> IMenuTypeExtension.create(DeathPackageGUIMenu::new));
}
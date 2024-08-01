
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package gsd.tyuxx.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import gsd.tyuxx.grimmsmod.world.inventory.StatsGUIMenu;
import gsd.tyuxx.grimmsmod.GrimmsmodMod;

public class GrimmsmodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, GrimmsmodMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<StatsGUIMenu>> STATS_GUI = REGISTRY.register("stats_gui", () -> IMenuTypeExtension.create(StatsGUIMenu::new));
}

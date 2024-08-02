
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gsd.tyuxx.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import gsd.tyuxx.grimmsmod.GrimmsmodMod;

public class GrimmsmodModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GrimmsmodMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GRIMMS_MOD = REGISTRY.register("grimms_mod",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.grimmsmod.grimms_mod")).icon(() -> new ItemStack(GrimmsmodModItems.FANCY_CLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(GrimmsmodModItems.FANCY_CLOCK.get());
				tabData.accept(GrimmsmodModItems.FANCIER_CLOCK.get());
			})

					.build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GRIMMS_MOD_SPECIAL = REGISTRY.register("grimms_mod_special",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.grimmsmod.grimms_mod_special")).icon(() -> new ItemStack(GrimmsmodModItems.BUILDERS_WAND.get())).displayItems((parameters, tabData) -> {
				tabData.accept(GrimmsmodModItems.BUILDERS_WAND.get());
				tabData.accept(GrimmsmodModItems.PLACEHOLDER.get());
			})

					.build());
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import grimmsmod.GrimmsMod;

public class GrimmsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GrimmsMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GRIMMS_MOD = REGISTRY.register("grimms_mod",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.grimms.grimms_mod")).icon(() -> new ItemStack(GrimmsModItems.FANCY_CLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(GrimmsModItems.FANCY_CLOCK.get());
				tabData.accept(GrimmsModItems.FANCIER_CLOCK.get());
				tabData.accept(GrimmsModItems.MICROSCOPE.get());
				tabData.accept(GrimmsModItems.HANDHELD_MICROSCOPE.get());
				tabData.accept(GrimmsModItems.SCALPEL.get());
				tabData.accept(GrimmsModItems.MULTI_USE_SCALPEL.get());
				tabData.accept(GrimmsModItems.DISINFECTANT_SCALPEL.get());
				tabData.accept(GrimmsModItems.WOODEN_HAMMER.get());
				tabData.accept(GrimmsModItems.IRON_HAMMER.get());
				tabData.accept(GrimmsModItems.DIAMOND_HAMMER.get());
				tabData.accept(GrimmsModItems.NETHERITE_HAMMER.get());
				tabData.accept(GrimmsModItems.STEEL.get());
			})

					.build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GRIMMS_MOD_SPECIAL = REGISTRY.register("grimms_mod_special",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.grimms.grimms_mod_special")).icon(() -> new ItemStack(GrimmsModItems.BUILDERS_WAND.get())).displayItems((parameters, tabData) -> {
				tabData.accept(GrimmsModItems.BUILDERS_WAND.get());
				tabData.accept(GrimmsModItems.PLACEHOLDER.get());
				tabData.accept(GrimmsModItems.LOGO.get());
				tabData.accept(GrimmsModItems.THRASH.get());
			})

					.build());
}

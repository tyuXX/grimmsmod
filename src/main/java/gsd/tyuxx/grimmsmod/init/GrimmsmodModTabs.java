
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gsd.tyuxx.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import gsd.tyuxx.grimmsmod.GrimmsmodMod;

public class GrimmsmodModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GrimmsmodMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GRIMMS_MOD = REGISTRY.register("grimms_mod",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.grimmsmod.grimms_mod")).icon(() -> new ItemStack(Blocks.AIR)).displayItems((parameters, tabData) -> {
				tabData.accept(GrimmsmodModItems.FANCY_CLOCK.get());
				tabData.accept(GrimmsmodModItems.FANCIER_CLOCK.get());
			})

					.build());
}

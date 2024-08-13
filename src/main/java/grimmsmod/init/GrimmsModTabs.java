
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
				tabData.accept(GrimmsModItems.KATANA.get());
				tabData.accept(GrimmsModItems.TRANSMUTATION_TABLET.get());
				tabData.accept(GrimmsModBlocks.LAND_MINE.get().asItem());
				tabData.accept(GrimmsModBlocks.FORGERY_TABLE.get().asItem());
				tabData.accept(GrimmsModItems.STEEL_DUST.get());
				tabData.accept(GrimmsModItems.COAL_DUST.get());
				tabData.accept(GrimmsModItems.IRON_DUST.get());
				tabData.accept(GrimmsModItems.MORTAR_AND_PESTLE.get());
				tabData.accept(GrimmsModItems.MORTAR.get());
				tabData.accept(GrimmsModBlocks.REFINERY.get().asItem());
				tabData.accept(GrimmsModBlocks.DISTILLERY.get().asItem());
				tabData.accept(GrimmsModItems.TIN_CAN.get());
				tabData.accept(GrimmsModItems.METAL_PIPE.get());
				tabData.accept(GrimmsModBlocks.TV_LIQUIDATOR.get().asItem());
				tabData.accept(GrimmsModBlocks.BASIC_COBBLESTONE_GENERATOR.get().asItem());
				tabData.accept(GrimmsModItems.HEAVY_METAL_PIPE.get());
				tabData.accept(GrimmsModItems.TEMPERED_STEEL.get());
				tabData.accept(GrimmsModBlocks.HEAVY_BLASTER.get().asItem());
				tabData.accept(GrimmsModItems.SUPERIOR_EXPERIANCE_BOTTLE.get());
				tabData.accept(GrimmsModItems.IRIDIUM_INGOT.get());
				tabData.accept(GrimmsModBlocks.IRIDIUM_ORE.get().asItem());
				tabData.accept(GrimmsModBlocks.IRIDIUM_BLOCK.get().asItem());
				tabData.accept(GrimmsModItems.SILVER_INGOT.get());
				tabData.accept(GrimmsModBlocks.SILVER_ORE.get().asItem());
				tabData.accept(GrimmsModBlocks.SILVER_BLOCK.get().asItem());
				tabData.accept(GrimmsModItems.URANIUM_INGOT.get());
				tabData.accept(GrimmsModBlocks.URANIUM_ORE.get().asItem());
				tabData.accept(GrimmsModBlocks.URANIUM_BLOCK.get().asItem());
				tabData.accept(GrimmsModItems.THORIUM_INGOT.get());
				tabData.accept(GrimmsModBlocks.THORIUM_ORE.get().asItem());
				tabData.accept(GrimmsModBlocks.THORIUM_BLOCK.get().asItem());
				tabData.accept(GrimmsModItems.LEAD_INGOT.get());
				tabData.accept(GrimmsModBlocks.LEAD_ORE.get().asItem());
				tabData.accept(GrimmsModBlocks.LEAD_BLOCK.get().asItem());
			})

					.build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GRIMMS_MOD_SPECIAL = REGISTRY.register("grimms_mod_special",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.grimms.grimms_mod_special")).icon(() -> new ItemStack(GrimmsModItems.BUILDERS_WAND.get())).displayItems((parameters, tabData) -> {
				tabData.accept(GrimmsModItems.BUILDERS_WAND.get());
				tabData.accept(GrimmsModItems.PLACEHOLDER.get());
				tabData.accept(GrimmsModItems.LOGO.get());
				tabData.accept(GrimmsModItems.THRASH.get());
				tabData.accept(GrimmsModItems.TEST_DUMMY_SPAWN_EGG.get());
				tabData.accept(GrimmsModBlocks.LOOT_CRATE.get().asItem());
			})

					.build());
}

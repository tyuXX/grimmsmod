
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import grimm.grimmsmod.GrimmsMod;

public class GrimmsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GrimmsMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GRIMMS_MOD = REGISTRY.register("grimms_mod",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.grimms.grimms_mod")).icon(() -> new ItemStack(GrimmsModItems.FANCY_CLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(GrimmsModItems.FANCY_CLOCK.get());
				tabData.accept(GrimmsModItems.FANCIER_CLOCK.get());
				tabData.accept(GrimmsModItems.MICROSCOPE.get());
				tabData.accept(GrimmsModItems.SCALPEL.get());
				tabData.accept(GrimmsModItems.MULTI_USE_SCALPEL.get());
				tabData.accept(GrimmsModItems.DISINFECTANT_SCALPEL.get());
				tabData.accept(GrimmsModItems.THRASH.get());
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
				tabData.accept(GrimmsModItems.VOLT_METER.get());
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
				tabData.accept(GrimmsModItems.SALT.get());
				tabData.accept(GrimmsModItems.SCREW.get());
				tabData.accept(GrimmsModItems.GALVANIZED_STEEL.get());
				tabData.accept(GrimmsModItems.GALVANIZED_SCREW.get());
				tabData.accept(GrimmsModItems.PHOTOGRAPH_OF_MOTORCAR.get());
				tabData.accept(GrimmsModItems.MATH_EXAM.get());
				tabData.accept(GrimmsModItems.PLUTONIUM_INGOT.get());
				tabData.accept(GrimmsModBlocks.PLUTONIUM_ORE.get().asItem());
				tabData.accept(GrimmsModBlocks.PLUTONIUM_BLOCK.get().asItem());
				tabData.accept(GrimmsModItems.DOSIMETER.get());
				tabData.accept(GrimmsModItems.SALT_BUCKET.get());
				tabData.accept(GrimmsModItems.BACKPACK_T_1.get());
				tabData.accept(GrimmsModItems.BACKPACK_T_2.get());
				tabData.accept(GrimmsModItems.BACKPACK_T_3.get());
				tabData.accept(GrimmsModItems.VOIDPACK.get());
				tabData.accept(GrimmsModItems.IRIDIUM_HAMMER.get());
				tabData.accept(GrimmsModItems.BACKPACK_T_4.get());
				tabData.accept(GrimmsModItems.BACKPACK_T_5.get());
				tabData.accept(GrimmsModItems.BACKPACK_T_6.get());
				tabData.accept(GrimmsModItems.SCREW_BLUEPRINT.get());
				tabData.accept(GrimmsModItems.BLUEPRINT.get());
				tabData.accept(GrimmsModItems.GOLD_SCREW.get());
				tabData.accept(GrimmsModItems.TUNGSTEN_INGOT.get());
				tabData.accept(GrimmsModBlocks.TUNGSTEN_ORE.get().asItem());
				tabData.accept(GrimmsModBlocks.TUNGSTEN_BLOCK.get().asItem());
				tabData.accept(GrimmsModItems.TUNGSTEN_CARBIDE_INGOT.get());
				tabData.accept(GrimmsModItems.TUNGSTEN_CARBIDE_SCREW.get());
				tabData.accept(GrimmsModItems.IRIDIUM_SCREW.get());
				tabData.accept(GrimmsModItems.NETHERITE_SCREW.get());
				tabData.accept(GrimmsModItems.TIN_INGOT.get());
				tabData.accept(GrimmsModBlocks.TIN_ORE.get().asItem());
				tabData.accept(GrimmsModBlocks.TIN_BLOCK.get().asItem());
				tabData.accept(GrimmsModItems.TIN_SCREW.get());
				tabData.accept(GrimmsModItems.ETERNAL_TIN_CAN.get());
				tabData.accept(GrimmsModItems.FULL_TIN_CAN.get());
				tabData.accept(GrimmsModItems.WHETSTONE.get());
				tabData.accept(GrimmsModItems.STICK_O_CRAFTING.get());
				tabData.accept(GrimmsModItems.SODA_BOTTLE.get());
				tabData.accept(GrimmsModItems.SODA_BOTTLE_2.get());
				tabData.accept(GrimmsModItems.PULLUP_TAB.get());
				tabData.accept(GrimmsModItems.CHAMPAGNE_BOTTLE.get());
				tabData.accept(GrimmsModItems.TIN_SODA_BOTTLE.get());
				tabData.accept(GrimmsModItems.ROTTEN_FOOD.get());
				tabData.accept(GrimmsModItems.ALLOYED_INGOT.get());
				tabData.accept(GrimmsModItems.COMPOSITE_GEM.get());
				tabData.accept(GrimmsModItems.COMPOSITE_GALLOY_INGOT.get());
				tabData.accept(GrimmsModItems.INTERDIMENSIONAL_TRAPEZOID.get());
				tabData.accept(GrimmsModItems.ERROR.get());
				tabData.accept(GrimmsModItems.ERROR_B.get());
				tabData.accept(GrimmsModBlocks.DEVELOPMENT_CHAMBER.get().asItem());
			})

					.build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GRIMMS_MOD_SPECIAL = REGISTRY.register("grimms_mod_special",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.grimms.grimms_mod_special")).icon(() -> new ItemStack(GrimmsModItems.BUILDERS_WAND.get())).displayItems((parameters, tabData) -> {
				tabData.accept(GrimmsModItems.BUILDERS_WAND.get());
				tabData.accept(GrimmsModItems.LOGO.get());
				tabData.accept(GrimmsModItems.TEST_DUMMY_SPAWN_EGG.get());
				tabData.accept(GrimmsModBlocks.LOOT_CRATE.get().asItem());
			})

					.build());
}

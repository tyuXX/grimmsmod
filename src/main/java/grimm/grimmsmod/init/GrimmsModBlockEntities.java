
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import grimm.grimmsmod.block.entity.TVLiquidatorBlockEntity;
import grimm.grimmsmod.block.entity.RefineryBlockEntity;
import grimm.grimmsmod.block.entity.HeavyBlasterBlockEntity;
import grimm.grimmsmod.block.entity.ForgeryTableBlockEntity;
import grimm.grimmsmod.block.entity.DistilleryBlockEntity;
import grimm.grimmsmod.block.entity.DevelopmentChamberBlockEntity;
import grimm.grimmsmod.block.entity.BasicCobblestoneGeneratorBlockEntity;
import grimm.grimmsmod.GrimmsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GrimmsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, GrimmsMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FORGERY_TABLE = register("forgery_table", GrimmsModBlocks.FORGERY_TABLE, ForgeryTableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> REFINERY = register("refinery", GrimmsModBlocks.REFINERY, RefineryBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> DISTILLERY = register("distillery", GrimmsModBlocks.DISTILLERY, DistilleryBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TV_LIQUIDATOR = register("tv_liquidator", GrimmsModBlocks.TV_LIQUIDATOR, TVLiquidatorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BASIC_COBBLESTONE_GENERATOR = register("basic_cobblestone_generator", GrimmsModBlocks.BASIC_COBBLESTONE_GENERATOR, BasicCobblestoneGeneratorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> HEAVY_BLASTER = register("heavy_blaster", GrimmsModBlocks.HEAVY_BLASTER, HeavyBlasterBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> DEVELOPMENT_CHAMBER = register("development_chamber", GrimmsModBlocks.DEVELOPMENT_CHAMBER, DevelopmentChamberBlockEntity::new);

	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FORGERY_TABLE.get(), (blockEntity, side) -> ((ForgeryTableBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, REFINERY.get(), (blockEntity, side) -> ((RefineryBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DISTILLERY.get(), (blockEntity, side) -> ((DistilleryBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TV_LIQUIDATOR.get(), (blockEntity, side) -> ((TVLiquidatorBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BASIC_COBBLESTONE_GENERATOR.get(), (blockEntity, side) -> ((BasicCobblestoneGeneratorBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HEAVY_BLASTER.get(), (blockEntity, side) -> ((HeavyBlasterBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DEVELOPMENT_CHAMBER.get(), (blockEntity, side) -> ((DevelopmentChamberBlockEntity) blockEntity).getItemHandler());
	}
}

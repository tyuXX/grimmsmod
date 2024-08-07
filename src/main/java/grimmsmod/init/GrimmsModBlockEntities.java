
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import grimmsmod.block.entity.RefineryBlockEntity;
import grimmsmod.block.entity.ForgeryTableBlockEntity;
import grimmsmod.block.entity.DistilleryBlockEntity;

import grimmsmod.GrimmsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GrimmsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, GrimmsMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FORGERY_TABLE = register("forgery_table", GrimmsModBlocks.FORGERY_TABLE, ForgeryTableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> REFINERY = register("refinery", GrimmsModBlocks.REFINERY, RefineryBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> DISTILLERY = register("distillery", GrimmsModBlocks.DISTILLERY, DistilleryBlockEntity::new);

	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FORGERY_TABLE.get(), (blockEntity, side) -> ((ForgeryTableBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, REFINERY.get(), (blockEntity, side) -> ((RefineryBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DISTILLERY.get(), (blockEntity, side) -> ((DistilleryBlockEntity) blockEntity).getItemHandler());
	}
}

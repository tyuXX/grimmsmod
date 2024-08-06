
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;

import grimmsmod.block.LandMineBlock;
import grimmsmod.block.ForgeryTableBlock;

import grimmsmod.GrimmsMod;

public class GrimmsModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(GrimmsMod.MODID);
	public static final DeferredHolder<Block, Block> LAND_MINE = REGISTRY.register("land_mine", LandMineBlock::new);
	public static final DeferredHolder<Block, Block> FORGERY_TABLE = REGISTRY.register("forgery_table", ForgeryTableBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;

import grimmsmod.block.UraniumOreBlock;
import grimmsmod.block.UraniumBlockBlock;
import grimmsmod.block.ThoriumOreBlock;
import grimmsmod.block.ThoriumBlockBlock;
import grimmsmod.block.TVLiquidatorBlock;
import grimmsmod.block.SilverOreBlock;
import grimmsmod.block.SilverBlockBlock;
import grimmsmod.block.RefineryBlock;
import grimmsmod.block.LootCrateBlock;
import grimmsmod.block.LeadOreBlock;
import grimmsmod.block.LeadBlockBlock;
import grimmsmod.block.LandMineBlock;
import grimmsmod.block.IridiumOreBlock;
import grimmsmod.block.IridiumBlockBlock;
import grimmsmod.block.HeavyBlasterBlock;
import grimmsmod.block.ForgeryTableBlock;
import grimmsmod.block.DistilleryBlock;
import grimmsmod.block.BasicCobblestoneGeneratorBlock;

import grimmsmod.GrimmsMod;

public class GrimmsModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(GrimmsMod.MODID);
	public static final DeferredHolder<Block, Block> LAND_MINE = REGISTRY.register("land_mine", LandMineBlock::new);
	public static final DeferredHolder<Block, Block> FORGERY_TABLE = REGISTRY.register("forgery_table", ForgeryTableBlock::new);
	public static final DeferredHolder<Block, Block> REFINERY = REGISTRY.register("refinery", RefineryBlock::new);
	public static final DeferredHolder<Block, Block> DISTILLERY = REGISTRY.register("distillery", DistilleryBlock::new);
	public static final DeferredHolder<Block, Block> TV_LIQUIDATOR = REGISTRY.register("tv_liquidator", TVLiquidatorBlock::new);
	public static final DeferredHolder<Block, Block> BASIC_COBBLESTONE_GENERATOR = REGISTRY.register("basic_cobblestone_generator", BasicCobblestoneGeneratorBlock::new);
	public static final DeferredHolder<Block, Block> HEAVY_BLASTER = REGISTRY.register("heavy_blaster", HeavyBlasterBlock::new);
	public static final DeferredHolder<Block, Block> LOOT_CRATE = REGISTRY.register("loot_crate", LootCrateBlock::new);
	public static final DeferredHolder<Block, Block> IRIDIUM_ORE = REGISTRY.register("iridium_ore", IridiumOreBlock::new);
	public static final DeferredHolder<Block, Block> IRIDIUM_BLOCK = REGISTRY.register("iridium_block", IridiumBlockBlock::new);
	public static final DeferredHolder<Block, Block> SILVER_ORE = REGISTRY.register("silver_ore", SilverOreBlock::new);
	public static final DeferredHolder<Block, Block> SILVER_BLOCK = REGISTRY.register("silver_block", SilverBlockBlock::new);
	public static final DeferredHolder<Block, Block> URANIUM_ORE = REGISTRY.register("uranium_ore", UraniumOreBlock::new);
	public static final DeferredHolder<Block, Block> URANIUM_BLOCK = REGISTRY.register("uranium_block", UraniumBlockBlock::new);
	public static final DeferredHolder<Block, Block> THORIUM_ORE = REGISTRY.register("thorium_ore", ThoriumOreBlock::new);
	public static final DeferredHolder<Block, Block> THORIUM_BLOCK = REGISTRY.register("thorium_block", ThoriumBlockBlock::new);
	public static final DeferredHolder<Block, Block> LEAD_ORE = REGISTRY.register("lead_ore", LeadOreBlock::new);
	public static final DeferredHolder<Block, Block> LEAD_BLOCK = REGISTRY.register("lead_block", LeadBlockBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}

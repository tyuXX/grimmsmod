
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;

import grimm.grimmsmod.block.UraniumOreBlock;
import grimm.grimmsmod.block.UraniumBlockBlock;
import grimm.grimmsmod.block.TungstenOreBlock;
import grimm.grimmsmod.block.TungstenBlockBlock;
import grimm.grimmsmod.block.TinOreBlock;
import grimm.grimmsmod.block.TinBlockBlock;
import grimm.grimmsmod.block.ThoriumOreBlock;
import grimm.grimmsmod.block.ThoriumBlockBlock;
import grimm.grimmsmod.block.TVLiquidatorBlock;
import grimm.grimmsmod.block.SilverOreBlock;
import grimm.grimmsmod.block.SilverBlockBlock;
import grimm.grimmsmod.block.RefineryBlock;
import grimm.grimmsmod.block.PlutoniumOreBlock;
import grimm.grimmsmod.block.PlutoniumBlockBlock;
import grimm.grimmsmod.block.LootCrateBlock;
import grimm.grimmsmod.block.LeadOreBlock;
import grimm.grimmsmod.block.LeadBlockBlock;
import grimm.grimmsmod.block.LandMineBlock;
import grimm.grimmsmod.block.IridiumOreBlock;
import grimm.grimmsmod.block.IridiumBlockBlock;
import grimm.grimmsmod.block.HeavyBlasterBlock;
import grimm.grimmsmod.block.ForgeryTableBlock;
import grimm.grimmsmod.block.DistilleryBlock;
import grimm.grimmsmod.block.DevelopmentChamberBlock;
import grimm.grimmsmod.block.BasicCobblestoneGeneratorBlock;
import grimm.grimmsmod.GrimmsMod;

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
	public static final DeferredHolder<Block, Block> PLUTONIUM_ORE = REGISTRY.register("plutonium_ore", PlutoniumOreBlock::new);
	public static final DeferredHolder<Block, Block> PLUTONIUM_BLOCK = REGISTRY.register("plutonium_block", PlutoniumBlockBlock::new);
	public static final DeferredHolder<Block, Block> TUNGSTEN_ORE = REGISTRY.register("tungsten_ore", TungstenOreBlock::new);
	public static final DeferredHolder<Block, Block> TUNGSTEN_BLOCK = REGISTRY.register("tungsten_block", TungstenBlockBlock::new);
	public static final DeferredHolder<Block, Block> TIN_ORE = REGISTRY.register("tin_ore", TinOreBlock::new);
	public static final DeferredHolder<Block, Block> TIN_BLOCK = REGISTRY.register("tin_block", TinBlockBlock::new);
	public static final DeferredHolder<Block, Block> DEVELOPMENT_CHAMBER = REGISTRY.register("development_chamber", DevelopmentChamberBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}

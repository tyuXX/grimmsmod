
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import grimm.grimmsmod.procedures.LockAndKeyPropertyValueProviderProcedure;
import grimm.grimmsmod.item.inventory.VoidpackInventoryCapability;
import grimm.grimmsmod.item.inventory.MathExamInventoryCapability;
import grimm.grimmsmod.item.inventory.DeathPackageInventoryCapability;
import grimm.grimmsmod.item.inventory.BackpackT6InventoryCapability;
import grimm.grimmsmod.item.inventory.BackpackT5InventoryCapability;
import grimm.grimmsmod.item.inventory.BackpackT4InventoryCapability;
import grimm.grimmsmod.item.inventory.BackpackT3InventoryCapability;
import grimm.grimmsmod.item.inventory.BackpackT2InventoryCapability;
import grimm.grimmsmod.item.inventory.BackpackT1InventoryCapability;
import grimm.grimmsmod.item.WrittenPaperItem;
import grimm.grimmsmod.item.WoodenHammerItem;
import grimm.grimmsmod.item.WhetstoneItem;
import grimm.grimmsmod.item.VoltMeterItem;
import grimm.grimmsmod.item.VoidpackItem;
import grimm.grimmsmod.item.UraniumIngotItem;
import grimm.grimmsmod.item.TungstenIngotItem;
import grimm.grimmsmod.item.TungstenCarbideScrewItem;
import grimm.grimmsmod.item.TungstenCarbideIngotItem;
import grimm.grimmsmod.item.TransmutationTabletItem;
import grimm.grimmsmod.item.TinSodaBottleItem;
import grimm.grimmsmod.item.TinScrewItem;
import grimm.grimmsmod.item.TinIngotItem;
import grimm.grimmsmod.item.TinCanItem;
import grimm.grimmsmod.item.ThrashItem;
import grimm.grimmsmod.item.ThoriumIngotItem;
import grimm.grimmsmod.item.TemperedSteelItem;
import grimm.grimmsmod.item.SuperiorExperianceBottleItem;
import grimm.grimmsmod.item.StickOCraftingItem;
import grimm.grimmsmod.item.SteelItem;
import grimm.grimmsmod.item.SteelDustItem;
import grimm.grimmsmod.item.SodaBottleItem;
import grimm.grimmsmod.item.SodaBottle2Item;
import grimm.grimmsmod.item.SilverIngotItem;
import grimm.grimmsmod.item.ScrewItem;
import grimm.grimmsmod.item.ScrewBlueprintItem;
import grimm.grimmsmod.item.ScalpelItem;
import grimm.grimmsmod.item.SaltItem;
import grimm.grimmsmod.item.SaltBucketItem;
import grimm.grimmsmod.item.RottenFoodItem;
import grimm.grimmsmod.item.PullupTabItem;
import grimm.grimmsmod.item.PlutoniumIngotItem;
import grimm.grimmsmod.item.PlaceholderItem;
import grimm.grimmsmod.item.PhotographOfMotorcarItem;
import grimm.grimmsmod.item.NetheriteScrewItem;
import grimm.grimmsmod.item.NetheriteHammerItem;
import grimm.grimmsmod.item.MultiUseScalpelItem;
import grimm.grimmsmod.item.MortarItem;
import grimm.grimmsmod.item.MortarAndPestleItem;
import grimm.grimmsmod.item.MicroscopeItem;
import grimm.grimmsmod.item.MetalPipeItem;
import grimm.grimmsmod.item.MathExamItem;
import grimm.grimmsmod.item.MailItem;
import grimm.grimmsmod.item.LootBagItem;
import grimm.grimmsmod.item.LogoItem;
import grimm.grimmsmod.item.LockpickItem;
import grimm.grimmsmod.item.LockAndKeyItem;
import grimm.grimmsmod.item.LeadIngotItem;
import grimm.grimmsmod.item.KatanaItem;
import grimm.grimmsmod.item.IronHammerItem;
import grimm.grimmsmod.item.IronDustItem;
import grimm.grimmsmod.item.IridiumScrewItem;
import grimm.grimmsmod.item.IridiumIngotItem;
import grimm.grimmsmod.item.IridiumHammerItem;
import grimm.grimmsmod.item.InterdimensionalTrapezoidItem;
import grimm.grimmsmod.item.HeavyMetalPipeItem;
import grimm.grimmsmod.item.GoldScrewItem;
import grimm.grimmsmod.item.GalvanizedSteelItem;
import grimm.grimmsmod.item.GalvanizedScrewItem;
import grimm.grimmsmod.item.FullTinCanItem;
import grimm.grimmsmod.item.FancyClockItem;
import grimm.grimmsmod.item.FancierClockItem;
import grimm.grimmsmod.item.EternalTinCanItem;
import grimm.grimmsmod.item.ErrorItem;
import grimm.grimmsmod.item.ErrorBItem;
import grimm.grimmsmod.item.DosimeterItem;
import grimm.grimmsmod.item.DisinfectantScalpelItem;
import grimm.grimmsmod.item.DiamondHammerItem;
import grimm.grimmsmod.item.DespawnWandItem;
import grimm.grimmsmod.item.DebugWandItem;
import grimm.grimmsmod.item.DeathPackageItem;
import grimm.grimmsmod.item.CompositeGemItem;
import grimm.grimmsmod.item.CompositeGalloyIngotItem;
import grimm.grimmsmod.item.CoalDustItem;
import grimm.grimmsmod.item.ChampagneBottleItem;
import grimm.grimmsmod.item.BuildersWandItem;
import grimm.grimmsmod.item.BlueprintItem;
import grimm.grimmsmod.item.BackpackT6Item;
import grimm.grimmsmod.item.BackpackT5Item;
import grimm.grimmsmod.item.BackpackT4Item;
import grimm.grimmsmod.item.BackpackT3Item;
import grimm.grimmsmod.item.BackpackT2Item;
import grimm.grimmsmod.item.BackpackT1Item;
import grimm.grimmsmod.item.AlloyedIngotItem;
import grimm.grimmsmod.GrimmsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GrimmsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(GrimmsMod.MODID);
	public static final DeferredHolder<Item, Item> FANCY_CLOCK = REGISTRY.register("fancy_clock", FancyClockItem::new);
	public static final DeferredHolder<Item, Item> FANCIER_CLOCK = REGISTRY.register("fancier_clock", FancierClockItem::new);
	public static final DeferredHolder<Item, Item> BUILDERS_WAND = REGISTRY.register("builders_wand", BuildersWandItem::new);
	public static final DeferredHolder<Item, Item> PLACEHOLDER = REGISTRY.register("placeholder", PlaceholderItem::new);
	public static final DeferredHolder<Item, Item> LOGO = REGISTRY.register("logo", LogoItem::new);
	public static final DeferredHolder<Item, Item> MICROSCOPE = REGISTRY.register("microscope", MicroscopeItem::new);
	public static final DeferredHolder<Item, Item> SCALPEL = REGISTRY.register("scalpel", ScalpelItem::new);
	public static final DeferredHolder<Item, Item> MULTI_USE_SCALPEL = REGISTRY.register("multi_use_scalpel", MultiUseScalpelItem::new);
	public static final DeferredHolder<Item, Item> DISINFECTANT_SCALPEL = REGISTRY.register("disinfectant_scalpel", DisinfectantScalpelItem::new);
	public static final DeferredHolder<Item, Item> THRASH = REGISTRY.register("thrash", ThrashItem::new);
	public static final DeferredHolder<Item, Item> WOODEN_HAMMER = REGISTRY.register("wooden_hammer", WoodenHammerItem::new);
	public static final DeferredHolder<Item, Item> IRON_HAMMER = REGISTRY.register("iron_hammer", IronHammerItem::new);
	public static final DeferredHolder<Item, Item> DIAMOND_HAMMER = REGISTRY.register("diamond_hammer", DiamondHammerItem::new);
	public static final DeferredHolder<Item, Item> NETHERITE_HAMMER = REGISTRY.register("netherite_hammer", NetheriteHammerItem::new);
	public static final DeferredHolder<Item, Item> STEEL = REGISTRY.register("steel", SteelItem::new);
	public static final DeferredHolder<Item, Item> KATANA = REGISTRY.register("katana", KatanaItem::new);
	public static final DeferredHolder<Item, Item> DEATH_PACKAGE = REGISTRY.register("death_package", DeathPackageItem::new);
	public static final DeferredHolder<Item, Item> TEST_DUMMY_SPAWN_EGG = REGISTRY.register("test_dummy_spawn_egg", () -> new DeferredSpawnEggItem(GrimmsModEntities.TEST_DUMMY, -10092391, -1, new Item.Properties()));
	public static final DeferredHolder<Item, Item> TRANSMUTATION_TABLET = REGISTRY.register("transmutation_tablet", TransmutationTabletItem::new);
	public static final DeferredHolder<Item, Item> LAND_MINE = block(GrimmsModBlocks.LAND_MINE);
	public static final DeferredHolder<Item, Item> FORGERY_TABLE = block(GrimmsModBlocks.FORGERY_TABLE);
	public static final DeferredHolder<Item, Item> STEEL_DUST = REGISTRY.register("steel_dust", SteelDustItem::new);
	public static final DeferredHolder<Item, Item> COAL_DUST = REGISTRY.register("coal_dust", CoalDustItem::new);
	public static final DeferredHolder<Item, Item> IRON_DUST = REGISTRY.register("iron_dust", IronDustItem::new);
	public static final DeferredHolder<Item, Item> MORTAR_AND_PESTLE = REGISTRY.register("mortar_and_pestle", MortarAndPestleItem::new);
	public static final DeferredHolder<Item, Item> MORTAR = REGISTRY.register("mortar", MortarItem::new);
	public static final DeferredHolder<Item, Item> REFINERY = block(GrimmsModBlocks.REFINERY);
	public static final DeferredHolder<Item, Item> DISTILLERY = block(GrimmsModBlocks.DISTILLERY);
	public static final DeferredHolder<Item, Item> TIN_CAN = REGISTRY.register("tin_can", TinCanItem::new);
	public static final DeferredHolder<Item, Item> METAL_PIPE = REGISTRY.register("metal_pipe", MetalPipeItem::new);
	public static final DeferredHolder<Item, Item> TV_LIQUIDATOR = block(GrimmsModBlocks.TV_LIQUIDATOR);
	public static final DeferredHolder<Item, Item> BASIC_COBBLESTONE_GENERATOR = block(GrimmsModBlocks.BASIC_COBBLESTONE_GENERATOR);
	public static final DeferredHolder<Item, Item> HEAVY_METAL_PIPE = REGISTRY.register("heavy_metal_pipe", HeavyMetalPipeItem::new);
	public static final DeferredHolder<Item, Item> TEMPERED_STEEL = REGISTRY.register("tempered_steel", TemperedSteelItem::new);
	public static final DeferredHolder<Item, Item> VOLT_METER = REGISTRY.register("volt_meter", VoltMeterItem::new);
	public static final DeferredHolder<Item, Item> HEAVY_BLASTER = block(GrimmsModBlocks.HEAVY_BLASTER);
	public static final DeferredHolder<Item, Item> LOOT_CRATE = block(GrimmsModBlocks.LOOT_CRATE);
	public static final DeferredHolder<Item, Item> SUPERIOR_EXPERIANCE_BOTTLE = REGISTRY.register("superior_experiance_bottle", SuperiorExperianceBottleItem::new);
	public static final DeferredHolder<Item, Item> IRIDIUM_INGOT = REGISTRY.register("iridium_ingot", IridiumIngotItem::new);
	public static final DeferredHolder<Item, Item> IRIDIUM_ORE = block(GrimmsModBlocks.IRIDIUM_ORE);
	public static final DeferredHolder<Item, Item> IRIDIUM_BLOCK = block(GrimmsModBlocks.IRIDIUM_BLOCK);
	public static final DeferredHolder<Item, Item> SILVER_INGOT = REGISTRY.register("silver_ingot", SilverIngotItem::new);
	public static final DeferredHolder<Item, Item> SILVER_ORE = block(GrimmsModBlocks.SILVER_ORE);
	public static final DeferredHolder<Item, Item> SILVER_BLOCK = block(GrimmsModBlocks.SILVER_BLOCK);
	public static final DeferredHolder<Item, Item> URANIUM_INGOT = REGISTRY.register("uranium_ingot", UraniumIngotItem::new);
	public static final DeferredHolder<Item, Item> URANIUM_ORE = block(GrimmsModBlocks.URANIUM_ORE);
	public static final DeferredHolder<Item, Item> URANIUM_BLOCK = block(GrimmsModBlocks.URANIUM_BLOCK);
	public static final DeferredHolder<Item, Item> THORIUM_INGOT = REGISTRY.register("thorium_ingot", ThoriumIngotItem::new);
	public static final DeferredHolder<Item, Item> THORIUM_ORE = block(GrimmsModBlocks.THORIUM_ORE);
	public static final DeferredHolder<Item, Item> THORIUM_BLOCK = block(GrimmsModBlocks.THORIUM_BLOCK);
	public static final DeferredHolder<Item, Item> LEAD_INGOT = REGISTRY.register("lead_ingot", LeadIngotItem::new);
	public static final DeferredHolder<Item, Item> LEAD_ORE = block(GrimmsModBlocks.LEAD_ORE);
	public static final DeferredHolder<Item, Item> LEAD_BLOCK = block(GrimmsModBlocks.LEAD_BLOCK);
	public static final DeferredHolder<Item, Item> SALT = REGISTRY.register("salt", SaltItem::new);
	public static final DeferredHolder<Item, Item> SCREW = REGISTRY.register("screw", ScrewItem::new);
	public static final DeferredHolder<Item, Item> GALVANIZED_STEEL = REGISTRY.register("galvanized_steel", GalvanizedSteelItem::new);
	public static final DeferredHolder<Item, Item> GALVANIZED_SCREW = REGISTRY.register("galvanized_screw", GalvanizedScrewItem::new);
	public static final DeferredHolder<Item, Item> PHOTOGRAPH_OF_MOTORCAR = REGISTRY.register("photograph_of_motorcar", PhotographOfMotorcarItem::new);
	public static final DeferredHolder<Item, Item> MATH_EXAM = REGISTRY.register("math_exam", MathExamItem::new);
	public static final DeferredHolder<Item, Item> PLUTONIUM_INGOT = REGISTRY.register("plutonium_ingot", PlutoniumIngotItem::new);
	public static final DeferredHolder<Item, Item> PLUTONIUM_ORE = block(GrimmsModBlocks.PLUTONIUM_ORE);
	public static final DeferredHolder<Item, Item> PLUTONIUM_BLOCK = block(GrimmsModBlocks.PLUTONIUM_BLOCK);
	public static final DeferredHolder<Item, Item> DOSIMETER = REGISTRY.register("dosimeter", DosimeterItem::new);
	public static final DeferredHolder<Item, Item> SALT_BUCKET = REGISTRY.register("salt_bucket", SaltBucketItem::new);
	public static final DeferredHolder<Item, Item> BACKPACK_T_1 = REGISTRY.register("backpack_t_1", BackpackT1Item::new);
	public static final DeferredHolder<Item, Item> BACKPACK_T_2 = REGISTRY.register("backpack_t_2", BackpackT2Item::new);
	public static final DeferredHolder<Item, Item> BACKPACK_T_3 = REGISTRY.register("backpack_t_3", BackpackT3Item::new);
	public static final DeferredHolder<Item, Item> VOIDPACK = REGISTRY.register("voidpack", VoidpackItem::new);
	public static final DeferredHolder<Item, Item> IRIDIUM_HAMMER = REGISTRY.register("iridium_hammer", IridiumHammerItem::new);
	public static final DeferredHolder<Item, Item> BACKPACK_T_4 = REGISTRY.register("backpack_t_4", BackpackT4Item::new);
	public static final DeferredHolder<Item, Item> BACKPACK_T_5 = REGISTRY.register("backpack_t_5", BackpackT5Item::new);
	public static final DeferredHolder<Item, Item> BACKPACK_T_6 = REGISTRY.register("backpack_t_6", BackpackT6Item::new);
	public static final DeferredHolder<Item, Item> SCREW_BLUEPRINT = REGISTRY.register("screw_blueprint", ScrewBlueprintItem::new);
	public static final DeferredHolder<Item, Item> BLUEPRINT = REGISTRY.register("blueprint", BlueprintItem::new);
	public static final DeferredHolder<Item, Item> GOLD_SCREW = REGISTRY.register("gold_screw", GoldScrewItem::new);
	public static final DeferredHolder<Item, Item> TUNGSTEN_INGOT = REGISTRY.register("tungsten_ingot", TungstenIngotItem::new);
	public static final DeferredHolder<Item, Item> TUNGSTEN_ORE = block(GrimmsModBlocks.TUNGSTEN_ORE);
	public static final DeferredHolder<Item, Item> TUNGSTEN_BLOCK = block(GrimmsModBlocks.TUNGSTEN_BLOCK);
	public static final DeferredHolder<Item, Item> TUNGSTEN_CARBIDE_INGOT = REGISTRY.register("tungsten_carbide_ingot", TungstenCarbideIngotItem::new);
	public static final DeferredHolder<Item, Item> TUNGSTEN_CARBIDE_SCREW = REGISTRY.register("tungsten_carbide_screw", TungstenCarbideScrewItem::new);
	public static final DeferredHolder<Item, Item> IRIDIUM_SCREW = REGISTRY.register("iridium_screw", IridiumScrewItem::new);
	public static final DeferredHolder<Item, Item> NETHERITE_SCREW = REGISTRY.register("netherite_screw", NetheriteScrewItem::new);
	public static final DeferredHolder<Item, Item> TIN_INGOT = REGISTRY.register("tin_ingot", TinIngotItem::new);
	public static final DeferredHolder<Item, Item> TIN_ORE = block(GrimmsModBlocks.TIN_ORE);
	public static final DeferredHolder<Item, Item> TIN_BLOCK = block(GrimmsModBlocks.TIN_BLOCK);
	public static final DeferredHolder<Item, Item> TIN_SCREW = REGISTRY.register("tin_screw", TinScrewItem::new);
	public static final DeferredHolder<Item, Item> ETERNAL_TIN_CAN = REGISTRY.register("eternal_tin_can", EternalTinCanItem::new);
	public static final DeferredHolder<Item, Item> FULL_TIN_CAN = REGISTRY.register("full_tin_can", FullTinCanItem::new);
	public static final DeferredHolder<Item, Item> WHETSTONE = REGISTRY.register("whetstone", WhetstoneItem::new);
	public static final DeferredHolder<Item, Item> STICK_O_CRAFTING = REGISTRY.register("stick_o_crafting", StickOCraftingItem::new);
	public static final DeferredHolder<Item, Item> SODA_BOTTLE = REGISTRY.register("soda_bottle", SodaBottleItem::new);
	public static final DeferredHolder<Item, Item> SODA_BOTTLE_2 = REGISTRY.register("soda_bottle_2", SodaBottle2Item::new);
	public static final DeferredHolder<Item, Item> PULLUP_TAB = REGISTRY.register("pullup_tab", PullupTabItem::new);
	public static final DeferredHolder<Item, Item> CHAMPAGNE_BOTTLE = REGISTRY.register("champagne_bottle", ChampagneBottleItem::new);
	public static final DeferredHolder<Item, Item> TIN_SODA_BOTTLE = REGISTRY.register("tin_soda_bottle", TinSodaBottleItem::new);
	public static final DeferredHolder<Item, Item> ROTTEN_FOOD = REGISTRY.register("rotten_food", RottenFoodItem::new);
	public static final DeferredHolder<Item, Item> ALLOYED_INGOT = REGISTRY.register("alloyed_ingot", AlloyedIngotItem::new);
	public static final DeferredHolder<Item, Item> COMPOSITE_GEM = REGISTRY.register("composite_gem", CompositeGemItem::new);
	public static final DeferredHolder<Item, Item> COMPOSITE_GALLOY_INGOT = REGISTRY.register("composite_galloy_ingot", CompositeGalloyIngotItem::new);
	public static final DeferredHolder<Item, Item> INTERDIMENSIONAL_TRAPEZOID = REGISTRY.register("interdimensional_trapezoid", InterdimensionalTrapezoidItem::new);
	public static final DeferredHolder<Item, Item> ERROR = REGISTRY.register("error", ErrorItem::new);
	public static final DeferredHolder<Item, Item> ERROR_B = REGISTRY.register("error_b", ErrorBItem::new);
	public static final DeferredHolder<Item, Item> DEVELOPMENT_CHAMBER = block(GrimmsModBlocks.DEVELOPMENT_CHAMBER);
	public static final DeferredHolder<Item, Item> LOCK_AND_KEY = REGISTRY.register("lock_and_key", LockAndKeyItem::new);
	public static final DeferredHolder<Item, Item> VAULT_OPEN = block(GrimmsModBlocks.VAULT_OPEN);
	public static final DeferredHolder<Item, Item> VAULT_CLOSED = block(GrimmsModBlocks.VAULT_CLOSED);
	public static final DeferredHolder<Item, Item> LOCKPICK = REGISTRY.register("lockpick", LockpickItem::new);
	public static final DeferredHolder<Item, Item> DESPAWN_WAND = REGISTRY.register("despawn_wand", DespawnWandItem::new);
	public static final DeferredHolder<Item, Item> DEBUG_WAND = REGISTRY.register("debug_wand", DebugWandItem::new);
	public static final DeferredHolder<Item, Item> LOOT_BAG = REGISTRY.register("loot_bag", LootBagItem::new);
	public static final DeferredHolder<Item, Item> MAIL = REGISTRY.register("mail", MailItem::new);
	public static final DeferredHolder<Item, Item> WRITTEN_PAPER = REGISTRY.register("written_paper", WrittenPaperItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new DeathPackageInventoryCapability(stack), DEATH_PACKAGE.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new MathExamInventoryCapability(stack), MATH_EXAM.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new BackpackT1InventoryCapability(stack), BACKPACK_T_1.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new BackpackT2InventoryCapability(stack), BACKPACK_T_2.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new BackpackT3InventoryCapability(stack), BACKPACK_T_3.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new VoidpackInventoryCapability(stack), VOIDPACK.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new BackpackT4InventoryCapability(stack), BACKPACK_T_4.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new BackpackT5InventoryCapability(stack), BACKPACK_T_5.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new BackpackT6InventoryCapability(stack), BACKPACK_T_6.get());
	}

	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void clientLoad(FMLClientSetupEvent event) {
			event.enqueueWork(() -> {
				ItemProperties.register(LOCK_AND_KEY.get(), new ResourceLocation("grimms:lock_and_key_bound"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) LockAndKeyPropertyValueProviderProcedure.execute(itemStackToRender));
			});
		}
	}
}

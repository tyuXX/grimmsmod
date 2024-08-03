
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.Item;

import grimmsmod.item.WoodenHammerItem;
import grimmsmod.item.ThrashItem;
import grimmsmod.item.SteelItem;
import grimmsmod.item.ScalpelItem;
import grimmsmod.item.PlaceholderItem;
import grimmsmod.item.NetheriteHammerItem;
import grimmsmod.item.MultiUseScalpelItem;
import grimmsmod.item.MicroscopeItem;
import grimmsmod.item.LogoItem;
import grimmsmod.item.IronHammerItem;
import grimmsmod.item.HandheldMicroscopeItem;
import grimmsmod.item.FancyClockItem;
import grimmsmod.item.FancierClockItem;
import grimmsmod.item.DisinfectantScalpelItem;
import grimmsmod.item.DiamondHammerItem;
import grimmsmod.item.BuildersWandItem;

import grimmsmod.GrimmsMod;

public class GrimmsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(GrimmsMod.MODID);
	public static final DeferredHolder<Item, Item> FANCY_CLOCK = REGISTRY.register("fancy_clock", FancyClockItem::new);
	public static final DeferredHolder<Item, Item> FANCIER_CLOCK = REGISTRY.register("fancier_clock", FancierClockItem::new);
	public static final DeferredHolder<Item, Item> BUILDERS_WAND = REGISTRY.register("builders_wand", BuildersWandItem::new);
	public static final DeferredHolder<Item, Item> PLACEHOLDER = REGISTRY.register("placeholder", PlaceholderItem::new);
	public static final DeferredHolder<Item, Item> LOGO = REGISTRY.register("logo", LogoItem::new);
	public static final DeferredHolder<Item, Item> MICROSCOPE = REGISTRY.register("microscope", MicroscopeItem::new);
	public static final DeferredHolder<Item, Item> HANDHELD_MICROSCOPE = REGISTRY.register("handheld_microscope", HandheldMicroscopeItem::new);
	public static final DeferredHolder<Item, Item> SCALPEL = REGISTRY.register("scalpel", ScalpelItem::new);
	public static final DeferredHolder<Item, Item> MULTI_USE_SCALPEL = REGISTRY.register("multi_use_scalpel", MultiUseScalpelItem::new);
	public static final DeferredHolder<Item, Item> DISINFECTANT_SCALPEL = REGISTRY.register("disinfectant_scalpel", DisinfectantScalpelItem::new);
	public static final DeferredHolder<Item, Item> THRASH = REGISTRY.register("thrash", ThrashItem::new);
	public static final DeferredHolder<Item, Item> WOODEN_HAMMER = REGISTRY.register("wooden_hammer", WoodenHammerItem::new);
	public static final DeferredHolder<Item, Item> IRON_HAMMER = REGISTRY.register("iron_hammer", IronHammerItem::new);
	public static final DeferredHolder<Item, Item> DIAMOND_HAMMER = REGISTRY.register("diamond_hammer", DiamondHammerItem::new);
	public static final DeferredHolder<Item, Item> NETHERITE_HAMMER = REGISTRY.register("netherite_hammer", NetheriteHammerItem::new);
	public static final DeferredHolder<Item, Item> STEEL = REGISTRY.register("steel", SteelItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}

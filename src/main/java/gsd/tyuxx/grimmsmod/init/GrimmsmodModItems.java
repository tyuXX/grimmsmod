
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package gsd.tyuxx.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.Item;

import gsd.tyuxx.grimmsmod.item.FancyClockItem;
import gsd.tyuxx.grimmsmod.item.FancierClockItem;
import gsd.tyuxx.grimmsmod.GrimmsmodMod;

public class GrimmsmodModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(GrimmsmodMod.MODID);
	public static final DeferredHolder<Item, Item> FANCY_CLOCK = REGISTRY.register("fancy_clock", FancyClockItem::new);
	public static final DeferredHolder<Item, Item> FANCIER_CLOCK = REGISTRY.register("fancier_clock", FancierClockItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}


package gsd.tyuxx.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FancyClockItem extends Item {
	public FancyClockItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}
}

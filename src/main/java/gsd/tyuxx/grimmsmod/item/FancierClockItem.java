
package gsd.tyuxx.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FancierClockItem extends Item {
	public FancierClockItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}
}


package grimm.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DebugWandItem extends Item {
	public DebugWandItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}
}

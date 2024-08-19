
package grimm.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TinScrewItem extends Item {
	public TinScrewItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}

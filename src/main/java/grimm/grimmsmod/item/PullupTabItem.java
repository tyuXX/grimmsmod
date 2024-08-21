
package grimm.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PullupTabItem extends Item {
	public PullupTabItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}

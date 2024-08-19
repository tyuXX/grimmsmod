
package grimm.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class NetheriteScrewItem extends Item {
	public NetheriteScrewItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}

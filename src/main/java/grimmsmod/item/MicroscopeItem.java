
package grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MicroscopeItem extends Item {
	public MicroscopeItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}

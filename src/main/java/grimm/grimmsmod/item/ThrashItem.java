
package grimm.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ThrashItem extends Item {
	public ThrashItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
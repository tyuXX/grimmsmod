
package grimm.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BlueprintItem extends Item {
	public BlueprintItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}

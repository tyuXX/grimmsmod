
package grimm.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OldBoneItem extends Item {
	public OldBoneItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}

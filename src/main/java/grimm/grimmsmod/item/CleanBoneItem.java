
package grimm.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CleanBoneItem extends Item {
	public CleanBoneItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}

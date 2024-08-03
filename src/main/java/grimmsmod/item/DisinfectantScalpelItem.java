
package grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DisinfectantScalpelItem extends Item {
	public DisinfectantScalpelItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	}
}

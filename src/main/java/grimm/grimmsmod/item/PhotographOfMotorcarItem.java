
package grimm.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PhotographOfMotorcarItem extends Item {
	public PhotographOfMotorcarItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}


package grimmsmod.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;

public class XpBoostEnchantment extends Enchantment {
	public XpBoostEnchantment(EquipmentSlot... slots) {
		super(Enchantment.definition(ItemTags.SHARP_WEAPON_ENCHANTABLE, 2, 10, Enchantment.dynamicCost(1, 10), Enchantment.dynamicCost(6, 10), 4, EquipmentSlot.MAINHAND));
	}
}

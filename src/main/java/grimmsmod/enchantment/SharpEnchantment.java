
package grimmsmod.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;

public class SharpEnchantment extends Enchantment {
	public SharpEnchantment(EquipmentSlot... slots) {
		super(Enchantment.definition(ItemTags.SHARP_WEAPON_ENCHANTABLE, 2, 7, Enchantment.dynamicCost(1, 10), Enchantment.dynamicCost(6, 10), 4, EquipmentSlot.MAINHAND));
	}
}

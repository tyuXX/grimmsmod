
package grimmsmod.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;

public class LifestealEnchantment extends Enchantment {
	public LifestealEnchantment(EquipmentSlot... slots) {
		super(Enchantment.definition(ItemTags.SHARP_WEAPON_ENCHANTABLE, 1, 10, Enchantment.dynamicCost(1, 10), Enchantment.dynamicCost(6, 10), 8, EquipmentSlot.MAINHAND));
	}
}

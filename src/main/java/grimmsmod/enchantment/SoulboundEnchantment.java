
package grimmsmod.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;

public class SoulboundEnchantment extends Enchantment {
	public SoulboundEnchantment(EquipmentSlot... slots) {
		super(Enchantment.definition(ItemTags.DURABILITY_ENCHANTABLE, 10, 1, Enchantment.dynamicCost(1, 10), Enchantment.dynamicCost(6, 10), 1, EquipmentSlot.values()));
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}

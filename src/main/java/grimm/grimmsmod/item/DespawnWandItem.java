
package grimm.grimmsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import grimm.grimmsmod.procedures.DespawnWandLivingEntityIsHitWithItemProcedure;

public class DespawnWandItem extends Item {
	public DespawnWandItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		DespawnWandLivingEntityIsHitWithItemProcedure.execute(entity);
		return retval;
	}
}


package grimm.grimmsmod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import grimm.grimmsmod.procedures.InterdimensionalTrapezoidRightclickedProcedure;

public class InterdimensionalTrapezoidItem extends Item {
	public InterdimensionalTrapezoidItem() {
		super(new Item.Properties().durability(10).rarity(Rarity.EPIC));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		InterdimensionalTrapezoidRightclickedProcedure.execute(entity, ar.getObject());
		return ar;
	}
}

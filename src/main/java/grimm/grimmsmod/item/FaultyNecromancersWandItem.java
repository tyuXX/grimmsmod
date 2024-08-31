
package grimm.grimmsmod.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import grimm.grimmsmod.procedures.FaultyNecromancersWandRightclickedOnBlockProcedure;

public class FaultyNecromancersWandItem extends Item {
	public FaultyNecromancersWandItem() {
		super(new Item.Properties().durability(25).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		FaultyNecromancersWandRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}

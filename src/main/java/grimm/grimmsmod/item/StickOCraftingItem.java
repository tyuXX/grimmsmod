
package grimm.grimmsmod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import grimm.grimmsmod.procedures.StickOCraftingRightclickedProcedure;

public class StickOCraftingItem extends Item {
	public StickOCraftingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		StickOCraftingRightclickedProcedure.execute(entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}
}

package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import grimm.grimmsmod.init.GrimmsModItems;

public class MailRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack tmp = ItemStack.EMPTY;
		if (entity.isShiftKeyDown()) {
			tmp = new ItemStack(GrimmsModItems.WRITTEN_PAPER.get());
			tmp.applyComponents(itemstack.getComponents());
			itemstack.shrink(1);
			if (entity instanceof Player _player) {
				ItemStack _setstack = tmp.copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}

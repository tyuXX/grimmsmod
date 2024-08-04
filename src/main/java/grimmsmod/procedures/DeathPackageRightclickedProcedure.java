package grimmsmod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class DeathPackageRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double itemid = 0;
		if (entity.isShiftKeyDown()) {
			for (int index0 = 0; index0 < 44; index0++) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = (new Object() {
						public ItemStack getItemStack(int sltid, ItemStack _isc) {
							IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(sltid).copy();
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) itemid, itemstack)).copy();
					_setstack.setCount((new Object() {
						public ItemStack getItemStack(int sltid, ItemStack _isc) {
							IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(sltid).copy();
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) itemid, itemstack)).getCount());
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				itemid = itemid + 1;
			}
			itemstack.setCount(0);
		}
	}
}

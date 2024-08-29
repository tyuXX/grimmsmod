package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import grimm.grimmsmod.init.GrimmsModItems;

public class ThrashItemInInventoryTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:errorprogress") > 1000) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(GrimmsModItems.ERROR_B.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			itemstack.shrink(1);
		} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:errorprogress") > 100) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(GrimmsModItems.ERROR.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			itemstack.shrink(1);
		}
	}
}

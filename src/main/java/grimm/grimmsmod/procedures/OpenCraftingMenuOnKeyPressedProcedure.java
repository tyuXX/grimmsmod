package grimm.grimmsmod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import grimm.grimmsmod.init.GrimmsModItems;

public class OpenCraftingMenuOnKeyPressedProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(GrimmsModItems.STICK_O_CRAFTING.get())) : false) {
			StickOCraftingRightclickedProcedure.execute(x, y, z, entity);
		}
	}
}

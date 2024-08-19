package grimm.grimmsmod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import grimm.grimmsmod.init.GrimmsModItems;

public class PlayerHasDosimeterProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(GrimmsModItems.DOSIMETER.get())) : false;
	}
}

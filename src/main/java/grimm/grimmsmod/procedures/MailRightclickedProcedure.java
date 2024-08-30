package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import grimm.grimmsmod.init.GrimmsModItems;

public class MailRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack tmp = ItemStack.EMPTY;
		if (entity.isShiftKeyDown()) {
			tmp = new ItemStack(GrimmsModItems.WRITTEN_PAPER.get());
			{
				final String _tagName = "grimms:papertext";
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("grimms:papertext"));
				CustomData.update(DataComponents.CUSTOM_DATA, tmp, tag -> tag.putString(_tagName, _tagValue));
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = tmp.copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			itemstack.shrink(1);
		}
	}
}

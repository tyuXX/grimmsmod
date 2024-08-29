package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import grimm.grimmsmod.init.GrimmsModItems;

public class DevelopmentChamberOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack tmp = ItemStack.EMPTY;
		tmp = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				if (world instanceof ILevelExtension _ext) {
					IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
					if (_itemHandler != null)
						return _itemHandler.getStackInSlot(slotid).copy();
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 0));
		if (tmp.getItem() == GrimmsModItems.THRASH.get()) {
			{
				final String _tagName = "grimms:errorprogress";
				final double _tagValue = (tmp.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:errorprogress") + 1);
				CustomData.update(DataComponents.CUSTOM_DATA, tmp, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = tmp.copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(0, _setstack);
			}
		}
	}
}

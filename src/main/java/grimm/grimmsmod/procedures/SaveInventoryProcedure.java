package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.DoubleTag;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.init.GrimmsModItems;
import grimm.grimmsmod.init.GrimmsModEnchantments;

public class SaveInventoryProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack tmp = ItemStack.EMPTY;
		double itemid = 0;
		double tmp2 = 0;
		double tmp3 = 0;
		if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.get("prestige:keepinventory")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) > 9) {
			tmp = new ItemStack(GrimmsModItems.DEATH_PACKAGE.get());
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
				for (int _idx = 0; _idx < _modHandler.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandler.getStackInSlot(_idx).copy();
					if (tmp.getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
						ItemStack _setstack = itemstackiterator.copy();
						_setstack.setCount(itemstackiterator.getCount());
						_modHandlerItemSetSlot.setStackInSlot((int) itemid, _setstack);
					}
					itemid = itemid + 1;
				}
			}
			{
				GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
				_vars.deathpackage = tmp;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player)
				_player.getInventory().clearContent();
		} else {
			tmp = new ItemStack(GrimmsModItems.DEATH_PACKAGE.get());
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
				for (int _idx = 0; _idx < _modHandler.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandler.getStackInSlot(_idx).copy();
					if (EnchantmentHelper.getItemEnchantmentLevel(GrimmsModEnchantments.SOULBOUND.get(), itemstackiterator) != 0 || itemstackiterator.is(ItemTags.create(new ResourceLocation("grimms:forcesoulbound")))) {
						if (tmp.getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
							ItemStack _setstack = itemstackiterator.copy();
							_setstack.setCount(itemstackiterator.getCount());
							_modHandlerItemSetSlot.setStackInSlot((int) itemid, _setstack);
						}
						itemid = itemid + 1;
					}
				}
			}
			if (itemid > 0) {
				{
					GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
					_vars.deathpackage = tmp;
					_vars.syncPlayerVariables(entity);
				}
			}
			itemid = 0;
			for (int index0 = 0; index0 < 44; index0++) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = (new Object() {
						public ItemStack getItemStack(int sltid, ItemStack _isc) {
							IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(sltid).copy();
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) itemid, tmp));
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (new Object() {
						public ItemStack getItemStack(int sltid, ItemStack _isc) {
							IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(sltid).copy();
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) itemid, tmp)).getCount(), _player.inventoryMenu.getCraftSlots());
				}
				itemid = itemid + 1;
			}
		}
	}
}

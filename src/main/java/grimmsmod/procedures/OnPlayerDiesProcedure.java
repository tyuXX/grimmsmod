package grimmsmod.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.init.GrimmsModItems;
import grimmsmod.init.GrimmsModEnchantments;

@EventBusSubscriber
public class OnPlayerDiesProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack tmp = ItemStack.EMPTY;
		double itemid = 0;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(GrimmsModItems.DEATH_PACKAGE.get())) : false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(GrimmsModItems.DEATH_PACKAGE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 100, _player.inventoryMenu.getCraftSlots());
			}
		}
		if (entity.getData(GrimmsModVariables.PLAYER_VARIABLES).keepinventory) {
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
					if (EnchantmentHelper.getItemEnchantmentLevel(GrimmsModEnchantments.SOULBOUND.get(), itemstackiterator) != 0) {
						if (tmp.getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
							ItemStack _setstack = itemstackiterator.copy();
							_setstack.setCount(itemstackiterator.getCount());
							_modHandlerItemSetSlot.setStackInSlot((int) itemid, _setstack);
						}
						itemstackiterator.setCount(0);
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
		}
	}
}

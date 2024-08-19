package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.core.component.DataComponents;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import javax.annotation.Nullable;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.init.GrimmsModItems;
import grimm.grimmsmod.init.GrimmsModEnchantments;

@EventBusSubscriber
public class OnPlayerDiesProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack tmp = ItemStack.EMPTY;
		double itemid = 0;
		double tmp2 = 0;
		double tmp3 = 0;
		{
			final String _tagName = "grimms:kills";
			final double _tagValue = ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:kills") + 1);
			CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
		}
		if (entity instanceof Player && sourceentity instanceof Player) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:victim"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:murderer"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(GrimmsModItems.DEATH_PACKAGE.get())) : false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(GrimmsModItems.DEATH_PACKAGE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 100, _player.inventoryMenu.getCraftSlots());
			}
		}
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

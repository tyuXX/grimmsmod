package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.init.GrimmsModItems;
import grimm.grimmsmod.init.GrimmsModGameRules;
import grimm.grimmsmod.init.GrimmsModEnchantments;
import grimm.grimmsmod.init.GrimmsModBlocks;

@EventBusSubscriber
public class OnEntityDiesAbsoluteProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack tmp = ItemStack.EMPTY;
		double itemid = 0;
		double tmp2 = 0;
		double tmp3 = 0;
		tmp = new ItemStack(GrimmsModItems.DEATH_PACKAGE.get());
		if (!world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
			if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.get("prestige:keepinventory")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) > 0) {
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
			if (!world.getLevelData().getGameRules().getBoolean(GrimmsModGameRules.DISABLE_GRAVE_SPAWNING) && y > -64) {
				if (world.getLevelData().getGameRules().getBoolean(GrimmsModGameRules.ENABLE_MOB_GRAVES) || entity instanceof Player) {
					itemid = 0;
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						for (int _idx = 0; _idx < _modHandler.getSlots(); _idx++) {
							ItemStack itemstackiterator = _modHandler.getStackInSlot(_idx).copy();
							world.setBlock(BlockPos.containing(x, y, z), GrimmsModBlocks.BASIC_GRAVE.get().defaultBlockState(), 3);
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putString("owner", (entity.getStringUUID()));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = itemstackiterator.copy();
								_setstack.setCount(itemstackiterator.getCount());
								_itemHandlerModifiable.setStackInSlot((int) itemid, _setstack);
							}
							itemid = itemid + 1;
						}
					}
					if (entity instanceof Player _player)
						_player.getInventory().clearContent();
				}
			}
			SetDataElementProcedure.execute(DoubleTag.valueOf((entity instanceof Player _plr ? _plr.experienceLevel : 0)), entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false, "grimm:lastdeathxp");
		}
	}
}

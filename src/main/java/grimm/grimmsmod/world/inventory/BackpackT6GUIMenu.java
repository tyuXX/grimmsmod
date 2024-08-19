
package grimm.grimmsmod.world.inventory;

import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import grimm.grimmsmod.init.GrimmsModMenus;

public class BackpackT6GUIMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public BackpackT6GUIMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(GrimmsModMenus.BACKPACK_T_6_GUI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(60);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
				IItemHandler cap = itemstack.getCapability(Capabilities.ItemHandler.ITEM);
				if (cap != null) {
					this.internal = cap;
					this.bound = true;
				}
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntity(extraData.readVarInt());
				if (boundEntity != null) {
					IItemHandler cap = boundEntity.getCapability(Capabilities.ItemHandler.ENTITY);
					if (cap != null) {
						this.internal = cap;
						this.bound = true;
					}
				}
			} else { // might be bound to block
				boundBlockEntity = this.world.getBlockEntity(pos);
				if (boundBlockEntity instanceof BaseContainerBlockEntity baseContainerBlockEntity) {
					this.internal = new InvWrapper(baseContainerBlockEntity);
					this.bound = true;
				}
			}
		}
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 46, 8) {
		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 64, 8) {
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 82, 8) {
		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 100, 8) {
		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 118, 8) {
		}));
		this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 136, 8) {
		}));
		this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 154, 8) {
		}));
		this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 172, 8) {
		}));
		this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 190, 8) {
		}));
		this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 46, 26) {
		}));
		this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 64, 26) {
		}));
		this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 82, 26) {
		}));
		this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 100, 26) {
		}));
		this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 118, 26) {
		}));
		this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 136, 26) {
		}));
		this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 154, 26) {
		}));
		this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 172, 26) {
		}));
		this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 190, 26) {
		}));
		this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 46, 44) {
		}));
		this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 64, 44) {
		}));
		this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 82, 44) {
		}));
		this.customSlots.put(21, this.addSlot(new SlotItemHandler(internal, 21, 100, 44) {
		}));
		this.customSlots.put(22, this.addSlot(new SlotItemHandler(internal, 22, 118, 44) {
		}));
		this.customSlots.put(23, this.addSlot(new SlotItemHandler(internal, 23, 136, 44) {
		}));
		this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 154, 44) {
		}));
		this.customSlots.put(25, this.addSlot(new SlotItemHandler(internal, 25, 172, 44) {
		}));
		this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 190, 44) {
		}));
		this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 82, 62) {
		}));
		this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 100, 62) {
		}));
		this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 154, 62) {
		}));
		this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 136, 62) {
		}));
		this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 118, 62) {
		}));
		this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 46, 62) {
		}));
		this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 64, 62) {
		}));
		this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 172, 62) {
		}));
		this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 190, 62) {
		}));
		this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 28, 62) {
		}));
		this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 208, 62) {
		}));
		this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 208, 44) {
		}));
		this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 28, 44) {
		}));
		this.customSlots.put(40, this.addSlot(new SlotItemHandler(internal, 40, 28, 26) {
		}));
		this.customSlots.put(41, this.addSlot(new SlotItemHandler(internal, 41, 208, 26) {
		}));
		this.customSlots.put(42, this.addSlot(new SlotItemHandler(internal, 42, 28, 8) {
		}));
		this.customSlots.put(43, this.addSlot(new SlotItemHandler(internal, 43, 208, 8) {
		}));
		this.customSlots.put(44, this.addSlot(new SlotItemHandler(internal, 44, 10, 8) {
		}));
		this.customSlots.put(45, this.addSlot(new SlotItemHandler(internal, 45, 10, 26) {
		}));
		this.customSlots.put(46, this.addSlot(new SlotItemHandler(internal, 46, 10, 44) {
		}));
		this.customSlots.put(47, this.addSlot(new SlotItemHandler(internal, 47, 226, 8) {
		}));
		this.customSlots.put(48, this.addSlot(new SlotItemHandler(internal, 48, 10, 62) {
		}));
		this.customSlots.put(49, this.addSlot(new SlotItemHandler(internal, 49, 226, 26) {
		}));
		this.customSlots.put(50, this.addSlot(new SlotItemHandler(internal, 50, 226, 44) {
		}));
		this.customSlots.put(51, this.addSlot(new SlotItemHandler(internal, 51, 226, 62) {
		}));
		this.customSlots.put(52, this.addSlot(new SlotItemHandler(internal, 52, 10, 80) {
		}));
		this.customSlots.put(53, this.addSlot(new SlotItemHandler(internal, 53, 10, 98) {
		}));
		this.customSlots.put(54, this.addSlot(new SlotItemHandler(internal, 54, 10, 116) {
		}));
		this.customSlots.put(55, this.addSlot(new SlotItemHandler(internal, 55, 10, 134) {
		}));
		this.customSlots.put(56, this.addSlot(new SlotItemHandler(internal, 56, 226, 80) {
		}));
		this.customSlots.put(57, this.addSlot(new SlotItemHandler(internal, 57, 226, 98) {
		}));
		this.customSlots.put(58, this.addSlot(new SlotItemHandler(internal, 58, 226, 116) {
		}));
		this.customSlots.put(59, this.addSlot(new SlotItemHandler(internal, 59, 226, 134) {
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 39 + 8 + sj * 18, 0 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 39 + 8 + si * 18, 0 + 142));
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 60) {
				if (!this.moveItemStackTo(itemstack1, 60, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 60, false)) {
				if (index < 60 + 27) {
					if (!this.moveItemStackTo(itemstack1, 60 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 60, 60 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0)
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
			if (itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean moveItemStackTo(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
		boolean flag = false;
		int i = p_38905_;
		if (p_38907_) {
			i = p_38906_ - 1;
		}
		if (p_38904_.isStackable()) {
			while (!p_38904_.isEmpty() && (p_38907_ ? i >= p_38905_ : i < p_38906_)) {
				Slot slot = this.slots.get(i);
				ItemStack itemstack = slot.getItem();
				if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameComponents(p_38904_, itemstack)) {
					int j = itemstack.getCount() + p_38904_.getCount();
					int k = slot.getMaxStackSize(itemstack);
					if (j <= k) {
						p_38904_.setCount(0);
						itemstack.setCount(j);
						slot.set(itemstack);
						flag = true;
					} else if (itemstack.getCount() < k) {
						p_38904_.shrink(k - itemstack.getCount());
						itemstack.setCount(k);
						slot.set(itemstack);
						flag = true;
					}
				}
				if (p_38907_) {
					i--;
				} else {
					i++;
				}
			}
		}
		if (!p_38904_.isEmpty()) {
			if (p_38907_) {
				i = p_38906_ - 1;
			} else {
				i = p_38905_;
			}
			while (p_38907_ ? i >= p_38905_ : i < p_38906_) {
				Slot slot1 = this.slots.get(i);
				ItemStack itemstack1 = slot1.getItem();
				if (itemstack1.isEmpty() && slot1.mayPlace(p_38904_)) {
					int l = slot1.getMaxStackSize(p_38904_);
					slot1.setByPlayer(p_38904_.split(Math.min(p_38904_.getCount(), l)));
					slot1.setChanged();
					flag = true;
					break;
				}
				if (p_38907_) {
					i--;
				} else {
					i++;
				}
			}
		}
		return flag;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					playerIn.drop(internal.getStackInSlot(j), false);
					if (internal instanceof IItemHandlerModifiable ihm)
						ihm.setStackInSlot(j, ItemStack.EMPTY);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					playerIn.getInventory().placeItemBackInInventory(internal.getStackInSlot(i));
					if (internal instanceof IItemHandlerModifiable ihm)
						ihm.setStackInSlot(i, ItemStack.EMPTY);
				}
			}
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}

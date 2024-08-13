package grimmsmod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;
import java.util.Map;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.GrimmsMod;

public class ForgeryTableForgeButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String tmp = "";
		ItemStack itemout = ItemStack.EMPTY;
		if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.get("prestige:forger")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) > 0) {
			tmp = "craft:forgery$"
					+ ((BuiltInRegistries.ITEM.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem())
							.toString()) + "/")
					+ ((BuiltInRegistries.ITEM.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem())
							.toString()) + "/")
					+ ((BuiltInRegistries.ITEM.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem())
							.toString()) + "/")
					+ ((BuiltInRegistries.ITEM.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem())
							.toString()) + "/")
					+ ((BuiltInRegistries.ITEM.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem())
							.toString()) + "/")
					+ ((BuiltInRegistries.ITEM.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem())
							.toString()) + "/")
					+ ((BuiltInRegistries.ITEM.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem())
							.toString()) + "/")
					+ ((BuiltInRegistries.ITEM.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(7)).getItem() : ItemStack.EMPTY).getItem())
							.toString()) + "/")
					+ (BuiltInRegistries.ITEM.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem())
							.toString());
			GrimmsMod.LOGGER.info(tmp);
			GrimmsMod.LOGGER.info(((GrimmsModVariables.cache.get(tmp)) instanceof StringTag _stringTag ? _stringTag.getAsString() : ""));
			if (GrimmsModVariables.cache.contains(tmp)) {
				itemout = new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation((((GrimmsModVariables.cache.get(tmp)) instanceof StringTag _stringTag ? _stringTag.getAsString() : "")).toLowerCase(java.util.Locale.ENGLISH))));
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(9)).getItem() : ItemStack.EMPTY)
						.getCount() < (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(9)).getItem() : ItemStack.EMPTY).getMaxStackSize()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(9)).getItem() : ItemStack.EMPTY).getItem() == itemout.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(9)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(0)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(1)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(2)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(3)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(4)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(5)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(6)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(7)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(8)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = itemout.copy();
							_setstack.setCount(
									(int) ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(9)).getItem() : ItemStack.EMPTY).getCount() + 1));
							((Slot) _slots.get(9)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
	}
}

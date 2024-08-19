package grimm.grimmsmod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.ByteTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.gui.components.EditBox;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import grimm.grimmsmod.network.GrimmsModVariables;

public class TransmutationGUIWhileThisGUIIsOpenTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(0) > 0) {
			if (GrimmsModVariables.cache.contains(("tv:" + (BuiltInRegistries.ITEM
					.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem()).toString())))) {
				SetDataElementProcedure.execute(ByteTag.valueOf(true), entity.getData(GrimmsModVariables.PLAYER_VARIABLES).learnedtvs, entity, false, "tv:" + (BuiltInRegistries.ITEM
						.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem()).toString()));
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("grimms:itemlvlinit")) {
					ChangeNumberDataElementProcedure.execute(GrimmsModVariables.MapVariables.get(world).mapstats, entity, false,
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl") * new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
												ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
												if (stack != null)
													return stack.getCount();
											}
											return 0;
										}
									}.getAmount(0)
									* ((GrimmsModVariables.cache.get(("tv:" + (BuiltInRegistries.ITEM
											.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem())
											.toString())))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D),
							entity.getStringUUID() + "/grimm:totaltv");
				} else {
					ChangeNumberDataElementProcedure.execute(GrimmsModVariables.MapVariables.get(world).mapstats, entity, false, new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(0) * ((GrimmsModVariables.cache.get(("tv:" + (BuiltInRegistries.ITEM
							.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem())
							.toString())))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D), entity.getStringUUID() + "/grimm:totaltv");
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					((Slot) _slots.get(0)).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if (!(BuiltInRegistries.ITEM.get(new ResourceLocation(((guistate.containsKey("text:itemid") ? ((EditBox) guistate.get("text:itemid")).getValue() : "")).toLowerCase(java.util.Locale.ENGLISH))) == Blocks.AIR.asItem())) {
			if (((GrimmsModVariables.MapVariables.get(world).mapstats.get((entity.getStringUUID() + "/grimm:totaltv"))) instanceof DoubleTag _doubleTag
					? _doubleTag.getAsDouble()
					: 0.0D) >= ((GrimmsModVariables.cache.get(("tv:" + (BuiltInRegistries.ITEM
							.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem())
							.toString())))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)) {
				if (entity.getData(GrimmsModVariables.PLAYER_VARIABLES).learnedtvs.contains((guistate.containsKey("text:itemid") ? ((EditBox) guistate.get("text:itemid")).getValue() : ""))) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(((guistate.containsKey("text:itemid") ? ((EditBox) guistate.get("text:itemid")).getValue() : "")).toLowerCase(java.util.Locale.ENGLISH))))
								.copy();
						_setstack.setCount(1);
						((Slot) _slots.get(1)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		} else {
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(1)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}

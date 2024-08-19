package grimm.grimmsmod.item.inventory;

import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

import javax.annotation.Nonnull;

import grimm.grimmsmod.init.GrimmsModItems;
import grimm.grimmsmod.client.gui.BackpackT2GUIScreen;

@EventBusSubscriber(Dist.CLIENT)
public class BackpackT2InventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == GrimmsModItems.BACKPACK_T_2.get()) {
			if (Minecraft.getInstance().screen instanceof BackpackT2GUIScreen) {
				Minecraft.getInstance().player.closeContainer();
			}
		}
	}

	public BackpackT2InventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 15);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != GrimmsModItems.BACKPACK_T_2.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}

package grimmsmod.item.inventory;

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

import grimmsmod.init.GrimmsModItems;

import grimmsmod.client.gui.DeathPackageGUIScreen;

@EventBusSubscriber(Dist.CLIENT)
public class DeathPackageInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == GrimmsModItems.DEATH_PACKAGE.get()) {
			if (Minecraft.getInstance().screen instanceof DeathPackageGUIScreen) {
				Minecraft.getInstance().player.closeContainer();
			}
		}
	}

	public DeathPackageInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 44);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != GrimmsModItems.DEATH_PACKAGE.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}

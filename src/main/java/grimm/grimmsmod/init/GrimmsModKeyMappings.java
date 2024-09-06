
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import grimm.grimmsmod.network.OpenStatsMessage;
import grimm.grimmsmod.network.OpenItemAttributionMenuMessage;
import grimm.grimmsmod.network.OpenCraftingMenuMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GrimmsModKeyMappings {
	public static final KeyMapping OPEN_STATS = new KeyMapping("key.grimms.open_stats", GLFW.GLFW_KEY_Z, "key.categories.grimmsmod") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OpenStatsMessage(0, 0));
				OpenStatsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_ITEM_ATTRIBUTION_MENU = new KeyMapping("key.grimms.open_item_attribution_menu", GLFW.GLFW_KEY_X, "key.categories.grimmsmod") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OpenItemAttributionMenuMessage(0, 0));
				OpenItemAttributionMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_CRAFTING_MENU = new KeyMapping("key.grimms.open_crafting_menu", GLFW.GLFW_KEY_C, "key.categories.grimms") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OpenCraftingMenuMessage(0, 0));
				OpenCraftingMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(OPEN_STATS);
		event.register(OPEN_ITEM_ATTRIBUTION_MENU);
		event.register(OPEN_CRAFTING_MENU);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				OPEN_STATS.consumeClick();
				OPEN_ITEM_ATTRIBUTION_MENU.consumeClick();
				OPEN_CRAFTING_MENU.consumeClick();
			}
		}
	}
}

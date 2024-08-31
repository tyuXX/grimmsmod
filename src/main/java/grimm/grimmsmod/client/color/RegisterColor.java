package grimm.grimmsmod.client.color;

import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.component.DyedItemColor;

import grimm.grimmsmod.init.GrimmsModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class RegisterColor {
	@SubscribeEvent
	public static void onItemColorRegister(RegisterColorHandlersEvent.Item event) {
		event.register((stack, tintIndex) -> tintIndex > 0 ? -1 : DyedItemColor.getOrDefault(stack, -1), GrimmsModItems.ALLOYED_INGOT.get());
		event.register((stack, tintIndex) -> tintIndex > 0 ? -1 : DyedItemColor.getOrDefault(stack, -1), GrimmsModItems.COMPOSITE_GEM.get());
		event.register((stack, tintIndex) -> tintIndex > 0 ? -1 : DyedItemColor.getOrDefault(stack, -1), GrimmsModItems.COMPOSITE_GALLOY_INGOT.get());
		event.register((stack, tintIndex) -> tintIndex > 0 ? -1 : DyedItemColor.getOrDefault(stack, -1), GrimmsModItems.LONG_SWORD.get());
	}
}

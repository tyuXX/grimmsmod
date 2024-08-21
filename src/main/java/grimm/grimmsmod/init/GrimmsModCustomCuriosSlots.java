package grimm.grimmsmod.init;

import top.theillusivec4.curios.api.SlotTypeMessage;

import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.InterModComms;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GrimmsModCustomCuriosSlots {
	@SubscribeEvent
	public static void enqueueIMC(final InterModEnqueueEvent event) {
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("stick_o_crafting_slot").icon(new ResourceLocation("curios:slot/portable_crafter")).size(1).build());
	}
}

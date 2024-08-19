
package grimm.grimmsmod.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import grimm.grimmsmod.GrimmsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record OpenItemAttributionMenuMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<OpenItemAttributionMenuMessage> TYPE = new Type<>(new ResourceLocation(GrimmsMod.MODID, "key_open_item_attribution_menu"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenItemAttributionMenuMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenItemAttributionMenuMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenItemAttributionMenuMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenItemAttributionMenuMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenItemAttributionMenuMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		GrimmsMod.addNetworkMessage(OpenItemAttributionMenuMessage.TYPE, OpenItemAttributionMenuMessage.STREAM_CODEC, OpenItemAttributionMenuMessage::handleData);
	}
}


package grimmsmod.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.HashMap;

import grimmsmod.world.inventory.PrestigeUpgradesGUIMenu;

import grimmsmod.procedures.UpgradePrestigeAbiliyProcedure;

import grimmsmod.GrimmsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record PrestigeUpgradesGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<PrestigeUpgradesGUIButtonMessage> TYPE = new Type<>(new ResourceLocation(GrimmsMod.MODID, "prestige_upgrades_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PrestigeUpgradesGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PrestigeUpgradesGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PrestigeUpgradesGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<PrestigeUpgradesGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PrestigeUpgradesGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = PrestigeUpgradesGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 1) {

			UpgradePrestigeAbiliyProcedure.execute(entity, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		GrimmsMod.addNetworkMessage(PrestigeUpgradesGUIButtonMessage.TYPE, PrestigeUpgradesGUIButtonMessage.STREAM_CODEC, PrestigeUpgradesGUIButtonMessage::handleData);
	}
}

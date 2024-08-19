package grimm.grimmsmod.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import grimm.grimmsmod.world.inventory.StatsGUIMenu;
import grimm.grimmsmod.procedures.XpTextValueProcedure;
import grimm.grimmsmod.procedures.XpReqTextValueProcedure;
import grimm.grimmsmod.procedures.PrestigeTextValueProcedure;
import grimm.grimmsmod.procedures.PrestigeReqTextValueProcedure;
import grimm.grimmsmod.procedures.LevelTextValueProcedure;
import grimm.grimmsmod.network.StatsGUIButtonMessage;

import com.mojang.blaze3d.systems.RenderSystem;

public class StatsGUIScreen extends AbstractContainerScreen<StatsGUIMenu> {
	private final static HashMap<String, Object> guistate = StatsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_prestige;
	Button button_open_prestige_upgrades;

	public StatsGUIScreen(StatsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 230;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("grimms:textures/screens/stats_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				LevelTextValueProcedure.execute(entity), 15, 7, -12829636, false);
		guiGraphics.drawString(this.font,

				XpTextValueProcedure.execute(entity), 15, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.grimms.stats_gui.label_empty"), 78, 25, -12829636, false);
		guiGraphics.drawString(this.font,

				XpReqTextValueProcedure.execute(entity), 87, 25, -12829636, false);
		guiGraphics.drawString(this.font,

				PrestigeTextValueProcedure.execute(entity), 15, 52, -12829636, false);
		guiGraphics.drawString(this.font,

				PrestigeReqTextValueProcedure.execute(entity), 105, 70, -12829636, false);
		guiGraphics.drawString(this.font,

				LevelTextValueProcedure.execute(entity), 15, 70, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.grimms.stats_gui.label_empty1"), 96, 70, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_prestige = Button.builder(Component.translatable("gui.grimms.stats_gui.button_prestige"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new StatsGUIButtonMessage(0, x, y, z));
				StatsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 15, this.topPos + 106, 67, 20).build();
		guistate.put("button:button_prestige", button_prestige);
		this.addRenderableWidget(button_prestige);
		button_open_prestige_upgrades = Button.builder(Component.translatable("gui.grimms.stats_gui.button_open_prestige_upgrades"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new StatsGUIButtonMessage(1, x, y, z));
				StatsGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 15, this.topPos + 133, 140, 20).build();
		guistate.put("button:button_open_prestige_upgrades", button_open_prestige_upgrades);
		this.addRenderableWidget(button_open_prestige_upgrades);
	}
}

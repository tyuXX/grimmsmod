package grimmsmod.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import grimmsmod.world.inventory.PrestigeUpgradesGUIMenu;

import grimmsmod.procedures.PrestigepointsTextValueProcedure;
import grimmsmod.procedures.PrestigeUpgradeTextValueProcedure;

import grimmsmod.network.PrestigeUpgradesGUIButtonMessage;

import com.mojang.blaze3d.systems.RenderSystem;

public class PrestigeUpgradesGUIScreen extends AbstractContainerScreen<PrestigeUpgradesGUIMenu> {
	private final static HashMap<String, Object> guistate = PrestigeUpgradesGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox prestigeupgradeid;
	EditBox sid;
	Button button_next;
	Button button_upgrade;

	public PrestigeUpgradesGUIScreen(PrestigeUpgradesGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 278;
		this.imageHeight = 129;
	}

	private static final ResourceLocation texture = new ResourceLocation("grimms:textures/screens/prestige_upgrades_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		prestigeupgradeid.render(guiGraphics, mouseX, mouseY, partialTicks);
		sid.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (prestigeupgradeid.isFocused())
			return prestigeupgradeid.keyPressed(key, b, c);
		if (sid.isFocused())
			return sid.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String prestigeupgradeidValue = prestigeupgradeid.getValue();
		String sidValue = sid.getValue();
		super.resize(minecraft, width, height);
		prestigeupgradeid.setValue(prestigeupgradeidValue);
		sid.setValue(sidValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				PrestigepointsTextValueProcedure.execute(entity), 12, 6, -12829636, false);
		guiGraphics.drawString(this.font,

				PrestigeUpgradeTextValueProcedure.execute(entity, guistate), 12, 24, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		prestigeupgradeid = new EditBox(this.font, this.leftPos + 13, this.topPos + 52, 118, 18, Component.translatable("gui.grimms.prestige_upgrades_gui.prestigeupgradeid")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.grimms.prestige_upgrades_gui.prestigeupgradeid").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.grimms.prestige_upgrades_gui.prestigeupgradeid").getString());
				else
					setSuggestion(null);
			}
		};
		prestigeupgradeid.setMaxLength(32767);
		prestigeupgradeid.setSuggestion(Component.translatable("gui.grimms.prestige_upgrades_gui.prestigeupgradeid").getString());
		guistate.put("text:prestigeupgradeid", prestigeupgradeid);
		this.addWidget(this.prestigeupgradeid);
		sid = new EditBox(this.font, this.leftPos + -1301, this.topPos + -371, 118, 18, Component.translatable("gui.grimms.prestige_upgrades_gui.sid")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.grimms.prestige_upgrades_gui.sid").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.grimms.prestige_upgrades_gui.sid").getString());
				else
					setSuggestion(null);
			}
		};
		sid.setMaxLength(32767);
		sid.setSuggestion(Component.translatable("gui.grimms.prestige_upgrades_gui.sid").getString());
		guistate.put("text:sid", sid);
		this.addWidget(this.sid);
		button_next = Button.builder(Component.translatable("gui.grimms.prestige_upgrades_gui.button_next"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new PrestigeUpgradesGUIButtonMessage(0, x, y, z));
				PrestigeUpgradesGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 102, this.topPos + 87, 46, 20).build();
		guistate.put("button:button_next", button_next);
		this.addRenderableWidget(button_next);
		button_upgrade = Button.builder(Component.translatable("gui.grimms.prestige_upgrades_gui.button_upgrade"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new PrestigeUpgradesGUIButtonMessage(1, x, y, z));
				PrestigeUpgradesGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 87, 61, 20).build();
		guistate.put("button:button_upgrade", button_upgrade);
		this.addRenderableWidget(button_upgrade);
	}
}

package grimm.grimmsmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import grimm.grimmsmod.world.inventory.KeyGUIMenu;

import com.mojang.blaze3d.systems.RenderSystem;

public class KeyGUIScreen extends AbstractContainerScreen<KeyGUIMenu> {
	private final static HashMap<String, Object> guistate = KeyGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox password;

	public KeyGUIScreen(KeyGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 142;
		this.imageHeight = 61;
	}

	private static final ResourceLocation texture = new ResourceLocation("grimms:textures/screens/key_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		password.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (password.isFocused())
			return password.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String passwordValue = password.getValue();
		super.resize(minecraft, width, height);
		password.setValue(passwordValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.grimms.key_gui.label_set_password"), 34, 8, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		password = new EditBox(this.font, this.leftPos + 8, this.topPos + 27, 118, 18, Component.translatable("gui.grimms.key_gui.password")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.grimms.key_gui.password").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.grimms.key_gui.password").getString());
				else
					setSuggestion(null);
			}
		};
		password.setMaxLength(32767);
		password.setSuggestion(Component.translatable("gui.grimms.key_gui.password").getString());
		guistate.put("text:password", password);
		this.addWidget(this.password);
	}
}

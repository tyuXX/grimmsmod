package grimm.grimmsmod.client.gui;

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

import grimm.grimmsmod.world.inventory.MathExamGUIMenu;
import grimm.grimmsmod.procedures.MathExamQuestionTextValueProcedure;
import grimm.grimmsmod.network.MathExamGUIButtonMessage;

import com.mojang.blaze3d.systems.RenderSystem;

public class MathExamGUIScreen extends AbstractContainerScreen<MathExamGUIMenu> {
	private final static HashMap<String, Object> guistate = MathExamGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox answer;
	Button button_submit;

	public MathExamGUIScreen(MathExamGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("grimms:textures/screens/math_exam_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		answer.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (answer.isFocused())
			return answer.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String answerValue = answer.getValue();
		super.resize(minecraft, width, height);
		answer.setValue(answerValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				MathExamQuestionTextValueProcedure.execute(entity), 15, 16, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		answer = new EditBox(this.font, this.leftPos + 16, this.topPos + 89, 118, 18, Component.translatable("gui.grimms.math_exam_gui.answer")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.grimms.math_exam_gui.answer").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.grimms.math_exam_gui.answer").getString());
				else
					setSuggestion(null);
			}
		};
		answer.setMaxLength(32767);
		answer.setSuggestion(Component.translatable("gui.grimms.math_exam_gui.answer").getString());
		guistate.put("text:answer", answer);
		this.addWidget(this.answer);
		button_submit = Button.builder(Component.translatable("gui.grimms.math_exam_gui.button_submit"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MathExamGUIButtonMessage(0, x, y, z));
				MathExamGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 15, this.topPos + 115, 56, 20).build();
		guistate.put("button:button_submit", button_submit);
		this.addRenderableWidget(button_submit);
	}
}

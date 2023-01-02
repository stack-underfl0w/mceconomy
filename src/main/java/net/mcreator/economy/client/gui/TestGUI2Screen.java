
package net.mcreator.economy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.economy.world.inventory.TestGUI2Menu;
import net.mcreator.economy.network.TestGUI2ButtonMessage;
import net.mcreator.economy.EconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.components.ImageButton;

public class TestGUI2Screen extends AbstractContainerScreen<TestGUI2Menu> {
	private final static HashMap<String, Object> guistate = TestGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public TestGUI2Screen(TestGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("economy:textures/screens/test_gui_2.png");
	private static final ResourceLocation MYIMAGE = new ResourceLocation("economy:textures/iconmap.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		/*this.addRenderableWidget(new Button(this.leftPos + 7, this.topPos + 40, 61, 20, Component.literal("diamond"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new TestGUI2ButtonMessage(0, x, y, z));
				TestGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 7, this.topPos + 8, 18, 18, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new TestGUI2ButtonMessage(0, x, y, z));
				TestGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 7, this.topPos + 8);
        }));
	}
}


package net.mcreator.economy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.economy.world.inventory.CoinstorageMenu;
import net.mcreator.economy.network.CoinstorageButtonMessage;
import net.mcreator.economy.EconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CoinstorageScreen extends AbstractContainerScreen<CoinstorageMenu> {
	private final static HashMap<String, Object> guistate = CoinstorageMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox withdraw;

	public CoinstorageScreen(CoinstorageMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 252;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("economy:textures/screens/coinstorage.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		withdraw.render(ms, mouseX, mouseY, partialTicks);
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
		if (withdraw.isFocused())
			return withdraw.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		withdraw.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Store", 15, 11, -12829636);
		this.font.draw(poseStack, "Withdraw", 12, 35, -12829636);
		this.font.draw(poseStack, "Storage", 10, 59, -12829636);
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
		withdraw = new EditBox(this.font, this.leftPos + 59, this.topPos + 31, 120, 20, Component.literal(""));
		guistate.put("text:withdraw", withdraw);
		withdraw.setMaxLength(32767);
		this.addWidget(this.withdraw);
		this.addRenderableWidget(new Button(this.leftPos + 182, this.topPos + 6, 61, 20, Component.literal("Confirm"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new CoinstorageButtonMessage(0, x, y, z));
				CoinstorageButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 182, this.topPos + 31, 61, 20, Component.literal("Confirm"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new CoinstorageButtonMessage(1, x, y, z));
				CoinstorageButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 182, this.topPos + 57, 61, 20, Component.literal("Confirm"), e -> {
		}));
	}
}

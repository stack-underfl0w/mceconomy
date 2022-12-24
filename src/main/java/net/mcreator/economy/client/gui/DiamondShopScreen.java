
package net.mcreator.economy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.economy.world.inventory.DiamondShopMenu;
import net.mcreator.economy.network.EconomyModVariables;
import net.mcreator.economy.network.DiamondShopButtonMessage;
import net.mcreator.economy.EconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class DiamondShopScreen extends AbstractContainerScreen<DiamondShopMenu> {
	private final static HashMap<String, Object> guistate = DiamondShopMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public DiamondShopScreen(DiamondShopMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("economy:textures/screens/diamond_shop.png");

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
		this.font.draw(poseStack, "Diamonds", 67, 6, -12829636);
		this.font.draw(poseStack, "" + (EconomyModVariables.MapVariables.get(world).buy) + "", 111, 28, -12829636);
		this.font.draw(poseStack, "" + (EconomyModVariables.MapVariables.get(world).sell) + "", 27, 60, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 67, this.topPos + 22, 40, 20, Component.literal("Buy"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new DiamondShopButtonMessage(0, x, y, z));
				DiamondShopButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 64, this.topPos + 54, 46, 20, Component.literal("Sell"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new DiamondShopButtonMessage(1, x, y, z));
				DiamondShopButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}

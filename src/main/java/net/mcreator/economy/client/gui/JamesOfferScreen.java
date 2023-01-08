
package net.mcreator.economy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.economy.world.inventory.JamesOfferMenu;
import net.mcreator.economy.network.EconomyModVariables;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class JamesOfferScreen extends AbstractContainerScreen<JamesOfferMenu> {
	private final static HashMap<String, Object> guistate = JamesOfferMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public JamesOfferScreen(JamesOfferMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 240;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("economy:textures/screens/james_offer.png");

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
		this.font.draw(poseStack, "You Get:", 62, 28, -12829636);
		this.font.draw(poseStack, "Cost:", 140, 29, -12829636);
		this.font.draw(poseStack, "MineBay Listings", 79, 9, -12829636);
		this.font.draw(poseStack, "Player:", 8, 28, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer10) + "", 57, 39, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer11) + "", 60, 49, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer12) + "", 57, 57, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer13) + "", 58, 67, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer14) + "", 57, 76, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer15) + "", 58, 84, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeCost1) + "", 163, 59, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer10Num) + "", 110, 39, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer11Num) + "", 116, 47, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer12Num) + "", 114, 60, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer13Num) + "", 111, 68, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer14Num) + "", 111, 78, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).TradeOffer15Num) + "", 111, 86, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 168, this.topPos + 138, 30, 20, Component.literal(">"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 40, this.topPos + 138, 30, 20, Component.literal("<"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 188, this.topPos + 39, 40, 20, Component.literal("Buy"), e -> {
		}));
	}
}

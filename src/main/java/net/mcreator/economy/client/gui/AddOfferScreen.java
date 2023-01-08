
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

import net.mcreator.economy.world.inventory.AddOfferMenu;
import net.mcreator.economy.network.AddOfferButtonMessage;
import net.mcreator.economy.EconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AddOfferScreen extends AbstractContainerScreen<AddOfferMenu> {
	private final static HashMap<String, Object> guistate = AddOfferMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox GoldSellPrice;
	EditBox SilverSellPrice;
	EditBox BronzeSellPrice;

	public AddOfferScreen(AddOfferMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("economy:textures/screens/add_offer.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		GoldSellPrice.render(ms, mouseX, mouseY, partialTicks);
		SilverSellPrice.render(ms, mouseX, mouseY, partialTicks);
		BronzeSellPrice.render(ms, mouseX, mouseY, partialTicks);
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
		if (GoldSellPrice.isFocused())
			return GoldSellPrice.keyPressed(key, b, c);
		if (SilverSellPrice.isFocused())
			return SilverSellPrice.keyPressed(key, b, c);
		if (BronzeSellPrice.isFocused())
			return BronzeSellPrice.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		GoldSellPrice.tick();
		SilverSellPrice.tick();
		BronzeSellPrice.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "You Give:", 12, 10, -12829636);
		this.font.draw(poseStack, "You Receive:", 88, 10, -12829636);
		this.font.draw(poseStack, "G    S    B", 94, 45, -12829636);
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
		GoldSellPrice = new EditBox(this.font, this.leftPos + 84, this.topPos + 23, 120, 20, Component.literal(""));
		guistate.put("text:GoldSellPrice", GoldSellPrice);
		GoldSellPrice.setMaxLength(32767);
		this.addWidget(this.GoldSellPrice);
		SilverSellPrice = new EditBox(this.font, this.leftPos + 108, this.topPos + 23, 120, 20, Component.literal(""));
		guistate.put("text:SilverSellPrice", SilverSellPrice);
		SilverSellPrice.setMaxLength(32767);
		this.addWidget(this.SilverSellPrice);
		BronzeSellPrice = new EditBox(this.font, this.leftPos + 134, this.topPos + 23, 120, 20, Component.literal(""));
		guistate.put("text:BronzeSellPrice", BronzeSellPrice);
		BronzeSellPrice.setMaxLength(32767);
		this.addWidget(this.BronzeSellPrice);
		this.addRenderableWidget(new Button(this.leftPos + 86, this.topPos + 57, 72, 20, Component.literal("List Item"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new AddOfferButtonMessage(0, x, y, z));
				AddOfferButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}

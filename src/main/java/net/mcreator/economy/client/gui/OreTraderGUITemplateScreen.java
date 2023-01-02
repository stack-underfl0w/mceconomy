
package net.mcreator.economy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.economy.world.inventory.OreTraderGUITemplateMenu;
import net.mcreator.economy.network.OreTraderGUITemplateButtonMessage;
import net.mcreator.economy.EconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class OreTraderGUITemplateScreen extends AbstractContainerScreen<OreTraderGUITemplateMenu> {
	private final static HashMap<String, Object> guistate = OreTraderGUITemplateMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public OreTraderGUITemplateScreen(OreTraderGUITemplateMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("economy:textures/screens/ore_trader_gui_template.png");

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
		this.addRenderableWidget(new Button(this.leftPos + 194, this.topPos + 6, 82, 20, Component.literal("Diamond"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(0, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 195, this.topPos + 29, 66, 20, Component.literal("Iron"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(1, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 34, this.topPos + 31, 46, 20, Component.literal("Coal"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(2, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 196, this.topPos + 76, 67, 20, Component.literal("Redstone"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(3, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 201, this.topPos + 124, 51, 20, Component.literal("Lapis"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(4, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 195, this.topPos + 53, 98, 20, Component.literal("Ancient Debris"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(5, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 38, this.topPos + 8, 67, 20, Component.literal("Obsidian"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(6, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 33, this.topPos + 55, 46, 20, Component.literal("Gold"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(7, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 27, this.topPos + 79, 67, 20, Component.literal("Amethyst"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(8, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 33, this.topPos + 100, 61, 20, Component.literal("Emerald"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(9, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 199, this.topPos + 98, 56, 20, Component.literal("Quartz"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(10, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 39, this.topPos + 122, 56, 20, Component.literal("Copper"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUITemplateButtonMessage(11, x, y, z));
				OreTraderGUITemplateButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}));
	}
}

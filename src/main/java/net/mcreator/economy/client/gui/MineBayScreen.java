
package net.mcreator.economy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.economy.world.inventory.MineBayMenu;
import net.mcreator.economy.procedures.Listing4CheckerProcedure;
import net.mcreator.economy.procedures.Listing3CheckerProcedure;
import net.mcreator.economy.procedures.Listing2CheckerProcedure;
import net.mcreator.economy.procedures.Listing1CheckerProcedure;
import net.mcreator.economy.network.MineBayButtonMessage;
import net.mcreator.economy.network.EconomyModVariables;
import net.mcreator.economy.EconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class MineBayScreen extends AbstractContainerScreen<MineBayMenu> {
	private final static HashMap<String, Object> guistate = MineBayMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public MineBayScreen(MineBayMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("economy:textures/screens/mine_bay.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("economy:textures/screens/bg2.png"));
		this.blit(ms, this.leftPos + -40, this.topPos + -46, 0, 0, 256, 256, 256, 256);

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
		this.font.draw(poseStack, "1", 81, 144, -12829636);
		this.font.draw(poseStack, "MinEbay", 66, 11, -12829636);
		if (Listing1CheckerProcedure.execute(world))
			this.font.draw(poseStack, "" + (EconomyModVariables.MapVariables.get(world).Listing1) + "", 15, 40, -12829636);
		if (Listing2CheckerProcedure.execute(world))
			this.font.draw(poseStack, "" + (EconomyModVariables.MapVariables.get(world).Listing2) + "", 15, 65, -12829636);
		if (Listing3CheckerProcedure.execute(world))
			this.font.draw(poseStack, "" + (EconomyModVariables.MapVariables.get(world).Listing3) + "", 16, 90, -12829636);
		if (Listing4CheckerProcedure.execute(world))
			this.font.draw(poseStack, "" + (EconomyModVariables.MapVariables.get(world).Listing4) + "", 17, 115, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 95, this.topPos + 140, 72, 20, Component.literal("List Items"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new MineBayButtonMessage(0, x, y, z));
				MineBayButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 7, this.topPos + 140, 30, 20, Component.literal("<"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 42, this.topPos + 140, 30, 20, Component.literal(">"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 60, 154, 20, Component.literal(" "), e -> {
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (Listing2CheckerProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 35, 154, 20, Component.literal(" "), e -> {
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (Listing1CheckerProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 85, 154, 20, Component.literal(" "), e -> {
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (Listing3CheckerProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 110, 154, 20, Component.literal(" "), e -> {
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (Listing4CheckerProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}

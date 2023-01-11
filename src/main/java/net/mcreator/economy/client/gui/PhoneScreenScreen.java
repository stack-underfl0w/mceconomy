
package net.mcreator.economy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.economy.world.inventory.PhoneScreenMenu;
import net.mcreator.economy.network.PhoneScreenButtonMessage;
import net.mcreator.economy.EconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.components.ImageButton;


public class PhoneScreenScreen extends AbstractContainerScreen<PhoneScreenMenu> {
	private final static HashMap<String, Object> guistate = PhoneScreenMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PhoneScreenScreen(PhoneScreenMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 113;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("economy:textures/screens/phone_screen.png");
	private static final ResourceLocation MYIMAGE = new ResourceLocation("economy:textures/blink.png");


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
		/*this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 33, 46, 20, Component.literal("App1"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new PhoneScreenButtonMessage(0, x, y, z));
				PhoneScreenButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 11, this.topPos + 32, 42, 42, 0, 0, 42, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new PhoneScreenButtonMessage(0, x, y, z));
				PhoneScreenButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 11, this.topPos + 32);
      	}));

		
		/*this.addRenderableWidget(new Button(this.leftPos + 59, this.topPos + 33, 46, 20, Component.literal("App2"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new PhoneScreenButtonMessage(1, x, y, z));
				PhoneScreenButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 60, this.topPos + 32, 42, 42, 0, 0, 42, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new PhoneScreenButtonMessage(1, x, y, z));
				PhoneScreenButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 60, this.topPos + 32);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 91, 46, 20, Component.literal("App3"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new PhoneScreenButtonMessage(2, x, y, z));
				PhoneScreenButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 11, this.topPos + 79, 42, 42, 0, 0, 42, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new PhoneScreenButtonMessage(2, x, y, z));
				PhoneScreenButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 11, this.topPos + 79);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + 58, this.topPos + 91, 46, 20, Component.literal("App4"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new PhoneScreenButtonMessage(3, x, y, z));
				PhoneScreenButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 60, this.topPos + 79, 42, 42, 0, 0, 42, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new PhoneScreenButtonMessage(3, x, y, z));
				PhoneScreenButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 60, this.topPos + 79);
      	}));
	}
}

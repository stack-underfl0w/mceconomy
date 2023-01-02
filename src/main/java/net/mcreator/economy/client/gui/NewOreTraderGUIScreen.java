
package net.mcreator.economy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.economy.world.inventory.NewOreTraderGUIMenu;
import net.mcreator.economy.network.NewOreTraderGUIButtonMessage;
import net.mcreator.economy.EconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.components.ImageButton;

public class NewOreTraderGUIScreen extends AbstractContainerScreen<NewOreTraderGUIMenu> {
	private final static HashMap<String, Object> guistate = NewOreTraderGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public NewOreTraderGUIScreen(NewOreTraderGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("economy:textures/screens/ore_trader_gui.png");
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
		/*this.addRenderableWidget(new Button(this.leftPos + 132, this.topPos + 4, 82, 20, Component.literal("Diamond"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(0, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 46, this.topPos + 48, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(0, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 46, this.topPos + 48);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + 133, this.topPos + 27, 66, 20, Component.literal("Iron"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(1, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 68, this.topPos + 48, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(1, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 68, this.topPos + 48);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + -27, this.topPos + 29, 46, 20, Component.literal("Coal"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(2, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 112, this.topPos + 48, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(2, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 112, this.topPos + 48);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + 134, this.topPos + 74, 67, 20, Component.literal("Redstone"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(3, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 46, this.topPos + 69, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(3, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 46, this.topPos + 69);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + 139, this.topPos + 122, 51, 20, Component.literal("Lapis"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(4, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 68, this.topPos + 69, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(4, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 68, this.topPos + 69);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + 133, this.topPos + 51, 98, 20, Component.literal("Ancient Debris"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(5, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 112, this.topPos + 69, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(5, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 112, this.topPos + 69);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + -23, this.topPos + 6, 67, 20, Component.literal("Obsidian"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(6, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 90, this.topPos + 90, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(5, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 90, this.topPos + 90);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + -28, this.topPos + 53, 46, 20, Component.literal("Gold"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(7, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 90, this.topPos + 48, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(7, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 90, this.topPos + 48);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + -34, this.topPos + 77, 67, 20, Component.literal("Amethyst"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(8, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 112, this.topPos + 90, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(8, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 112, this.topPos + 90);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + -28, this.topPos + 98, 61, 20, Component.literal("Emerald"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(9, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 90, this.topPos + 69, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(9, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 90, this.topPos + 69);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + 137, this.topPos + 96, 56, 20, Component.literal("Quartz"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(10, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 46, this.topPos + 90, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(10, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 10, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 46, this.topPos + 90);
      	}));
		
		/*this.addRenderableWidget(new Button(this.leftPos + -22, this.topPos + 120, 56, 20, Component.literal("Copper"), e -> {
			if (true) {
				EconomyMod.PACKET_HANDLER.sendToServer(new OreTraderGUIButtonMessage(11, x, y, z));
				OreTraderGUIButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}));
*/

		this.addRenderableWidget(new ImageButton(this.leftPos + 68, this.topPos + 90, 16, 16, 30, 30, 0, MYIMAGE, e -> {
        	if (true) {
            	EconomyMod.PACKET_HANDLER.sendToServer(new NewOreTraderGUIButtonMessage(11, x, y, z));
				NewOreTraderGUIButtonMessage.handleButtonAction(entity, 11, x, y, z);
            }
        ((ImageButton)e).setPosition(this.leftPos + 68, this.topPos + 90);
      	}));
	}
}

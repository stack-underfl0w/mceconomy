
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

import net.mcreator.economy.world.inventory.CreateListingScreenMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CreateListingScreenScreen extends AbstractContainerScreen<CreateListingScreenMenu> {
	private final static HashMap<String, Object> guistate = CreateListingScreenMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox ListingName;
	EditBox ListingDesc;
	EditBox ListingPrice;

	public CreateListingScreenScreen(CreateListingScreenMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 184;
		this.imageHeight = 196;
	}

	private static final ResourceLocation texture = new ResourceLocation("economy:textures/screens/create_listing_screen.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		ListingName.render(ms, mouseX, mouseY, partialTicks);
		ListingDesc.render(ms, mouseX, mouseY, partialTicks);
		ListingPrice.render(ms, mouseX, mouseY, partialTicks);
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
		if (ListingName.isFocused())
			return ListingName.keyPressed(key, b, c);
		if (ListingDesc.isFocused())
			return ListingDesc.keyPressed(key, b, c);
		if (ListingPrice.isFocused())
			return ListingPrice.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		ListingName.tick();
		ListingDesc.tick();
		ListingPrice.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Create Listing", 55, 7, -12829636);
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
		ListingName = new EditBox(this.font, this.leftPos + 31, this.topPos + 20, 120, 20, Component.literal("Title")) {
			{
				setSuggestion("Title");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Title");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Title");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:ListingName", ListingName);
		ListingName.setMaxLength(32767);
		this.addWidget(this.ListingName);
		ListingDesc = new EditBox(this.font, this.leftPos + 31, this.topPos + 40, 120, 20, Component.literal("Description")) {
			{
				setSuggestion("Description");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Description");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Description");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:ListingDesc", ListingDesc);
		ListingDesc.setMaxLength(32767);
		this.addWidget(this.ListingDesc);
		ListingPrice = new EditBox(this.font, this.leftPos + 91, this.topPos + 62, 60, 20, Component.literal("Cost")) {
			{
				setSuggestion("Cost");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Cost");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Cost");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:ListingPrice", ListingPrice);
		ListingPrice.setMaxLength(32767);
		this.addWidget(this.ListingPrice);
		this.addRenderableWidget(new Button(this.leftPos + 98, this.topPos + 82, 46, 20, Component.literal("List"), e -> {
		}));
	}
}

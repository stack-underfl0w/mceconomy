
package net.mcreator.economy.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import net.mcreator.economy.entity.DiamondTraderEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class DiamondTraderRenderer extends MobRenderer<DiamondTraderEntity, VillagerModel<DiamondTraderEntity>> {
	public DiamondTraderRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
	}

	@Override
	protected void scale(DiamondTraderEntity villager, PoseStack poseStack, float f) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public ResourceLocation getTextureLocation(DiamondTraderEntity entity) {
		return new ResourceLocation("economy:textures/entities/villager_png.png");
	}
}

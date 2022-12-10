
package net.mcreator.economy.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.economy.entity.OreTraderEntity;
import net.mcreator.economy.client.model.Modelcustom_model;

public class OreTraderRenderer extends MobRenderer<OreTraderEntity, Modelcustom_model<OreTraderEntity>> {
	public OreTraderRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(OreTraderEntity entity) {
		return new ResourceLocation("economy:textures/entities/ore_till2.png");
	}
}

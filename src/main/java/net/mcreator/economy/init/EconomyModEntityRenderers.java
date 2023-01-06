
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.economy.client.renderer.PoliceRenderer;
import net.mcreator.economy.client.renderer.OreTraderRenderer;
import net.mcreator.economy.client.renderer.GunRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EconomyModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EconomyModEntities.ORE_TRADER.get(), OreTraderRenderer::new);
		event.registerEntityRenderer(EconomyModEntities.POLICE.get(), PoliceRenderer::new);
		event.registerEntityRenderer(EconomyModEntities.GUN.get(), GunRenderer::new);
	}
}

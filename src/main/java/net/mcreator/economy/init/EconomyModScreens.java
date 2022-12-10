
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.economy.client.gui.OreTraderGUIScreen;
import net.mcreator.economy.client.gui.DiamondShopScreen;
import net.mcreator.economy.client.gui.CoalShopScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EconomyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(EconomyModMenus.ORE_TRADER_GUI.get(), OreTraderGUIScreen::new);
			MenuScreens.register(EconomyModMenus.DIAMOND_SHOP.get(), DiamondShopScreen::new);
			MenuScreens.register(EconomyModMenus.COAL_SHOP.get(), CoalShopScreen::new);
		});
	}
}

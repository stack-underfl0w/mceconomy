
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.economy.client.gui.TradingGUIScreen;
import net.mcreator.economy.client.gui.TradingGUI2Screen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EconomyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(EconomyModMenus.TRADING_GUI.get(), TradingGUIScreen::new);
			MenuScreens.register(EconomyModMenus.TRADING_GUI_2.get(), TradingGUI2Screen::new);
		});
	}
}

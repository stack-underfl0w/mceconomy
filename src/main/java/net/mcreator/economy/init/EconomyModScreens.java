
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.economy.client.gui.TestGUIScreen;
import net.mcreator.economy.client.gui.TestGUI2Screen;
import net.mcreator.economy.client.gui.OreTraderGUITemplateScreen;
import net.mcreator.economy.client.gui.OreTraderGUIScreen;
import net.mcreator.economy.client.gui.NewOreTraderGUIScreen;
import net.mcreator.economy.client.gui.DiamondUnlockScreen;
import net.mcreator.economy.client.gui.DiamondShopScreen;
import net.mcreator.economy.client.gui.DiamondCustomScreen;
import net.mcreator.economy.client.gui.CoinstorageScreen;
import net.mcreator.economy.client.gui.ATMScreenScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EconomyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(EconomyModMenus.ORE_TRADER_GUI.get(), OreTraderGUIScreen::new);
			MenuScreens.register(EconomyModMenus.DIAMOND_SHOP.get(), DiamondShopScreen::new);
			MenuScreens.register(EconomyModMenus.COINSTORAGE.get(), CoinstorageScreen::new);
			MenuScreens.register(EconomyModMenus.ATM_SCREEN.get(), ATMScreenScreen::new);
			MenuScreens.register(EconomyModMenus.DIAMOND_UNLOCK.get(), DiamondUnlockScreen::new);
			MenuScreens.register(EconomyModMenus.DIAMOND_CUSTOM.get(), DiamondCustomScreen::new);
			MenuScreens.register(EconomyModMenus.TEST_GUI.get(), TestGUIScreen::new);
			MenuScreens.register(EconomyModMenus.TEST_GUI_2.get(), TestGUI2Screen::new);
			MenuScreens.register(EconomyModMenus.ORE_TRADER_GUI_TEMPLATE.get(), OreTraderGUITemplateScreen::new);
			MenuScreens.register(EconomyModMenus.NEW_ORE_TRADER_GUI.get(), NewOreTraderGUIScreen::new);
		});
	}
}

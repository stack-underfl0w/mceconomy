
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.economy.world.inventory.TradingGUIMenu;
import net.mcreator.economy.world.inventory.TradingGUI2Menu;
import net.mcreator.economy.EconomyMod;

public class EconomyModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EconomyMod.MODID);
	public static final RegistryObject<MenuType<TradingGUIMenu>> TRADING_GUI = REGISTRY.register("trading_gui",
			() -> IForgeMenuType.create(TradingGUIMenu::new));
	public static final RegistryObject<MenuType<TradingGUI2Menu>> TRADING_GUI_2 = REGISTRY.register("trading_gui_2",
			() -> IForgeMenuType.create(TradingGUI2Menu::new));
}

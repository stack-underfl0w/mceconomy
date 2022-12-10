
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.economy.world.inventory.OreTraderGUIMenu;
import net.mcreator.economy.world.inventory.DiamondShopMenu;
import net.mcreator.economy.EconomyMod;

public class EconomyModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EconomyMod.MODID);
	public static final RegistryObject<MenuType<OreTraderGUIMenu>> ORE_TRADER_GUI = REGISTRY.register("ore_trader_gui",
			() -> IForgeMenuType.create(OreTraderGUIMenu::new));
	public static final RegistryObject<MenuType<DiamondShopMenu>> DIAMOND_SHOP = REGISTRY.register("diamond_shop",
			() -> IForgeMenuType.create(DiamondShopMenu::new));
}

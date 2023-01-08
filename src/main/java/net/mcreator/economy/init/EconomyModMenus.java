
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.economy.world.inventory.TestGUIMenu;
import net.mcreator.economy.world.inventory.TestGUI2Menu;
import net.mcreator.economy.world.inventory.OreTraderGUITemplateMenu;
import net.mcreator.economy.world.inventory.OreTraderGUIMenu;
import net.mcreator.economy.world.inventory.NewOreTraderGUIMenu;
import net.mcreator.economy.world.inventory.MineBayMenu;
import net.mcreator.economy.world.inventory.JamesOfferMenu;
import net.mcreator.economy.world.inventory.DiamondUnlockMenu;
import net.mcreator.economy.world.inventory.DiamondShopMenu;
import net.mcreator.economy.world.inventory.DiamondCustomMenu;
import net.mcreator.economy.world.inventory.CoinstorageMenu;
import net.mcreator.economy.world.inventory.AddOfferMenu;
import net.mcreator.economy.world.inventory.ATMScreenMenu;
import net.mcreator.economy.EconomyMod;

public class EconomyModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EconomyMod.MODID);
	public static final RegistryObject<MenuType<OreTraderGUIMenu>> ORE_TRADER_GUI = REGISTRY.register("ore_trader_gui",
			() -> IForgeMenuType.create(OreTraderGUIMenu::new));
	public static final RegistryObject<MenuType<DiamondShopMenu>> DIAMOND_SHOP = REGISTRY.register("diamond_shop",
			() -> IForgeMenuType.create(DiamondShopMenu::new));
	public static final RegistryObject<MenuType<CoinstorageMenu>> COINSTORAGE = REGISTRY.register("coinstorage",
			() -> IForgeMenuType.create(CoinstorageMenu::new));
	public static final RegistryObject<MenuType<ATMScreenMenu>> ATM_SCREEN = REGISTRY.register("atm_screen",
			() -> IForgeMenuType.create(ATMScreenMenu::new));
	public static final RegistryObject<MenuType<DiamondUnlockMenu>> DIAMOND_UNLOCK = REGISTRY.register("diamond_unlock",
			() -> IForgeMenuType.create(DiamondUnlockMenu::new));
	public static final RegistryObject<MenuType<DiamondCustomMenu>> DIAMOND_CUSTOM = REGISTRY.register("diamond_custom",
			() -> IForgeMenuType.create(DiamondCustomMenu::new));
	public static final RegistryObject<MenuType<TestGUIMenu>> TEST_GUI = REGISTRY.register("test_gui", () -> IForgeMenuType.create(TestGUIMenu::new));
	public static final RegistryObject<MenuType<TestGUI2Menu>> TEST_GUI_2 = REGISTRY.register("test_gui_2",
			() -> IForgeMenuType.create(TestGUI2Menu::new));
	public static final RegistryObject<MenuType<OreTraderGUITemplateMenu>> ORE_TRADER_GUI_TEMPLATE = REGISTRY.register("ore_trader_gui_template",
			() -> IForgeMenuType.create(OreTraderGUITemplateMenu::new));
	public static final RegistryObject<MenuType<NewOreTraderGUIMenu>> NEW_ORE_TRADER_GUI = REGISTRY.register("new_ore_trader_gui",
			() -> IForgeMenuType.create(NewOreTraderGUIMenu::new));
	public static final RegistryObject<MenuType<AddOfferMenu>> ADD_OFFER = REGISTRY.register("add_offer",
			() -> IForgeMenuType.create(AddOfferMenu::new));
	public static final RegistryObject<MenuType<JamesOfferMenu>> JAMES_OFFER = REGISTRY.register("james_offer",
			() -> IForgeMenuType.create(JamesOfferMenu::new));
	public static final RegistryObject<MenuType<MineBayMenu>> MINE_BAY = REGISTRY.register("mine_bay", () -> IForgeMenuType.create(MineBayMenu::new));
}

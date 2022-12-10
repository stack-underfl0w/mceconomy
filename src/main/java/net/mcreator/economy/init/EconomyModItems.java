
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.economy.item.GoldCoinItem;
import net.mcreator.economy.EconomyMod;

public class EconomyModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EconomyMod.MODID);
	public static final RegistryObject<Item> ORE_TRADER = REGISTRY.register("ore_trader_spawn_egg",
			() -> new ForgeSpawnEggItem(EconomyModEntities.ORE_TRADER, -16751104, -3394561, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> GOLD_COIN = REGISTRY.register("gold_coin", () -> new GoldCoinItem());
}

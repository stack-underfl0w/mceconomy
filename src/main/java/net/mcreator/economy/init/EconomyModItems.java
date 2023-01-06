
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.economy.item.SilverCoinItem;
import net.mcreator.economy.item.GunItem;
import net.mcreator.economy.item.GoldCoinItem;
import net.mcreator.economy.item.BronzeCoinItem;
import net.mcreator.economy.EconomyMod;

public class EconomyModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EconomyMod.MODID);
	public static final RegistryObject<Item> ORE_TRADER = REGISTRY.register("ore_trader_spawn_egg",
			() -> new ForgeSpawnEggItem(EconomyModEntities.ORE_TRADER, -16751104, -3394561, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> GOLD_COIN = REGISTRY.register("gold_coin", () -> new GoldCoinItem());
	public static final RegistryObject<Item> BASECHEST = block(EconomyModBlocks.BASECHEST, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SILVER_COIN = REGISTRY.register("silver_coin", () -> new SilverCoinItem());
	public static final RegistryObject<Item> BRONZE_COIN = REGISTRY.register("bronze_coin", () -> new BronzeCoinItem());
	public static final RegistryObject<Item> ATM = block(EconomyModBlocks.ATM, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> BANK_VAULT = block(EconomyModBlocks.BANK_VAULT, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DRILL = block(EconomyModBlocks.DRILL, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LOOT = block(EconomyModBlocks.LOOT, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> POLICE = REGISTRY.register("police_spawn_egg",
			() -> new ForgeSpawnEggItem(EconomyModEntities.POLICE, -16776961, -65485, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> GUN = REGISTRY.register("gun", () -> new GunItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}

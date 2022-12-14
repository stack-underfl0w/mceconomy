
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.economy.block.LootBlock;
import net.mcreator.economy.block.DrillBlock;
import net.mcreator.economy.block.BasechestBlock;
import net.mcreator.economy.block.BankVaultBlock;
import net.mcreator.economy.block.ATMBlock;
import net.mcreator.economy.EconomyMod;

public class EconomyModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EconomyMod.MODID);
	public static final RegistryObject<Block> BASECHEST = REGISTRY.register("basechest", () -> new BasechestBlock());
	public static final RegistryObject<Block> ATM = REGISTRY.register("atm", () -> new ATMBlock());
	public static final RegistryObject<Block> BANK_VAULT = REGISTRY.register("bank_vault", () -> new BankVaultBlock());
	public static final RegistryObject<Block> DRILL = REGISTRY.register("drill", () -> new DrillBlock());
	public static final RegistryObject<Block> LOOT = REGISTRY.register("loot", () -> new LootBlock());
}

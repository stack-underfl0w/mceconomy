package net.mcreator.economy.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.economy.EconomyMod;

public class DiamondBufferProcedure {
	public static void execute(LevelAccessor world) {
		EconomyMod.queueServerWork(1, () -> {
		});
	}
}

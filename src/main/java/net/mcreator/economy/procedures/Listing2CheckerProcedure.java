package net.mcreator.economy.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.economy.network.EconomyModVariables;

public class Listing2CheckerProcedure {
	public static boolean execute(LevelAccessor world) {
		boolean bool = false;
		if ((EconomyModVariables.MapVariables.get(world).Listing2).isEmpty()) {
			bool = false;
		} else {
			bool = true;
		}
		return bool;
	}
}

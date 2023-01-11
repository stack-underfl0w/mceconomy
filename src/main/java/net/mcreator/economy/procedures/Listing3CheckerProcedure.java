package net.mcreator.economy.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.economy.network.EconomyModVariables;

public class Listing3CheckerProcedure {
	public static boolean execute(LevelAccessor world) {
		boolean bool = false;
		if ((EconomyModVariables.MapVariables.get(world).Listing3).isEmpty()) {
			bool = false;
		} else {
			bool = true;
		}
		return bool;
	}
}

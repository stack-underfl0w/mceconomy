package net.mcreator.economy.procedures;

import org.objectweb.asm.tree.analysis.Value;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.economy.network.EconomyModVariables;

public class SellDiamondProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double Value = 0;
		double PreGold = 0;
		double PreSilver = 0;
		double PreBronze = 0;
		double MoneyToGive = 0;
		EconomyModVariables.MapVariables.get(world).SellBoolean = true;
		EconomyModVariables.MapVariables.get(world).syncData(world);
		DiamondSellBufferProcedure.execute(world, entity);
	}
}

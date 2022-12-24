package net.mcreator.economy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.economy.EconomyMod;

public class DiamondBufferProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		EconomyMod.queueServerWork(1, () -> {
			SellDiamondPreviewProcedure.execute(world, entity);
		});
	}
}

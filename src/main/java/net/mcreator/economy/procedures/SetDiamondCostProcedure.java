package net.mcreator.economy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.economy.network.EconomyModVariables;

public class SetDiamondCostProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double DiamondA = 0;
		double DiamondB = 0;
		DiamondA = 4096;
		DiamondB = 0.015625;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					Component.literal(("" + DiamondA * Math.pow(Math.E, (-1) * DiamondB * EconomyModVariables.MapVariables.get(world).DiamondX))),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(("" + DiamondA)), (false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(("" + DiamondB)), (false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(("" + EconomyModVariables.MapVariables.get(world).DiamondX)), (false));
		EconomyModVariables.MapVariables.get(world).DiamondCost = DiamondA
				* Math.pow(Math.E, (-1) * DiamondB * EconomyModVariables.MapVariables.get(world).DiamondX);
		EconomyModVariables.MapVariables.get(world).syncData(world);
	}
}

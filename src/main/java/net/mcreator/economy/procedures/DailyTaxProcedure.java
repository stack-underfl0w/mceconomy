package net.mcreator.economy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.economy.network.EconomyModVariables;
import net.mcreator.economy.EconomyMod;

import java.util.List;
import java.util.ArrayList;

public class DailyTaxProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		while (true) {
			EconomyMod.queueServerWork((int) (Math.random() * 1728000), () -> {
				{
					List<? extends Player> _players = new ArrayList<>(world.players());
					for (Entity entityiterator : _players) {
						{
							double _setval = Math.round((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EconomyModVariables.PlayerVariables())).baseCash * 0.9);
							entityiterator.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.baseCash = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					}
				}
			});
		}
	}
}

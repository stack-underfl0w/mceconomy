package net.mcreator.economy.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.economy.network.EconomyModVariables;

import javax.annotation.Nullable;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class DailyTaxProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level);
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		double TotalMoney = 0;
		double TaxRate = 0;
		double MintTakeRate = 0;
		TotalMoney = 0;
		MintTakeRate = 0.5;
		{
			List<? extends Player> _players = new ArrayList<>(world.players());
			for (Entity entityiterator : _players) {
				TotalMoney = TotalMoney + (entityiterator.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EconomyModVariables.PlayerVariables())).baseCash;
			}
		}
		TaxRate = (EconomyModVariables.MapVariables.get(world).TotalCurrencyMinted * MintTakeRate) / TotalMoney;
		if (TaxRate > 0.5) {
			TaxRate = 0.5;
		}
		{
			List<? extends Player> _players = new ArrayList<>(world.players());
			for (Entity entityiterator : _players) {
				{
					double _setval = Math.ceil((entityiterator.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EconomyModVariables.PlayerVariables())).baseCash * TaxRate);
					entityiterator.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.baseCash = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				{
					Entity _ent = entityiterator;
					Scoreboard _sc = _ent.getLevel().getScoreboard();
					Objective _so = _sc.getObjective("baseCash");
					if (_so == null)
						_so = _sc.addObjective("baseCash", ObjectiveCriteria.DUMMY, Component.literal("baseCash"),
								ObjectiveCriteria.RenderType.INTEGER);
					_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so)
							.setScore((int) (entityiterator.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EconomyModVariables.PlayerVariables())).baseCash);
				}
			}
		}
		EconomyModVariables.MapVariables.get(world).TotalCurrencyMinted = EconomyModVariables.MapVariables.get(world).TotalCurrencyMinted
				- TaxRate * TotalMoney;
		EconomyModVariables.MapVariables.get(world).syncData(world);
	}
}

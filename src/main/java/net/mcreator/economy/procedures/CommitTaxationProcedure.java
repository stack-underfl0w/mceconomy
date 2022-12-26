package net.mcreator.economy.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CommitTaxationProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level);
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		double TotalMoney = 0;
		double MintTaxRate = 0;
		double TaxRate = 0;
		TotalMoney = 0;
		MintTaxRate = 0.5;
		{
			List<? extends Player> _players = new ArrayList<>(world.players());
			for (Entity entityiterator : _players) {
				TotalMoney = TotalMoney + (entityiterator.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EconomyModVariables.PlayerVariables())).baseCash;
			}
		}
		TaxRate = (EconomyModVariables.MapVariables.get(world).NewCurrencyMinted * MintTaxRate) / TotalMoney;
		if (TaxRate > 0.5) {
			TaxRate = 0.5;
		}
		{
			List<? extends Player> _players = new ArrayList<>(world.players());
			for (Entity entityiterator : _players) {
				{
					double _setval = Math.ceil((entityiterator.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EconomyModVariables.PlayerVariables())).baseCash
							- (entityiterator.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
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
		EconomyModVariables.MapVariables.get(world).NewCurrencyMinted = EconomyModVariables.MapVariables.get(world).NewCurrencyMinted
				- TaxRate * TotalMoney;
		EconomyModVariables.MapVariables.get(world).syncData(world);
	}
}

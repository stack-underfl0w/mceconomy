package net.mcreator.economy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.economy.network.EconomyModVariables;
import net.mcreator.economy.EconomyMod;

import java.util.function.Supplier;
import java.util.Map;

public class SellDiamondPreviewProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		EconomyMod.queueServerWork(2, () -> {
			{
				double _setval = new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(1) * EconomyModVariables.MapVariables.get(world).DiamondCost;
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Value = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = Math.floor((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EconomyModVariables.PlayerVariables())).Value / 4096);
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SellGold = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EconomyModVariables.PlayerVariables())).Value
						- (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EconomyModVariables.PlayerVariables())).SellGold * 4096;
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Value = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = Math.floor((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EconomyModVariables.PlayerVariables())).Value / 64);
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SellSilver = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EconomyModVariables.PlayerVariables())).Value
						- (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EconomyModVariables.PlayerVariables())).SellSilver * 64;
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Value = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EconomyModVariables.PlayerVariables())).Value;
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SellBronze = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			EconomyModVariables.MapVariables.get(world).sell = ("" + (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EconomyModVariables.PlayerVariables())).SellGold).replace(".0", "")
					+ ", "
					+ ("" + (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EconomyModVariables.PlayerVariables())).SellSilver).replace(".0", "")
					+ ", " + ("" + (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EconomyModVariables.PlayerVariables())).SellBronze).replace(".0", "");
			EconomyModVariables.MapVariables.get(world).syncData(world);
		});
	}
}

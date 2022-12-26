package net.mcreator.economy.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.economy.network.EconomyModVariables;
import net.mcreator.economy.init.EconomyModItems;

import java.util.function.Supplier;
import java.util.Map;

public class GoldConvertFixedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		AtmValueProcedure.execute(entity);
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(EconomyModItems.BRONZE_COIN.get());
			_setstack.setCount((int) ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EconomyModVariables.PlayerVariables())).CashInATM % 64 + new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(8)));
			((Slot) _slots.get(8)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(EconomyModItems.SILVER_COIN.get());
			_setstack.setCount((int) Math.floor(((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EconomyModVariables.PlayerVariables())).CashInATM % 4096) / 64 + new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(7)));
			((Slot) _slots.get(7)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(EconomyModItems.GOLD_COIN.get());
			_setstack.setCount((int) Math.floor((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EconomyModVariables.PlayerVariables())).CashInATM / 4096 + new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(6)));
			((Slot) _slots.get(6)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		{
			double _setval = 0;
			entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CashInATM = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}

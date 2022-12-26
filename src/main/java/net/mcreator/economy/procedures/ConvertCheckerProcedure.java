package net.mcreator.economy.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.economy.network.EconomyModVariables;
import net.mcreator.economy.init.EconomyModItems;
import net.mcreator.economy.EconomyMod;

import java.util.function.Supplier;
import java.util.Map;

public class ConvertCheckerProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		EconomyMod.queueServerWork(1, () -> {
			{
				double _setval = 0;
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.iteration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			for (int index0 = 0; index0 < (int) (6); index0++) {
				if (!((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt
								? ((Slot) _slt.get((int) (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EconomyModVariables.PlayerVariables())).iteration)).getItem()
								: ItemStack.EMPTY)
						.getItem() == EconomyModItems.GOLD_COIN.get()
						|| (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt
										? ((Slot) _slt.get((int) (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EconomyModVariables.PlayerVariables())).iteration)).getItem()
										: ItemStack.EMPTY)
								.getItem() == EconomyModItems.SILVER_COIN.get()
						|| (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt
										? ((Slot) _slt.get((int) (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EconomyModVariables.PlayerVariables())).iteration)).getItem()
										: ItemStack.EMPTY)
								.getItem() == EconomyModItems.BRONZE_COIN.get())) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt
										? ((Slot) _slt.get((int) (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EconomyModVariables.PlayerVariables())).iteration)).getItem()
										: ItemStack.EMPTY);
						_setstack.setCount(new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount((int) (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EconomyModVariables.PlayerVariables())).iteration));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
							&& _current.get() instanceof Map _slots) {
						((Slot) _slots.get((int) (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EconomyModVariables.PlayerVariables())).iteration)).set(ItemStack.EMPTY);
						_player.containerMenu.broadcastChanges();
					}
				}
				{
					double _setval = (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EconomyModVariables.PlayerVariables())).iteration + 1;
					entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.iteration = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		});
	}
}

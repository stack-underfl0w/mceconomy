package net.mcreator.economy.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;

import net.mcreator.economy.network.EconomyModVariables;
import net.mcreator.economy.init.EconomyModItems;

import java.util.concurrent.atomic.AtomicReference;
import java.util.List;
import java.util.ArrayList;

public class BuyItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double InventoryCurrency = 0;
		double InventoryGold = 0;
		double InventorySilver = 0;
		double InventoryBronze = 0;
		double Change = 0;
		InventoryCurrency = 0;
		Change = 0;
		{
			List<? extends Player> _players = new ArrayList<>(world.players());
			for (Entity entityiterator : _players) {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString())), false);
				}
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					entityiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _iitemhandlerref.set(capability));
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == EconomyModItems.GOLD_COIN.get()) {
								InventoryGold = InventoryGold + (itemstackiterator).getCount();
							} else if (itemstackiterator.getItem() == EconomyModItems.SILVER_COIN.get()) {
								InventorySilver = InventorySilver + (itemstackiterator).getCount();
							}
							if (itemstackiterator.getItem() == EconomyModItems.BRONZE_COIN.get()) {
								InventoryBronze = InventoryBronze + (itemstackiterator).getCount();
							}
							InventoryCurrency = InventoryGold * 4096 + InventorySilver * 64 + InventoryBronze;
						}
					}
				}
				Change = InventoryCurrency - (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EconomyModVariables.PlayerVariables())).TradeCost1;
				if (InventoryCurrency >= (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EconomyModVariables.PlayerVariables())).TradeCost1) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(EconomyModItems.GOLD_COIN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) InventoryGold,
								_player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(EconomyModItems.SILVER_COIN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) InventorySilver,
								_player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(EconomyModItems.BRONZE_COIN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) InventoryBronze,
								_player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(EconomyModItems.GOLD_COIN.get());
						_setstack.setCount((int) Math.floor(Change / 4096));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(EconomyModItems.SILVER_COIN.get());
						_setstack.setCount((int) Math.floor((Change % 4096) / 64));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(EconomyModItems.BRONZE_COIN.get());
						_setstack.setCount((int) Math.floor(Change % 64));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("Too poor, dumbass"), (false));
				}
			}
		}
	}
}

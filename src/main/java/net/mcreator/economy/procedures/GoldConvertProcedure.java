package net.mcreator.economy.procedures;

import org.objectweb.asm.tree.analysis.Value;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.economy.network.EconomyModVariables;
import net.mcreator.economy.init.EconomyModItems;

import java.util.function.Supplier;
import java.util.Map;

public class GoldConvertProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double GoldNum = 0;
		double SilverNum = 0;
		double BronzeNum = 0;
		double Value = 0;
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(EconomyModItems.BRONZE_COIN.get());
			_setstack.setCount((int) (EconomyModVariables.MapVariables.get(world).CashInATM % 64 + new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
							&& _current.get() instanceof Map _slots) {
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount(5)));
			((Slot) _slots.get(5)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(EconomyModItems.SILVER_COIN.get());
			_setstack.setCount((int) (Math.floor((EconomyModVariables.MapVariables.get(world).CashInATM % 4096) / 64) + new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
							&& _current.get() instanceof Map _slots) {
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount(4)));
			((Slot) _slots.get(4)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(EconomyModItems.GOLD_COIN.get());
			_setstack.setCount((int) (Math.floor(EconomyModVariables.MapVariables.get(world).CashInATM / 4096) + new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
							&& _current.get() instanceof Map _slots) {
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount(3)));
			((Slot) _slots.get(3)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			((Slot) _slots.get(0)).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			((Slot) _slots.get(1)).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			((Slot) _slots.get(2)).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			((Slot) _slots.get(6)).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			((Slot) _slots.get(7)).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			((Slot) _slots.get(8)).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		EconomyModVariables.MapVariables.get(world).CashInATM = 0;
		EconomyModVariables.MapVariables.get(world).syncData(world);
	}
}

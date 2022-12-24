package net.mcreator.economy.procedures;

import org.objectweb.asm.tree.analysis.Value;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.economy.network.EconomyModVariables;
import net.mcreator.economy.init.EconomyModItems;

import java.util.function.Supplier;
import java.util.Map;

public class BuyDiamondProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double GoldNum = 0;
		double SilverNum = 0;
		double BronzeNum = 0;
		double Spent = 0;
		double Value = 0;
		double Change = 0;
		{
			boolean _setval = true;
			entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BuyBoolean = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(Items.DIAMOND);
			_setstack.setCount((int) (EconomyModVariables.MapVariables.get(world).ItemNum + new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
							&& _current.get() instanceof Map _slots) {
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount(2)));
			((Slot) _slots.get(2)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		GoldNum = new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(0);
		SilverNum = new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(4);
		BronzeNum = new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(5);
		Spent = BronzeNum + SilverNum * 64 + GoldNum * 4096;
		Change = Spent - GoldNum;
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(EconomyModItems.GOLD_COIN.get());
			_setstack.setCount((int) (Change / 4096 - Change % 4096));
			((Slot) _slots.get(0)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		Change = Change - EconomyModVariables.MapVariables.get(world).DiamondCost * new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(0);
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(EconomyModItems.SILVER_COIN.get());
			_setstack.setCount((int) (Change / 64 - Change % 64));
			((Slot) _slots.get(4)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		Change = Change - EconomyModVariables.MapVariables.get(world).DiamondCost * new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(4);
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(EconomyModItems.BRONZE_COIN.get());
			_setstack.setCount((int) Change);
			((Slot) _slots.get(5)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
	}
}

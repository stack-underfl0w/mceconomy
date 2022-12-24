package net.mcreator.economy.procedures;

import org.objectweb.asm.tree.analysis.Value;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.economy.network.EconomyModVariables;

import java.util.function.Supplier;
import java.util.Map;

public class BuyDiamondPreviewProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double GoldNum = 0;
		double SilverNum = 0;
		double BronzeNum = 0;
		double DiamondA = 0;
		double DiamondB = 0;
		double DiamondX = 0;
		double Projected = 0;
		double DiamondNum = 0;
		double Cost = 0;
		double Value = 0;
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
		Value = BronzeNum + SilverNum * 64 + GoldNum * 4096;
		DiamondA = 4096;
		DiamondB = 0.015625;
		DiamondX = EconomyModVariables.MapVariables.get(world).DiamondX;
		Projected = EconomyModVariables.MapVariables.get(world).DiamondCost;
		DiamondNum = 0;
		Cost = 0;
		while (Projected <= Value) {
			Value = Value - Projected;
			Cost = Cost + Projected;
			DiamondNum = DiamondNum + 1;
			Projected = DiamondA * Math.pow(Math.E, (-1) * DiamondB * DiamondX);
			DiamondX = DiamondX - 1;
		}
		EconomyModVariables.MapVariables.get(world).buy = "" + DiamondNum;
		EconomyModVariables.MapVariables.get(world).syncData(world);
		if ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).BuyBoolean) {
			EconomyModVariables.MapVariables.get(world).DiamondCost = Projected;
			EconomyModVariables.MapVariables.get(world).syncData(world);
			EconomyModVariables.MapVariables.get(world).DiamondX = DiamondX;
			EconomyModVariables.MapVariables.get(world).syncData(world);
			{
				double _setval = Cost;
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Charge = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			EconomyModVariables.MapVariables.get(world).ItemNum = DiamondNum;
			EconomyModVariables.MapVariables.get(world).syncData(world);
			{
				boolean _setval = false;
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BuyBoolean = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

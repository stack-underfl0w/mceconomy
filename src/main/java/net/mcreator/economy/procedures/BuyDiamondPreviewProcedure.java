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
		double SellGold = 0;
		double SellSilver = 0;
		double SellBronze = 0;
		double Test = 0;
		double Value = 0;
		double DiamondProjected = 0;
		double DiamondZ = 0;
		double DiamondNum = 0;
		double DiamondA = 0;
		double DiamondB = 0;
		double Charge = 0;
		SellGold = new Object() {
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
		SellSilver = new Object() {
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
		SellBronze = new Object() {
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
		Value = SellGold * 4096 + SellSilver * 64 + SellBronze;
		DiamondProjected = EconomyModVariables.MapVariables.get(world).DiamondCost;
		DiamondA = 4096;
		DiamondB = 0.015625;
		DiamondZ = EconomyModVariables.MapVariables.get(world).DiamondX;
		DiamondNum = 0;
		Charge = 0;
		while (DiamondProjected <= Value) {
			Value = Value - DiamondProjected;
			Charge = Charge + DiamondProjected;
			DiamondNum = DiamondNum + 1;
			DiamondProjected = DiamondA * Math.pow(Math.E, (-1) * DiamondB * DiamondZ);
			DiamondZ = DiamondZ - 1;
		}
		EconomyModVariables.MapVariables.get(world).buy = "" + DiamondNum;
		EconomyModVariables.MapVariables.get(world).syncData(world);
		if ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).BuyBoolean) {
			EconomyModVariables.MapVariables.get(world).DiamondX = DiamondZ;
			EconomyModVariables.MapVariables.get(world).syncData(world);
			EconomyModVariables.MapVariables.get(world).DiamondCost = DiamondProjected;
			EconomyModVariables.MapVariables.get(world).syncData(world);
			{
				double _setval = Charge;
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

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

public class SellDiamondPreviewProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double Value = 0;
		double DiamondA = 0;
		double DiamondB = 0;
		double DiamondZ = 0;
		double DiamondCost = 0;
		double Bronze = 0;
		double Silver = 0;
		double Goldd = 0;
		DiamondA = 4096;
		DiamondB = 0.015625;
		DiamondZ = EconomyModVariables.MapVariables.get(world).DiamondX;
		for (int index0 = 0; index0 < (int) (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(1)); index0++) {
			DiamondCost = DiamondA * Math.pow(Math.E, (-1) * DiamondB * DiamondZ);
			Value = Value + DiamondCost;
			DiamondZ = DiamondZ + 1;
			DiamondCost = DiamondA * Math.pow(Math.E, (-1) * DiamondB * DiamondZ);
		}
		Bronze = Value % 64;
		Value = Value - Bronze;
		Silver = (Value % 4096) / 64;
		Value = Value - Silver * 64;
		Goldd = Value / 4096;
		EconomyModVariables.MapVariables.get(world).sell = ("" + Goldd).replace(".0", "") + ", " + ("" + Silver).replace(".0", "") + ", "
				+ ("" + Math.round(Bronze)).replace(".0", "");
		EconomyModVariables.MapVariables.get(world).syncData(world);
	}
}

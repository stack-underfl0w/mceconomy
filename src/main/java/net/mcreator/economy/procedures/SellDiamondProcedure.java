package net.mcreator.economy.procedures;

import org.objectweb.asm.tree.analysis.Value;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.economy.network.EconomyModVariables;

import java.util.function.Supplier;
import java.util.Map;

public class SellDiamondProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Value = 0;
		double PreGold = 0;
		double PreSilver = 0;
		double PreBronze = 0;
		double MoneyToGive = 0;
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(1) > 0) {
			{
				boolean _setval = true;
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BuyBoolean = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			DiamondSellBufferProcedure.execute(world, entity);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("economy:beep")),
						SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("economy:beep")), SoundSource.NEUTRAL, 1, 1,
						false);
			}
		}
	}
}

package net.mcreator.economy.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.economy.network.EconomyModVariables;

public class DasdasProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.DiamondUnlock = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(-130, 63, 53),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("economy:lacrimosaaaaaa")), SoundSource.AMBIENT, 1, 1);
			} else {
				_level.playLocalSound((-130), 63, 53, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("economy:lacrimosaaaaaa")),
						SoundSource.AMBIENT, 1, 1, false);
			}
		}
	}
}

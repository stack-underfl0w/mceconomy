package net.mcreator.economy.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DiamondUnlockCheckerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
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
		}.getAmount(0) > 0) {
			{
				boolean _setval = true;
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DiamondUnlock = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			DiamondPressProcedure.execute(world, x, y, z, entity);
		}
	}
}

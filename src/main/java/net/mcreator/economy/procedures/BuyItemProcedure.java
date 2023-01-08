package net.mcreator.economy.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.ArrayList;

public class BuyItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			List<? extends Player> _players = new ArrayList<>(world.players());
			for (Entity entityiterator : _players) {
				if ((entityiterator.getDisplayName().getString()).equals("")) {
					if (entity instanceof Player _player) {
						_player.getAbilities().mayBuild = (true);
						_player.onUpdateAbilities();
					}
				}
			}
		}
		if (!world.isClientSide()) {
			MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
			if (_mcserv != null)
				_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString())), false);
		}
	}
}

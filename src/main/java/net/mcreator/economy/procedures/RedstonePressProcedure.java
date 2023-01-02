package net.mcreator.economy.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.economy.world.inventory.DiamondUnlockMenu;
import net.mcreator.economy.world.inventory.DiamondShopMenu;
import net.mcreator.economy.network.EconomyModVariables;

import io.netty.buffer.Unpooled;

public class RedstonePressProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).DiamondUnlock) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("DiamondShop");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new DiamondShopMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("economy:evaed")),
							SoundSource.NEUTRAL, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("economy:evaed")), SoundSource.NEUTRAL,
							(float) 0.5, 1, false);
				}
			}
		} else {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("DiamondUnlock");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new DiamondUnlockMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}

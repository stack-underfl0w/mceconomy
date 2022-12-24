package net.mcreator.economy.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.economy.network.EconomyModVariables;
import net.mcreator.economy.init.EconomyModItems;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class WithdrawBaseCashProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EconomyModVariables.PlayerVariables())).baseCash >= new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:withdraw") ? ((EditBox) guistate.get("text:withdraw")).getValue() : "")) {
			{
				double _setval = (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EconomyModVariables.PlayerVariables())).baseCash - new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(guistate.containsKey("text:withdraw") ? ((EditBox) guistate.get("text:withdraw")).getValue() : "");
				entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.baseCash = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("basecash");
				if (_so == null)
					_so = _sc.addObjective("basecash", ObjectiveCriteria.DUMMY, Component.literal("basecash"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so)
						.setScore((int) (entity.getCapability(EconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EconomyModVariables.PlayerVariables())).baseCash);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(EconomyModItems.GOLD_COIN.get());
				_setstack.setCount((int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:withdraw") ? ((EditBox) guistate.get("text:withdraw")).getValue() : ""));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
					&& _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(EconomyModItems.GOLD_COIN.get());
				_setstack.setCount((int) (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(0) - new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:withdraw") ? ((EditBox) guistate.get("text:withdraw")).getValue() : "")));
				((Slot) _slots.get(0)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Dont withdraw more than you have stored you numpty"), (false));
		}
	}
}

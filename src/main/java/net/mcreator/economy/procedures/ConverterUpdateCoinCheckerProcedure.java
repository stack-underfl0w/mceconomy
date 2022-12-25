package net.mcreator.economy.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.economy.network.EconomyModVariables;
import net.mcreator.economy.init.EconomyModItems;
import net.mcreator.economy.EconomyMod;

import java.util.function.Supplier;
import java.util.Map;

public class ConverterUpdateCoinCheckerProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		EconomyMod.queueServerWork(2, () -> {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
					.getItem() == EconomyModItems.GOLD_COIN.get()) {
				EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(0) * 4096;
				EconomyModVariables.MapVariables.get(world).syncData(world);
			} else {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getItem() == EconomyModItems.SILVER_COIN.get()) {
					EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(0) * 64;
					EconomyModVariables.MapVariables.get(world).syncData(world);
				} else {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
							.getItem() == EconomyModItems.BRONZE_COIN.get()) {
						EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
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
						EconomyModVariables.MapVariables.get(world).syncData(world);
					} else {
						EconomyMod.queueServerWork(1, () -> {
							if (entity instanceof Player _player) {
								ItemStack _setstack = (entity instanceof ServerPlayer _plrSlotItem
										&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
												? ((Slot) _slt.get(0)).getItem()
												: ItemStack.EMPTY);
								_setstack.setCount(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
												&& _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								((Slot) _slots.get(0)).set(ItemStack.EMPTY);
								_player.containerMenu.broadcastChanges();
							}
						});
					}
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == EconomyModItems.GOLD_COIN.get()) {
				EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(1) * 4096;
				EconomyModVariables.MapVariables.get(world).syncData(world);
			} else {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
						.getItem() == EconomyModItems.SILVER_COIN.get()) {
					EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(1) * 64;
					EconomyModVariables.MapVariables.get(world).syncData(world);
				} else {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getItem() == EconomyModItems.BRONZE_COIN.get()) {
						EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(1);
						EconomyModVariables.MapVariables.get(world).syncData(world);
					} else {
						EconomyMod.queueServerWork(1, () -> {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								((Slot) _slots.get(1)).set(ItemStack.EMPTY);
								_player.containerMenu.broadcastChanges();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = (entity instanceof ServerPlayer _plrSlotItem
										&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
												? ((Slot) _slt.get(1)).getItem()
												: ItemStack.EMPTY);
								_setstack.setCount(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
												&& _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(1));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						});
					}
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
					.getItem() == EconomyModItems.GOLD_COIN.get()) {
				EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(2) * 4096;
				EconomyModVariables.MapVariables.get(world).syncData(world);
			} else {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == EconomyModItems.SILVER_COIN.get()) {
					EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(2) * 64;
					EconomyModVariables.MapVariables.get(world).syncData(world);
				} else {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
							.getItem() == EconomyModItems.BRONZE_COIN.get()) {
						EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(2);
						EconomyModVariables.MapVariables.get(world).syncData(world);
					} else {
						EconomyMod.queueServerWork(1, () -> {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								((Slot) _slots.get(2)).set(ItemStack.EMPTY);
								_player.containerMenu.broadcastChanges();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = (entity instanceof ServerPlayer _plrSlotItem
										&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
												? ((Slot) _slt.get(2)).getItem()
												: ItemStack.EMPTY);
								_setstack.setCount(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
												&& _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						});
					}
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY)
					.getItem() == EconomyModItems.GOLD_COIN.get()) {
				EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(6) * 4096;
				EconomyModVariables.MapVariables.get(world).syncData(world);
			} else {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY)
						.getItem() == EconomyModItems.SILVER_COIN.get()) {
					EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(6) * 64;
					EconomyModVariables.MapVariables.get(world).syncData(world);
				} else {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY)
							.getItem() == EconomyModItems.BRONZE_COIN.get()) {
						EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(6);
						EconomyModVariables.MapVariables.get(world).syncData(world);
					} else {
						EconomyMod.queueServerWork(1, () -> {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								((Slot) _slots.get(6)).set(ItemStack.EMPTY);
								_player.containerMenu.broadcastChanges();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = (entity instanceof ServerPlayer _plrSlotItem
										&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
												? ((Slot) _slt.get(6)).getItem()
												: ItemStack.EMPTY);
								_setstack.setCount(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
												&& _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(6));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						});
					}
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(7)).getItem() : ItemStack.EMPTY)
					.getItem() == EconomyModItems.GOLD_COIN.get()) {
				EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(7) * 4096;
				EconomyModVariables.MapVariables.get(world).syncData(world);
			} else {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(7)).getItem() : ItemStack.EMPTY)
						.getItem() == EconomyModItems.SILVER_COIN.get()) {
					EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(7) * 64;
					EconomyModVariables.MapVariables.get(world).syncData(world);
				} else {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(7)).getItem() : ItemStack.EMPTY)
							.getItem() == EconomyModItems.BRONZE_COIN.get()) {
						EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(7);
						EconomyModVariables.MapVariables.get(world).syncData(world);
					} else {
						EconomyMod.queueServerWork(1, () -> {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								((Slot) _slots.get(7)).set(ItemStack.EMPTY);
								_player.containerMenu.broadcastChanges();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = (entity instanceof ServerPlayer _plrSlotItem
										&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
												? ((Slot) _slt.get(7)).getItem()
												: ItemStack.EMPTY);
								_setstack.setCount(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
												&& _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(7));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						});
					}
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY)
					.getItem() == EconomyModItems.GOLD_COIN.get()) {
				EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(8) * 4096;
				EconomyModVariables.MapVariables.get(world).syncData(world);
			} else {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY)
						.getItem() == EconomyModItems.SILVER_COIN.get()) {
					EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(8) * 64;
					EconomyModVariables.MapVariables.get(world).syncData(world);
				} else {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY)
							.getItem() == EconomyModItems.BRONZE_COIN.get()) {
						EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM + new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(8);
						EconomyModVariables.MapVariables.get(world).syncData(world);
					} else {
						EconomyMod.queueServerWork(1, () -> {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get() instanceof Map _slots) {
								((Slot) _slots.get(8)).set(ItemStack.EMPTY);
								_player.containerMenu.broadcastChanges();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = (entity instanceof ServerPlayer _plrSlotItem
										&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
												? ((Slot) _slt.get(8)).getItem()
												: ItemStack.EMPTY);
								_setstack.setCount(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
												&& _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(8));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						});
					}
				}
			}
			EconomyModVariables.MapVariables.get(world).CashInATM = EconomyModVariables.MapVariables.get(world).CashInATM / 2;
			EconomyModVariables.MapVariables.get(world).syncData(world);
		});
	}
}

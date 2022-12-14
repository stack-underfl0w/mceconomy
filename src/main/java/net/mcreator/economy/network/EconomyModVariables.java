package net.mcreator.economy.network;

import org.objectweb.asm.tree.analysis.Value;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.economy.EconomyMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EconomyModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		EconomyMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new,
				SavedDataSyncMessage::handler);
		EconomyMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.Value = original.Value;
			clone.SellGold = original.SellGold;
			clone.SellSilver = original.SellSilver;
			clone.SellBronze = original.SellBronze;
			clone.Charge = original.Charge;
			clone.BuyBoolean = original.BuyBoolean;
			clone.baseCash = original.baseCash;
			clone.CashInATM = original.CashInATM;
			clone.iteration = original.iteration;
			clone.DiamondUnlock = original.DiamondUnlock;
			clone.TradeOffer10 = original.TradeOffer10;
			clone.TradeOffer11 = original.TradeOffer11;
			clone.TradeOffer12 = original.TradeOffer12;
			clone.TradeOffer13 = original.TradeOffer13;
			clone.TradeOffer14 = original.TradeOffer14;
			clone.TradeOffer15 = original.TradeOffer15;
			clone.TradeOffer10Num = original.TradeOffer10Num;
			clone.TradeOffer11Num = original.TradeOffer11Num;
			clone.TradeOffer12Num = original.TradeOffer12Num;
			clone.TradeOffer13Num = original.TradeOffer13Num;
			clone.TradeOffer14Num = original.TradeOffer14Num;
			clone.TradeOffer15Num = original.TradeOffer15Num;
			clone.TradeCost1 = original.TradeCost1;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					EconomyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					EconomyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					EconomyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "economy_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				EconomyMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "economy_mapvars";
		public double DiamondCost = 128.0;
		public double CoalCost = 0.0;
		public double InventoryCoins = 0;
		public String sell = "\"\"";
		public String buy = "\"\"";
		public double DiamondX = 0.0;
		public double ItemNum = 0;
		public double NewCurrencyMinted = 16.0;
		public String Listing1 = "\"\"";
		public String Listing2 = "\"\"";
		public String Listing3 = "\"\"";
		public String Listing4 = "\"\"";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			DiamondCost = nbt.getDouble("DiamondCost");
			CoalCost = nbt.getDouble("CoalCost");
			InventoryCoins = nbt.getDouble("InventoryCoins");
			sell = nbt.getString("sell");
			buy = nbt.getString("buy");
			DiamondX = nbt.getDouble("DiamondX");
			ItemNum = nbt.getDouble("ItemNum");
			NewCurrencyMinted = nbt.getDouble("NewCurrencyMinted");
			Listing1 = nbt.getString("Listing1");
			Listing2 = nbt.getString("Listing2");
			Listing3 = nbt.getString("Listing3");
			Listing4 = nbt.getString("Listing4");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("DiamondCost", DiamondCost);
			nbt.putDouble("CoalCost", CoalCost);
			nbt.putDouble("InventoryCoins", InventoryCoins);
			nbt.putString("sell", sell);
			nbt.putString("buy", buy);
			nbt.putDouble("DiamondX", DiamondX);
			nbt.putDouble("ItemNum", ItemNum);
			nbt.putDouble("NewCurrencyMinted", NewCurrencyMinted);
			nbt.putString("Listing1", Listing1);
			nbt.putString("Listing2", Listing2);
			nbt.putString("Listing3", Listing3);
			nbt.putString("Listing4", Listing4);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				EconomyMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e),
						MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("economy", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double Value = 0;
		public double SellGold = 0;
		public double SellSilver = 0;
		public double SellBronze = 0;
		public double Charge = 0;
		public boolean BuyBoolean = false;
		public double baseCash = 0;
		public double CashInATM = 0;
		public double iteration = 0;
		public boolean DiamondUnlock = false;
		public String TradeOffer10 = "";
		public String TradeOffer11 = "";
		public String TradeOffer12 = "";
		public String TradeOffer13 = "";
		public String TradeOffer14 = "";
		public String TradeOffer15 = "";
		public double TradeOffer10Num = 0;
		public double TradeOffer11Num = 0;
		public double TradeOffer12Num = 0;
		public double TradeOffer13Num = 0;
		public double TradeOffer14Num = 0;
		public double TradeOffer15Num = 0;
		public double TradeCost1 = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				EconomyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Value", Value);
			nbt.putDouble("SellGold", SellGold);
			nbt.putDouble("SellSilver", SellSilver);
			nbt.putDouble("SellBronze", SellBronze);
			nbt.putDouble("Charge", Charge);
			nbt.putBoolean("BuyBoolean", BuyBoolean);
			nbt.putDouble("baseCash", baseCash);
			nbt.putDouble("CashInATM", CashInATM);
			nbt.putDouble("iteration", iteration);
			nbt.putBoolean("DiamondUnlock", DiamondUnlock);
			nbt.putString("TradeOffer10", TradeOffer10);
			nbt.putString("TradeOffer11", TradeOffer11);
			nbt.putString("TradeOffer12", TradeOffer12);
			nbt.putString("TradeOffer13", TradeOffer13);
			nbt.putString("TradeOffer14", TradeOffer14);
			nbt.putString("TradeOffer15", TradeOffer15);
			nbt.putDouble("TradeOffer10Num", TradeOffer10Num);
			nbt.putDouble("TradeOffer11Num", TradeOffer11Num);
			nbt.putDouble("TradeOffer12Num", TradeOffer12Num);
			nbt.putDouble("TradeOffer13Num", TradeOffer13Num);
			nbt.putDouble("TradeOffer14Num", TradeOffer14Num);
			nbt.putDouble("TradeOffer15Num", TradeOffer15Num);
			nbt.putDouble("TradeCost1", TradeCost1);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Value = nbt.getDouble("Value");
			SellGold = nbt.getDouble("SellGold");
			SellSilver = nbt.getDouble("SellSilver");
			SellBronze = nbt.getDouble("SellBronze");
			Charge = nbt.getDouble("Charge");
			BuyBoolean = nbt.getBoolean("BuyBoolean");
			baseCash = nbt.getDouble("baseCash");
			CashInATM = nbt.getDouble("CashInATM");
			iteration = nbt.getDouble("iteration");
			DiamondUnlock = nbt.getBoolean("DiamondUnlock");
			TradeOffer10 = nbt.getString("TradeOffer10");
			TradeOffer11 = nbt.getString("TradeOffer11");
			TradeOffer12 = nbt.getString("TradeOffer12");
			TradeOffer13 = nbt.getString("TradeOffer13");
			TradeOffer14 = nbt.getString("TradeOffer14");
			TradeOffer15 = nbt.getString("TradeOffer15");
			TradeOffer10Num = nbt.getDouble("TradeOffer10Num");
			TradeOffer11Num = nbt.getDouble("TradeOffer11Num");
			TradeOffer12Num = nbt.getDouble("TradeOffer12Num");
			TradeOffer13Num = nbt.getDouble("TradeOffer13Num");
			TradeOffer14Num = nbt.getDouble("TradeOffer14Num");
			TradeOffer15Num = nbt.getDouble("TradeOffer15Num");
			TradeCost1 = nbt.getDouble("TradeCost1");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.Value = message.data.Value;
					variables.SellGold = message.data.SellGold;
					variables.SellSilver = message.data.SellSilver;
					variables.SellBronze = message.data.SellBronze;
					variables.Charge = message.data.Charge;
					variables.BuyBoolean = message.data.BuyBoolean;
					variables.baseCash = message.data.baseCash;
					variables.CashInATM = message.data.CashInATM;
					variables.iteration = message.data.iteration;
					variables.DiamondUnlock = message.data.DiamondUnlock;
					variables.TradeOffer10 = message.data.TradeOffer10;
					variables.TradeOffer11 = message.data.TradeOffer11;
					variables.TradeOffer12 = message.data.TradeOffer12;
					variables.TradeOffer13 = message.data.TradeOffer13;
					variables.TradeOffer14 = message.data.TradeOffer14;
					variables.TradeOffer15 = message.data.TradeOffer15;
					variables.TradeOffer10Num = message.data.TradeOffer10Num;
					variables.TradeOffer11Num = message.data.TradeOffer11Num;
					variables.TradeOffer12Num = message.data.TradeOffer12Num;
					variables.TradeOffer13Num = message.data.TradeOffer13Num;
					variables.TradeOffer14Num = message.data.TradeOffer14Num;
					variables.TradeOffer15Num = message.data.TradeOffer15Num;
					variables.TradeCost1 = message.data.TradeCost1;
				}
			});
			context.setPacketHandled(true);
		}
	}
}

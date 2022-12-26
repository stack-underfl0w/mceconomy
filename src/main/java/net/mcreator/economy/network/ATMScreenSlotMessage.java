
package net.mcreator.economy.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.economy.world.inventory.ATMScreenMenu;
import net.mcreator.economy.procedures.ConvertCheckerProcedure;
import net.mcreator.economy.EconomyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ATMScreenSlotMessage {
	private final int slotID, x, y, z, changeType, meta;

	public ATMScreenSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public ATMScreenSlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(ATMScreenSlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(ATMScreenSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int slotID = message.slotID;
			int changeType = message.changeType;
			int meta = message.meta;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleSlotAction(entity, slotID, changeType, meta, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleSlotAction(Player entity, int slotID, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = ATMScreenMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slotID == 0 && changeType == 0) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 0 && changeType == 1) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 0 && changeType == 2) {
			int amount = meta;

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 1 && changeType == 0) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 1 && changeType == 1) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 1 && changeType == 2) {
			int amount = meta;

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 2 && changeType == 0) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 2 && changeType == 1) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 2 && changeType == 2) {
			int amount = meta;

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 3 && changeType == 0) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 3 && changeType == 1) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 3 && changeType == 2) {
			int amount = meta;

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 4 && changeType == 0) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 4 && changeType == 1) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 4 && changeType == 2) {
			int amount = meta;

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 5 && changeType == 0) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 5 && changeType == 1) {

			ConvertCheckerProcedure.execute(world, entity);
		}
		if (slotID == 5 && changeType == 2) {
			int amount = meta;

			ConvertCheckerProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EconomyMod.addNetworkMessage(ATMScreenSlotMessage.class, ATMScreenSlotMessage::buffer, ATMScreenSlotMessage::new,
				ATMScreenSlotMessage::handler);
	}
}

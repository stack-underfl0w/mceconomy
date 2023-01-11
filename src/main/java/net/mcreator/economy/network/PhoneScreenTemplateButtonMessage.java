
package net.mcreator.economy.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.economy.world.inventory.PhoneScreenTemplateMenu;
import net.mcreator.economy.procedures.App4Procedure;
import net.mcreator.economy.procedures.App3Procedure;
import net.mcreator.economy.procedures.App2Procedure;
import net.mcreator.economy.procedures.App1Procedure;
import net.mcreator.economy.EconomyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PhoneScreenTemplateButtonMessage {
	private final int buttonID, x, y, z;

	public PhoneScreenTemplateButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PhoneScreenTemplateButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PhoneScreenTemplateButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PhoneScreenTemplateButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = PhoneScreenTemplateMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			App1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			App2Procedure.execute();
		}
		if (buttonID == 2) {

			App3Procedure.execute();
		}
		if (buttonID == 3) {

			App4Procedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EconomyMod.addNetworkMessage(PhoneScreenTemplateButtonMessage.class, PhoneScreenTemplateButtonMessage::buffer,
				PhoneScreenTemplateButtonMessage::new, PhoneScreenTemplateButtonMessage::handler);
	}
}


package net.mcreator.economy.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.economy.world.inventory.OreTraderGUITemplateMenu;
import net.mcreator.economy.procedures.RedstonePressProcedure;
import net.mcreator.economy.procedures.QuartzPressProcedure;
import net.mcreator.economy.procedures.ObsidianPressProcedure;
import net.mcreator.economy.procedures.LapisPressProcedure;
import net.mcreator.economy.procedures.IronPressProcedure;
import net.mcreator.economy.procedures.GoldPressProcedure;
import net.mcreator.economy.procedures.EmeraldPressProcedure;
import net.mcreator.economy.procedures.DiamondPressProcedure;
import net.mcreator.economy.procedures.CopperPressProcedure;
import net.mcreator.economy.procedures.CoalPressProcedure;
import net.mcreator.economy.procedures.AncientDebrisPressProcedure;
import net.mcreator.economy.procedures.AmethystPressProcedure;
import net.mcreator.economy.EconomyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreTraderGUITemplateButtonMessage {
	private final int buttonID, x, y, z;

	public OreTraderGUITemplateButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public OreTraderGUITemplateButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(OreTraderGUITemplateButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(OreTraderGUITemplateButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = OreTraderGUITemplateMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			DiamondPressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			IronPressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			CoalPressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			RedstonePressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			LapisPressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			AncientDebrisPressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ObsidianPressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			GoldPressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			AmethystPressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			EmeraldPressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			QuartzPressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			CopperPressProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EconomyMod.addNetworkMessage(OreTraderGUITemplateButtonMessage.class, OreTraderGUITemplateButtonMessage::buffer,
				OreTraderGUITemplateButtonMessage::new, OreTraderGUITemplateButtonMessage::handler);
	}
}

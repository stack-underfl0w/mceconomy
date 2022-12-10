
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.economy.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EconomyModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.DIAMOND),

					new ItemStack(Items.PAPER), 10, 500, 0f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.DIAMOND),

					new ItemStack(Items.GOLD_INGOT, 5), 10, 5, 0f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.GOLD_INGOT, 5),

					new ItemStack(Items.DIAMOND), 10, 5, 0f));
		}
	}
}

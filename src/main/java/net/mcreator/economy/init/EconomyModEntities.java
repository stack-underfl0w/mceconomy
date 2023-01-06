
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.economy.entity.PoliceEntity;
import net.mcreator.economy.entity.OreTraderEntity;
import net.mcreator.economy.entity.GunEntity;
import net.mcreator.economy.EconomyMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EconomyModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EconomyMod.MODID);
	public static final RegistryObject<EntityType<OreTraderEntity>> ORE_TRADER = register("ore_trader",
			EntityType.Builder.<OreTraderEntity>of(OreTraderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OreTraderEntity::new).fireImmune().sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<PoliceEntity>> POLICE = register("police",
			EntityType.Builder.<PoliceEntity>of(PoliceEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(PoliceEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GunEntity>> GUN = register("projectile_gun",
			EntityType.Builder.<GunEntity>of(GunEntity::new, MobCategory.MISC).setCustomClientFactory(GunEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			OreTraderEntity.init();
			PoliceEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(ORE_TRADER.get(), OreTraderEntity.createAttributes().build());
		event.put(POLICE.get(), PoliceEntity.createAttributes().build());
	}
}

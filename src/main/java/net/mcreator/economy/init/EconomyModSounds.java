
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.economy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.economy.EconomyMod;

public class EconomyModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EconomyMod.MODID);
	public static final RegistryObject<SoundEvent> VINEBOOM = REGISTRY.register("vineboom",
			() -> new SoundEvent(new ResourceLocation("economy", "vineboom")));
	public static final RegistryObject<SoundEvent> LACRIMOSA = REGISTRY.register("lacrimosa",
			() -> new SoundEvent(new ResourceLocation("economy", "lacrimosa")));
	public static final RegistryObject<SoundEvent> LACRIMOSAAAAAA = REGISTRY.register("lacrimosaaaaaa",
			() -> new SoundEvent(new ResourceLocation("economy", "lacrimosaaaaaa")));
	public static final RegistryObject<SoundEvent> EVAED = REGISTRY.register("evaed", () -> new SoundEvent(new ResourceLocation("economy", "evaed")));
	public static final RegistryObject<SoundEvent> BEEP = REGISTRY.register("beep", () -> new SoundEvent(new ResourceLocation("economy", "beep")));
}

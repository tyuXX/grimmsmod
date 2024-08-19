
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import grimm.grimmsmod.GrimmsMod;

public class GrimmsModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, GrimmsMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> METALPIPEHIT = REGISTRY.register("metalpipehit", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("grimms", "metalpipehit")));
}

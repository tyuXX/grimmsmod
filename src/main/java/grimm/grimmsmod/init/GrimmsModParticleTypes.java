
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import grimm.grimmsmod.GrimmsMod;

public class GrimmsModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, GrimmsMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FIREFLY = REGISTRY.register("firefly", () -> new SimpleParticleType(false));
}

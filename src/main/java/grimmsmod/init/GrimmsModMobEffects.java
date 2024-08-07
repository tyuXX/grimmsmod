
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import grimmsmod.potion.TrueSightMobEffect;
import grimmsmod.potion.SuperDizzinessMobEffect;
import grimmsmod.potion.SeizureMobEffect;
import grimmsmod.potion.DizzinessMobEffect;
import grimmsmod.potion.BleedingMobEffect;

import grimmsmod.GrimmsMod;

public class GrimmsModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, GrimmsMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DIZZINESS = REGISTRY.register("dizziness", () -> new DizzinessMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SUPER_DIZZINESS = REGISTRY.register("super_dizziness", () -> new SuperDizzinessMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SEIZURE = REGISTRY.register("seizure", () -> new SeizureMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TRUE_SIGHT = REGISTRY.register("true_sight", () -> new TrueSightMobEffect());
}

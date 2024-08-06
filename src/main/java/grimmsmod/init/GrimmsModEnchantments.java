
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.core.registries.Registries;

import grimmsmod.enchantment.XpBoostEnchantment;
import grimmsmod.enchantment.SoulboundEnchantment;
import grimmsmod.enchantment.SharpEnchantment;
import grimmsmod.enchantment.LifestealEnchantment;

import grimmsmod.GrimmsMod;

public class GrimmsModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(Registries.ENCHANTMENT, GrimmsMod.MODID);
	public static final DeferredHolder<Enchantment, Enchantment> LIFESTEAL = REGISTRY.register("lifesteal", () -> new LifestealEnchantment());
	public static final DeferredHolder<Enchantment, Enchantment> SOULBOUND = REGISTRY.register("soulbound", () -> new SoulboundEnchantment());
	public static final DeferredHolder<Enchantment, Enchantment> SHARP = REGISTRY.register("sharp", () -> new SharpEnchantment());
	public static final DeferredHolder<Enchantment, Enchantment> XP_BOOST = REGISTRY.register("xp_boost", () -> new XpBoostEnchantment());
}

package grimmsmod.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import javax.annotation.Nullable;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.init.GrimmsModMobEffects;

@EventBusSubscriber
public class OnPlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		String ShaderLocation = "";
		if (GrimmsModVariables.MapVariables.get(world).worldtick % 2000 == 0) {
			if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= 2) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:level_up"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= 45) {
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:level_up_2"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			}
			if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:prestige")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= 2) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:prestige"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
			if (((GrimmsModVariables.MapVariables.get(world).mapstats.get((entity.getStringUUID() + "/grimm:money"))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= 10000) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:rich_guy"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				if (((GrimmsModVariables.MapVariables.get(world).mapstats.get((entity.getStringUUID() + "/grimm:money"))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= 1000000) {
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:millionare"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (((GrimmsModVariables.MapVariables.get(world).mapstats.get((entity.getStringUUID() + "/grimm:money"))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= 1000000000) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:billionare"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
				}
			}
			if (((GrimmsModVariables.MapVariables.get(world).mapstats.get((entity.getStringUUID() + "/grimm:totaltv"))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= 1000) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:transmuter"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				if (((GrimmsModVariables.MapVariables.get(world).mapstats.get((entity.getStringUUID() + "/grimm:totaltv"))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) >= 1000000) {
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("grimms:transmutation_professor"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			}
		}
		if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.get("presige:cure")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) > 0) {
			if (entity instanceof LivingEntity _mobEffectContext) {
				for (MobEffectInstance mobeffectiterator : _mobEffectContext.getActiveEffects()) {
					if (mobeffectiterator.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {/*TODO: Add this*/
					}
				}
			}
		}
		if (world.isClientSide()) {
			if (entity instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(GrimmsModMobEffects.SEIZURE)) {
				if (GrimmsModVariables.MapVariables.get(world).worldtick % 5 == 0) {
					ShaderLocation = "minecraft:shaders/post/invert.json";
				} else {
					ShaderLocation = "n/a";
				}
			} else if (entity instanceof LivingEntity _livEnt36 && _livEnt36.hasEffect(GrimmsModMobEffects.SUPER_DIZZINESS)) {
				ShaderLocation = "minecraft:shaders/post/blur.json";
			} else if (entity instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(GrimmsModMobEffects.DIZZINESS)) {
				ShaderLocation = "minecraft:shaders/post/invert.json";
			} else {
				ShaderLocation = "n/a";
			}
			if ((ShaderLocation).equals("n/a")) {
				Minecraft.getInstance().gameRenderer.shutdownEffect();
			} else {
				if (Minecraft.getInstance().gameRenderer.currentEffect() == null || !(Minecraft.getInstance().gameRenderer.currentEffect().getName()).equals(ShaderLocation)) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation((ShaderLocation).toLowerCase(java.util.Locale.ENGLISH)));
				}
			}
		}
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			for (int _idx = 0; _idx < _modHandler.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandler.getStackInSlot(_idx).copy();
				if (GrimmsModVariables.cache.contains(("rad:" + BuiltInRegistries.ITEM.getKey(itemstackiterator.getItem()).toString()))) {
					ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats, entity, false,
							(GrimmsModVariables.cache.get(("rad:" + BuiltInRegistries.ITEM.getKey(itemstackiterator.getItem()).toString()))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D, "grimm:rads");
				}
			}
		}
	}
}

package grimm.grimmsmod.procedures;

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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import javax.annotation.Nullable;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.init.GrimmsModMobEffects;
import grimm.grimmsmod.configuration.ServerConfigConfiguration;

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
		double radsontick = 0;
		if (GrimmsModVariables.WorldVariables.get(world).worldtick % 2000 == 0) {
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
		if (world.isClientSide()) {
			if (entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(GrimmsModMobEffects.SEIZURE)) {
				if (GrimmsModVariables.WorldVariables.get(world).worldtick % 5 == 0) {
					ShaderLocation = "minecraft:shaders/post/invert.json";
				} else {
					ShaderLocation = "n/a";
				}
			} else if (entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(GrimmsModMobEffects.SUPER_DIZZINESS)) {
				ShaderLocation = "minecraft:shaders/post/blur.json";
			} else if (entity instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(GrimmsModMobEffects.DIZZINESS)) {
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
		if (ServerConfigConfiguration.RADENABLE.get()) {
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
				for (int _idx = 0; _idx < _modHandler.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandler.getStackInSlot(_idx).copy();
					if (GrimmsModVariables.cache.contains(("rad:" + BuiltInRegistries.ITEM.getKey(itemstackiterator.getItem()).toString()))) {
						ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats, entity, false,
								itemstackiterator.getCount() * ((GrimmsModVariables.cache.get(("rad:" + BuiltInRegistries.ITEM.getKey(itemstackiterator.getItem()).toString()))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D),
								"grimm:rads");
						radsontick = radsontick
								+ itemstackiterator.getCount() * ((GrimmsModVariables.cache.get(("rad:" + BuiltInRegistries.ITEM.getKey(itemstackiterator.getItem()).toString()))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D);
					}
				}
			}
		}
		SetDataElementProcedure.execute(DoubleTag.valueOf(radsontick), entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats, entity, false, "grimm:radslasttick");
	}
}

package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import javax.annotation.Nullable;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.init.GrimmsModMobEffects;
import grimm.grimmsmod.init.GrimmsModItems;
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
		double tmp = 0;
		ItemStack tmp2 = ItemStack.EMPTY;
		if (GrimmsModVariables.WorldVariables.get(world).worldtick % 2000 == 0) {
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
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			for (int _idx = 0; _idx < _modHandler.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandler.getStackInSlot(_idx).copy();
				if (ServerConfigConfiguration.RADENABLE.get()) {
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
		for (int index0 = 0; index0 < 36; index0++) {
			if (ServerConfigConfiguration.ROTENABLE.get() && !((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						return _modHandler.getStackInSlot(sltid).copy();
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) tmp, entity)).getItem() == Blocks.AIR.asItem())) {
				tmp2 = (new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							return _modHandler.getStackInSlot(sltid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) tmp, entity));
				if (tmp2.has(DataComponents.FOOD) && !tmp2.is(ItemTags.create(new ResourceLocation("grimms:cantrot")))) {
					{
						final String _tagName = "grimms:rot";
						final double _tagValue = (tmp2.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:rot") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, tmp2, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (tmp2.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:rot") > (double) ServerConfigConfiguration.ROTTIME.get()
							* ((tmp2.has(DataComponents.FOOD) ? tmp2.getFoodProperties(null).saturation() : 0) + (tmp2.has(DataComponents.FOOD) ? tmp2.getFoodProperties(null).nutrition() : 0))) {
						{
							final String _tagName = "grimms:rot";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA, tmp2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(GrimmsModItems.ROTTEN_FOOD.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							ItemStack _setstack = tmp2.copy();
							_setstack.setCount((int) (tmp2.getCount() - 1));
							_modHandler.setStackInSlot((int) tmp, _setstack);
						}
					} else {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							ItemStack _setstack = tmp2.copy();
							_setstack.setCount(tmp2.getCount());
							_modHandler.setStackInSlot((int) tmp, _setstack);
						}
					}
				}
			}
			tmp = tmp + 1;
		}
		if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats.get("grimm:rads")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) > (double) ServerConfigConfiguration.RADPOISLIM.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(GrimmsModMobEffects.RADIATION_POSIONING, 60,
						(int) Math.min(10, Math.round(Math.log10((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats.get("grimm:rads")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D))), true, false));
			if (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).lifetimestats.get("grimm:rads")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) > (double) ServerConfigConfiguration.RADPOISLIM.get() * 100) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("grimms:radiation_damage_type")))),
						entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			}
		}
		if (world.isClientSide()) {
			if (entity instanceof LivingEntity _livEnt69 && _livEnt69.hasEffect(GrimmsModMobEffects.SEIZURE)) {
				if (GrimmsModVariables.WorldVariables.get(world).worldtick % 5 == 0) {
					ShaderLocation = "minecraft:shaders/post/invert.json";
				} else {
					ShaderLocation = "n/a";
				}
			} else if (entity instanceof LivingEntity _livEnt70 && _livEnt70.hasEffect(GrimmsModMobEffects.SUPER_DIZZINESS)) {
				ShaderLocation = "minecraft:shaders/post/blur.json";
			} else if (entity instanceof LivingEntity _livEnt71 && _livEnt71.hasEffect(GrimmsModMobEffects.DIZZINESS)) {
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
	}
}

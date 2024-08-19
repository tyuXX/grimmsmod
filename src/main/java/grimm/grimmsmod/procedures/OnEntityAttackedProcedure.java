package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.init.GrimmsModMobEffects;
import grimm.grimmsmod.init.GrimmsModItems;
import grimm.grimmsmod.init.GrimmsModEnchantments;

@EventBusSubscriber
public class OnEntityAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static InteractionResult execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		return execute(null, world, damagesource, entity, immediatesourceentity, sourceentity, amount);
	}

	private static InteractionResult execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || immediatesourceentity == null || sourceentity == null)
			return InteractionResult.PASS;
		double tmp = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GrimmsModItems.IRON_HAMMER.get() && entity instanceof IronGolem) {
			if (!(sourceentity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().get(new ResourceLocation("grimms:comrade"))).isDone())) {
				if (sourceentity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(GrimmsModItems.PHOTOGRAPH_OF_MOTORCAR.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			tmp = tmp + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:dodgechance");
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			tmp = tmp + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:dodgechance");
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			tmp = tmp + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:dodgechance");
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			tmp = tmp + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:dodgechance");
		}
		if (tmp > 0) {
			if (Math.random() < tmp) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				return InteractionResult.PASS;
			}
			return InteractionResult.PASS;
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(GrimmsModEnchantments.LIFESTEAL.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
						+ (amount * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(GrimmsModEnchantments.LIFESTEAL.get())) / 30));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(GrimmsModEnchantments.SHARP.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(GrimmsModMobEffects.BLEEDING, (int) (60 * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(GrimmsModEnchantments.SHARP.get())),
						(int) Math.ceil((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(GrimmsModEnchantments.SHARP.get())
								/ (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0)),
						true, false));
		} else if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("grimms:sharpdamage")))) {
			if (Math.random() < 0.2 / (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(GrimmsModMobEffects.BLEEDING, 120, 1, true, false));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(GrimmsModEnchantments.XP_BOOST.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if (sourceentity instanceof Player _player)
				_player.giveExperiencePoints((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(GrimmsModEnchantments.XP_BOOST.get()));
		}
		if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("grimms:nonrecurrabledamage")))) {
			entity.hurt(
					new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("grimms:prestige_damage_boost"))), immediatesourceentity,
							sourceentity),
					(float) ((((sourceentity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:level")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)
							* ((sourceentity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.get("prestige:powerful")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)) / 10));
			entity.hurt(
					new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("grimms:item_level_damage_boost"))), immediatesourceentity,
							sourceentity),
					(float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:itemdamageboost")));
		}
		ItemXpHandleProcedure.execute(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY, amount);
		ItemXpHandleProcedure.execute(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY, amount);
		ItemXpHandleProcedure.execute(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY, amount);
		ItemXpHandleProcedure.execute(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY, amount);
		ItemXpHandleProcedure.execute(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY, amount);
		return InteractionResult.SUCCESS;
	}
}

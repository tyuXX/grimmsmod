
package grimm.grimmsmod.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import grimm.grimmsmod.procedures.RadiationPosioningOnEffectActiveTickProcedure;

public class RadiationPosioningMobEffect extends MobEffect {
	public RadiationPosioningMobEffect() {
		super(MobEffectCategory.HARMFUL, -16764109);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		RadiationPosioningOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}

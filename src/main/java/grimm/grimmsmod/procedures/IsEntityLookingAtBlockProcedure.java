package grimm.grimmsmod.procedures;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.ByteTag;

import grimm.grimmsmod.network.GrimmsModVariables;

public class IsEntityLookingAtBlockProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.level()
				.clip(new ClipContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.BLOCK_INTERACTION_RANGE).getValue())), ClipContext.Block.OUTLINE,
						ClipContext.Fluid.NONE, entity))
				.getType() == HitResult.Type.BLOCK && ((GrimmsModVariables.config.get("client:blockchud")) instanceof ByteTag _byteTag ? _byteTag.getAsByte() == 1 : false);
	}
}

package grimm.grimmsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class GetBlockEntityIsLookingAtProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if (IsEntityLookingAtBlockProcedure.execute(entity)) {
			return (new ItemStack((world.getBlockState(new BlockPos(
					entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.BLOCK_INTERACTION_RANGE).getValue())),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX(),
					entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.BLOCK_INTERACTION_RANGE).getValue())),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getY(),
					entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.BLOCK_INTERACTION_RANGE).getValue())),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getZ())))
					.getBlock())).getDisplayName().getString();
		}
		return "N/A";
	}
}

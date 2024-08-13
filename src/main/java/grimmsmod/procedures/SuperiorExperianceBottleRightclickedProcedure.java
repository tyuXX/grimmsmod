package grimmsmod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import grimmsmod.network.GrimmsModVariables;

public class SuperiorExperianceBottleRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, true, Mth.nextDouble(RandomSource.create(), 1, 100), "grimm:xp");
		itemstack.shrink(1);
	}
}

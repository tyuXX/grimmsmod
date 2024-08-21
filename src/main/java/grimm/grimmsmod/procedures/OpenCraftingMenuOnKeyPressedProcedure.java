package grimm.grimmsmod.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import grimm.grimmsmod.init.GrimmsModItems;

public class OpenCraftingMenuOnKeyPressedProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(GrimmsModItems.STICK_O_CRAFTING.get(), lv).isPresent() : false) {
			StickOCraftingRightclickedProcedure.execute(x, y, z, entity);
		}
	}
}

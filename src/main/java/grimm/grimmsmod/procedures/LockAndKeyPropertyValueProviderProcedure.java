package grimm.grimmsmod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class LockAndKeyPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if (!(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("grimms:password")).equals("")) {
			return 1;
		}
		return 0;
	}
}

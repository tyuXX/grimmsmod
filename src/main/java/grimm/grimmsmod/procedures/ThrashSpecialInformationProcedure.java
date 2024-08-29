package grimm.grimmsmod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class ThrashSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:errorprogress") > 0) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:errorprogress") > 1100) {
				return "Error progress: Overcooked";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:errorprogress") > 1000) {
				return "Error progress (Very ready for displacement): " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:errorprogress")) + "%";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:errorprogress") > 100) {
				return "Error progress (Ready for displacement): " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:errorprogress")) + "%";
			}
			return "Error progress: " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:errorprogress")) + "%";
		}
		return "Aww, your tool broke. How sad.";
	}
}

package grimm.grimmsmod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimm.grimmsmod.init.GrimmsModItems;

public class KeyGUIThisGUIIsClosedProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GrimmsModItems.LOCK_AND_KEY.get()) {
			{
				final String _tagName = "grimms:password";
				final String _tagValue = (guistate.containsKey("text:password") ? ((EditBox) guistate.get("text:password")).getValue() : "");
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
			}
		}
	}
}

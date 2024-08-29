package grimm.grimmsmod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimm.grimmsmod.init.GrimmsModItems;

public class WrittenPaperGUIThisGUIIsClosedProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GrimmsModItems.WRITTEN_PAPER.get()) {
			{
				final String _tagName = "grimms:papertext";
				final String _tagValue = (guistate.containsKey("text:papertext") ? ((EditBox) guistate.get("text:papertext")).getValue() : "");
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
			}
		}
	}
}

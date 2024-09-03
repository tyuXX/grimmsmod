package grimm.grimmsmod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import grimm.grimmsmod.network.GrimmsModVariables;

public class TransmutationGUIItemTakenFromSlotProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!(Blocks.AIR.asItem() == BuiltInRegistries.ITEM.get(new ResourceLocation(((guistate.containsKey("text:itemid") ? ((EditBox) guistate.get("text:itemid")).getValue() : "")).toLowerCase(java.util.Locale.ENGLISH))))) {
			ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, true,
					(-1) * ((GrimmsModVariables.cache.get(("tv:" + (guistate.containsKey("text:itemid") ? ((EditBox) guistate.get("text:itemid")).getValue() : "")))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D),
					entity.getStringUUID() + "/grimm:totaltv");
		}
	}
}

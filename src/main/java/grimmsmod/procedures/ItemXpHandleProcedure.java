package grimmsmod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

import grimmsmod.configuration.ServerConfigConfiguration;

public class ItemXpHandleProcedure {
	public static void execute(ItemStack itemstack, double xpamount) {
		double levelups = 0;
		if (!(itemstack.getItem() == Blocks.AIR.asItem()) && !itemstack.is(ItemTags.create(new ResourceLocation("grimms:notlevelable")))) {
			if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("grimms:itemlvlinit")) {
				{
					final String _tagName = "grimms:itemlvlinit";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				{
					final String _tagName = "grimms:lvl";
					final double _tagValue = 1;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			{
				final String _tagName = "grimms:xp";
				final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:xp") + xpamount);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			while (ServerConfigConfiguration.INSTLEVELUP.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:xp") >= Math
					.round(Math.pow(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl") * (double) ServerConfigConfiguration.LVLMULT.get(), (double) ServerConfigConfiguration.LVLEXPO.get()))) {
				{
					final String _tagName = "grimms:xp";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:xp") - Math.round(
							Math.pow(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl") * (double) ServerConfigConfiguration.LVLMULT.get(), (double) ServerConfigConfiguration.LVLEXPO.get())));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "grimms:lvl";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl") + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				levelups = levelups + 1;
			}
			if (levelups > 0) {
				if (!itemstack.is(ItemTags.create(new ResourceLocation("grimms:customlevelable")))) {
					if (itemstack.getItem() instanceof AxeItem || itemstack.getItem() instanceof ShovelItem || itemstack.getItem() instanceof PickaxeItem) {/*todo fill this in*/
					} else if (itemstack.getItem() instanceof SwordItem || itemstack.getItem() instanceof AxeItem) {/*todo fill this in*/
					} else if (itemstack.getItem() instanceof ArmorItem) {/*todo fill this in*/
					}
				}
				itemstack.setDamageValue(0);
			}
		}
	}
}

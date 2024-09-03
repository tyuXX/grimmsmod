package grimm.grimmsmod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.ByteTag;
import net.minecraft.core.component.DataComponents;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.init.GrimmsModGameRules;

public class ItemXpHandleProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack, double xpamount) {
		double levelups = 0;
		if (!(itemstack.getItem() == Blocks.AIR.asItem()) && !itemstack.is(ItemTags.create(new ResourceLocation("grimms:notlevelable"))) && itemstack.getMaxDamage() > 0) {
			if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("grimms:itemlvlinit")) {
				{
					final String _tagName = "grimms:itemlvlinit";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				{
					final String _tagName = "grimms:lvl";
					final double _tagValue = 0;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			{
				final String _tagName = "grimms:xp";
				final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:xp") + xpamount);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			while (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:xp") >= Math
					.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl") * (world.getLevelData().getGameRules().getInt(GrimmsModGameRules.ITEM_XP_MULTIPILIER)))) {
				{
					final String _tagName = "grimms:xp";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:xp")
							- Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl") * (world.getLevelData().getGameRules().getInt(GrimmsModGameRules.ITEM_XP_MULTIPILIER))));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "grimms:lvl";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl") + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				levelups = levelups + 1;
				if (!((GrimmsModVariables.config.get("common:instlvlup")) instanceof ByteTag _byteTag ? _byteTag.getAsByte() == 1 : false)) {
					break;
				}
			}
		}
		if (levelups > 0) {
			{
				final String _tagName = "grimms:xpn";
				final double _tagValue = Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl") * (world.getLevelData().getGameRules().getInt(GrimmsModGameRules.ITEM_XP_MULTIPILIER)));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (!itemstack.is(ItemTags.create(new ResourceLocation("grimms:customlevelable")))) {
				{
					final String _tagName = "grimms:lvlpoints";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvlpoints") + levelups);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("grimms:sentient")) {
				SentientItemHandleProcedure.execute();
			}
			itemstack.setDamageValue(0);
		}
	}
}

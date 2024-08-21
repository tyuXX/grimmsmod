package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

import java.util.List;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.configuration.ServerConfigConfiguration;

@EventBusSubscriber(value = {Dist.CLIENT})
public class OnTooltipRenderedProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.is(ItemTags.create(new ResourceLocation("grimms:cantrot")))) {
			tooltip.add(Component.literal("Can't rot."));
		} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:rot") > 0) {
			tooltip.add(
					Component
							.literal(
									("\u00A72Rotten "
											+ new java.text.DecimalFormat("##.##")
													.format((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:rot") * 100) / ((double) ServerConfigConfiguration.ROTTIME.get()
															* ((itemstack.has(DataComponents.FOOD) ? itemstack.getFoodProperties(null).nutrition() : 0) + (itemstack.has(DataComponents.FOOD) ? itemstack.getFoodProperties(null).saturation() : 0))))
											+ "%")));
		}
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("grimms:itemlvlinit")) {
			tooltip.add(Component.literal(("\u00A77Item Level: " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl")))));
			tooltip.add(Component.literal(("\u00A77Xp: " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:xp")) + "/" + new java.text.DecimalFormat("##")
					.format(Math.pow(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl") * (double) ServerConfigConfiguration.LVLMULT.get(), (double) ServerConfigConfiguration.LVLEXPO.get())))));
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("grimms:sentient")) {
				tooltip.add(Component.literal("\u00A7bSentient"));
			}
		}
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:kills") > 0) {
			tooltip.add(Component.literal(("\u00A77Item Kills: " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:kills")))));
		}
		if (GrimmsModVariables.cache.contains(("tv:" + BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()))) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("grimms:itemlvlinit")) {
				tooltip.add(Component.literal(("\u00A7eTV:\u00A7r" + (new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl")
						* ((GrimmsModVariables.cache.get(("tv:" + BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D))))));
			} else {
				tooltip.add(Component.literal(("\u00A7eTV:\u00A7r"
						+ (new java.text.DecimalFormat("##").format((GrimmsModVariables.cache.get(("tv:" + BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)))));
			}
			tooltip.add(Component.literal(("\u00A7eTT:\u00A7r"
					+ (new java.text.DecimalFormat("##").format(Math.log((GrimmsModVariables.cache.get(("tv:" + BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D))))));
		}
		if (GrimmsModVariables.cache.contains(("rad:" + BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()))) {
			tooltip.add(Component.literal(("\u00A7eRAD:\u00A7r" + ((GrimmsModVariables.cache.get(("rad:" + BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) + "/t")));
			tooltip.add(Component.literal(("\u00A7eStack RAD:\u00A7r"
					+ (itemstack.getCount() * ((GrimmsModVariables.cache.get(("rad:" + BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)) + "/t")));
		}
	}
}

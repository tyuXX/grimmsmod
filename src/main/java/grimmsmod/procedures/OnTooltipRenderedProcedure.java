package grimmsmod.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

import java.util.List;

import grimmsmod.network.GrimmsModVariables;

import grimmsmod.configuration.ServerConfigConfiguration;

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
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("grimms:itemlvlinit")) {
			tooltip.add(Component.literal(("\u00A77Item Level: " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl")))));
			tooltip.add(Component.literal(("\u00A77Xp: " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:xp")) + "/" + new java.text.DecimalFormat("##")
					.format(Math.pow(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:lvl") * (double) ServerConfigConfiguration.LVLMULT.get(), (double) ServerConfigConfiguration.LVLEXPO.get())))));
		}
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:kills") > 0) {
			tooltip.add(Component.literal(("\u00A77Item Kills: " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:kills")))));
		}
		if (GrimmsModVariables.ctvalues.contains((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()))) {
			tooltip.add(Component.literal(("\u00A7eTV:\u00A7r"
					+ (new java.text.DecimalFormat("##").format((GrimmsModVariables.ctvalues.get((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()))) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)))));
		}
	}
}

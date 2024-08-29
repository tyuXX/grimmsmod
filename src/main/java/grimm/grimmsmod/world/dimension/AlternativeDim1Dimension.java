
package grimm.grimmsmod.world.dimension;

import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.DimensionSpecialEffects;

public class AlternativeDim1Dimension {
	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class AlternativeDim1SpecialEffectsHandler {
		@SubscribeEvent
		public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
			DimensionSpecialEffects customEffect = new DimensionSpecialEffects(DimensionSpecialEffects.OverworldEffects.CLOUD_LEVEL, true, DimensionSpecialEffects.SkyType.NORMAL, false, false) {
				@Override
				public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
					return color.multiply(sunHeight * 0.94 + 0.06, sunHeight * 0.94 + 0.06, sunHeight * 0.91 + 0.09);
				}

				@Override
				public boolean isFoggyAt(int x, int y) {
					return false;
				}
			};
			event.register(new ResourceLocation("grimms:alternative_dim_1"), customEffect);
		}
	}
}

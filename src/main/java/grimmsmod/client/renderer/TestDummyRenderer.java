
package grimmsmod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import grimmsmod.entity.TestDummyEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class TestDummyRenderer extends MobRenderer<TestDummyEntity, VillagerModel<TestDummyEntity>> {
	public TestDummyRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
	}

	@Override
	protected void scale(TestDummyEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public ResourceLocation getTextureLocation(TestDummyEntity entity) {
		return new ResourceLocation("grimms:textures/entities/grimsmod.png");
	}

	@Override
	protected boolean isBodyVisible(TestDummyEntity entity) {
		return false;
	}
}

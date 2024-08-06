
package grimmsmod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import grimmsmod.entity.TestDummyEntity;

public class TestDummyRenderer extends HumanoidMobRenderer<TestDummyEntity, HumanoidModel<TestDummyEntity>> {
	public TestDummyRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
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

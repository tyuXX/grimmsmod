
package grimm.grimmsmod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import grimm.grimmsmod.entity.TestDummyEntity;
import grimm.grimmsmod.client.model.Modeltestdummy;

public class TestDummyRenderer extends MobRenderer<TestDummyEntity, Modeltestdummy<TestDummyEntity>> {
	public TestDummyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltestdummy(context.bakeLayer(Modeltestdummy.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TestDummyEntity entity) {
		return new ResourceLocation("grimms:textures/entities/testdummy.png");
	}
}

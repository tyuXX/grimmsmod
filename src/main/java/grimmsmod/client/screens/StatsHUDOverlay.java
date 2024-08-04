
package grimmsmod.client.screens;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import grimmsmod.procedures.MoneyTextValueProcedure;
import grimmsmod.procedures.GetShowPlayerHUDProcedure;
import grimmsmod.procedures.GetShowCorHUDProcedure;
import grimmsmod.procedures.GetPlayerAsEntityProcedure;
import grimmsmod.procedures.CoordsTextValueProcedure;

@EventBusSubscriber({Dist.CLIENT})
public class StatsHUDOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					MoneyTextValueProcedure.execute(entity), w / 2 + -207, h / 2 + -112, -16738048, false);
			if (GetShowCorHUDProcedure.execute())
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						CoordsTextValueProcedure.execute(x, y, z), w / 2 + -207, h / 2 + -103, -1, false);
			if (GetPlayerAsEntityProcedure.execute(entity) instanceof LivingEntity livingEntity) {
				if (GetShowPlayerHUDProcedure.execute())
					renderEntityInInventoryFollowsAngle(event.getGuiGraphics(), w / 2 + 181, h / 2 + -65, 30, 0f, 0, livingEntity);
			}
		}
	}

	private static void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}

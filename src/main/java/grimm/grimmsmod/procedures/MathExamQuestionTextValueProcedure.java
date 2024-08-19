package grimm.grimmsmod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.component.DataComponents;

public class MathExamQuestionTextValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double tmp = 0;
		double num1 = 0;
		double num2 = 0;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("grimms:examinit"))) {
			tmp = Math.round(Mth.nextDouble(RandomSource.create(), 1, 5));
			if (tmp == 1) {
				num1 = Mth.nextDouble(RandomSource.create(), 1, 1000000000);
				num2 = Mth.nextDouble(RandomSource.create(), 1, 1000000000);
				{
					final String _tagName = "grimms:examquestion";
					final String _tagValue = (new java.text.DecimalFormat("##").format(num1) + " + " + new java.text.DecimalFormat("##").format(num2));
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "grimms:examqanswer";
					final String _tagValue = (new java.text.DecimalFormat("##").format(num1 + num2));
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			} else if (tmp == 2) {
				num1 = Mth.nextDouble(RandomSource.create(), 1, 1000000000);
				num2 = Mth.nextDouble(RandomSource.create(), 1, 1000000000);
				{
					final String _tagName = "grimms:examquestion";
					final String _tagValue = (new java.text.DecimalFormat("##").format(num1) + " - " + new java.text.DecimalFormat("##").format(num2));
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "grimms:examqanswer";
					final String _tagValue = (new java.text.DecimalFormat("##").format(num1 - num2));
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			} else if (tmp == 3) {
				num1 = Mth.nextDouble(RandomSource.create(), 1, 1000000000);
				num2 = Mth.nextDouble(RandomSource.create(), 1, 1000000000);
				{
					final String _tagName = "grimms:examquestion";
					final String _tagValue = (new java.text.DecimalFormat("##").format(num1) + " * " + new java.text.DecimalFormat("##").format(num2));
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "grimms:examqanswer";
					final String _tagValue = (new java.text.DecimalFormat("##").format(num1 * num2));
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			} else if (tmp == 4) {
				num1 = Mth.nextDouble(RandomSource.create(), 1, 1000000000);
				num2 = Mth.nextDouble(RandomSource.create(), 1, 1000000000);
				{
					final String _tagName = "grimms:examquestion";
					final String _tagValue = (new java.text.DecimalFormat("##").format(num1) + " % " + new java.text.DecimalFormat("##").format(num2));
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "grimms:examqanswer";
					final String _tagValue = (new java.text.DecimalFormat("##").format(num1 % num2));
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			}
			{
				final String _tagName = "grimms:examinit";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
		return "Question #"
				+ (new java.text.DecimalFormat("##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("grimms:examqdone")))
				+ "/100 " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("grimms:examquestion"));
	}
}

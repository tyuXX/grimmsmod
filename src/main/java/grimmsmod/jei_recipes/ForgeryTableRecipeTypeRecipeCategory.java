
package grimmsmod.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

import grimmsmod.init.GrimmsModJeiPlugin;
import grimmsmod.init.GrimmsModBlocks;

public class ForgeryTableRecipeTypeRecipeCategory implements IRecipeCategory<ForgeryTableRecipeTypeRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("grimms", "forgery_table_recipe_type");
	public final static ResourceLocation TEXTURE = new ResourceLocation("grimms", "textures/screens/forgery_table_gui.png");
	private final IDrawable background;
	private final IDrawable icon;

	public ForgeryTableRecipeTypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 0, 0);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(GrimmsModBlocks.FORGERY_TABLE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<ForgeryTableRecipeTypeRecipe> getRecipeType() {
		return GrimmsModJeiPlugin.ForgeryTableRecipeType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Forgery Table");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, ForgeryTableRecipeTypeRecipe recipe, IFocusGroup focuses) {
	}
}

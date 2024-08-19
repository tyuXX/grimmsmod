
package grimm.grimmsmod.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

import grimm.grimmsmod.init.GrimmsModJeiPlugin;
import grimm.grimmsmod.init.GrimmsModBlocks;

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
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(recipe.getIngredients().get(6));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(recipe.getIngredients().get(7));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(recipe.getIngredients().get(8));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 0, 0).addItemStack(recipe.getResultItem(null));
	}
}

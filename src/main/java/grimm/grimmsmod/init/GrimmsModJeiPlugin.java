
package grimm.grimmsmod.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;

import grimm.grimmsmod.jei_recipes.RefineryRecipeTypeRecipeCategory;
import grimm.grimmsmod.jei_recipes.RefineryRecipeTypeRecipe;
import grimm.grimmsmod.jei_recipes.ForgeryTableRecipeTypeRecipeCategory;
import grimm.grimmsmod.jei_recipes.ForgeryTableRecipeTypeRecipe;
import grimm.grimmsmod.jei_recipes.DistilleryRecipeTypeRecipeCategory;
import grimm.grimmsmod.jei_recipes.DistilleryRecipeTypeRecipe;

@JeiPlugin
public class GrimmsModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<ForgeryTableRecipeTypeRecipe> ForgeryTableRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(ForgeryTableRecipeTypeRecipeCategory.UID, ForgeryTableRecipeTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<RefineryRecipeTypeRecipe> RefineryRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(RefineryRecipeTypeRecipeCategory.UID, RefineryRecipeTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<DistilleryRecipeTypeRecipe> DistilleryRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(DistilleryRecipeTypeRecipeCategory.UID, DistilleryRecipeTypeRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("grimms:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new ForgeryTableRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new RefineryRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new DistilleryRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<ForgeryTableRecipeTypeRecipe> ForgeryTableRecipeTypeRecipes = recipeManager.getAllRecipesFor(ForgeryTableRecipeTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(ForgeryTableRecipeType_Type, ForgeryTableRecipeTypeRecipes);
		List<RefineryRecipeTypeRecipe> RefineryRecipeTypeRecipes = recipeManager.getAllRecipesFor(RefineryRecipeTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(RefineryRecipeType_Type, RefineryRecipeTypeRecipes);
		List<DistilleryRecipeTypeRecipe> DistilleryRecipeTypeRecipes = recipeManager.getAllRecipesFor(DistilleryRecipeTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(DistilleryRecipeType_Type, DistilleryRecipeTypeRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(GrimmsModBlocks.FORGERY_TABLE.get().asItem()), ForgeryTableRecipeType_Type);
		registration.addRecipeCatalyst(new ItemStack(GrimmsModBlocks.REFINERY.get().asItem()), RefineryRecipeType_Type);
		registration.addRecipeCatalyst(new ItemStack(GrimmsModBlocks.DISTILLERY.get().asItem()), DistilleryRecipeType_Type);
	}
}

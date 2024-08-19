
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
import grimm.grimmsmod.jei_recipes.HeavyBlasterRecipeTypeRecipeCategory;
import grimm.grimmsmod.jei_recipes.HeavyBlasterRecipeTypeRecipe;
import grimm.grimmsmod.jei_recipes.ForgeryTableRecipeTypeRecipeCategory;
import grimm.grimmsmod.jei_recipes.ForgeryTableRecipeTypeRecipe;
import grimm.grimmsmod.jei_recipes.DistilleryRecipeTypeRecipeCategory;
import grimm.grimmsmod.jei_recipes.DistilleryRecipeTypeRecipe;

@JeiPlugin
public class GrimmsModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<ForgeryTableRecipeTypeRecipe> ForgeryTableRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(ForgeryTableRecipeTypeRecipeCategory.UID, ForgeryTableRecipeTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<RefineryRecipeTypeRecipe> RefineryRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(RefineryRecipeTypeRecipeCategory.UID, RefineryRecipeTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<DistilleryRecipeTypeRecipe> DistilleryRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(DistilleryRecipeTypeRecipeCategory.UID, DistilleryRecipeTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<HeavyBlasterRecipeTypeRecipe> HeavyBlasterRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(HeavyBlasterRecipeTypeRecipeCategory.UID, HeavyBlasterRecipeTypeRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("grimms:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new ForgeryTableRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new RefineryRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new DistilleryRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new HeavyBlasterRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
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
		List<HeavyBlasterRecipeTypeRecipe> HeavyBlasterRecipeTypeRecipes = recipeManager.getAllRecipesFor(HeavyBlasterRecipeTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(HeavyBlasterRecipeType_Type, HeavyBlasterRecipeTypeRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(GrimmsModBlocks.FORGERY_TABLE.get().asItem()), ForgeryTableRecipeType_Type);
		registration.addRecipeCatalyst(new ItemStack(GrimmsModBlocks.REFINERY.get().asItem()), RefineryRecipeType_Type);
		registration.addRecipeCatalyst(new ItemStack(GrimmsModBlocks.DISTILLERY.get().asItem()), DistilleryRecipeType_Type);
		registration.addRecipeCatalyst(new ItemStack(GrimmsModBlocks.HEAVY_BLASTER.get().asItem()), HeavyBlasterRecipeType_Type);
	}
}

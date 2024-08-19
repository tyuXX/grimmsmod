package grimm.grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import grimm.grimmsmod.jei_recipes.RefineryRecipeTypeRecipe;
import grimm.grimmsmod.jei_recipes.HeavyBlasterRecipeTypeRecipe;
import grimm.grimmsmod.jei_recipes.ForgeryTableRecipeTypeRecipe;
import grimm.grimmsmod.jei_recipes.DistilleryRecipeTypeRecipe;
import grimm.grimmsmod.GrimmsMod;

@EventBusSubscriber(modid = GrimmsMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GrimmsModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "grimms");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("forgery_table_recipe_type", () -> ForgeryTableRecipeTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("refinery_recipe_type", () -> RefineryRecipeTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("distillery_recipe_type", () -> DistilleryRecipeTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("heavy_blaster_recipe_type", () -> HeavyBlasterRecipeTypeRecipe.Serializer.INSTANCE);
		});
	}
}

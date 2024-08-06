package grimmsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import grimmsmod.jei_recipes.ForgeryTableRecipeTypeRecipe;

import grimmsmod.GrimmsMod;

@EventBusSubscriber(modid = GrimmsMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GrimmsModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "grimms");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("forgery_table_recipe_type", () -> ForgeryTableRecipeTypeRecipe.Serializer.INSTANCE);
		});
	}
}

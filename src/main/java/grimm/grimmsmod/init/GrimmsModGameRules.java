
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package grimm.grimmsmod.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GrimmsModGameRules {
	public static GameRules.Key<GameRules.IntegerValue> INVULNERABLITY_TICKS;
	public static GameRules.Key<GameRules.IntegerValue> ITEM_XP_MULTIPILIER;
	public static GameRules.Key<GameRules.BooleanValue> DISABLE_GRAVE_SPAWNING;
	public static GameRules.Key<GameRules.BooleanValue> SHOUT_PRESTIGE;
	public static GameRules.Key<GameRules.IntegerValue> SHOUT_LEVEL;
	public static GameRules.Key<GameRules.BooleanValue> ENABLE_MOB_GRAVES;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		INVULNERABLITY_TICKS = GameRules.register("invulnerablityTicks", GameRules.Category.MISC, GameRules.IntegerValue.create(20));
		ITEM_XP_MULTIPILIER = GameRules.register("itemXPMultipilier", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
		DISABLE_GRAVE_SPAWNING = GameRules.register("disableGraveSpawning", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		SHOUT_PRESTIGE = GameRules.register("shoutPrestige", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		SHOUT_LEVEL = GameRules.register("shoutLevel", GameRules.Category.PLAYER, GameRules.IntegerValue.create(10));
		ENABLE_MOB_GRAVES = GameRules.register("enableMobGraves", GameRules.Category.MOBS, GameRules.BooleanValue.create(false));
	}
}

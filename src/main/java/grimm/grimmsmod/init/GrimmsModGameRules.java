
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
	public static GameRules.Key<GameRules.BooleanValue> ENABLE_RADIATION;
	public static GameRules.Key<GameRules.BooleanValue> ENABLE_ROTTING;
	public static GameRules.Key<GameRules.IntegerValue> INVULNERABLITY_TICKS;
	public static GameRules.Key<GameRules.BooleanValue> ENABLE_THIRST;
	public static GameRules.Key<GameRules.BooleanValue> ENABLE_TEMPENTURE;
	public static GameRules.Key<GameRules.BooleanValue> ENABLE_MIXING;
	public static GameRules.Key<GameRules.IntegerValue> ROT_TIME;
	public static GameRules.Key<GameRules.IntegerValue> RADIATION_LIMIT;
	public static GameRules.Key<GameRules.IntegerValue> ITEM_XP_MULTIPILIER;
	public static GameRules.Key<GameRules.IntegerValue> ITEM_XP_EXPONENT;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		ENABLE_RADIATION = GameRules.register("enableRadiation", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		ENABLE_ROTTING = GameRules.register("enableRotting", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		INVULNERABLITY_TICKS = GameRules.register("invulnerablityTicks", GameRules.Category.MISC, GameRules.IntegerValue.create(10));
		ENABLE_THIRST = GameRules.register("enableThirst", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		ENABLE_TEMPENTURE = GameRules.register("enableTempenture", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		ENABLE_MIXING = GameRules.register("enableMixing", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
		ROT_TIME = GameRules.register("rotTime", GameRules.Category.PLAYER, GameRules.IntegerValue.create(1500));
		RADIATION_LIMIT = GameRules.register("radiationLimit", GameRules.Category.PLAYER, GameRules.IntegerValue.create(1000));
		ITEM_XP_MULTIPILIER = GameRules.register("itemXPMultipilier", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
		ITEM_XP_EXPONENT = GameRules.register("itemXPExponent", GameRules.Category.PLAYER, GameRules.IntegerValue.create(11));
	}
}

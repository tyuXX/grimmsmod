package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.DoubleTag;

import javax.annotation.Nullable;

import grimm.grimmsmod.network.GrimmsModVariables;
import grimm.grimmsmod.init.GrimmsModItems;

@EventBusSubscriber
public class OnPlayerRespawnProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double itemid = 0;
		InitLifetimeStatsProcedure.execute(entity);
		for (int index0 = 0; index0 < 44; index0++) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (new Object() {
					public ItemStack getItemStack(int sltid, ItemStack _isc) {
						IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(sltid).copy();
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) itemid, entity.getData(GrimmsModVariables.PLAYER_VARIABLES).deathpackage)).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			itemid = itemid + 1;
		}
		{
			GrimmsModVariables.PlayerVariables _vars = entity.getData(GrimmsModVariables.PLAYER_VARIABLES);
			_vars.deathpackage = new ItemStack(GrimmsModItems.DEATH_PACKAGE.get());
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player)
			_player.giveExperienceLevels((int) (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats.get("grimm:lastdeathxp")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D)
					* (((entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentabilities.get("prestige:keepxp")) instanceof DoubleTag _doubleTag ? _doubleTag.getAsDouble() : 0.0D) / 10)));
		SetDataElementProcedure.execute(DoubleTag.valueOf(0), entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false, "grimm:lastdeathxp");
		ChangeNumberDataElementProcedure.execute(entity.getData(GrimmsModVariables.PLAYER_VARIABLES).persistentstats, entity, false, 1, "deaths");
	}
}

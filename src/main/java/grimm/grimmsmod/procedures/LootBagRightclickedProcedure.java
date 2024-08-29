package grimm.grimmsmod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class LootBagRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(
					(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(new ResourceLocation("grimms:lootcratedrop"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		itemstack.shrink(1);
	}
}

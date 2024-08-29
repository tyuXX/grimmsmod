
package grimm.grimmsmod.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import java.util.List;

import grimm.grimmsmod.procedures.WrittenPaperSpecialInformationProcedure;
import grimm.grimmsmod.procedures.WrittenPaperRightclickedProcedure;

public class WrittenPaperItem extends Item {
	public WrittenPaperItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : Minecraft.getInstance().player;
		list.add(Component.literal(WrittenPaperSpecialInformationProcedure.execute(itemstack)));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		WrittenPaperRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}

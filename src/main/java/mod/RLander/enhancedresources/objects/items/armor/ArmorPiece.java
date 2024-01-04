package mod.RLander.enhancedresources.objects.items.armor;

import mod.RLander.enhancedresources.util.helpers.ItemHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ArmorPiece extends ItemArmor
{
	private TextFormatting toolTipColor;
	private TextFormatting toolTipStyle;
	private String toolTipMessage;
	public ArmorPiece(ArmorMaterial material, int index, EntityEquipmentSlot slot, String toolTipMessage, TextFormatting toolTipColor, TextFormatting toolTipStyle)
	{
		super(material, index, slot);
		this.toolTipColor = toolTipColor != null ? toolTipColor : TextFormatting.GRAY;
		this.toolTipStyle = toolTipStyle != null ? toolTipStyle : this.toolTipColor;
		this.toolTipMessage = toolTipMessage;
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag)
	{
		ItemHelper.setToolTip(list, toolTipMessage, toolTipColor, toolTipStyle);
	}
}

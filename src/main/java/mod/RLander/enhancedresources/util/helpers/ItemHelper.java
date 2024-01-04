package mod.RLander.enhancedresources.util.helpers;

import mod.RLander.enhancedresources.init.ModItems;
import mod.RLander.enhancedresources.objects.items.tools.IndraniumSword;
import mod.RLander.enhancedresources.util.ItemUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class ItemHelper {

	public static void setToolTip(List<String> list, String message, TextFormatting color, TextFormatting style)
	{
		if (message != null && !message.equals("")) {
			if (color == null) color = TextFormatting.WHITE;
	    	if (style == null) style = color;
	    	list.add("" + color + style + message);
	    }
	}
	
	public static boolean disableEnchants(ItemStack stack, Enchantment enchantment, ToolMaterial material, List<Enchantment> eList)
	{
		if(eList != null)
		{
			List<Enchantment> list;
			if (material.equals(ItemUtil.TOOL_VULCANIUM))
			{
				list = ItemUtil.ENCHANTMENT_RESTRCTIONS_VULCANIUM;	
			} else if (material.equals(ItemUtil.TOOL_INDRANIUM))
			{
				list = ItemUtil.ENCHANTMENT_RESTRCTIONS_INDRANIUM;
			} else {
				list = eList;
			}
			
			for (Enchantment enchant : list) {
				if (enchant.equals(enchantment)) return false;
			}
		}
		return enchantment.type.canEnchantItem(stack.getItem());
	}
}

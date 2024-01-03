package mod.RLander.enhancedresources.util.helpers;

import java.util.List;

import mod.RLander.enhancedresources.init.ModItems;
import mod.RLander.enhancedresources.objects.items.armor.VulcaniumChestplate;
import mod.RLander.enhancedresources.objects.items.tools.IndraniumSword;
import mod.RLander.enhancedresources.util.ItemUtil;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.text.TextFormatting;
import scala.actors.threadpool.Arrays;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;

public class ItemHelper {

	public static void setToolTip(ItemStack stack, List<String> list, String message, TextFormatting color, TextFormatting style, ToolMaterial material)
	{
		if (material.equals(ItemUtil.TOOL_VULCANIUM)) 
	    {
			if(stack.getItem().equals(ModItems.VULCANIUM_SWORD))
			{
		    	list.add(TextFormatting.RED + "" + TextFormatting.BOLD + "Fire Aspect");

			} else {
		    	list.add(TextFormatting.RED + "" + TextFormatting.BOLD + "Auto-Smelts");
			}

	    } else if (material.equals(ItemUtil.TOOL_INDRANIUM) && !(stack.getItem() instanceof IndraniumSword)) {
	    	list.add("" + TextFormatting.AQUA + "Silk-Touch");

	    } else if (message != null) {
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

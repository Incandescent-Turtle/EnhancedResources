package mod.RLander.enhancedresources.objects.items.tools;

import mod.RLander.enhancedresources.util.ItemUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.text.TextFormatting;

public class VulcaniumSword extends ToolSword {

	public VulcaniumSword(String name, ToolMaterial material, String toolTipMessage, TextFormatting toolTipColor, TextFormatting toolTipStyle) {
		super(name, ItemUtil.TOOL_INDRANIUM, toolTipMessage, toolTipColor, toolTipStyle);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if(!attacker.isSneaking())
		{
			stack.damageItem(2, attacker);
			target.setFire(8);
		} else stack.damageItem(1, attacker);
        return true;
	}
}

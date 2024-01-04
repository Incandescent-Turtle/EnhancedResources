package mod.RLander.enhancedresources.objects.items.tools;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.util.helpers.ItemHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ToolShovel extends ItemSpade {
	
	private TextFormatting toolTipColor;
	private TextFormatting toolTipStyle;
	private String toolTipMessage;
	private List<Enchantment> enchantList;


	public ToolShovel(String name, ToolMaterial material) {
		super(material);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(EnhancedResources.ENHANCED_RESOURCES);
		
		//ModItems.ITEMS.add(this);
	}
	
	public ToolShovel(String name, ToolMaterial material, String toolTipMessage, TextFormatting toolTipColor, TextFormatting toolTipStyle) {
		this(name, material);
		this.toolTipColor = toolTipColor != null ? toolTipColor : TextFormatting.GRAY;
		this.toolTipStyle = toolTipStyle != null ? toolTipStyle : this.toolTipColor;
		this.toolTipMessage = toolTipMessage;
	}
	
	public ToolShovel(String name, ToolMaterial material, String toolTipMessage, TextFormatting toolTipColor, TextFormatting toolTipStyle, List<Enchantment> enchantList)
	{
		this(name, material, toolTipMessage, toolTipColor, toolTipStyle);
		this.enchantList = enchantList;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World world, List<String> list, ITooltipFlag flag) {
		ItemHelper.setToolTip(list, toolTipMessage, toolTipColor, toolTipStyle);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return ItemHelper.disableEnchants(stack, enchantment, toolMaterial, enchantList);
	}
}

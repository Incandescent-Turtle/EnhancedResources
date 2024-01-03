package mod.RLander.enhancedresources.util;

import mod.RLander.enhancedresources.init.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Arrays;
import java.util.List;

public class ItemUtil {
	public static final ArmorMaterial ARMOR_BLATIUM = EnumHelper
			.addArmorMaterial("armor_blatium", Reference.MOD_ID + ":blatium", 100, new int[] { 4, 7, 9, 5 }, 17,
					SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 5.0F)
			.setRepairItem(new ItemStack(ModItems.BLATIUM_INGOT));
	public static final ArmorMaterial ARMOR_VULCANIUM = EnumHelper
			.addArmorMaterial("armor_vulcanium", Reference.MOD_ID + ":vulcanium", 80, new int[] { 4, 7, 9, 5 }, 17,
					SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 5.0F)
			.setRepairItem(new ItemStack(ModItems.VULCANIUM_CHUNK));
	public static final ArmorMaterial ARMOR_INDRANIUM = EnumHelper.addArmorMaterial("armor_indranium",
			Reference.MOD_ID + ":indranium", 30, new int[] { 2, 5, 4, 1 }, 13, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F)
			.setRepairItem(new ItemStack(ModItems.INDRANIUM_PEARL));
	public static final ArmorMaterial ARMOR_PERACTIO = EnumHelper.addArmorMaterial("armor_peractio",
			Reference.MOD_ID + ":peractio", 30, new int[] { 2, 5, 4, 1 }, 13, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F)
			.setRepairItem(new ItemStack(ModItems.PERACTIO_GEM));

	public static final ToolMaterial TOOL_BLATIUM = EnumHelper.addToolMaterial("tool_blatium", 3, 1625, 7.0F, 3.5F, 25)
			.setRepairItem(new ItemStack(ModItems.BLATIUM_INGOT));
	public static final ToolMaterial TOOL_VULCANIUM = EnumHelper
			.addToolMaterial("tool_vulcanium", 3, 1625, 7.0F, 3.5F, 25)
			.setRepairItem(new ItemStack(ModItems.VULCANIUM_CHUNK));
	public static final ToolMaterial TOOL_INDRANIUM = EnumHelper
			.addToolMaterial("tool_indranium", 2, 200, 2.0F, 2.8F, 10)
			.setRepairItem(new ItemStack(ModItems.INDRANIUM_PEARL));
	public static final ToolMaterial TOOL_PERACTIO = EnumHelper.addToolMaterial("tool_peractio", 2, 200, 2.0F, 2.8F, 10)
			.setRepairItem(new ItemStack(ModItems.PERACTIO_GEM));

	/*
	 * Enchant Restrictions
	 * 
	 */
	public static final List<Enchantment> ENCHANTMENT_RESTRCTIONS_VULCANIUM = Arrays
			.asList(new Enchantment[] { Enchantments.FIRE_ASPECT, Enchantments.FIRE_PROTECTION });
	public static final List<Enchantment> ENCHANTMENT_RESTRCTIONS_INDRANIUM = Arrays
			.asList(new Enchantment[] { Enchantments.FORTUNE, Enchantments.SILK_TOUCH, Enchantments.FEATHER_FALLING });
}

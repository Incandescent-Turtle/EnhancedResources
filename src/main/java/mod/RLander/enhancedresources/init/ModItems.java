package mod.RLander.enhancedresources.init;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.objects.items.armor.IndraniumChestplate;
import mod.RLander.enhancedresources.objects.items.armor.VulcaniumChestplate;
import mod.RLander.enhancedresources.objects.items.throwable.ItemIndraniumPearl;
import mod.RLander.enhancedresources.objects.items.tools.*;
import mod.RLander.enhancedresources.util.Reference;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import javax.annotation.Nonnull;

import static mod.RLander.enhancedresources.util.ItemUtil.*;
  
@ObjectHolder(Reference.MOD_ID)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModItems { //where all items (non blocks) are created

		/* 
		 * Materials
		 */
					
		
		/*
		 * Ingots
		 */
		public static final Item BLATIUM_INGOT = null;
												 
		/*
		 * Shards
		 */
		public static final Item VULCANIUM_SHARD = null;;
		public static final Item INDRANIUM_SHARD = null;
		public static final Item PERACTIO_SHARD = null;
		/*
		 * Chunks
		 */
		public static final Item VULCANIUM_CHUNK = null;
		
		/*
		 * Pearls
		 */
		public static final Item INDRANIUM_PEARL = null;
		
		/*
		 * Gems
		 */
		public static final Item PERACTIO_GEM = null;
				
		/*
		 * Fragments
		 */
		public static final Item PERACTIO_FRAGMENTS = null;
		/*
		 * Armours
		 */
		//Blatium
		public static final Item BLATIUM_HELMET = null;	        				
		public static final Item BLATIUM_CHESTPLATE = null;
		public static final Item BLATIUM_LEGGINGS= null;
		public static final Item BLATIUM_BOOTS = null;
		
		//Vulcanium
		public static final Item VULCANIUM_HELMET = null;
		public static final Item VULCANIUM_CHESTPLATE = null;
		public static final Item VULCANIUM_LEGGINGS = null;
		public static final Item VULCANIUM_BOOTS = null;
		
		//Indranium
		public static final Item INDRANIUM_HELMET = null;
		public static final Item INDRANIUM_CHESTPLATE = null;
		public static final Item INDRANIUM_LEGGINGS = null;
		public static final Item INDRANIUM_BOOTS = null;
		
		//Peractio
		public static final Item PERACTIO_HELMET = null;
		public static final Item PERACTIO_CHESTPLATE = null;
		public static final Item PERACTIO_LEGGINGS = null;
		public static final Item PERACTIO_BOOTS = null;
		/* 
		 * Tools
		 */
		//Blatium
		public static final Item BLATIUM_SWORD = null;
		public static final Item BLATIUM_PICKAXE = null;
		public static final Item BLATIUM_AXE = null;
		public static final Item BLATIUM_SHOVEL = null;
		
		//Vulcanium
		public static final Item VULCANIUM_SWORD = null;
		public static final Item VULCANIUM_PICKAXE = null;
		public static final Item VULCANIUM_AXE = null;
		public static final Item VULCANIUM_SHOVEL = null;
		
		//Indranium
		public static final Item INDRANIUM_SWORD = null;
		public static final Item INDRANIUM_PICKAXE = null;
		public static final Item INDRANIUM_AXE = null;
		public static final Item INDRANIUM_SHOVEL = null;
		
		//Peractio
		public static final Item PERACTIO_SWORD = null;
		public static final Item PERACTIO_PICKAXE = null;
		public static final Item PERACTIO_AXE = null;
		public static final Item PERACTIO_SHOVEL = null;
		
		@SubscribeEvent
		public static void onItemRegistryEvent(@Nonnull final RegistryEvent.Register<Item> event) {
		        event.getRegistry().registerAll(
		        		//Blatium
		        		makeArmor(ARMOR_BLATIUM, "helmet"),
		        		makeArmor(ARMOR_BLATIUM, "chestplate"),
		        		makeArmor(ARMOR_BLATIUM, "leggings"),
		        		makeArmor(ARMOR_BLATIUM, "boots"),
		        		
		        		new ItemIndraniumPearl("indranium_pearl", EnhancedResources.ENHANCED_RESOURCES),
		        		
		        		makeArmor(ARMOR_INDRANIUM, "helmet"),
		        		new IndraniumChestplate("indranium_chestplate", ARMOR_INDRANIUM, 1, EntityEquipmentSlot.CHEST),
		        		makeArmor(ARMOR_INDRANIUM, "leggings"),
		        		makeArmor(ARMOR_INDRANIUM, "boots"),
		        		
		        		makeTool(TOOL_BLATIUM, "sword"),
		        		makeTool(TOOL_BLATIUM, "pickaxe"),
		        		makeTool(TOOL_BLATIUM, "axe"),
		        		makeTool(TOOL_BLATIUM, "shovel"),
		        		makeBasicItem("blatium_ingot"),
		        		
		        		new IndraniumSword("indranium_sword", TOOL_INDRANIUM, "The Weapon o' Zues", TextFormatting.AQUA, null),
		        		makeTool(TOOL_INDRANIUM, "shovel"),
		        		makeTool(TOOL_INDRANIUM, "axe"),
		        		makeTool(TOOL_INDRANIUM, "pickaxe"),
		        		
		        		//Vulcanium
		        		makeArmor(ARMOR_VULCANIUM, "helmet"),
		        		new VulcaniumChestplate("vulcanium_chestplate", ARMOR_VULCANIUM, 1, EntityEquipmentSlot.CHEST),
		        		makeArmor(ARMOR_VULCANIUM, "leggings"),
		        		makeArmor(ARMOR_VULCANIUM, "boots"),
		        		
		        		makeBasicItem("vulcanium_shard"),
		        		makeBasicItem("indranium_shard"),
		        		makeBasicItem("vulcanium_chunk"),
		        		makeBasicItem("peractio_gem"),
		        		makeBasicItem("peractio_fragments"),
		        		makeBasicItem("peractio_shard"),
		        		
		        		new VulcaniumSword("vulcanium_sword", TOOL_VULCANIUM, "Fire Aspect", TextFormatting.RED, TextFormatting.BOLD),
		        		makeTool(TOOL_VULCANIUM, "pickaxe"),
		        		makeTool(TOOL_VULCANIUM, "shovel"),
		        		makeTool(TOOL_VULCANIUM, "axe"),
		        		
		        		makeArmor(ARMOR_PERACTIO, "helmet"),
		        		makeArmor(ARMOR_PERACTIO, "chestplate"),
		        		makeArmor(ARMOR_PERACTIO, "leggings"),
		        		makeArmor(ARMOR_PERACTIO, "boots"),
		        		
		        		makeTool(TOOL_PERACTIO, "sword"),
		        		makeTool(TOOL_PERACTIO, "axe"),
		        		makeTool(TOOL_PERACTIO, "pickaxe"),
		        		makeTool(TOOL_PERACTIO, "shovel"));
		} 

		/*private static Item makeBasicItem(String name, CreativeTabs tab)
		{
			return new Item().setTranslationKey(name).setRegistryName(name).setCreativeTab(tab);
		} */
		
		private static Item makeBasicItem(String name)
		{
			return new Item().setTranslationKey(name).setRegistryName(name).setCreativeTab(EnhancedResources.ENHANCED_RESOURCES);
		}
		
		private static Item makeArmor(ArmorMaterial material, String armourPart)
		{
			EntityEquipmentSlot slot = null;
			String name = material.toString().split("_")[1].toLowerCase() + "_" + armourPart;
			int index = 1;
			switch (armourPart.toLowerCase())
			{
			case "helmet":
				slot = EntityEquipmentSlot.HEAD;
				break;
			case "chestplate":
				slot = EntityEquipmentSlot.CHEST;
				break;
			case "leggings":
				slot = EntityEquipmentSlot.LEGS;
				index = 2;
				break;
			case "boots":
				slot = EntityEquipmentSlot.FEET;
				break;
			}
			return new ItemArmor(material, index, slot).setTranslationKey(name).setRegistryName(name).setCreativeTab(EnhancedResources.ENHANCED_RESOURCES);
		}
		
		private static Item makeTool(ToolMaterial material, String toolType)
		{
			String name = material.toString().split("_")[1].toLowerCase() + "_" + toolType;
			if (toolType.equals("pickaxe")) return new ToolPickaxe(name, material);
			if (toolType.equals("sword")) return new ToolSword(name, material);
			if (toolType.equals("shovel")) return new ToolShovel(name, material);
			if (toolType.equals("axe")) return new ToolAxe(name, material);
			return new Item().setTranslationKey("this_shouldnt_exist").setRegistryName("this_shouldnt_exist").setCreativeTab(EnhancedResources.ENHANCED_RESOURCES);
		}
}


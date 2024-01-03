package mod.RLander.enhancedresources.init;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.crafting.BlockEnhancedCraftingTable;
import mod.RLander.enhancedresources.objects.blocks.Cloud;
import mod.RLander.enhancedresources.objects.blocks.MagmaObsidian;
import mod.RLander.enhancedresources.objects.blocks.OreBlock;
import mod.RLander.enhancedresources.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import javax.annotation.Nonnull;

@ObjectHolder(Reference.MOD_ID)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModBlocks { //all blocks in the mod are created here
		
		/*
		 * Resource Blocks
		 */
		public static final Block BLATIUM_BLOCK = null;;
		//Cloud blocks drop Indranium shard
		public static final Block CLOUD = null;

		/* 
		 * Ores
		 */
		public static final Block BLATIUM_ORE = null;
		public static final Block VULCANIUM_ORE = null;
		public static final Block PERACTIO_ORE = null;
		/*
		 * Misc
		 */
		public static final Block MAGMA_OBSIDIAN = null;
		
		/*
		 * Blocks with GUI
		 */
		public static final Block ENHANCED_CRAFTING_TABLE = null;
		
		@SubscribeEvent
		public static void onBlockRegistryEvent(@Nonnull final RegistryEvent.Register<Block> event) 
		{
			//Misc
			event.getRegistry().registerAll(
					makeBasicBlock("blatium_block", Material.IRON, "pickaxe", 2, 2.5F),
					new Cloud("cloud"),
					new MagmaObsidian("magma_obsidian"),
					new BlockEnhancedCraftingTable("enhanced_crafting_table"));
			//Ores
			event.getRegistry().registerAll(
					new OreBlock("blatium_ore", Material.ROCK, EnhancedResources.ENHANCED_RESOURCES, SoundType.STONE, 1.75F, 15.0F, 2, 0),
					new OreBlock("vulcanium_ore", Material.ROCK, EnhancedResources.ENHANCED_RESOURCES, SoundType.STONE, 0.3F, 0F, 3, 0, () -> ModItems.VULCANIUM_SHARD, 1, 8),
					new OreBlock("peractio_ore", Material.ROCK, EnhancedResources.ENHANCED_RESOURCES, SoundType.STONE, 2.0F, 15.0F, 3, 0, () -> ModItems.PERACTIO_FRAGMENTS));
		}
		
		@SubscribeEvent
		public static void registerItemBlocks(@Nonnull final RegistryEvent.Register<Item> event) 
		{
			event.getRegistry().registerAll(makeItemBlocks(
	        		ModBlocks.BLATIUM_BLOCK,
					ModBlocks.BLATIUM_ORE,
					ModBlocks.CLOUD,
					ModBlocks.ENHANCED_CRAFTING_TABLE,
					ModBlocks.MAGMA_OBSIDIAN,
					ModBlocks.PERACTIO_ORE,
					ModBlocks.VULCANIUM_ORE));
		}
		
		private static Block makeBasicBlock(String name, Material material, String tool, int miningLevel, float breakingSpeed)
		{
			Block block = new Block(material).setTranslationKey(name).setRegistryName(name).setCreativeTab(EnhancedResources.ENHANCED_RESOURCES).setHardness(breakingSpeed).setResistance(30F);
			block.setHarvestLevel(tool, miningLevel);
			return block;
		}
		
		private static Item[] makeItemBlocks(Block...blocks)
		{
			Item[] list = new Item[blocks.length];
			int i = 0;
			for(Block block : blocks)
			{
				list[i++] = new ItemBlock(block).setRegistryName(block.getRegistryName()).setTranslationKey((block.getTranslationKey()));
			}
			return list;
		}
}


	

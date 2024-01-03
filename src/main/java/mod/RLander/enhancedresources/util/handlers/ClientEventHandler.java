package mod.RLander.enhancedresources.util.handlers;

import java.lang.reflect.Array;
import java.util.List;

import mod.RLander.enhancedresources.init.ModBlocks;
import mod.RLander.enhancedresources.init.ModItems;
import mod.RLander.enhancedresources.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MOD_ID)
public class ClientEventHandler {
	
	@SubscribeEvent
	public static void modelRegister(ModelRegistryEvent event)
	{
		//Items
		registerModel(
				ModItems.BLATIUM_AXE,
				ModItems.BLATIUM_BOOTS,
				ModItems.BLATIUM_CHESTPLATE,
				ModItems.BLATIUM_HELMET,
				ModItems.BLATIUM_INGOT,
				ModItems.BLATIUM_LEGGINGS,
				ModItems.BLATIUM_PICKAXE,
				ModItems.BLATIUM_SHOVEL,
				ModItems.BLATIUM_SWORD,
				ModItems.INDRANIUM_AXE,
				ModItems.INDRANIUM_BOOTS,
				ModItems.INDRANIUM_CHESTPLATE,
				ModItems.INDRANIUM_HELMET,
				ModItems.INDRANIUM_LEGGINGS,
				ModItems.INDRANIUM_PEARL,
				ModItems.INDRANIUM_PICKAXE,
				ModItems.INDRANIUM_SHARD,
				ModItems.INDRANIUM_SHOVEL,
				ModItems.INDRANIUM_SWORD,
				ModItems.PERACTIO_GEM,
				ModItems.VULCANIUM_AXE,
				ModItems.VULCANIUM_BOOTS,
				ModItems.VULCANIUM_CHESTPLATE,
				ModItems.VULCANIUM_CHUNK,
				ModItems.VULCANIUM_HELMET,
				ModItems.VULCANIUM_LEGGINGS,
				ModItems.VULCANIUM_PICKAXE,
				ModItems.VULCANIUM_SHARD,
				ModItems.VULCANIUM_SHOVEL,
				ModItems.VULCANIUM_SWORD,
				ModItems.PERACTIO_FRAGMENTS,
				ModItems.PERACTIO_SHARD,
				ModItems.PERACTIO_HELMET,
				ModItems.PERACTIO_CHESTPLATE,
				ModItems.PERACTIO_LEGGINGS,
				ModItems.PERACTIO_BOOTS,
				ModItems.PERACTIO_SWORD,
				ModItems.PERACTIO_SHOVEL,
				ModItems.PERACTIO_AXE,
				ModItems.PERACTIO_PICKAXE
				);
		
		//Blocks
		registerModel(
				ModBlocks.BLATIUM_BLOCK,
				ModBlocks.BLATIUM_ORE,
				ModBlocks.CLOUD,
				ModBlocks.ENHANCED_CRAFTING_TABLE,
				ModBlocks.MAGMA_OBSIDIAN,
				ModBlocks.PERACTIO_ORE,
				ModBlocks.VULCANIUM_ORE);

	}
	
	private static void registerModel(Item...list)
	{
		for (Item item : list)
		{
			System.out.println(item.getRegistryName());
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
	
	private static void registerModel(Block...list)
	{
		for (Block block : list)
		{
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Item.getItemFromBlock(block).getRegistryName(), "inventory"));
		}
	}
}

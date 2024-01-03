package mod.RLander.enhancedresources.util.handlers;

import mod.RLander.enhancedresources.crafting.ContainerEnhancedCraftingTable;
import mod.RLander.enhancedresources.crafting.GuiEnhancedCraftingTable;
import mod.RLander.enhancedresources.init.ModBlocks;
import mod.RLander.enhancedresources.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.ENHANCED_CRAFTING_TABLE_GUI_ID) {
			return ID == Reference.ENHANCED_CRAFTING_TABLE_GUI_ID && world.getBlockState(new BlockPos(x,y,z)).getBlock() == ModBlocks.ENHANCED_CRAFTING_TABLE ? new ContainerEnhancedCraftingTable(player.inventory, world, new BlockPos(x,y,z)) : null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			if(ID == Reference.ENHANCED_CRAFTING_TABLE_GUI_ID) {
				return ID == Reference.ENHANCED_CRAFTING_TABLE_GUI_ID && world.getBlockState(new BlockPos(x,y,z)).getBlock() == ModBlocks.ENHANCED_CRAFTING_TABLE ? new GuiEnhancedCraftingTable(player.inventory, world, new BlockPos(x,y,z)) : null;
			}
		return null;
	}
}

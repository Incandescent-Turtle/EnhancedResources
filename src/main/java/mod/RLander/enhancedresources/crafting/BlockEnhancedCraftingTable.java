package mod.RLander.enhancedresources.crafting;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.init.ModBlocks;
import mod.RLander.enhancedresources.init.ModItems;
import mod.RLander.enhancedresources.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class BlockEnhancedCraftingTable extends Block
{
    public BlockEnhancedCraftingTable(String name)
    {
        super(Material.WOOD);
        this.setCreativeTab(EnhancedResources.ENHANCED_RESOURCES);
		setTranslationKey(name);
		setRegistryName(name);
		setHarvestLevel("axe", 0);
    }

    /**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            playerIn.openGui(EnhancedResources.instance, Reference.ENHANCED_CRAFTING_TABLE_GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
            playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
            return true;
        }
    }
}
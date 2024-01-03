package mod.RLander.enhancedresources.objects.blocks;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class Cloud extends Block {
	//Drops Indranium
	private static long timeLastClicked = 0;
	
	public Cloud (String name) {
		super(Material.GROUND);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(EnhancedResources.ENHANCED_RESOURCES);
		setHardness(1.0F);
}	 
	
	/*
	 * Dealing with item drops
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.INDRANIUM_SHARD;
	}
    
	@Override
	public int quantityDropped(Random random)
    {
        return random.nextInt(3)+1;
    }
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
    {
		
        if (fortune > 0)
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
	
	
	@Override
	public boolean isTranslucent(IBlockState state) {
		return true;
	} 
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	/*
	 * Rendering on Client
	 */
	
    @SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();
        if (blockState != iblockstate)
        {
            return true;
        }
        if (block == this)
        {
            return false;
        }
        return false; 
	}
    
    @SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
}



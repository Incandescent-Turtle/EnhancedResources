package mod.RLander.enhancedresources.objects.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagmaObsidian extends Block {

	public MagmaObsidian(String name) {
		super(Material.ROCK);
		setRegistryName(name);
		setTranslationKey(name);
		setBlockUnbreakable();
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(world, pos, state, rand);
		if (!world.isRemote) world.setBlockState(pos, Blocks.LAVA.getDefaultState());
	}
}

package mod.RLander.enhancedresources.objects.blocks;

import java.util.Random;
import java.util.function.Supplier;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.init.ModBlocks;
import mod.RLander.enhancedresources.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OreBlock extends Block { 
	/*to create ores. three different constructors, so both diamond-like ores, lapis-like ores and iron-like ores can be made. they can either drop themselves, or another
	item, as well as different amounts of said item*/

		private Supplier<Item> itemDropped;
		private int maxDropped;
		private int minDropped;
		private boolean canUseFortune;
		
		//iron-like
		public OreBlock(String name, Material material, CreativeTabs tab, SoundType sound, float breakingSpeed, float blastResistance, int miningLevel, float lightLevel) {
			super(material);
			setTranslationKey(name);
			setRegistryName(name);
			setCreativeTab(tab);
			setSoundType(sound);
			setHardness(breakingSpeed);
			setResistance(blastResistance);
			setHarvestLevel("pickaxe", miningLevel);
			setLightLevel(lightLevel);
			
			//this.itemDropped = () -> new ItemBlock(this);
			this.minDropped = 1;
			this.maxDropped = 1;
			this.canUseFortune = false;
		}
		
		//diamond-like (drops 1 if no fortune)
		public OreBlock(String name, Material material, CreativeTabs tab, SoundType sound, float breakingSpeed, float blastResistance, int miningLevel, float lightLevel, Supplier<Item> itemDropped) {
			super(material);
			setTranslationKey(name);
			setRegistryName(name);
			setCreativeTab(tab);
			setSoundType(sound);
			setHardness(breakingSpeed);
			setResistance(blastResistance);
			setHarvestLevel("pickaxe", miningLevel);
			setLightLevel(lightLevel);
			
			this.itemDropped = itemDropped;
			this.minDropped = 1;
			this.maxDropped = 1;
			this.canUseFortune = true;
		}
				
		//lapis-like
		public OreBlock(String name, Material material, CreativeTabs tab, SoundType sound, float breakingSpeed, float blastResistance, int miningLevel, float lightLevel, Supplier<Item> itemDropped, int minDropped, int maxDropped) {
			super(material);
			setTranslationKey(name);
			setRegistryName(name);
			setCreativeTab(tab);
			setSoundType(sound);
			setHardness(breakingSpeed);
			setResistance(blastResistance);
			setHarvestLevel("pickaxe", miningLevel);
			setLightLevel(lightLevel);
			
			this.itemDropped = itemDropped;
			this.minDropped = minDropped;
			this.maxDropped = maxDropped;
			this.canUseFortune = true;
		}
		 
		@Override
		public Item getItemDropped(IBlockState state, Random rand, int fortune) {
			return itemDropped.get();
		}
		
		@Override
		public int quantityDropped(Random random)
	    {
	        return maxDropped-minDropped==0 ? 1: random.nextInt(maxDropped-minDropped+1)+minDropped;
	    }
		
		@Override
		public int quantityDroppedWithBonus(int fortune, Random random)
	    {
			
	        if (canUseFortune && fortune > 0 && new ItemBlock(this) != itemDropped.get())
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
		public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
			worldIn.scheduleBlockUpdate(pos, ModBlocks.PERACTIO_ORE, 100, 3);
		}
		
		@Override
		public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
			EntityLightningBolt lightning = new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ(), false);
		    worldIn.addWeatherEffect(lightning);
			worldIn.scheduleBlockUpdate(pos, this, 12000, 3);
		}
}

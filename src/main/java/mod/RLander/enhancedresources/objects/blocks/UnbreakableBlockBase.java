package mod.RLander.enhancedresources.objects.blocks;

import java.util.Random;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.init.ModBlocks;
import mod.RLander.enhancedresources.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class UnbreakableBlockBase extends Block {
/* class to easily create bedrock-type blocks that cant be broken in survival or exploded in any way*/
		private Item itemDropped;
		private int maxDropped;
		private int minDropped;
		
		public UnbreakableBlockBase(String name, Material material, CreativeTabs tab, SoundType sound, float lightLevel) {
			super(material);
			setTranslationKey(name);
			setRegistryName(name);
			setCreativeTab(tab);
			setSoundType(sound);
			setResistance(300000);
			setLightLevel(lightLevel);
			setBlockUnbreakable();
		}
}

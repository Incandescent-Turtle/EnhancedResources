package mod.RLander.enhancedresources.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

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

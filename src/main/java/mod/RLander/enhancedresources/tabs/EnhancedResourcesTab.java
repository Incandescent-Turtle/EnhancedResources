package mod.RLander.enhancedresources.tabs;

import mod.RLander.enhancedresources.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EnhancedResourcesTab extends CreativeTabs{
	/* this class is for a custom creative tab */
	
	public EnhancedResourcesTab(String label) {
		super("enhancedresourcestab");
	}

	public ItemStack createIcon() {
		return new ItemStack(ModItems.BLATIUM_INGOT);
	}

}

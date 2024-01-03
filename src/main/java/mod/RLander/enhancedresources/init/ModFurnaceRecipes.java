package mod.RLander.enhancedresources.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModFurnaceRecipes { //where all FURNACE recipes are
	
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.BLATIUM_ORE, new ItemStack(ModItems.BLATIUM_INGOT, 1), 2F);
	}
}

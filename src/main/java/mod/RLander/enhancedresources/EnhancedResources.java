package mod.RLander.enhancedresources;

import mod.RLander.enhancedresources.init.ModEntities;
import mod.RLander.enhancedresources.init.ModFurnaceRecipes;
import mod.RLander.enhancedresources.proxy.ClientProxy;
import mod.RLander.enhancedresources.proxy.CommonProxy;
import mod.RLander.enhancedresources.tabs.EnhancedResourcesTab;
import mod.RLander.enhancedresources.util.Reference;
import mod.RLander.enhancedresources.util.handlers.GuiHandler;
import mod.RLander.enhancedresources.util.handlers.KeyHandler;
import mod.RLander.enhancedresources.util.handlers.ModEventHandler;
import mod.RLander.enhancedresources.world.ModWorldGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version= Reference.VERSION)
public class EnhancedResources {
	
	@Instance
	public static EnhancedResources instance;
	
	public static final CreativeTabs ENHANCED_RESOURCES = new EnhancedResourcesTab("enhancedresourcestab");
	
	public static final int ENHANCED_CRAFTING_TABLE_GUI_ID = 1;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy; 
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
	    proxy.init(event);
		ModFurnaceRecipes.init();
		ModEntities.registerEntities();
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
		NetworkRegistry.INSTANCE.registerGuiHandler(EnhancedResources.instance, new GuiHandler());
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new ModEventHandler());
	}
}

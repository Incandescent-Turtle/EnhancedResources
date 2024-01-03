package mod.RLander.enhancedresources.proxy;

import mod.RLander.enhancedresources.entities.EntityIndraniumPearl;
import mod.RLander.enhancedresources.init.ModItems;
import mod.RLander.enhancedresources.util.handlers.KeyHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {
	public static KeyBinding[] keyBindings;
	public static boolean overworldFlightEnabled = true;

	
	
	@Override
    public void init(FMLInitializationEvent event) 
	{
		setUpKeyBinds();
		RenderingRegistry.registerEntityRenderingHandler(EntityIndraniumPearl.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ModItems.INDRANIUM_PEARL, Minecraft.getMinecraft().getRenderItem()));
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(new KeyHandler());
	}
	
	private static void setUpKeyBinds() 
	{
		keyBindings = new KeyBinding[1]; 
		
		keyBindings[0] = new KeyBinding("key.enableoverworldflight.desc", Keyboard.KEY_G, "key.enhancedresources.category");
		
		for (KeyBinding binding : keyBindings)
		{
		    ClientRegistry.registerKeyBinding(binding);
		}
	}
}

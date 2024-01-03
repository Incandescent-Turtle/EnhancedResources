package mod.RLander.enhancedresources.util.handlers;

import mod.RLander.enhancedresources.init.ModItems;
import mod.RLander.enhancedresources.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(Side.CLIENT)
public class KeyHandler {

	private static KeyBinding[] keyBindings = ClientProxy.keyBindings;

	@SubscribeEvent
	public static void toggleOverWorldFlight(KeyInputEvent event)
	{
		EntityPlayer player = Minecraft.getMinecraft().player;
	    if(player.inventory.armorItemInSlot(0).getItem().equals(ModItems.INDRANIUM_BOOTS) && ((EntityPlayer)player).inventory.armorItemInSlot(1).getItem().equals(ModItems.INDRANIUM_LEGGINGS) && ((EntityPlayer)player).inventory.armorItemInSlot(2).getItem().equals(ModItems.INDRANIUM_CHESTPLATE) && ((EntityPlayer)player).inventory.armorItemInSlot(3).getItem().equals(ModItems.INDRANIUM_HELMET))
	    {
	    	if (keyBindings[0].isKeyDown()) 
		    {
	    		TextComponentString message;
	    		if(ClientProxy.overworldFlightEnabled == true)
	    		{

		    		player.sendMessage(new TextComponentString("Overworld flight has been " + TextFormatting.RED + TextFormatting.BOLD + "disabled"));
		    		ClientProxy.overworldFlightEnabled = false;
	    		} else {
		    		player.sendMessage(new TextComponentString("Overworld flight has been " + TextFormatting.GREEN + TextFormatting.BOLD + "enabled"));
		    		ClientProxy.overworldFlightEnabled = true;
		    		
	    		}	    		
		    }
	    }
	}
}

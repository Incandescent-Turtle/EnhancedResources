package mod.RLander.enhancedresources.objects.items.armor;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.init.ModItems;
import mod.RLander.enhancedresources.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class IndraniumChestplate extends ArmorPiece {

	public IndraniumChestplate(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot) {
		super(material, renderIndex, equipmentSlot, "Flight & Fall Immunity", TextFormatting.AQUA, null);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(EnhancedResources.ENHANCED_RESOURCES);
		
		//ModItems.ITEMS.add(this);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		if(world.isRemote && entity instanceof EntityPlayer) 
		{
			EntityPlayer player = (EntityPlayer) entity;
			if((!(player.isCreative())) && Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown() && ClientProxy.overworldFlightEnabled == true && player.inventory.armorItemInSlot(0).getItem().equals(ModItems.INDRANIUM_BOOTS) && ((EntityPlayer)player).inventory.armorItemInSlot(1).getItem().equals(ModItems.INDRANIUM_LEGGINGS) && ((EntityPlayer)player).inventory.armorItemInSlot(2).getItem().equals(ModItems.INDRANIUM_CHESTPLATE) && ((EntityPlayer)player).inventory.armorItemInSlot(3).getItem().equals(ModItems.INDRANIUM_HELMET))
		    { 
				if (player.motionY < 0) player.motionY+=0.05;					
				player.motionY+=0.1;
		    }
		} 
	}
}

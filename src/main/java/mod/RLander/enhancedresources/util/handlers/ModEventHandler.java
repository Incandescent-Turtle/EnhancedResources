package mod.RLander.enhancedresources.util.handlers;

import java.util.ArrayList;
import java.util.List;

import mod.RLander.enhancedresources.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ModEventHandler {

	@SubscribeEvent
	public void vulcaniumAutoSmelt(HarvestDropsEvent event)  
	{ 
		Item inHand = event.getHarvester() instanceof EntityPlayer ? ((EntityPlayer)event.getHarvester()).getHeldItemMainhand().getItem() : null;
		if(!(inHand==null) && !event.getWorld().isRemote && ((inHand.equals(ModItems.VULCANIUM_PICKAXE) || inHand.equals(ModItems.VULCANIUM_AXE) || inHand.equals(ModItems.VULCANIUM_SHOVEL))))
		{
			List<ItemStack> drops = new ArrayList<ItemStack>();
			for(ItemStack stack : event.getDrops())
			{ 
				if(!(FurnaceRecipes.instance().getSmeltingResult(stack).equals(ItemStack.EMPTY)))
				{ 
					drops.add(FurnaceRecipes.instance().getSmeltingResult(stack).copy());	
				} 
				else 
				{
					drops.add(stack);
				} 
			}
			event.getDrops().clear();
			event.getDrops().addAll(drops);
		}
	}
	
	@SubscribeEvent
	public void vulcaniumFireProtection(LivingAttackEvent event)
	{
		if(!event.getEntityLiving().world.isRemote && event.getEntityLiving() instanceof EntityPlayer)
		{ 
			EntityPlayer player = ((EntityPlayer)event.getEntityLiving());
			
			NonNullList<ItemStack> armorInv = player.inventory.armorInventory;
			if(armorInv.get(0).getItem().equals(ModItems.VULCANIUM_BOOTS) && armorInv.get(1).getItem().equals(ModItems.VULCANIUM_LEGGINGS) && armorInv.get(2).getItem().equals(ModItems.VULCANIUM_CHESTPLATE) && armorInv.get(3).getItem().equals(ModItems.VULCANIUM_HELMET)) 
			{
				if(event.getSource().isFireDamage()) 
				{
					event.setCanceled(true);
					event.getEntity().extinguish();
				}
			}
		}
	}

	@SubscribeEvent
	public void indraniumFallDamage(LivingFallEvent event)
	{
		if(!event.getEntityLiving().world.isRemote && event.getEntityLiving() instanceof EntityPlayer) 
		{
			EntityPlayer player = ((EntityPlayer)event.getEntityLiving());
			NonNullList<ItemStack> armorInv = player.inventory.armorInventory;
			if(armorInv.get(0).getItem().equals(ModItems.INDRANIUM_BOOTS) && armorInv.get(1).getItem().equals(ModItems.INDRANIUM_LEGGINGS) && armorInv.get(2).getItem().equals(ModItems.INDRANIUM_CHESTPLATE) && armorInv.get(3).getItem().equals(ModItems.INDRANIUM_HELMET)) 
			{
				event.setCanceled(true);
			}
		}

	}
	@SubscribeEvent
	public void cookMeat(LivingDropsEvent event)
	{
		if(event.getSource().getTrueSource() instanceof EntityPlayer && (((EntityPlayer)event.getSource().getTrueSource()).getHeldItemMainhand().getItem().equals(ModItems.VULCANIUM_SWORD) || ((EntityPlayer)event.getSource().getTrueSource()).getHeldItemMainhand().getItem().equals(ModItems.VULCANIUM_AXE)))
		{
			World world = event.getEntityLiving().world;
			List<EntityItem> meatDrops = new ArrayList<EntityItem>();

			for(EntityItem itemEntity : event.getDrops())
			{				
				if(!(FurnaceRecipes.instance().getSmeltingResult(itemEntity.getItem()).equals(ItemStack.EMPTY))) 
				{
					meatDrops.add(new EntityItem(world, itemEntity.posX, itemEntity.posY, itemEntity.posZ, FurnaceRecipes.instance().getSmeltingResult(itemEntity.getItem()).copy()));				
				} else {
					meatDrops.add(new EntityItem(world, itemEntity.posX, itemEntity.posY, itemEntity.posZ, itemEntity.getItem()));				
				}
			}
			event.getDrops().clear();
			for(EntityItem item : meatDrops)
			{
				event.getDrops().add(item);
			}
		}
	}
	
	@SubscribeEvent
	public void indraniumSilkTouch(HarvestDropsEvent event)  
	{ 
		Item inHand = event.getHarvester() instanceof EntityPlayer ? ((EntityPlayer)event.getHarvester()).getHeldItemMainhand().getItem() : null;
		if(!(inHand==null) && !event.getWorld().isRemote && (inHand.equals(ModItems.INDRANIUM_PICKAXE) || inHand.equals(ModItems.INDRANIUM_AXE) || inHand.equals(ModItems.INDRANIUM_SHOVEL) || inHand.equals(ModItems.INDRANIUM_SWORD)))
		{
			event.getDrops().clear();
			event.getDrops().add(new ItemStack(Item.getItemFromBlock(event.getState().getBlock())));
		}
	}
}

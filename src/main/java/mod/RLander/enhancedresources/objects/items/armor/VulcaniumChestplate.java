package mod.RLander.enhancedresources.objects.items.armor;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.init.ModBlocks;
import mod.RLander.enhancedresources.init.ModItems;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class VulcaniumChestplate extends ArmorPiece {

	public VulcaniumChestplate(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot) {
		super(material, renderIndex, equipmentSlot, "Fire-Proof", TextFormatting.RED, TextFormatting.BOLD);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(EnhancedResources.ENHANCED_RESOURCES);
		
		//ModItems.ITEMS.add(this);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		if(entity instanceof EntityPlayer) {
			Entity player = (EntityPlayer)entity;
			if(!world.isRemote) createMagma(world, ((EntityPlayer)player));

		}
	}
	
	private static void createMagma(World world, EntityPlayer player)
	{
		NonNullList<ItemStack> armorInv = player.inventory.armorInventory;
        if(armorInv.get(0).getItem().equals(ModItems.VULCANIUM_BOOTS) && armorInv.get(1).getItem().equals(ModItems.VULCANIUM_LEGGINGS) && armorInv.get(2).getItem().equals(ModItems.VULCANIUM_CHESTPLATE) && armorInv.get(3).getItem().equals(ModItems.VULCANIUM_HELMET))
        {
	        BlockPos pos = player.getPosition();
	        for (BlockPos.MutableBlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-2, -1.0D, -2), pos.add(2, -1.0D, 2)))
	        {
	            if (blockpos.distanceSqToCenter(pos.getX(), pos.getY(), pos.getZ()) <= 4)
                {
		            IBlockState state = world.getBlockState(blockpos);

		            if ((state.getBlock().equals(Blocks.LAVA) || state.getBlock().equals(Blocks.FLOWING_LAVA)) && ((Integer)state.getValue(BlockLiquid.LEVEL)).intValue()==0)
		            {
		                world.setBlockState(blockpos, ModBlocks.MAGMA_OBSIDIAN.getDefaultState());
		                world.scheduleBlockUpdate(blockpos, ModBlocks.MAGMA_OBSIDIAN, 100, 3);
		            }
                }
	        }
        }
	}
}



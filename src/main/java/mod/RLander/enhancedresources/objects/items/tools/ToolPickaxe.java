package mod.RLander.enhancedresources.objects.items.tools;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.util.helpers.ItemHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ToolPickaxe extends ItemPickaxe{

	private TextFormatting toolTipColor;
	private TextFormatting toolTipStyle;
	private String toolTipMessage;
	private List<Enchantment> enchantList;
	
	public ToolPickaxe(String name, ToolMaterial material) {
		super(material);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(EnhancedResources.ENHANCED_RESOURCES);
		
		//ModItems.ITEMS.add(this);
	}
	
	public ToolPickaxe(String name, ToolMaterial material, String toolTipMessage, TextFormatting toolTipColor, TextFormatting toolTipStyle) {
		this(name, material);
		this.toolTipColor = toolTipColor != null ? toolTipColor : TextFormatting.GRAY;
		this.toolTipStyle = toolTipStyle != null ? toolTipStyle : this.toolTipColor;
		this.toolTipMessage = toolTipMessage;
	}
	
	public ToolPickaxe(String name, ToolMaterial material, String toolTipMessage, TextFormatting toolTipColor, TextFormatting toolTipStyle, List<Enchantment> enchantList)
	{
		this(name, material, toolTipMessage, toolTipColor, toolTipStyle);
		this.enchantList = enchantList;
	}

	/*
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase player)
    {
		if(state.getBlock().getHarvestTool(state)=="pickaxe" && !player.isSneaking()) {
			if(Math.abs(player.rotationPitch)>70) {
				for (int i=-1; i<2; i++) {
					for (int j=-1; j<2; j++) {
						BlockPos adjacent = new BlockPos(pos.getX()+j, pos.getY(), pos.getZ()+i);
						mine3x3(world, state, pos, adjacent, stack, player);
					} 
				}
			}  else if(player.getHorizontalFacing()==EnumFacing.EAST || player.getHorizontalFacing()==EnumFacing.WEST) {
					for (int i=-1; i<2; i++) {
						for (int j=-1; j<2; j++) {
							BlockPos adjacent = new BlockPos(pos.getX(), pos.getY()+j, pos.getZ()+i);
							mine3x3(world, state, pos, adjacent, stack, player);
						}
					}
				} else if(player.getHorizontalFacing()==EnumFacing.NORTH || player.getHorizontalFacing()==EnumFacing.SOUTH) {
					for (int i=-1; i<2; i++) {
						for (int j=-1; j<2; j++) {
							BlockPos adjacent = new BlockPos(pos.getX()+i, pos.getY()+j, pos.getZ());
							mine3x3(world, state, pos, adjacent, stack, player);
						}
					}
				}
		} else if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {
            stack.damageItem(1, player);
        }
        
        return true;
    } 
	
	private static void mine3x3(World world, IBlockState state, BlockPos pos, BlockPos adjacent, ItemStack stack, EntityLivingBase player) {
		if(world.getBlockState(adjacent).getBlock().getHarvestTool(world.getBlockState(adjacent))=="pickaxe" && state.getBlockHardness(world, pos) >= world.getBlockState(adjacent).getBlockHardness(world, adjacent)) {
			if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D)
	        {
	            stack.damageItem(1, player);
	        }
			world.destroyBlock(adjacent, true);
		}
	} */
	
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, world, entityIn, itemSlot, isSelected);
	}
	/*@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, world, entity, itemSlot, isSelected);
		if(entity instanceof EntityPlayer) {
			EntityPlayer player= (EntityPlayer) entity;
			if(isSelected) {
				player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16);
				addEffect(new PotionEffect(Potion.getPotionById(1)), player);
		}
		}
	}
	
	private static void addEffect(PotionEffect effect, EntityPlayer player) {
		player.addPotionEffect(effect);
	}*/
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World world, List<String> list, ITooltipFlag flag) {
		ItemHelper.setToolTip(list, toolTipMessage, toolTipColor, toolTipStyle);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return ItemHelper.disableEnchants(stack, enchantment, toolMaterial, enchantList);
	}
}

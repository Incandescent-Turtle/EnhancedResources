package mod.RLander.enhancedresources.entities;

import mod.RLander.enhancedresources.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityIndraniumPearl extends EntityThrowable {

	public EntityIndraniumPearl(World worldIn) {
		super(worldIn);
	}
	
	public EntityIndraniumPearl(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}
	
	@SideOnly(Side.CLIENT)
	public EntityIndraniumPearl(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}
	
	@Override
	protected void onImpact(RayTraceResult result) 
	{ 
		if(result.entityHit != this.thrower)
		{
			if (result.entityHit != null)result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 10F);
			
			if (!this.world.isRemote)
	        { 
	        	BlockPos pos = result.getBlockPos();
	        	if(result.typeOfHit == RayTraceResult.Type.BLOCK && this.thrower instanceof EntityPlayer && !((EntityPlayer)this.thrower).capabilities.isCreativeMode) this.world.spawnEntity(new EntityItem(this.world, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(ModItems.INDRANIUM_PEARL, 1)));
	        	this.setDead();
	        }
		}
    }
}

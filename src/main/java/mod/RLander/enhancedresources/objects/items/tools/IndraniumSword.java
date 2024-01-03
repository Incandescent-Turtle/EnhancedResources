package mod.RLander.enhancedresources.objects.items.tools;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.init.ModItems;
import mod.RLander.enhancedresources.util.ItemUtil;
import mod.RLander.enhancedresources.util.helpers.ItemHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IndraniumSword extends ToolSword {
	
	private static long timeLastClicked = 0;
	
	private static final Predicate<EntityLivingBase> LIGHTNING_TARGETS = Predicates.and(EntitySelectors.NOT_SPECTATING, EntitySelectors.IS_ALIVE, new Predicate<EntityLivingBase>()
    {
		@Override
		public boolean apply(EntityLivingBase entity) {
            return !(entity instanceof EntityPlayer) && entity.canBeCollidedWith();
		}
    });
	
	public IndraniumSword(String name, ToolMaterial material, String toolTipMessage, TextFormatting toolTipColor, TextFormatting toolTipStyle) {
		super(name, ItemUtil.TOOL_INDRANIUM, toolTipMessage, toolTipColor, toolTipStyle);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		if (!(world.isRemote) && world.getWorldTime() - timeLastClicked > 20)
		{
			//timeLastClicked = world.getWorldTime();
			/*
			 * For entities
			 */
			Entity  entity = null;
	        List<EntityLivingBase> list = world.getEntitiesWithinAABB(EntityLivingBase.class, player.getEntityBoundingBox().grow(2.0D), LIGHTNING_TARGETS);
	        double prevDistance = 0.0D;

	        for (int i = 0; i < list.size(); ++i)
	        {
	            Entity entity1 = list.get(i);
                double newDistance = player.getPosition().distanceSq(entity1.posX, entity1.posY, entity1.posZ);
                if (newDistance < prevDistance || prevDistance == 0.0D)
                {
                    entity = entity1;
                    prevDistance = newDistance;
                }			
	        } 
			
	        /*
	         * For blocks/misses
	         */
	        Vec3d vec3d = player.getPositionEyes(1);
	        Vec3d vec3d1 = player.getLook(1);
	        Vec3d vec3d2 = vec3d.add(vec3d1.x * 20, vec3d1.y * 20, vec3d1.z * 20);
	        RayTraceResult ray = world.rayTraceBlocks(vec3d, vec3d2, true, false, true);
	        BlockPos rayPos = ray.getBlockPos();
	        BlockPos closestPos;
	        if (entity != null) closestPos = entity.getPosition(); else closestPos = rayPos;
        	EntityLightningBolt lightning = new EntityLightningBolt(world, closestPos.getX(),  closestPos.getY(), closestPos.getZ(), false);
		    world.addWeatherEffect(lightning);
		    if(new Random().nextInt(3)+1 == 1) player.getHeldItemMainhand().damageItem(1, player);
		}
		return super.onItemRightClick(world, player, handIn);
	}	
}

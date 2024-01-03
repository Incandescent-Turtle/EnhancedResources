package mod.RLander.enhancedresources.init;

import mod.RLander.enhancedresources.EnhancedResources;
import mod.RLander.enhancedresources.entities.EntityIndraniumPearl;
import mod.RLander.enhancedresources.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

	public static void registerEntities()
	{
		registerEntity("indranium_pearl", EntityIndraniumPearl.class, Reference.ENTITY_INDRANIUM_PEARL, 64);
	}
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, EnhancedResources.instance, range, 1, true);
	}
}

package mod.RLander.enhancedresources.crafting;
import java.lang.ref.Reference;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import mod.RLander.enhancedresources.EnhancedResources;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper.ShapedPrimer;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class EnhancedRecipeFactory implements IRecipeFactory {
    @Override
    public IRecipe parse(JsonContext context, JsonObject json) {
        ShapedOreRecipe recipe = ShapedOreRecipe.factory(context, json);
        int width = recipe.getWidth();
        int height = recipe.getHeight();
        NonNullList<Ingredient> input = recipe.getIngredients();
        ItemStack result = recipe.getRecipeOutput();
        String group = recipe.getGroup();
        return new EnhancedRecipes(group, width, height, input, result);
    }
}
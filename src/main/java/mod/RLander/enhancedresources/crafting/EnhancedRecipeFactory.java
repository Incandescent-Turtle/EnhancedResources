package mod.RLander.enhancedresources.crafting;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
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
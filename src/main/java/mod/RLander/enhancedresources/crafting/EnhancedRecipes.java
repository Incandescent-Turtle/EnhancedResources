package mod.RLander.enhancedresources.crafting;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class EnhancedRecipes extends ShapedRecipes
{

    public EnhancedRecipes(String group, int width, int height, NonNullList<Ingredient> ingredients, ItemStack result)
    {
    	super(group, width, height, ingredients, result);
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(InventoryCrafting inv, World worldIn)
    {
    	if(inv.getSizeInventory()>9)
    	{
    		for (int i = 0; i <= inv.getWidth() - this.recipeWidth; ++i)
            {
                for (int j = 0; j <= inv.getHeight() - this.recipeHeight; ++j)
                {
                    if (this.checkMatch(inv, i, j, true))
                    {
                        return true;
                    }

                    if (this.checkMatch(inv, i, j, false))
                    {
                        return true;
                    }
                }
            }
    	}
        return false;
    }

    /**
     * Checks if the region of a crafting inventory is match for the recipe.
     */
    private boolean checkMatch(InventoryCrafting p_77573_1_, int p_77573_2_, int p_77573_3_, boolean p_77573_4_)
    {
        for (int i = 0; i < p_77573_1_.getWidth(); ++i)
        {
            for (int j = 0; j < p_77573_1_.getHeight(); ++j)
            {
                int k = i - p_77573_2_;
                int l = j - p_77573_3_;
                Ingredient ingredient = Ingredient.EMPTY;

                if (k >= 0 && l >= 0 && k < this.recipeWidth && l < this.recipeHeight)
                {
                    if (p_77573_4_)
                    {
                        ingredient = this.recipeItems.get(this.recipeWidth - k - 1 + l * this.recipeWidth);
                    }
                    else
                    {
                        ingredient = this.recipeItems.get(k + l * this.recipeWidth);
                    }
                }

                if (!ingredient.apply(p_77573_1_.getStackInRowAndColumn(i, j)))
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static EnhancedRecipes deserialize(JsonObject p_193362_0_)
    {
        String s = JsonUtils.getString(p_193362_0_, "group", "");
        Map<String, Ingredient> map = deserializeKey(JsonUtils.getJsonObject(p_193362_0_, "key"));
        String[] astring = shrink(patternFromJson(JsonUtils.getJsonArray(p_193362_0_, "pattern")));
        int i = astring[0].length();
        int j = astring.length;
        NonNullList<Ingredient> nonnulllist = deserializeIngredients(astring, map, i, j);
        ItemStack itemstack = deserializeItem(JsonUtils.getJsonObject(p_193362_0_, "result"), true);
        return new EnhancedRecipes(s, i, j, nonnulllist, itemstack);
    }

    private static NonNullList<Ingredient> deserializeIngredients(String[] p_192402_0_, Map<String, Ingredient> p_192402_1_, int p_192402_2_, int p_192402_3_)
    {
        NonNullList<Ingredient> nonnulllist = NonNullList.<Ingredient>withSize(p_192402_2_ * p_192402_3_, Ingredient.EMPTY);
        Set<String> set = Sets.newHashSet(p_192402_1_.keySet());
        set.remove(" ");

        for (int i = 0; i < p_192402_0_.length; ++i)
        {
            for (int j = 0; j < p_192402_0_[i].length(); ++j)
            {
                String s = p_192402_0_[i].substring(j, j + 1);
                Ingredient ingredient = p_192402_1_.get(s);

                if (ingredient == null)
                {
                    throw new JsonSyntaxException("Pattern references symbol '" + s + "' but it's not defined in the key");
                }

                set.remove(s);
                nonnulllist.set(j + p_192402_2_ * i, ingredient);
            }
        }

        if (!set.isEmpty())
        {
            throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
        }
        else
        {
            return nonnulllist;
        }
    }

    @VisibleForTesting
    static String[] shrink(String... p_194134_0_)
    {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;

        for (int i1 = 0; i1 < p_194134_0_.length; ++i1)
        {
            String s = p_194134_0_[i1];
            i = Math.min(i, firstNonSpace(s));
            int j1 = lastNonSpace(s);
            j = Math.max(j, j1);

            if (j1 < 0)
            {
                if (k == i1)
                {
                    ++k;
                }

                ++l;
            }
            else
            {
                l = 0;
            }
        }

        if (p_194134_0_.length == l)
        {
            return new String[0];
        }
        else
        {
            String[] astring = new String[p_194134_0_.length - l - k];

            for (int k1 = 0; k1 < astring.length; ++k1)
            {
                astring[k1] = p_194134_0_[k1 + k].substring(i, j + 1);
            }

            return astring;
        }
    }

    private static int firstNonSpace(String str)
    {
        int i;

        for (i = 0; i < str.length() && str.charAt(i) == ' '; ++i)
        {
            ;
        }

        return i;
    }

    private static int lastNonSpace(String str)
    {
        int i;

        for (i = str.length() - 1; i >= 0 && str.charAt(i) == ' '; --i)
        {
            ;
        }

        return i;
    }

    private static String[] patternFromJson(JsonArray p_192407_0_)
    {
        String[] astring = new String[p_192407_0_.size()];

            for (int i = 0; i < astring.length; ++i)
            {
                String s = JsonUtils.getString(p_192407_0_.get(i), "pattern[" + i + "]");

                astring[i] = s;
            }

            return astring;
    }
    
    private static Map<String, Ingredient> deserializeKey(JsonObject p_192408_0_)
    {
        Map<String, Ingredient> map = Maps.<String, Ingredient>newHashMap();

        for (Entry<String, JsonElement> entry : p_192408_0_.entrySet())
        {
            if (((String)entry.getKey()).length() != 1)
            {
                throw new JsonSyntaxException("Invalid key entry: '" + (String)entry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }

            if (" ".equals(entry.getKey()))
            {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }

            map.put(entry.getKey(), deserializeIngredient(entry.getValue()));
        }

        map.put(" ", Ingredient.EMPTY);
        return map;
    }
}
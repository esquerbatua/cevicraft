package cevicraft;

import net.minecraft.src.*;
import java.util.*;

public class RecipesCoalFurnace 
{
    private static final RecipesCoalFurnace Base = new RecipesCoalFurnace();
 
    private Map List = new HashMap();
    private Map Experience = new HashMap();
 
    public static final RecipesCoalFurnace smelting()
    {
        return Base;
    }
 
    private RecipesCoalFurnace()
    {
    }

    public void addSmeltingCoal(int id, ItemStack itemStack, float experience)
    {
        List.put(Integer.valueOf(id), itemStack);
        this.Experience.put(Integer.valueOf(itemStack.itemID), Float.valueOf(experience));
    }

    public ItemStack getSmeltingResult(int id)
    {
        return (ItemStack)List.get(Integer.valueOf(id));
    }
 
    public Map getSmeltingList()
    {
        return List;
    }
    public float getExperience(int par1)
    {
        return this.Experience.containsKey(Integer.valueOf(par1)) ? ((Float)this.Experience.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }
}
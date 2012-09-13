package cevicraft;

import net.minecraft.src.*;
import java.util.*;

public class marble_cyan extends Block
{

    public marble_cyan(int par1, int par2)
    {
        super(par1, par2, Material.rock);
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public void addCreativeItems(ArrayList itemList)
    {
    itemList.add(new ItemStack(this));
    }
}
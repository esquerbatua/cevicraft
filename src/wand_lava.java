/*package cevicraft;

import net.minecraft.src.*;
import java.util.*;

public class wand_lava extends Item
{

    public wand_lava(int i)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(100);
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(l == 0)
            j--;
        if(l == 1)
            j++;
        if(l == 2)
            k--;
        if(l == 3)
            k++;
        if(l == 4)
            i--;
        if(l == 5)
            i++;
        if(!entityplayer.canPlayerEdit(i, j, k))
            return false;
        int i1 = world.getBlockId(i, j, k);
        if(i1 == 0)
        {
            world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            world.setBlockWithNotify(i, j, k, Block.lavaMoving.blockID);
        }
        itemstack.damageItem(1, entityplayer);
        return true;
    }
    private World worldObj;
}*/
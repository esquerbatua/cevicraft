/*package cevicraft;

import java.util.*;

import net.minecraft.src.*;

public class CoalWorkbench extends Block
{
    protected CoalWorkbench(int par1)
    {
        super(par1, Material.rock);
    }

    public int getBlockTextureFromSide(int par1)
    {
        if (par1 == 1)
        {
            return blockIndexInTexture - 16;
        }

        if (par1 == 0)
        {
            return Block.planks.getBlockTextureFromSide(0);
        }

        if (par1 == 2 || par1 == 4)
        {
            return blockIndexInTexture + 1;
        }
        else
        {
            return blockIndexInTexture;
        }
    }

    public boolean blockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            par5EntityPlayer.displayWorkbenchGUI(par2, par3, par4);
            return true;
        }
    }

    public void addCreativeItems(ArrayList itemList)
    {
    itemList.add(new ItemStack(this));
    }
}*/
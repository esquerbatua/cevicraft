package cevicraft;

import java.util.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class marble extends Block
{
	//public static final String[] Names = new String[] {"Marble White", "Marble Orange", "Marble Orange", "Marble Light Blue", "Marble Yellow", "Marble Lime", "Marble Pink", "Marble Gray", "Marble Light Gray", "Marble Cyan", "Marble Purple", "Marble Blue", "Marble Brown", "Marble Green", "Marble Red", "Marble Black"};
	
	int  Marble = 0, orange = 1, magenta = 2, light_blue = 3, yellow = 4, lime = 5, pink = 6, gray = 7, light_gray = 8, cyan = 9, purple = 10, blue = 11, brown = 12, green = 13, red = 14, black = 15;

    public marble(int i)
    {
        super(i, Material.rock);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
	{
        switch(j)
        {
        case 0:
        	return 0;
        case 1:
			return 1;
        case 2:
        	return 2;
        case 3:
        	return 3;
        case 4:
        	return 4;
        case 5:
        	return 5;
        case 6:
        	return 6;
        case 7:
        	return 7;
        case 8:
        	return 8;
        case 9:
        	return 9;
        case 10:
        	return 10;
        case 11:
        	return 11;
        case 12:
        	return 12;
        case 13:
        	return 13;
        case 14:
        	return 14;
        case 15:
        	return 15;
        case 16:
        	return 16;
        case 17:
        	return 17;
        }
        return j;
	}

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
        par3List.add(new ItemStack(par1, 1, 5));
        par3List.add(new ItemStack(par1, 1, 6));
        par3List.add(new ItemStack(par1, 1, 7));
        par3List.add(new ItemStack(par1, 1, 8));
        par3List.add(new ItemStack(par1, 1, 9));
        par3List.add(new ItemStack(par1, 1, 10));
        par3List.add(new ItemStack(par1, 1, 11));
        par3List.add(new ItemStack(par1, 1, 12));
        par3List.add(new ItemStack(par1, 1, 13));
        par3List.add(new ItemStack(par1, 1, 14));
        par3List.add(new ItemStack(par1, 1, 15));
        par3List.add(new ItemStack(par1, 1, 16));
        par3List.add(new ItemStack(par1, 1, 17));
    }

    public int idDropped(int i)
    {
    	return blockID;
    }

	public int getPlacedBlockMetadata(int i)
	{
		return i;
	}

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/marble.png";
    }
}
package cevicraft;

import java.util.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class marble extends Block
{
	int  Marble = 0, orange = 1, magenta = 2, light_blue = 3, yellow = 4, lime = 5, pink = 6, gray = 7, light_gray = 8, cyan = 9, purple = 10, blue = 11, brown = 12, green = 13, red = 14, black = 15;

	/*private String[] marble_names =  new String[]
	{
		"orange", "mageta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black", "white"
	};

	public String getItemNameIS(ItemStack itemstack)
    {
            return marble_names[itemstack.getItemDamage()];
    }*/

    public marble(int i)
    {
        super(i, 16, Material.rock);
        this.setCreativeTab(CreativeTabs.tabDeco);
        /*this.orange = orange;
        this.magenta = magenta;
        this.light_blue = light_blue;
        this.yellow = yellow;
        this.lime = lime;
        this.pink = pink;
        this.gray = gray;
        this.light_gray = light_gray;
        this.cyan = cyan;
        this.purple = purple;
        this.blue = blue;
        this.brown = brown;
        this.green = green;
        this.red = red;
        this.black = black;
        this.white = white;*/
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
	{
	        switch (j)
	    {
	        default:
	        	return 0;
	        case 0:
	        	return Marble;
	        case 1:
				return orange;
	        case 2:
	        	return magenta;
	        case 3:
	        	return light_blue;
	        case 4:
	        	return yellow;
	        case 5:
	        	return lime;
	        case 6:
	        	return pink;
	        case 7:
	        	return gray;
	        case 8:
	        	return light_gray;
	        case 9:
	        	return cyan;
	        case 10:
	        	return purple;
	        case 11:
	        	return blue;
	        case 12:
	        	return brown;
	        case 13:
	        	return green;
	        case 14:
	        	return red;
	        case 15:
	        	return black;
	    }
	}

    protected int damageDropped(int i)
    {
    	return i;
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
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/marble.png";
    }
    /*orange, magenta, light_blue, yellow, lime, pink, gray, light_gray, cyan, purple, blue, brown, green, red, black, white,*/
    //int orange, int magenta, int light_blue, int yellow, int lime, int pink, int gray, int light_gray, int cyan, int purple, int blue, int brown, int green, int red, int black, int white,*/
}
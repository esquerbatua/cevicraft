package cevicraft;

import cevicraft.*;
import net.minecraft.src.*;
import java.util.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class generator extends Block
{
	int wire = CommonProxy.e_wire.blockID;
	boolean right;
	boolean left;
	double generate = 200.0;

    public generator(int par1, int par2)
    {
        super(par1, Material.rock);
        this.blockIndexInTexture = par2;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public void generate(World world, int i, int j, int k, int energy)
    {
    	if(right = true)
    	{
    		//wire = voltios;
    	}
    }
    
    public void wirenearby(World world, int i, int j, int k)
    {
    	if(world.getBlockId(i + 1, j, k) == wire)
    	{
    		right = true;
    	}
    	if(world.getBlockId(i - 1, j, k) == wire)
    	{
    		left = true;
    	}
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/blocks.png";
    }
}
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
	boolean right1;
	boolean left1;
	double iright;
	double ileft;
	double iright1;
	double ileft1;
	double generateinitial = 200.0;
	double generatefinal;
	int divider;

    public generator(int par1, int par2)
    {
        super(par1, Material.rock);
        this.blockIndexInTexture = par2;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public void generate(int m)
    {
    	if(right = true)
    	{
    		//wire
    	}
    	if(left = true)
    	{
    		wire var1 = new wire(m, m);
    		var1.voltios = generatefinal;
    		var1.energy = true;
    	}
    	if(right1 = true)
    	{
    		wire var1 = new wire(m, m);
    		var1.voltios = generatefinal;
    		var1.energy = true;
    	}
    	if(left1 = true)
    	{
    		wire var1 = new wire(m, m);
    		var1.voltios = generatefinal;
    		var1.energy = true;
    	}
    }
    
    public double generatefinal()
    {
    	return generatefinal = iright + ileft + iright1 + ileft1;
    }
    
    public void wirenearby(World world, int i, int j, int k)
    {
    	if(world.getBlockId(i + 1, j, k) == wire)
    	{
    		right = true;
    	}
    	else if(world.getBlockId(i + 1, j, k) != wire)
    	{
    		right =  false;
    	}
    	if(world.getBlockId(i - 1, j, k) == wire)
    	{
    		left = true;
    	}
    	else if(world.getBlockId(i - 1, j, k) != wire)
    	{
    		left = false;
    	}
    	if(world.getBlockId(i, j, k + 1) == wire)
    	{
    		right1 = true;
    	}
    	else if(world.getBlockId(i, j, k + 1) != wire)
    	{
    		right1 = false;
    	}
    	if(world.getBlockId(i, j, k - 1) == wire)
    	{
    		left1 = true;
    	}
    	else if(world.getBlockId(i, j, k - 1) == wire)
    	{
    		left1 = false;
    	}
    }
    
    public void rightchange()
    {
    	if(right = true)
    	{
    		++iright;
    	}
    	else if(right = false)
    	{
    		--iright;
    	}
    }
    
    public void leftchange()
    {
    	if(left = true)
    	{
    		++ileft;
    	}
    	else if(left = false)
    	{
    		--ileft;
    	}
    }
    
    public void right1change()
    {
    	if(right1 = true)
    	{
    		++iright1;
    	}
    	else if(right1 = false)
    	{
    		--iright1;
    	}
    }
    
    public void left1change()
    {
    	if(left1 = true)
    	{
    		++ileft1;
    	}
    	else if(left1 = false)
    	{
    		--ileft1;
    	}
    }
    
    public void updatetick(int m)
    {
    	rightchange();
    	leftchange();
    	right1change();
    	left1change();
    	generatefinal();
    	generate(m);
    }

    public void randomDisplayTick(World par1World, int i, int j, int k, Random par5Random, int m)
    {
    	super.randomDisplayTick(par1World, i, j, k, par5Random);
    	if(par5Random.nextInt(1) == 0)
        {
    		updatetick(m);
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
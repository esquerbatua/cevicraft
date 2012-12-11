package cevicraft;

import cevicraft.*;
import cevicraft.energy.*;
import net.minecraft.src.*;
import java.util.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class wire extends Block
{

    public wire(int par1, int par2)
    {
        super(par1, Material.rock);
        this.blockIndexInTexture = par2;
        this.setCreativeTab(CreativeTabs.tabBlock);
        energy var0 = new energy();
        var0.voltios = 0;
        //var0.createid();
    }

    public void randomDisplayTick(World par1World, int i, int j, int k, Random par5Random)
    {
    	super.randomDisplayTick(par1World, i, j, k, par5Random);
    	//if(voltios != 0)
    	{
    		if(par5Random.nextInt(1) == 0)
            {
    			par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    			par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    			par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    			par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    			par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    			par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    			par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    			par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
            }
    	}
		//if(energy == true)
		{
			if(par5Random.nextInt(1) == 0)
            {
			par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
			par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
            }
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
package cevicraft;

import java.util.*;
import javax.swing.*;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class plutonio_ore extends Block
{
	Calendar ahora = Calendar.getInstance();
	double x;
	double inicio = ahora.get(Calendar.SECOND);
	double fin = inicio + x;
	boolean up = false;
    private boolean canBurn;
	
    public plutonio_ore(int par1, int par2)
    {
        super(par1, Material.dragonEgg);
        this.blockIndexInTexture = par2;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    protected plutonio_ore setBurning()
    {
        canBurn = true;
        return this;
    }
    
    public boolean getCanBurn()
    {
        return canBurn;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((float)par2 + f, par3, (float)par4 + f, (float)(par2 + 1) - f, (float)(par3 + 1) - f, (float)(par4 + 1) - f);
    }

    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.attackEntityFrom(DamageSource.lava, 2);
    }
    
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        checkBlockCoordValid(par1World, par2, par3, par4);
    }

    protected final void checkBlockCoordValid(World par1World, int par2, int par3, int par4)
    {
        if (!canBlockStay(par1World, par2, par3, par4))
        {
            dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
        }
    }

    public void randomDisplayTick(World par1World, int i, int j, int k, Random par5Random)
    {
        super.randomDisplayTick(par1World, i, j, k, par5Random);
    	if(par5Random.nextInt(6) == 0)
        {
    		par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        }
        if(par5Random.nextInt(2) == 0)
        {
        	par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        	par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        	par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        	par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        	par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        }
        while(par1World.getBlockId(i, j + 1, k) == Block.cobblestone.blockID)
    	{
		par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j + 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j + 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j + 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlock(i, j + 1, k, Block.stone.blockID);
    	break;
    	}

        while(par1World.getBlockId(i, j - 1, k) == Block.cobblestone.blockID)
    	{
		par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlock(i, j - 1, k, Block.stone.blockID);
    	break;
    	}
        while(par1World.getBlockId(i + 1, j, k) == Block.cobblestone.blockID)
    	{
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlock(i + 1, j, k, Block.stone.blockID);
    	break;
    	}
        while(par1World.getBlockId(i - 1, j, k) == Block.cobblestone.blockID)
    	{
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlock(i - 1, j, k, Block.stone.blockID);
    	break;
    	}
        while(par1World.getBlockId(i, j, k + 1) == Block.cobblestone.blockID)
    	{
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlock(i, j, k + 1, Block.stone.blockID);
    	break;
    	}
        while(par1World.getBlockId(i, j, k - 1) == Block.cobblestone.blockID)
    	{
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlock(i, j, k - 1, Block.stone.blockID);
    	break;
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
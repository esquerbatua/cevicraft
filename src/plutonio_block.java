package cevicraft;

import java.util.*;
import javax.swing.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class plutonio_block extends Block
{
	Calendar ahora = Calendar.getInstance();
	boolean up = false;
    private boolean canBurn;
	
    public plutonio_block(int par1, int par2)
    {
        super(par1, par2, Material.dragonEgg);
        this.blockIndexInTexture = par2;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    protected plutonio_block setBurning()
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
    	int vapor = CommonProxy.b_water_vapor.blockID;
        super.randomDisplayTick(par1World, i, j, k, par5Random);
    	if(par5Random.nextInt(3) == 0)
        {
    		par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        }
        if(par5Random.nextInt(1) == 0)
        {
        	par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        	par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        	par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        	par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        	par1World.spawnParticle("depthsuspend", (float)i + par5Random.nextFloat(), (float)j + 1.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
        }
        while(par1World.getBlockId(i, j + 1, k) == Block.waterMoving.blockID || par1World.getBlockId(i, j + 1, k) == Block.waterStill.blockID)
    	{
		par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j + 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j + 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j + 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlockWithNotify(i, j + 1, k, vapor);
    	break;
    	}

        while(par1World.getBlockId(i, j - 1, k) == Block.waterMoving.blockID || par1World.getBlockId(i, j - 1, k) == Block.waterStill.blockID)
    	{
		par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlock(i, j - 1, k, vapor);
    	break;
    	}
        while(par1World.getBlockId(i + 1, j, k) == Block.waterMoving.blockID || par1World.getBlockId(i + 1, j, k) == Block.waterStill.blockID)
    	{
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlock(i + 1, j, k, vapor);
    	break;
    	}
        while(par1World.getBlockId(i - 1, j, k) == Block.waterMoving.blockID || par1World.getBlockId(i - 1, j, k) == Block.waterStill.blockID)
    	{
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlock(i - 1, j, k, vapor);
    	break;
    	}
        while(par1World.getBlockId(i, j, k + 1) == Block.waterMoving.blockID || par1World.getBlockId(i, j, k + 1) == Block.waterStill.blockID)
    	{
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlock(i, j, k + 1, vapor);
    	break;
    	}
        while(par1World.getBlockId(i, j, k - 1) == Block.waterMoving.blockID || par1World.getBlockId(i, j, k - 1) == Block.waterStill.blockID)
    	{
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.spawnParticle("lava", (float)i + par5Random.nextFloat(), (float)j - 2.1F, (float)k + par5Random.nextFloat(), 20D, 20D, 20D);
    	par1World.setBlockWithNotify(i, j, k - 1, vapor);
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
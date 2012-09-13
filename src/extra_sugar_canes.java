package cevicraft;

import java.util.*;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class extra_sugar_canes extends Block
{
    boolean particle;
    boolean grow;
    int h;
    int quantitydroped;
	
    protected extra_sugar_canes(int par1, int par2)
    {
        super(par1, Material.plants);
        blockIndexInTexture = par2;
        float f = 0.375F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        setTickRandomly(true);
        this.blockIndexInTexture = par2;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    public void height(World par1World, int par2, int par3, int par4)
    {
    	int i = par1World.getBlockId(par2, par3 - 1, par4);
    	if(i == Block.sand.blockID)
    	{
    		int h = 4;
    	}
    	if(i == Block.dirt.blockID && i == Block.grass.blockID)
    	{
    		int h = 3;
    	}
    }

    public void updateTick(World world, int i, int j, int k, Random par5Random)
    {
    	if(grow = true)
    	{
		    if (world.isAirBlock(i, j + 1, k))
		    {
		        int w = 1;
		        for (w = 1; world.getBlockId(i, j - w, k) == CommonProxy.b_extra_sugar_canes.blockID; w++)
		        if(w <= h)
		        {
		        	particle = true;
		        	int x = (int)(Math.random() * 1 + 2);
		        	if(par5Random.nextInt(x) == 0)
		        	{
		                world.setBlockWithNotify(i, j + w, k, CommonProxy.b_extra_sugar_canes.blockID);
		            }
		        }
		        if(w > h) particle = false;
		    }
    	}
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        int i = par1World.getBlockId(par2, par3 - 1, par4);
        if (i == blockID)
        {
            return false;
        }
        if (i != Block.sand.blockID && i != Block.slowSand.blockID && i != Block.dirt.blockID && i != Block.grass.blockID)
        {
            grow = false;
            return false;
        }
        if (par1World.getBlockMaterial(par2 - 1, par3 - 1, par4) == Material.water)
        {
            grow = true;
        }
        if (par1World.getBlockMaterial(par2 + 1, par3 - 1, par4) == Material.water)
        {
            grow = true;
        }
        if (par1World.getBlockMaterial(par2, par3 - 1, par4 - 1) == Material.water)
        {
            grow = true;
        }
        return par1World.getBlockMaterial(par2, par3 - 1, par4 + 1) == Material.water || par1World.getBlockMaterial(par2, par3 - 1, par4 - 1) == Material.water || par1World.getBlockMaterial(par2 - 1, par3 - 1, par4) == Material.water || par1World.getBlockMaterial(par2 + 1, par3 - 1, par4) == Material.water;
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

    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return canPlaceBlockAt(par1World, par2, par3, par4);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int i)
    {
        return null;
    }

	public int quantityDropped(Random random)
	{
		return quantitydroped;
	}

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Item.reed.shiftedIndex;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 1;
    }
    
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	if(particle == true)
    	{
	    	super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
	        if(par5Random.nextInt(2) == 0)
	        {
	        	par1World.spawnParticle("reddust", (float)par2 + par5Random.nextFloat(), (float)par3 + 1.1F, (float)par4 + par5Random.nextFloat(), 1.25D, 0.8D, 0.06D);
	        }
    	}
    	if(particle == false)
    	{
    		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
	        if(par5Random.nextInt(2) == 0)
	        {
	        	par1World.spawnParticle("reddust", (float)par2 + par5Random.nextFloat(), (float)par3, (float)par4 + par5Random.nextFloat(), 1D, 1D, 1D);
	        }
    	}
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/blocks.png";
    }
}
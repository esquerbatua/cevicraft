package cevicraft;

import net.minecraft.src.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.*;

import net.minecraftforge.common.ForgeDirection;
import static net.minecraftforge.common.ForgeDirection.*;

public class water_vapor extends Block
{
	private int[] chanceToEncourageFire = new int[256];
	private int[] abilityToCatchFire = new int[256];

    protected water_vapor(int par1, int par2)
    {
        super(par1, Material.fire);
        this.setTickRandomly(true);
        this.blockIndexInTexture = par2;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 33;
    }

    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random par5Random)
    {
    	int speed = 1;
    	int down = world.getBlockId(i, j - 1, k);
    	int up = world.getBlockId(i, j + 1, k);
    	int up_right = world.getBlockId(i + 1, j + 1, k);
    	super.randomDisplayTick(world, i, j, k, par5Random);
		if(world.isAirBlock(i, j + 1, k))
		{
			if(par5Random.nextInt(speed) == 0)
			{
				world.setBlock(i, j + 1, k, this.blockID);
				world.setBlock(i, j, k, 0);
			}
			/*if(down == CommonProxy.b_water_vapor.blockID)
			{
				
			}*/
		}
		else if(world.isAirBlock(i + 1, j + 1, k))
		{
			if(up != CommonProxy.b_water_vapor.blockID)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i + 1, j + 1, k, this.blockID);
					world.setBlock(i, j, k, 0);
				}
			}
		}
		else if(world.isAirBlock(i - 1, j + 1, k))
		{
			if(up != CommonProxy.b_water_vapor.blockID)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i - 1, j + 1, k, this.blockID);
					world.setBlock(i, j, k, 0);
				}
			}
		}
		else if(world.isAirBlock(i, j + 1, k + 1))
		{
			if(up != CommonProxy.b_water_vapor.blockID)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i, j + 1, k + 1, this.blockID);
					world.setBlock(i, j, k, 0);
				}
			}
		}
		else if(world.isAirBlock(i, j + 1, k - 1))
		{
			if(up != CommonProxy.b_water_vapor.blockID)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i, j + 1, k - 1, this.blockID);
					world.setBlock(i, j, k, 0);
				}
			}
		}
		else if(world.isAirBlock(i + 1, j + 1, k + 1))
		{
			if(up != CommonProxy.b_water_vapor.blockID)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i + 1, j + 1, k + 1, this.blockID);
					world.setBlock(i, j, k, 0);
				}
			}
		}
		else if(world.isAirBlock(i - 1, j + 1, k + 1))
		{
			if(up != CommonProxy.b_water_vapor.blockID)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i - 1, j + 1, k + 1, this.blockID);
					world.setBlock(i, j, k, 0);
				}
			}
		}
		else if(world.isAirBlock(i + 1, j + 1, k - 1))
		{
			if(up != CommonProxy.b_water_vapor.blockID)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i + 1, j + 1, k - 1, this.blockID);
					world.setBlock(i, j, k, 0);
				}
			}
		}
		else if(world.isAirBlock(i - 1, j + 1, k - 1))
		{
			if(up != CommonProxy.b_water_vapor.blockID)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i - 1, j + 1, k - 1, this.blockID);
					world.setBlock(i, j, k, 0);
				}
			}
		}
		else
		{
			int move = 4;
			int c;
			Random rnd = new Random();
			
			if(move == 0)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i + 1, j, k, this.blockID);
					world.setBlock(i, j, k, 0);
				}
			}
			if(move == 1)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i - 1, j, k, this.blockID);
					world.setBlock(i, j, k, 0);
				}
			}
			if(move == 2)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i, j, k + 1, this.blockID);
					world.setBlock(i, j, k, 0);
				}
			}
			if(move == 3)
			{
				if(par5Random.nextInt(speed) == 0)
				{
					world.setBlock(i - 1, j, k - 1, this.blockID);
					world.setBlock(i, j, k, 0);
				}
	    	}
		}
	}

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/blocks.png";
    }
}
/*package cevicraft;

import net.minecraft.src.*;
import java.util.*;

public class WorldGenFirSapling extends WorldGenerator
{
	
    private final int baseHeight;
    private final int woodMetadata;
    private final int leavesMetadata;

    public WorldGenFirSapling(boolean par1, int par2, int par3, int par4)
    {
        super(par1);
        baseHeight = par2;
        woodMetadata = par3;
        leavesMetadata = par4;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        int l = random.nextInt(1) + baseHeight;
        boolean flag = true;
        if(j < 1 || j + l + 1 > 256)
            return false;
        for(int i1 = j; i1 <= j + 1 + l; i1++)
        {
            byte byte0 = 1;
            if(i1 == j)
                byte0 = 0;
            if(i1 >= (j + 1 + l) - 2)
                byte0 = 2;
            for(int i2 = i - byte0; i2 <= i + byte0 && flag; i2++)
            {
                for(int l2 = k - byte0; l2 <= k + byte0 && flag; l2++)
                    if(i1 >= 0 && i1 < 256)
                    {
                        int j3 = world.getBlockId(i2, i1, l2);
                        if (j3 != 0 && j3 != ClientProxy.b_fir_leaf.blockID && j3 != Block.grass.blockID && j3 != Block.dirt.blockID && j3 != ClientProxy.b_fir_log.blockID && j3 != ClientProxy.b_fir_leaf.blockID)
                        {
                        	flag = false;
                        }
                    }
                    else
                    {
                        flag = false;
                    }

            }

        }

        if(!flag)
            return false;
        int j1 = world.getBlockId(i, j - 1, k);
        if(j1 != Block.grass.blockID && j1 != Block.dirt.blockID || j >= 256 - l - 1)
        {
        	return false;
        }

        world.setBlock(i, j - 1, k, Block.dirt.blockID);
        world.setBlock(i + 1, j - 1, k, Block.dirt.blockID);
        world.setBlock(i, j - 1, k + 1, Block.dirt.blockID);
        world.setBlock(i + 1, j - 1, k + 1, Block.dirt.blockID);
        growLeaves(world, i, k, j + i, 2, random);

        for(int k1 = (j - 3) + l; k1 <= j + l; k1++)
        {
            int j2 = k1 - (j + l);
            int i3 = 1 - j2 / 2;
            for(int k3 = i - i3; k3 <= i + i3; k3++)
            {
                int l3 = k3 - i;
                for(int i4 = k - i3; i4 <= k + i3; i4++)
                {
                    int j4 = i4 - k;
                    if((Math.abs(l3) != i3 || Math.abs(j4) != i3 || random.nextInt(2) != 0 && j2 != 0) && !Block.opaqueCubeLookup[world.getBlockId(k3, k1, i4)])
                        setBlockAndMetadata(world, k3, k1, i4, ClientProxy.b_fir_leaf.blockID, 0);
                }

            }

        }

        for(int l1 = 0; l1 < l;)
        {
        	int j2 = world.getBlockId(i, j + j1, k);

            if (j2 == 0 || j2 == ClientProxy.b_fir_leaf.blockID)
            {
                setBlockAndMetadata(world, i, j + j1, k, ClientProxy.b_fir_log.blockID, woodMetadata);

                if (j1 > 0)
                {
                    if (random.nextInt(3) > 0 && world.isAirBlock(i - 1, j + j1, k))
                    {
                        setBlockAndMetadata(world, i - 1, j + j1, k, Block.vine.blockID, 8);
                    }

                    if (random.nextInt(3) > 0 && world.isAirBlock(i, j + j1, k - 1))
                    {
                        setBlockAndMetadata(world, i, j + j1, k - 1, Block.vine.blockID, 1);
                    }
                }
        	
            int k2 = world.getBlockId(i, j + l1, k);
            if(k2 == 0 || k2 == ClientProxy.b_fir_leaf.blockID)
                setBlockAndMetadata(world, i, j + l1, k, ClientProxy.b_fir_log.blockID, 0);
        }
        return true;
        }
		return flag;
    }

    private void growLeaves(World par1World, int par2, int par3, int par4, int par5, Random par6Random)
    {
        byte byte0 = 2;

        for (int i = par4 - byte0; i <= par4; i++)
        {
            int j = i - par4;
            int k = (par5 + 1) - j;

            for (int l = par2 - k; l <= par2 + k + 1; l++)
            {
                int i1 = l - par2;

                for (int j1 = par3 - k; j1 <= par3 + k + 1; j1++)
                {
                    int k1 = j1 - par3;

                    if ((i1 >= 0 || k1 >= 0 || i1 * i1 + k1 * k1 <= k * k) && (i1 <= 0 && k1 <= 0 || i1 * i1 + k1 * k1 <= (k + 1) * (k + 1)) && (par6Random.nextInt(4) != 0 || i1 * i1 + k1 * k1 <= (k - 1) * (k - 1)) && !Block.opaqueCubeLookup[par1World.getBlockId(l, i, j1)])
                    {
                        setBlockAndMetadata(par1World, l, i, j1, ClientProxy.b_fir_leaf.blockID, leavesMetadata);
                    }
                }
            }
        }
    }
}*/
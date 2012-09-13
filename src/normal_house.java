package cevicraft;

import java.util.*;
import net.minecraft.src.*;

public class normal_house extends Block
{

    public normal_house(int par1)
    {
        super(par1, Material.cloth);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public int idDropped(int i, Random random, int j)
    {
        return CommonProxy.b_normal_house.blockID;
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
    	int sizei = 5;
    	int sizej = 5;
    	int sizek = 5;
    	int sizeiw = 4;
    	int block = Block.planks.blockID;
    	int block1 = Block.wood.blockID;
    	int glass = Block.thinGlass.blockID;
        
        for (int i1 = -4; i1 < sizei; i1++)
    	{
    		for (int k1 = -4; k1 < sizek; k1++)
    		{
    			for (int j1 = 0; j1  < sizej; j1++)
    			{
    			//suelo
    			world.setBlockWithNotify(i+i1, j, k+k1, block);
    			//techo
    			world.setBlockWithNotify(i+i1, j + 5, k+k1, block);
    			//pilares de madera
    			world.setBlockWithNotify(i - 4, j+j1, k + 1, block1);
    			world.setBlockWithNotify(i - 4, j+j1, k - 1, block1);
    			world.setBlockWithNotify(i - 4, j+j1, k + 4, block1);
    			world.setBlockWithNotify(i - 4, j+j1, k - 4, block1);
    			world.setBlockWithNotify(i + 4, j+j1, k + 1, block1);
    			world.setBlockWithNotify(i + 4, j+j1, k - 1, block1);
    			world.setBlockWithNotify(i + 4, j+j1, k + 4, block1);
    			world.setBlockWithNotify(i + 4, j+j1, k - 4, block1);
    			}
    		}
    	}

        //paredes
        for (int iw = -3; iw < sizeiw; iw++)
    	{
    		for (int k1 = -3; k1 < sizek; k1++)
    		{
    			for (int j1 = 0; j1  < sizej; j1++)
    			{
    				world.setBlockWithNotify(i+iw, j+j1, k + 5, block);
    				world.setBlockWithNotify(i+iw, j+j1, k - 5, block);
    			}
    		}
    	}

        //madera entre los pilares
        world.setBlockWithNotify(i - 4, j + 1, k + 2, block);
        world.setBlockWithNotify(i - 4, j + 1, k + 3, block);
        world.setBlockWithNotify(i - 4, j + 1, k, block);
        world.setBlockWithNotify(i - 4, j + 1, k - 2, block);
        world.setBlockWithNotify(i - 4, j + 1, k - 3, block);
        world.setBlockWithNotify(i + 4, j + 1, k + 2, block);
        world.setBlockWithNotify(i + 4, j + 1, k + 3, block);
        world.setBlockWithNotify(i + 4, j + 1, k, block);
        world.setBlockWithNotify(i + 4, j + 1, k - 2, block);
        world.setBlockWithNotify(i + 4, j + 1, k - 3, block);
        world.setBlockWithNotify(i - 4, j + 4, k + 2, block);
        world.setBlockWithNotify(i - 4, j + 4, k + 3, block);
        world.setBlockWithNotify(i - 4, j + 4, k, block);
        world.setBlockWithNotify(i - 4, j + 4, k - 2, block);
        world.setBlockWithNotify(i - 4, j + 4, k - 3, block);
        world.setBlockWithNotify(i + 4, j + 4, k + 2, block);
        world.setBlockWithNotify(i + 4, j + 4, k + 3, block);
        world.setBlockWithNotify(i + 4, j + 4, k - 2, block);
        world.setBlockWithNotify(i + 4, j + 4, k - 3, block);

        //madera de arriba de la puerta
        world.setBlockWithNotify(i + 4, j + 3, k, block);
        world.setBlockWithNotify(i + 4, j + 4, k, block);

        //cristal
        world.setBlockWithNotify(i - 4, j + 2, k + 2, glass);
        world.setBlockWithNotify(i - 4, j + 2, k + 3, glass);
        world.setBlockWithNotify(i - 4, j + 2, k, glass);
        world.setBlockWithNotify(i - 4, j + 2, k - 2, glass);
        world.setBlockWithNotify(i - 4, j + 2, k - 3, glass);
        world.setBlockWithNotify(i + 4, j + 2, k + 2, glass);
        world.setBlockWithNotify(i + 4, j + 2, k + 3, glass);
        world.setBlockWithNotify(i + 4, j + 2, k - 2, glass);
        world.setBlockWithNotify(i + 4, j + 2, k - 3, glass);
        world.setBlockWithNotify(i - 4, j + 3, k + 2, glass);
        world.setBlockWithNotify(i - 4, j + 3, k + 3, glass);
        world.setBlockWithNotify(i - 4, j + 3, k, glass);
        world.setBlockWithNotify(i - 4, j + 3, k - 2, glass);
        world.setBlockWithNotify(i - 4, j + 3, k - 3, glass);
        world.setBlockWithNotify(i + 4, j + 3, k + 2, glass);
        world.setBlockWithNotify(i + 4, j + 3, k + 3, glass);
        world.setBlockWithNotify(i + 4, j + 3, k - 2, glass);
        world.setBlockWithNotify(i + 4, j + 3, k - 3, glass);
        boolean flag2 = false;
        //puerta
        world.setBlockAndMetadataWithNotify(i + 4, j + 1, k, Block.doorWood.blockID, 0);
        world.setBlockAndMetadataWithNotify(i + 4, j + 2, k, Block.doorWood.blockID, 8 | (flag2 ? 1 : 1));
        //cama
        world.setBlockAndMetadataWithNotify(i - 3, j + 1, k + 4, Block.bed.blockID, 8);
        world.setBlockAndMetadataWithNotify(i - 3, j + 1, k + 3, Block.bed.blockID,  4);
        int pressurePlatePlanks = Block.pressurePlatePlanks.blockID;
        world.setBlockWithNotify(i + 3, j + 1, k, pressurePlatePlanks);
        int torch = Block.torchWood.blockID;
        world.setBlockWithNotify(i + 3, j + 4, k, torch);
        world.setBlockWithNotify(i - 3, j + 4, k, torch);
        world.setBlockWithNotify(i, j + 4, k + 3, torch);
        world.setBlockWithNotify(i, j + 4, k - 3, torch);
        int workbenck = Block.workbench.blockID;
        world.setBlockWithNotify(i - 3, j + 1, k - 4, workbenck);
        int chest = Block.chest.blockID;
        world.setBlockWithNotify(i - 3, j + 1, k - 3, chest);
        world.setBlockWithNotify(i - 3, j + 1, k - 2, chest);
        int furnace = Block.stoneOvenIdle.blockID;
        world.setBlockWithNotify(i - 3, j + 1, k - 1, furnace);
    }

    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
        if(par5Random.nextInt(2) == 0)
        {
            par1World.spawnParticle("depthsuspend", (float)par2 + par5Random.nextFloat(), (float)par3 + 1.1F, (float)par4 + par5Random.nextFloat(), 20D, 20D, 20D);
            par1World.spawnParticle("depthsuspend", (float)par2 + par5Random.nextFloat(), (float)par3 + 1.1F, (float)par4 + par5Random.nextFloat(), 20D, 20D, 20D);
        }
    }
}
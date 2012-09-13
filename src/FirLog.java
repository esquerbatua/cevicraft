/*package cevicraft;

import java.util.*;
import net.minecraft.src.*;

public class FirLog extends Block
{

    protected FirLog(int i)
    {
        super(i, Material.wood);
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int idDropped(int i, Random random, int j)
    {
        return CommonProxy.b_fir_log.blockID;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        byte byte0 = 4;
        int l = byte0 + 1;
        if(world.checkChunksExist(i - l, j - l, k - l, i + l, j + l, k + l))
        {
            for(int i1 = -byte0; i1 <= byte0; i1++)
            {
                for(int j1 = -byte0; j1 <= byte0; j1++)
                {
                    for(int k1 = -byte0; k1 <= byte0; k1++)
                    {
                        int l1 = world.getBlockId(i + i1, j + j1, k + k1);
                        if(l1 == CommonProxy.b_fir_leaf.blockID)
                        {
                            int i2 = world.getBlockMetadata(i + i1, j + j1, k + k1);
                            if((i2 & 8) == 0)
                                world.setBlockMetadata(i + i1, j + j1, k + k1, i2 | 8);
                        }
                    }

                }

            }

        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 0)
            return ClientProxy.fir_logBottom;
        if(i == 1)
            return ClientProxy.fir_logBottom;
        if(i == 2)
            return ClientProxy.fir_logSide;
        if(i == 3)
            return ClientProxy.fir_logSide;
        if(i == 4)
            return ClientProxy.fir_logSide;
        if(i == 5)
            return ClientProxy.fir_logSide;
        if(j == 1)
            return 116;
        else
            return j == 2 ? 117 : 20;
    }

    protected int damageDropped(int i)
    {
        return i;
    }

    public void addCreativeItems(ArrayList itemList)
    {
    itemList.add(new ItemStack(this));
    }
}*/
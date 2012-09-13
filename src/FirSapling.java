/*package cevicraft;

import java.util.*;
import net.minecraft.src.*;

public class FirSapling extends BlockFlower
{

    protected FirSapling(int i, int j)
    {
        super(i, j);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == Block.grass.blockID;
    }

    protected boolean canThisPlantGrowOnThisBlockID1(int j)
    {
        return j == Block.dirt.blockID;
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.isRemote)
            return;
        super.updateTick(world, i, j, k, random);
        if(world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(7) == 0)
        {
            int l = world.getBlockMetadata(i, j, k);
            if((l & 8) == 0)
                world.setBlockMetadataWithNotify(i, j, k, l | 8);
            else
                growTree(world, i, j, k, random);
        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        j &= 3;
        if(j == 1)
            return blockIndexInTexture;
        if(j == 2)
            return blockIndexInTexture;
        else
            return blockIndexInTexture;
    }

    public void growTree(World world, int i, int j, int k, Random random)
    {
        int l = world.getBlockMetadata(i, j, k) & 3;
        world.setBlock(i, j, k, 0);
        Object obj = null;
        if(l == 1)
            obj = new WorldGenTaiga2(true);
        else
        if(l == 2)
        {
            obj = new WorldGenForest(true);
        } else
        {
            obj = new WorldGenTrees(true);
            if(random.nextInt(10) == 0)
                obj = new WorldGenBigTree(true);
        }
        if(!((WorldGenerator)obj).generate(world, random, i, j, k))
            world.setBlockAndMetadata(i, j, k, blockID, l);
    }

    protected int damageDropped(int i)
    {
        return i & 3;
    }

    public void addCreativeItems(ArrayList itemList)
    {
    itemList.add(new ItemStack(this));
    }
}*/
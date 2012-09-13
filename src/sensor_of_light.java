package cevicraft;

import net.minecraft.src.*;

import java.util.*;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class sensor_of_light extends Block
{
    protected sensor_of_light(int i, int par2)
    {
        super(i, 22, Material.iron);
        setTickRandomly(true);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        this.blockIndexInTexture = par2;
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    public int tickRate()
    {
        return 30;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return world.isBlockNormalCube(i, j - 1, k) || world.getBlockId(i, j - 1, k) == Block.fence.blockID;
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
    }

    /*public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        boolean flag = false;

        if (!world.isBlockNormalCube(i, j - 1, k) && world.getBlockId(i, j - 1, k) != Block.fence.blockID)
        {
            flag = true;
        }

        if (flag)
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
            world.setBlockWithNotify(i, j, k, 0);
        }
    }*/

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if (world.isRemote)
        {
            return;
        }
        else
        {
            h(world, i, j, k);
            return;
        }
    }

    private void h(World world, int i, int j, int k)
    {
        boolean flag = world.getBlockMetadata(i, j, k) == 1;
        boolean flag1 = false;
        int l = world.getBlockLightValue(i, j, k);

        if (l > 13)
        {
            flag1 = true;
        }

        if (flag1 && !flag)
        {
            world.setBlockMetadataWithNotify(i, j, k, 1);
            world.notifyBlocksOfNeighborChange(i, j, k, blockID);
            world.notifyBlocksOfNeighborChange(i, j - 1, k, blockID);
            world.notifyBlocksOfNeighborChange(i, j + 1, k, blockID);
            world.notifyBlocksOfNeighborChange(i + 1, j, k, blockID);
            world.notifyBlocksOfNeighborChange(i + 1, j, k + 1, blockID);
            world.markBlocksDirty(i, j, k, i, j, k);
            world.playSoundEffect((double)i + 0.5D, (double)j + 0.10000000000000001D, (double)k + 0.5D, "random.click", 0.3F, 0.6F);
        }

        if (!flag1 && flag)
        {
            world.setBlockMetadataWithNotify(i, j, k, 0);
            world.notifyBlocksOfNeighborChange(i, j, k, blockID);
            world.notifyBlocksOfNeighborChange(i, j - 1, k, blockID);
            world.notifyBlocksOfNeighborChange(i, j + 1, k, blockID);
            world.notifyBlocksOfNeighborChange(i + 1, j, k, blockID);
            world.notifyBlocksOfNeighborChange(i + 1, j, k + 1, blockID);
            world.markBlocksDirty(i, j, k, i, j, k);
            world.playSoundEffect((double)i + 0.5D, (double)j + 0.10000000000000001D, (double)k + 0.5D, "random.click", 0.3F, 0.5F);
        }

        world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);

        if (l > 0)
        {
            world.notifyBlocksOfNeighborChange(i, j, k, blockID);
            world.notifyBlocksOfNeighborChange(i, j - 1, k, blockID);
        }

        super.onBlockDestroyedByPlayer(world, i, j, k, l);
    }

    public boolean isPoweringTo(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return iblockaccess.getBlockMetadata(i, j, k) > 0;
    }

    public boolean isIndirectlyPoweringTo(World world, int i, int j, int k, int l)
    {
        if (world.getBlockMetadata(i, j, k) == 0)
        {
            return false;
        }

        return l == 1;
    }

    public boolean canProvidePower()
    {
        return true;
    }

    public int getMobilityFlag()
    {
        return 0;
    }

    public void addCreativeItems(ArrayList itemList)
    {
    itemList.add(new ItemStack(this));
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/blocks.png";
    }
}

/*package cevicraft;

import net.minecraft.src.*;

import java.util.*;

public class magnetic_chest extends BlockContainer
{
    private Random random;

    protected magnetic_chest(int i)
    {
        super(i, Material.wood);
        random = new Random();
        this.setCreativeTab(CreativeTabs.tabDeco);
    }

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        if (!(entity instanceof EntityItem))
        {
            return;
        }
        else
        {
            EntityItem entityitem = (EntityItem)entity;
            int l = entityitem.item.itemID;
            int i1 = entityitem.item.stackSize;
            int j1 = entityitem.item.getItemDamage();
            ItemStack itemstack = entityitem.item;
            TileEntitymagnetic_chest tileentitymagnetic_chest = (TileEntitymagnetic_chest)world.getBlockTileEntity(i, j, k);
            tileentitymagnetic_chest.addItem(itemstack, entityitem);
            return;
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((float)i + f, (float)j + f, (float)k + f, (float)(i + 1) - f, (float)(j + 1) - f, (float)(k + 1) - f);
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        super.onBlockAdded(world, i, j, k);
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = world.getBlockId(i, j, k - 1);
        int i1 = world.getBlockId(i, j, k + 1);
        int j1 = world.getBlockId(i - 1, j, k);
        int k1 = world.getBlockId(i + 1, j, k);
        byte byte0 = 0;
        int l1 = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;

        if (l1 == 0)
        {
            byte0 = 2;
        }

        if (l1 == 1)
        {
            byte0 = 5;
        }

        if (l1 == 2)
        {
            byte0 = 3;
        }

        if (l1 == 3)
        {
            byte0 = 4;
        }

        world.setBlockMetadataWithNotify(i, j, k, byte0);
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if (l == 1)
        {
            return CommonProxy.chestBottom;
        }

        if (l == 0)
        {
            return CommonProxy.chestBottom;
        }

        int i1 = iblockaccess.getBlockMetadata(i, j, k);

        if (l != i1)
        {
            return CommonProxy.chestSide;
        }
        else
        {
            return CommonProxy.chestFront;
        }
    }

    public int getBlockTextureFromSide(int i)
    {
        if (i == 1)
        {
            return CommonProxy.chestBottom;
        }

        if (i == 0)
        {
            return CommonProxy.chestBottom;
        }

        if (i == 3)
        {
            return CommonProxy.chestFront;
        }
        else
        {
            return CommonProxy.chestSide;
        }
    }

    private boolean isThereANeighborChest(World world, int i, int j, int k)
    {
        if (world.getBlockId(i, j, k) != blockID)
        {
            return false;
        }

        if (world.getBlockId(i - 1, j, k) == blockID)
        {
            return true;
        }

        if (world.getBlockId(i + 1, j, k) == blockID)
        {
            return true;
        }

        if (world.getBlockId(i, j, k - 1) == blockID)
        {
            return true;
        }
        else
        {
            return world.getBlockId(i, j, k + 1) == blockID;
        }
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
    	TileEntitymagnetic_chest tileentitymagnetic_chest = (TileEntitymagnetic_chest)world.getBlockTileEntity(i, j, k);

        if (tileentitymagnetic_chest != null)
        {
            for (int l = 0; l < tileentitymagnetic_chest.getSizeInventory(); l++)
            {
                ItemStack itemstack = tileentitymagnetic_chest.getStackInSlot(l);

                if (itemstack == null)
                {
                    continue;
                }

                float f = random.nextFloat() * 0.8F + 0.1F;
                float f1 = random.nextFloat() * 0.8F + 0.1F;
                float f2 = random.nextFloat() * 0.8F + 0.1F;

                while (itemstack.stackSize > 0)
                {
                    int i1 = random.nextInt(21) + 10;

                    if (i1 > itemstack.stackSize)
                    {
                        i1 = itemstack.stackSize;
                    }

                    itemstack.stackSize -= i1;
                    EntityItem entityitem = new EntityItem(world, (float)i + f, (float)j + f1, (float)k + f2, new ItemStack(itemstack.itemID, i1, itemstack.getItemDamage()));
                    float f3 = 0.05F;
                    entityitem.motionX = (float)random.nextGaussian() * f3;
                    entityitem.motionY = (float)random.nextGaussian() * f3 + 0.2F;
                    entityitem.motionZ = (float)random.nextGaussian() * f3;

                    if (itemstack.hasTagCompound())
                    {
                        entityitem.item.setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                    }

                    world.spawnEntityInWorld(entityitem);
                }
            }
        }


    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    	TileEntitymagnetic_chest tileentitymagnetic_chest = (TileEntitymagnetic_chest)world.getBlockTileEntity(i, j, k);

        if (tileentitymagnetic_chest == null)
        {
            return true;
        }

        if (world.isBlockNormalCube(i, j + 1, k))
        {
            return true;
        }

        if (world.getBlockId(i - 1, j, k) == blockID && world.isBlockNormalCube(i - 1, j + 1, k))
        {
            return true;
        }

        if (world.getBlockId(i + 1, j, k) == blockID && world.isBlockNormalCube(i + 1, j + 1, k))
        {
            return true;
        }

        if (world.getBlockId(i, j, k - 1) == blockID && world.isBlockNormalCube(i, j + 1, k - 1))
        {
            return true;
        }

        if (world.getBlockId(i, j, k + 1) == blockID && world.isBlockNormalCube(i, j + 1, k + 1))
        {
            return true;
        }

        if (world.isRemote)
        {
            return true;
        }
        else
        {
            entityplayer.displayGUIChest((IInventory)tileentitymagnetic_chest);
            return true;
        }
    }

    public TileEntity getBlockEntity()
    {
        return new TileEntitymagnetic_chest();
    }

    public void addCreativeItems(ArrayList itemList)
    {
    itemList.add(new ItemStack(this));
    }

	public TileEntity func_72274_a(World world)
	{
		return null;
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return null;
	}
}*/
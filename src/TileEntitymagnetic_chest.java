/*package cevicraft;

import net.minecraft.src.*;

import java.util.*;

public class TileEntitymagnetic_chest extends TileEntity implements IInventory
{
	private ItemStack[] chestContents = new ItemStack[36];
	public boolean adjacentChestChecked = false;
    public TileEntitymagnetic_chest adjacentChestZNeg;
    public TileEntitymagnetic_chest adjacentChestXPos;
    public TileEntitymagnetic_chest adjacentChestXNeg;
    public TileEntitymagnetic_chest adjacentChestZPos;
    public float lidAngle;
    public float prevLidAngle;
    public int numUsingPlayers;
    private int ticksSinceSync;
    public Random random;

    public int getSizeInventory()
    {
        return 27;
    }

    public ItemStack getStackInSlot(int par1)
    {
        return this.chestContents[par1];
    }

    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.chestContents[par1] != null)
        {
            ItemStack var3;

            if (this.chestContents[par1].stackSize <= par2)
            {
                var3 = this.chestContents[par1];
                this.chestContents[par1] = null;
                this.onInventoryChanged();
                return var3;
            }
            else
            {
                var3 = this.chestContents[par1].splitStack(par2);

                if (this.chestContents[par1].stackSize == 0)
                {
                    this.chestContents[par1] = null;
                }

                this.onInventoryChanged();
                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.chestContents[par1] != null)
        {
            ItemStack var2 = this.chestContents[par1];
            this.chestContents[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.chestContents[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }

        this.onInventoryChanged();
    }

    public String getInvName()
    {
        return "container.Magnetic Chest";
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.chestContents = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            int var5 = var4.getByte("Slot") & 255;

            if (var5 >= 0 && var5 < this.chestContents.length)
            {
                this.chestContents[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.chestContents.length; ++var3)
        {
            if (this.chestContents[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.chestContents[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void updateContainingBlockInfo()
    {
        super.updateContainingBlockInfo();
        this.adjacentChestChecked = false;
    }

    

    

    

    

    

    public TileEntitymagnetic_chest()
    {
        chestContents = new ItemStack[36];
        adjacentChestChecked = false;
        random = new Random();
    }

    public void addItem(ItemStack itemstack, EntityItem entityitem)
    {
        boolean flag = false;

        for (int i = 0; i < getSizeInventory(); i++)
        {
            ItemStack itemstack1 = chestContents[i];

            if (itemstack1 == null || itemstack1.itemID != itemstack.itemID || !itemstack1.isStackable() || !itemstack.isStackable())
            {
                continue;
            }

            int k = itemstack1.getMaxStackSize() - itemstack1.stackSize;
            int l = itemstack.stackSize;

            if (l <= k)
            {
                itemstack1.stackSize = itemstack1.stackSize + itemstack.stackSize;
                itemstack.stackSize -= itemstack.stackSize;
                worldObj.playSoundAtEntity(entityitem, "random.pop", 0.2F, ((random.nextFloat() - random.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            }

            if (l > k && k > 0)
            {
                itemstack.stackSize -= k;
                itemstack1.stackSize += k;
                worldObj.playSoundAtEntity(entityitem, "random.pop", 0.2F, ((random.nextFloat() - random.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            }
        }

        if (itemstack.stackSize == 0)
        {
            entityitem.setDead();
            return;
        }

        int j = getNextOpenSlot();

        if (j == -1)
        {
            return;
        }
        else
        {
            setInventorySlotContents(j, itemstack);
            entityitem.setDead();
            worldObj.playSoundAtEntity(entityitem, "random.pop", 0.2F, ((random.nextFloat() - random.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            return;
        }
    }

    public int getNextOpenSlot()
    {
        int i = -1;

        for (int j = getSizeInventory() - 1; j >= 0; j--)
        {
            ItemStack itemstack = chestContents[j];

            if (itemstack == null)
            {
                i = j;
            }
        }

        return i;
    }

    public void checkForAdjacentChests()
    {
        if (adjacentChestChecked)
        {
            return;
        }

        adjacentChestChecked = true;
        adjacentChestZNeg = null;
        adjacentChestXPos = null;
        adjacentChestXNeg = null;
        adjacentChestZPos = null;

        if (worldObj.getBlockId(xCoord - 1, yCoord, zCoord) == CommonProxy.b_magnetic_chest.blockID)
        {
            adjacentChestXNeg = (TileEntitymagnetic_chest)worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord);
        }

        if (worldObj.getBlockId(xCoord + 1, yCoord, zCoord) == CommonProxy.b_magnetic_chest.blockID)
        {
            adjacentChestXPos = (TileEntitymagnetic_chest)worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord);
        }

        if (worldObj.getBlockId(xCoord, yCoord, zCoord - 1) == CommonProxy.b_magnetic_chest.blockID)
        {
            adjacentChestZNeg = (TileEntitymagnetic_chest)worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1);
        }

        if (worldObj.getBlockId(xCoord, yCoord, zCoord + 1) == CommonProxy.b_magnetic_chest.blockID)
        {
            adjacentChestZPos = (TileEntitymagnetic_chest)worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1);
        }

        if (adjacentChestZNeg != null)
        {
            adjacentChestZNeg.updateContainingBlockInfo();
        }

        if (adjacentChestZPos != null)
        {
            adjacentChestZPos.updateContainingBlockInfo();
        }

        if (adjacentChestXPos != null)
        {
            adjacentChestXPos.updateContainingBlockInfo();
        }

        if (adjacentChestXNeg != null)
        {
            adjacentChestXNeg.updateContainingBlockInfo();
        }
    }

    public void updateEntity()
    {
        super.updateEntity();
        EntityPlayerSP entityplayersp = ModLoader.getMinecraftInstance().thePlayer;
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(entityplayersp, AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, (double)xCoord + 1.0D, (double)yCoord + 1.0D, (double)zCoord + 1.0D).expand(3D, 3D, 4D));

        if (!list.isEmpty())
        {
            for (int i = 0; i < list.size(); i++)
            {
                if (!((Entity)list.get(i) instanceof EntityItem))
                {
                    continue;
                }

                EntityItem entityitem = (EntityItem)list.get(i);
                double d1 = (double)xCoord + 0.5D;
                double d4 = (double)yCoord + 0.5D;
                double d6 = (double)zCoord + 0.5D;
                double d7 = d1 <= entityitem.posX ? -(entityitem.posX - d1) : d1 - entityitem.posX;
                double d8 = d4 <= entityitem.posY ? -(entityitem.posY - d4) : d4 - entityitem.posY;
                double d9 = d6 <= entityitem.posZ ? -(entityitem.posZ - d6) : d6 - entityitem.posZ;
                double d10 = 0.050000000000000003D;
                double d11 = entityitem.posX - d1;
                double d12 = entityitem.posZ - d6;
                double d13 = MathHelper.sqrt_double(d7 * d7 + d9 * d9);
                double d14 = Math.asin(d7 / d13);
                double d15 = (double)MathHelper.sin((float)d14) * d10;
                double d16 = (double)MathHelper.cos((float)d14) * d10;
                d16 = d9 <= 0.0D ? -d16 : d16;

                if ((double)MathHelper.abs((float)(entityitem.motionX + entityitem.motionY + entityitem.motionZ)) >= 0.10000000000000001D)
                {
                    continue;
                }

                if (d7 != 0.0D && (double)MathHelper.abs((float)entityitem.motionZ) < 0.10000000000000001D)
                {
                    entityitem.motionX = d15;
                }

                if (d9 != 0.0D && (double)MathHelper.abs((float)entityitem.motionZ) < 0.10000000000000001D)
                {
                    entityitem.motionZ = d16;
                }
            }
        }

        if ((++ticksSinceSync % 20) * 4 == 0);

        prevLidAngle = lidAngle;
        float f = 0.1F;

        if (numUsingPlayers > 0 && lidAngle == 0.0F && adjacentChestZNeg == null && adjacentChestXNeg == null)
        {
            double d = (double)xCoord + 0.5D;
            double d2 = (double)zCoord + 0.5D;

            if (adjacentChestZPos != null)
            {
                d2 += 0.5D;
            }

            if (adjacentChestXPos != null)
            {
                d += 0.5D;
            }

            worldObj.playSoundEffect(d, (double)yCoord + 0.5D, d2, "random.chestopen", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (numUsingPlayers == 0 && lidAngle > 0.0F || numUsingPlayers > 0 && lidAngle < 1.0F)
        {
            float f1 = lidAngle;

            if (numUsingPlayers > 0)
            {
                lidAngle += f;
            }
            else
            {
                lidAngle -= f;
            }

            if (lidAngle > 1.0F)
            {
                lidAngle = 1.0F;
            }

            float f2 = 0.5F;

            if (lidAngle < f2 && f1 >= f2 && adjacentChestZNeg == null && adjacentChestXNeg == null)
            {
                double d3 = (double)xCoord + 0.5D;
                double d5 = (double)zCoord + 0.5D;

                if (adjacentChestZPos != null)
                {
                    d5 += 0.5D;
                }

                if (adjacentChestXPos != null)
                {
                    d3 += 0.5D;
                }

                worldObj.playSoundEffect(d3, (double)yCoord + 0.5D, d5, "random.chestclosed", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (lidAngle < 0.0F)
            {
                lidAngle = 0.0F;
            }
        }
    }

    public void onTileEntityPowered(int i, int j)
    {
        if (i == 1)
        {
            numUsingPlayers = j;
        }
    }

    public void invalidate()
    {
        updateContainingBlockInfo();
        checkForAdjacentChests();
        super.invalidate();
    }

    public void openChest()
    {
    	++this.numUsingPlayers;
    	this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, CommonProxy.b_magnetic_chest.blockID, 1, this.numUsingPlayers);
    }

    public void closeChest()
    {
    	--this.numUsingPlayers;
    	this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, CommonProxy.b_magnetic_chest.blockID, 1, this.numUsingPlayers);
    }
}*/
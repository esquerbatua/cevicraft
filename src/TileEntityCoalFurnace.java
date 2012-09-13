package cevicraft;

import net.minecraft.src.*;

public class TileEntityCoalFurnace extends TileEntity implements IInventory
{
	private ItemStack ItemStacks[];
	public int BurnTime;
    private boolean isActive;
    public int ItemBurnTime;
    public int CookTime;
    public int front = 0;
    
    public TileEntityCoalFurnace()
    {
    	ItemStacks = new ItemStack[3];
        BurnTime = 0;
        ItemBurnTime = 0;
        CookTime = 0;
    }

    public void setFrontDirection(int x)
    {
    	this.front = x;
    }

    public ItemStack getStackInSlot(int par1)
    {
        return ItemStacks[par1];
    }

    public ItemStack decrStackSize(int par1, int par2)
    {
        if (ItemStacks[par1] != null)
        {
            if (ItemStacks[par1].stackSize <= par2)
            {
                ItemStack itemstack = ItemStacks[par1];
                ItemStacks[par1] = null;
                return itemstack;
            }
 
            ItemStack itemstack1 = ItemStacks[par1].splitStack(par2);
 
            if (ItemStacks[par1].stackSize == 0)
            {
                ItemStacks[par1] = null;
            }
 
            return itemstack1;
        }
        else
        {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (ItemStacks[par1] != null)
        {
            ItemStack itemstack = ItemStacks[par1];
            ItemStacks[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        ItemStacks[par1] = par2ItemStack;
 
        if (par2ItemStack != null && par2ItemStack.stackSize > getInventoryStackLimit())
        {
            par2ItemStack.stackSize = getInventoryStackLimit();
        }
    }

    public String getInvName()
    {
        return "container.Coal Furnace";
    }

    public int getFrontDirection()
    {
    	return this.front;
    }
    
    public int getSizeInventory()
    {
        return ItemStacks.length;
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
    	super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        ItemStacks = new ItemStack[getSizeInventory()];
 
        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound.getByte("Slot");
 
            if (byte0 >= 0 && byte0 < ItemStacks.length)
            {
                ItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
        front = par1NBTTagCompound.getInteger("FrontDirection");
        BurnTime = par1NBTTagCompound.getShort("BurnTime");
        CookTime = par1NBTTagCompound.getShort("CookTime");
        ItemBurnTime = getItemBurnTime(ItemStacks[1]);
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
    	super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("FrontDirection", (int)front);
        par1NBTTagCompound.setShort("BurnTime", (short)BurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)CookTime);
        NBTTagList nbttaglist = new NBTTagList();
 
        for (int i = 0; i < ItemStacks.length; i++)
        {
            if (ItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                ItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }
        par1NBTTagCompound.setTag("Items", nbttaglist);
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public int getCookProgressScaled(int par1)
    {
        return (CookTime * par1) / 200;
    }

    public int getBurnTimeRemainingScaled(int par1)
    {
        if (ItemBurnTime == 0)
        {
            ItemBurnTime = 200;
        }
 
        return (BurnTime * par1) / ItemBurnTime;
    }

    public boolean isBurning()
    {
        return BurnTime > 0;
    }

    public void updateEntity()
    {
        boolean var1 = this.BurnTime > 0;
        boolean var2 = false;

        if (this.BurnTime > 0)
        {
            --this.BurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.BurnTime == 0 && this.canSmelt())
            {
                this.ItemBurnTime = this.BurnTime = getItemBurnTime(this.ItemStacks[1]);

                if (this.BurnTime > 0)
                {
                    var2 = true;

                    if (this.ItemStacks[1] != null)
                    {
                        --this.ItemStacks[1].stackSize;

                        if (this.ItemStacks[1].stackSize == 0)
                        {
                            Item var3 = this.ItemStacks[1].getItem().getContainerItem();
                            this.ItemStacks[1] = var3 == null ? null : new ItemStack(var3);
                        }
                    }
                }
            }
            if (this.isBurning() && this.canSmelt())
            {
                ++this.CookTime;
                if (this.CookTime == 200)
                {
                    this.CookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.CookTime = 0;
            }
            if (var1 != this.BurnTime > 0)
            {
                var2 = true;
                this.validate();
            }
        }
        boolean check = isActive;
        isActive = isBurning();
        if(isActive != check)
        {
        	this.worldObj.markBlockNeedsUpdate(this.xCoord, this.yCoord, this.zCoord);
        }
        if (var2)
        {
            this.onInventoryChanged();
        }
    }

    private boolean canSmelt()
    {
        if (ItemStacks[0] == null)
        {
            return false;
        }
 
        ItemStack itemstack = RecipesCoalFurnace.smelting().getSmeltingResult(ItemStacks[0].getItem().shiftedIndex);
 
        if (itemstack == null)
        {
            return false;
        }
 
        if (ItemStacks[2] == null)
        {
            return true;
        }
 
        if (!ItemStacks[2].isItemEqual(itemstack))
        {
            return false;
        }
 
        if (ItemStacks[2].stackSize < getInventoryStackLimit() && ItemStacks[2].stackSize < ItemStacks[2].getMaxStackSize())
        {
            return true;
        }
 
        return ItemStacks[2].stackSize < itemstack.getMaxStackSize();
    }
 
    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = RecipesCoalFurnace.smelting().getSmeltingResult(this.ItemStacks[0].getItem().shiftedIndex);

            if (this.ItemStacks[2] == null)
            {
                this.ItemStacks[2] = var1.copy();
            }
            else if (this.ItemStacks[2].itemID == var1.itemID)
            {
                ++this.ItemStacks[2].stackSize;
            }

            --this.ItemStacks[0].stackSize;

            if (this.ItemStacks[0].stackSize == 0)
            {
                Item var2 = this.ItemStacks[0].getItem().getContainerItem();
                this.ItemStacks[0] = var2 == null ? null : new ItemStack(var2);
            }
        }
    }

    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    public static int getItemBurnTime(ItemStack par1ItemStack)
    {
        if (par1ItemStack == null)
        {
            return 0;
        }

        int i = par1ItemStack.getItem().shiftedIndex;

        if (i < 256 && Block.blocksList[i].blockMaterial == Material.wood)
        {
            return 300;
        }
        if (i == Item.stick.shiftedIndex)
        {
            return 100;
        }
        if (i == Item.coal.shiftedIndex)
        {
            return 1600;
        }
        if (i == Item.bucketLava.shiftedIndex)
        {
            return 20000;
        }
        if (i == Block.sapling.blockID)
        {
            return 100;
        }
        if (i == Item.blazeRod.shiftedIndex)
        {
            return 2400;
        }
        if (i == Block.dirt.blockID)
        {
        	return 200;
        }
        else
        {
            return ModLoader.addAllFuel(par1ItemStack.itemID, par1ItemStack.getItemDamage());
        }
    }

    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }
        return par1EntityPlayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
    }

	@Override
	public void openChest()
	{
	}

	@Override
	public void closeChest()
	{
	}

    public boolean isActive() 
	{
		return this.isActive;
	}
}
package cevicraft;

import java.util.*;

import net.minecraft.src.*;

public class ContainerCoalFurnace extends Container
{

	private TileEntityCoalFurnace CoalFurnace;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
 
    public ContainerCoalFurnace(InventoryPlayer par1InventoryPlayer, TileEntityCoalFurnace par2TileEntityCoalFurnace)
    {
        lastCookTime = 0;
        lastBurnTime = 0;
        lastItemBurnTime = 0;
        CoalFurnace = par2TileEntityCoalFurnace;
        addSlotToContainer(new Slot(par2TileEntityCoalFurnace, 0, 90, 56));
        addSlotToContainer(new Slot(par2TileEntityCoalFurnace, 1, 54, 56));
        addSlotToContainer(new SlotCoalFurnace(par1InventoryPlayer.player, par2TileEntityCoalFurnace, 2, 51, 17));
 
        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 9; k++)
            {
            	addSlotToContainer(new Slot(par1InventoryPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }
 
        for (int j = 0; j < 9; j++)
        {
        	addSlotToContainer(new Slot(par1InventoryPlayer, j, 8 + j * 18, 142));
        }
    }
 
    /**
     * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
     */
    public void updateCraftingResults()
    {
        super.updateCraftingResults();
        Iterator var1 = this.crafters.iterator();

        while (var1.hasNext())
        {
            ICrafting var2 = (ICrafting)var1.next();

            if (this.lastCookTime != this.CoalFurnace.CookTime)
            {
                var2.updateCraftingInventoryInfo(this, 0, this.CoalFurnace.CookTime);
            }

            if (this.lastBurnTime != this.CoalFurnace.BurnTime)
            {
                var2.updateCraftingInventoryInfo(this, 1, this.CoalFurnace.BurnTime);
            }

            if (this.lastItemBurnTime != this.CoalFurnace.ItemBurnTime)
            {
                var2.updateCraftingInventoryInfo(this, 2, this.CoalFurnace.ItemBurnTime);
            }
        }
        this.lastCookTime = this.CoalFurnace.CookTime;
        this.lastBurnTime = this.CoalFurnace.BurnTime;
        this.lastItemBurnTime = this.CoalFurnace.ItemBurnTime;
    }
    
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
        	CoalFurnace.CookTime = par2;
        }
 
        if (par1 == 1)
        {
        	CoalFurnace.BurnTime = par2;
        }
 
        if (par1 == 2)
        {
        	CoalFurnace.ItemBurnTime = par2;
        }
    }
 
    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return CoalFurnace.isUseableByPlayer(par1EntityPlayer);
    }
 
    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    public ItemStack transferStackInSlot(int par1)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(par1);
 
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
 
            if (par1 == 2)
            {
                if (!mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }
 
                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par1 == 1 || par1 == 0)
            {
                if (!mergeItemStack(itemstack1, 3, 39, false))
                {
                    return null;
                }
            }
            else if (RecipesCoalFurnace.smelting().getSmeltingResult(itemstack1.getItem().shiftedIndex) != null)
            {
                if (!mergeItemStack(itemstack1, 0, 1, false))
                {
                    return null;
                }
            }
            else if (TileEntityCoalFurnace.isItemFuel(itemstack1))
            {
                if (!mergeItemStack(itemstack1, 1, 2, false))
                {
                    return null;
                }
            }
            else if (par1 >= 3 && par1 < 30)
            {
                if (!mergeItemStack(itemstack1, 30, 39, false))
                {
                    return null;
                }
            }
            else if (par1 >= 30 && par1 < 39 && !mergeItemStack(itemstack1, 3, 30, false))
            {
                return null;
            }
 
            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
 
            if (itemstack1.stackSize != itemstack.stackSize)
            {
                slot.onPickupFromSlot(itemstack1);
            }
            else
            {
                return null;
            }
        }
 
        return itemstack;
    }
}
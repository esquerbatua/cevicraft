/*package cevicraft;

import java.util.*;
import net.minecraft.src.*;

public class ContainerCoalWorkbench extends Container
{

    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerCoalWorkbench(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
    {
        craftMatrix = new InventoryCrafting(this, 4, 4);
        craftResult = new InventoryCraftResult();
        worldObj = par2World;
        posX = par3;
        posY = par4;
        posZ = par5;
        func_75146_a(new SlotCrafting(par1InventoryPlayer.player, craftMatrix, craftResult, 0, 124, 35));

        for (int i = 0; i < 4; i++)
        {
            for (int l = 0; l < 4; l++)
            {
            	func_75146_a(new Slot(craftMatrix, l + i * 4, 23 + l * 18, 17 + i * 18));
            }
        }

        for (int j = 0; j < 3; j++)
        {
            for (int i1 = 0; i1 < 9; i1++)
            {
            	func_75146_a(new Slot(par1InventoryPlayer, i1 + j * 9 + 9, 8 + i1 * 18, 102 + j * 18));
            }
        }

        for (int k = 0; k < 9; k++)
        {
        	func_75146_a(new Slot(par1InventoryPlayer, k, 8 + k * 18, 160));
        }

        onCraftMatrixChanged(craftMatrix);
    }

	public void onCraftMatrixChanged(IInventory par1IInventory)
    {
        craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(craftMatrix));
    }

    public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
    {
        super.onCraftGuiClosed(par1EntityPlayer);

        if (worldObj.isRemote)
        {
            return;
        }

        for (int i = 0; i < 16; i++)
        {
            ItemStack itemstack = craftMatrix.getStackInSlotOnClosing(i);

            if (itemstack != null)
            {
                par1EntityPlayer.dropPlayerItem(itemstack);
            }
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        if (worldObj.getBlockId(posX, posY, posZ) != mod_cevi.b_coalworkbench.blockID)
        {
            return false;
        }
        else
        {
        return par1EntityPlayer.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64D;
        }
    }


    public ItemStack transferStackInSlot(int par1)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(par1);
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (par1 == 0)
            {
                if (!mergeItemStack(itemstack1, 17, 53, true))
                {
                    return null;
                }
            } else
            if (par1 > 16 && par1 <= 52)
            {
                if (!mergeItemStack(itemstack1, 1, 17, false))
                {
                    return null;
                }
            } else
            if (!mergeItemStack(itemstack1, 17, 53, false))
            {
            	return null;
            }
            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            } else
            {
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize != itemstack.stackSize)
            {
                slot.onPickupFromSlot(itemstack1);
            } else
            {
                return null;
            }
        }
        return itemstack;
    }
}*/
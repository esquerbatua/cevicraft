/*package net.minecraft.src;

import net.minecraft.src.*;

public class wood_throw extends Item
{

    public wood_throw(int par1)
    {
        super(par1);
        maxStackSize = 64;
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if(!par3EntityPlayer.capabilities.isCreativeMode)
            par1ItemStack.stackSize--;
        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 2.0F, 1.6F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if(!par2World.isRemote)
            par2World.spawnEntityInWorld(new Entitywood_throw(par2World, par3EntityPlayer));
        return par1ItemStack;
    }
}*/
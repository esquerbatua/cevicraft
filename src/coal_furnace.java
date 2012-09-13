package cevicraft;

import java.util.*;
import net.minecraft.src.*;

public class coal_furnace extends BlockContainer
{
	private static boolean keepInventory = false;
	private Random furnaceRand;


    protected coal_furnace(int x, boolean active)
    {
    	super(x, Material.rock);
    	furnaceRand = new Random();
    	this.setRequiresSelfNotify();
    	this.setCreativeTab(CreativeTabs.tabDeco);
    }

    public TileEntity createNewTileEntity(World world)
    {
    	return new TileEntityCoalFurnace();
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
   	 super.onBlockAdded(par1World, par2, par3, par4);
   	 setDefaultDirection(par1World, par2, par3, par4);
   }

    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
    	TileEntity blockEntity = par1World.getBlockTileEntity(par2, par3, par4);
    	if(par1World.isRemote)
    	{
    		return;
    	}
    	
    	int i = par1World.getBlockId(par2, par3, par4 - 1);
    	int j = par1World.getBlockId(par2, par3, par4 + 1);
    	int k = par1World.getBlockId(par2 - 1, par3, par4);
    	int l = par1World.getBlockId(par2 + 1, par3, par4);
    	byte byte0 = 3;
    	
    	if(Block.opaqueCubeLookup[i] && !Block.opaqueCubeLookup[j])
    	{
    		byte0 = 3;
    	}
    	if(Block.opaqueCubeLookup[j] && !Block.opaqueCubeLookup[i])
    	{
    		byte0 = 2;
    	}
    	if(Block.opaqueCubeLookup[k] && !Block.opaqueCubeLookup[l])
    	{
    		byte0 = 5;
    	}
    	if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[k])
    	{
    		byte0 = 4;
    	}
    	((TileEntityCoalFurnace)blockEntity).setFrontDirection(byte0);
    }

    public int getBlockTexture(IBlockAccess access, int x, int y, int z, int side)
    {
    	int front = 0;
    	
    	TileEntity tile = ModLoader.getMinecraftInstance().getIntegratedServer().theWorldServer[0].getBlockTileEntity(x, y, z);
    	
    	if(tile != null)
    	{
    		front = ((TileEntityCoalFurnace)tile).getFrontDirection();
    	}
    	else
    	{
    		ModLoader.getMinecraftInstance().getIntegratedServer().theWorldServer[0].markBlockAsNeedsUpdate(x, y, z);
    	}
    	switch(side)
    	{
    	case 0: return 0/*bottom*/;
    	case 1: return 1/*top*/;
    	default: if(side == front)
	    	{
	    		return /**front**/ 1;
	    	}
	    	else
	    	{
	    		return /**side**/ 1;
	    	}
    	}
    }

    public int getBlockTextureFromSide(int side)
    {
    	switch(side)
    	{
    	default: return 0 ;
    	case 0: return 0 /**bottom**/;
    	case 1: return 0 /**top**/;
    	case 2: return 0 /**side**/;
    	case 3: return 0 /**front**/;
    	case 4: return 0 /**side**/;
    	case 5: return 0 /**side**/;
    	}
    }

    @Override
    public void onBlockPlacedBy(World w, int x, int y, int z, EntityLiving entity)
    {
		int var = MathHelper.floor_double((double)(entity.rotationYaw *4.0F / 360.0F) + 0.5D) & 3;
		
		TileEntity blockEntity = (TileEntity) w.getBlockTileEntity(x, y, z);
		switch(var)
		{
		case 0: ((TileEntityCoalFurnace)blockEntity).setFrontDirection(2); break;
		case 1: ((TileEntityCoalFurnace)blockEntity).setFrontDirection(5); break;
		case 2: ((TileEntityCoalFurnace)blockEntity).setFrontDirection(3); break;
		case 3: ((TileEntityCoalFurnace)blockEntity).setFrontDirection(4); break;	
		}
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float a, float b, float c)
    {
    	TileEntityCoalFurnace coal = (TileEntityCoalFurnace)world.getBlockTileEntity(x, y, z);

	    if(player instanceof EntityPlayerMP)
	    {
	    ModLoader.serverOpenWindow((EntityPlayerMP)player, new ContainerCoalFurnace(player.inventory,coal), CommonProxy.CoalFurnaceGUIid, x, y, z);
	    }
	    else
	    {
	    ModLoader.openGUI((EntityPlayerSP)player, new GuiCoalFurnace(player.inventory, (TileEntityCoalFurnace)player.worldObj.getBlockTileEntity(x, y, z)));
	    }
	    return true;
    }

    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (!keepInventory)
        {
            TileEntityCoalFurnace coal = (TileEntityCoalFurnace)par1World.getBlockTileEntity(par2, par3, par4);

            if (coal != null)
            {
                for (int var8 = 0; var8 < coal.getSizeInventory(); ++var8)
                {
                    ItemStack item = coal.getStackInSlot(var8);

                    if (item != null)
                    {
                        float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float var11 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float var12 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (item.stackSize > 0)
                        {
                            int var13 = this.furnaceRand.nextInt(21) + 10;

                            if (var13 > item.stackSize)
                            {
                                var13 = item.stackSize;
                            }

                            item.stackSize -= var13;
                            EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(item.itemID, var13, item.getItemDamage()));

                            if (item.hasTagCompound())
                            {
                                var14.item.setTagCompound((NBTTagCompound)item.getTagCompound().copy());
                            }

                            float var15 = 0.05F;
                            var14.motionX = (double)((float)this.furnaceRand.nextGaussian() * var15);
                            var14.motionY = (double)((float)this.furnaceRand.nextGaussian() * var15 + 0.2F);
                            var14.motionZ = (double)((float)this.furnaceRand.nextGaussian() * var15);
                            par1World.spawnEntityInWorld(var14);
                        }
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
}
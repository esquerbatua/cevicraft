package cevicraft;

import static net.minecraftforge.common.ForgeDirection.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;
import net.minecraftforge.common.ForgeDirection;

public class fast_sand extends Block
{
    public fast_sand(int par1, int par2)
    {
        super(par1, Material.sand);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.blockIndexInTexture = par2;
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float var5 = 0.125F;
        return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par2, (double)par3, (double)par4, (double)(par2 - 0), (double)((float)(par3 + 0) - var5), (double)(par4 + 0));
    }

    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionX /= 0.85D;
        par5Entity.motionY /= 0.9D;
        par5Entity.motionZ /= 0.85D;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
    {
        ForgeDirection dir = ForgeDirection.getOrientation(par5);
        return (dir == DOWN  && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN )) ||
               (dir == UP    && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP   )) ||
               (dir == NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH)) ||
               (dir == SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH)) ||
               (dir == WEST  && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST )) ||
               (dir == EAST  && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ));
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ) ||
               par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST ) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH) ||
               par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP   ) ||
               par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN );
    }

    public int func_85104_a(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int var11 = par9 & 8;
        int var10 = par9 & 7;
        var10 = -1;

        if (par5 == 0 && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN))
        {
            var10 = par1World.rand.nextBoolean() ? 0 : 7;
        }

        if (par5 == 1 && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP))
        {
            var10 = 5 + par1World.rand.nextInt(2);
        }

        if (par5 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH))
        {
            var10 = 4;
        }

        if (par5 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH))
        {
            var10 = 3;
        }

        if (par5 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST))
        {
            var10 = 2;
        }

        if (par5 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST))
        {
            var10 = 1;
        }

        return var10 + var11;
    }

    public static int invertMetadata(int par0)
    {
        switch (par0)
        {
            case 0:
                return 0;
            case 1:
                return 5;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 2;
            case 5:
                return 1;
            default:
                return -1;
        }
    }

    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int var5 = par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 7;

        if (var5 == 1)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.125F, 1.0F, 1.0F);
        }
        else if (var5 == 2)
        {
            this.setBlockBounds(0.875F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        else if (var5 == 3)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.125F);
        }
        else if (var5 == 4)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.875F, 1.0F, 1.0F, 1.0F);
        }
        else if (var5 != 5 && var5 != 6)
        {
            if (var5 == 0 || var5 == 7)
            {
                this.setBlockBounds(0.0F, 0.875F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        }
    }

    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if ((par6 & 8) > 0)
        {
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
            int var7 = par6 & 7;

            if (var7 == 1)
            {
                par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
            }
            else if (var7 == 2)
            {
                par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
            }
            else if (var7 == 3)
            {
                par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
            }
            else if (var7 == 4)
            {
                par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
            }
            else if (var7 != 5 && var7 != 6)
            {
                if (var7 == 0 || var7 == 7)
                {
                    par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.blockID);
                }
            }
            else
            {
                par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
            }
        }
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/blocks.png";
    }
}
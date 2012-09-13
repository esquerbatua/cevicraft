package cevicraft;

import net.minecraft.src.*;
import java.util.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class coal_block extends Block
{

    public coal_block(int par1, int par2)
    {
        super(par1, Material.rock);
        this.blockIndexInTexture = par2;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public int idDropped(int i, Random random, int j)
    {
        return Item.coal.shiftedIndex;
    }

    public int quantityDropped(Random random)
    {
        return 9;
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/blocks.png";
    }
}
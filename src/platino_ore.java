package cevicraft;

import net.minecraft.src.*;
import java.util.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class platino_ore extends Block
{

    public platino_ore(int par1, int par2)
    {
        super(par1, Material.iron);
        this.blockIndexInTexture = par2;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/blocks.png";
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }
}
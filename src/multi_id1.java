package cevicraft;

import java.util.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class multi_id1 extends Block
{
	int  redstone_block = 17, redstone_brick = 18, lapislazuli_brick = 19;

    public multi_id1(int i)
    {
        super(i, Material.rock);
        setBlockName("multi_id1");
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
	{
        switch (j)
        {
        default:
        	return 0;
        case 0:
        	return redstone_block;
        case 1:
        	return redstone_brick;
        case 2:
        	return lapislazuli_brick;
        }
        
	}

    public int damageDropped(int i)
    {
    	return i;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/multi_id1.png";
    }
}
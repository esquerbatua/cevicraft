package cevicraft;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import java.util.List;
import cevicraft.*;
import net.minecraft.src.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class multi_id1_item extends ItemBlock
{
	public multi_id1_item(int par1)
	{
		super(par1);
		this.setHasSubtypes(true);
		setItemName("multi_id1");
	}

	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int par1)
	{
		return CommonProxy.b_multi_id1.getBlockTextureFromSideAndMetadata(16, par1);
	}
	
	public int getMetadata(int par1)
	{
		return par1;
	}

	public String getItemNameIS(ItemStack i)
	{
		switch(i.getItemDamage())
		{
		default: return "";
		case 0: return "Redstone block";
		case 1: return "Redstone brick";
		case 2: return "Lapislazuli brick";
		}
	}
}
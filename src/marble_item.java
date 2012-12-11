package cevicraft;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import java.util.List;
import cevicraft.*;
import net.minecraft.src.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class marble_item extends ItemBlock
{
	public marble_item(int i)
	{
		super(i);
		setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public String getItemNameIS(ItemStack i)
	{
		switch(i.getItemDamage())
		{
		default: return "";
		case 0: return "Marble white";
		case 1: return "Marble orange";
		case 2: return "Marble magenta";
		case 3: return "Marble light blue";
		case 4: return "Marble yellow";
		case 5: return "Marble lime";
		case 6: return "Marble pink";
		case 7: return "Marble gray";
		case 8: return "Marble light gray";
		case 9: return "Marble cyan";
		case 10: return "Marble purple";
		case 11: return "Marble blue";
		case 12: return "Marble brown";
		case 13: return "Marble green";
		case 14: return "Marble red";
		case 15: return "Marble black";
		case 16: return "prueba0";
		case 17: return "prueba1";
		}
	}
	
	public int getMetadata(int i)
	{
		return i;
	}
}
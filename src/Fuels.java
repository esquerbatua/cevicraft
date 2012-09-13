package cevicraft;

import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class Fuels implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if(fuel.itemID==CommonProxy.b_coal_block.blockID)
		{
			return 14400;
		}
		else
		{
			return 0;
		}

	}

}
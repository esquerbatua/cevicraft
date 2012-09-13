package cevicraft;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class part_of_the_wand_of_the_mob extends Item
{

    public part_of_the_wand_of_the_mob(int i)
    {
        super(i);
        maxStackSize = 64;
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
	{
		return "/cevicraft/items.png";
	}
}
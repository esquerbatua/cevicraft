package cevicraft;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class platino_ingot extends Item
{

    public platino_ingot(int i)
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
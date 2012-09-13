package cevicraft;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class plutonio extends Item
{

    public plutonio(int i)
    {
        super(i);
        maxStackSize = 64;
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/items.png";
    }
    
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1)
    {
    	return EnumRarity.rare;
    }
}
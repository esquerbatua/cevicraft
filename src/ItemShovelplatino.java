package cevicraft;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class ItemShovelplatino extends ItemToolcevi
{

    public ItemShovelplatino(int i, EnumToolcevi enumtoolcevi)
    {
        super(i, 1, enumtoolcevi, blocksEffectiveAgainst);
    }

    public boolean canHarvestBlock(Block block)
    {
        if(block == Block.snow)
            return true;
        return block == Block.blockSnow;
    }

    private static Block blocksEffectiveAgainst[];

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField
        });
    }
    
    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/items.png";
    }
}
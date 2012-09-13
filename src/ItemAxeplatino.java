package cevicraft;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class ItemAxeplatino extends ItemToolcevi
{
	private static final Block blocksEffectiveAgainst[] = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.fence, Block.fenceGate, /*mod_cevi.b_fir_log, mod_cevi.b_magnetic_chest*/};

    protected ItemAxeplatino(int i, EnumToolcevi enumtoolcevi)
    {
        super(i, 3, enumtoolcevi, blocksEffectiveAgainst);
        maxStackSize = 1;
        setMaxDamage(enumtoolcevi.getMaxUses());
    }

    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && par2Block.blockMaterial == Material.wood ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }

    public boolean isFull3D()
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/items.png";
    }
}
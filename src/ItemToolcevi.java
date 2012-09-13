package cevicraft;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class ItemToolcevi extends Item
{

    protected ItemToolcevi(int i, int j, EnumToolcevi enumtoolcevi, Block ablock[])
    {
        super(i);
        efficiencyOnProperMaterial = 5F;
        toolMaterial = enumtoolcevi;
        blocksEffectiveAgainst = ablock;
        maxStackSize = 1;
        setMaxDamage(enumtoolcevi.getMaxUses());
        efficiencyOnProperMaterial = enumtoolcevi.getEfficiencyOnProperMaterial();
        damageVsEntity = j + enumtoolcevi.getDamageVsEntity();
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        for(int i = 0; i < blocksEffectiveAgainst.length; i++)
            if(blocksEffectiveAgainst[i] == block)
                return efficiencyOnProperMaterial;

        return 1.0F;
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(2, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(1, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return damageVsEntity;
    }

    public boolean isFull3D()
    {
        return true;
    }

    private Block blocksEffectiveAgainst[];
    protected float efficiencyOnProperMaterial;
    private int damageVsEntity;
    protected EnumToolcevi toolMaterial;
}
package cevicraft;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class ItemSwordplatino extends Item
{

    public ItemSwordplatino(int i, EnumToolcevi enumtoolcevi)
    {
        super(i);
        this.field_40439_b = enumtoolcevi;
        this.maxStackSize = 1;
        this.setMaxDamage(enumtoolcevi.getMaxUses());
        this.weaponDamage = 5 + enumtoolcevi.getDamageVsEntity();
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return block.blockID == Block.web.blockID ? 15F : 1.5F;
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(1, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(2, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return weaponDamage;
    }

    public boolean isFull3D()
    {
        return true;
    }

    public EnumAction getItemUseAction(ItemStack itemstack)
    {
        return EnumAction.block;
    }

    public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 0x11940;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        entityplayer.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
        return itemstack;
    }

    public boolean canHarvestBlock(Block block)
    {
        return block.blockID == Block.web.blockID;
    }

    public int getItemEnchantability()
    {
        return field_40439_b.getEnchantability();
    }

    private int weaponDamage;
    private final EnumToolcevi field_40439_b;

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/items.png";
    }
}
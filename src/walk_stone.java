package cevicraft;

import net.minecraft.src.*;

import java.util.*;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class walk_stone extends Block
{

    public walk_stone(int par1, int par2)
    {
        super(par1, Material.rock);
        this.blockIndexInTexture = par2;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Block.cobblestone.blockID;
    }

    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity entity)
    {
        if (!par1World.isRemote)
        {
            EntitySilverfish var = new EntitySilverfish(par1World);
            var.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(var);
            var.spawnExplosionParticle();

            EntityXPOrb var1 = new EntityXPOrb(par1World);
            var1.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 1.0F, 1.0F);
            par1World.spawnEntityInWorld(var1);

            EntityChicken var2 = new EntityChicken(par1World);
            var2.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(var2);
            var2.spawnExplosionParticle();
            par1World.setBlockWithNotify(par2, par3, par4, 0);
        }
        super.onEntityWalking(par1World, par2, par3, par4, entity);
    }
    
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            EntitySilverfish var6 = new EntitySilverfish(par1World);
            var6.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(var6);
            var6.spawnExplosionParticle();
        }

        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }
}
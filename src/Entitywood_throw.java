/*package cevicraft;

import net.minecraft.src.*;

public class Entitywood_throw extends EntityThrowable
{

    public Entitywood_throw(World par1World)
    {
        super(par1World);
    }

    public Entitywood_throw(World par1World, EntityLiving par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public Entitywood_throw(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if(par1MovingObjectPosition.entityHit != null)
        {
            byte byte0 = 0;
            if(par1MovingObjectPosition.entityHit instanceof EntityBlaze)
                byte0 = 3;
            if(par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, thrower), byte0));
            for(int i = 0; i < 8; i++)
                worldObj.spawnParticle("snowballpoof", posX, posY, posZ, 0.0D, 0.0D, 0.0D);

            if(!worldObj.isRemote)
                setDead();
        }
    }
}*/
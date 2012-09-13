/*package cevicraft;

import net.minecraft.src.*;

public abstract class Entitymobilemagnetchest extends EntityMob
{
    private int randomTickDivider;
    private boolean isMatingFlag;
    private boolean isPlayingFlag;
    Village villageObj;

    public Entitymobilemagnetchest(World par1World)
    {
        this(par1World, 0);
    }

    public Entitymobilemagnetchest(World par1World, int par2)
    {
        super(par1World);
        this.texture = "/cevi/mob/mobilemagnetchest.png";
        randomTickDivider = 0;
        isMatingFlag = false;
        isPlayingFlag = false;
        villageObj = null;
        moveSpeed = 0.5F;
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIAvoidEntity(this, net.minecraft.src.EntityZombie.class, 8F, 0.3F, 0.35F));
        tasks.addTask(2, new EntityAIMoveIndoors(this));
        tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        tasks.addTask(4, new EntityAIOpenDoor(this, true));
        tasks.addTask(5, new EntityAIMoveTwardsRestriction(this, 0.3F));
     
        tasks.addTask(9, new EntityAIWatchClosest2(this, net.minecraft.src.EntityPlayer.class, 3F, 1.0F));
        tasks.addTask(9, new EntityAIWatchClosest2(this, net.minecraft.src.EntityVillager.class, 5F, 0.02F));
        tasks.addTask(9, new EntityAIWander(this, 0.3F));
        tasks.addTask(10, new EntityAIWatchClosest(this, net.minecraft.src.EntityLiving.class, 8F));
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, Integer.valueOf(0));
    }

    public int getMaxHealth()
    {
        return 20;
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    protected boolean canDespawn()
    {
        return false;
    }

    public void setAttackTarget(EntityLiving par1EntityLiving)
    {
        super.setAttackTarget(par1EntityLiving);
    }
}*/
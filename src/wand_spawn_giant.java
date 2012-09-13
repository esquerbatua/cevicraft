package cevicraft;

import net.minecraft.src.*;
import java.util.*;

public class wand_spawn_giant extends Item
{
        public wand_spawn_giant(int i)
        {
                super(i);
                maxStackSize = 1;
                setMaxDamage(10);
        }
   private World worldObj;

   public boolean onItemUse (ItemStack itemstack, EntityPlayer entityplayer, World world, int i ,int j, int k, int l){
	   if(!world.isRemote)
	   {
		   EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName("Giant", entityplayer.worldObj);
		   entityliving.setLocationAndAngles(i, j + 1, k, 0F, 0F);
		   entityplayer.worldObj.spawnEntityInWorld(entityliving);
		   entityplayer.swingItem();
	   }
   
	   return true;
   
   
   }
}
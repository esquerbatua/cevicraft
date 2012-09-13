package cevicraft;

import net.minecraft.src.*;
import java.util.*;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class wand_spawn_enderdragon extends Item
{
        public wand_spawn_enderdragon(int i)
        {
                super(i);
                maxStackSize = 1;
                setMaxDamage(10);
        }

   private World worldObj;

   public boolean onItemUse (ItemStack itemstack, EntityPlayer entityplayer, World world, int i ,int j, int k, int l){
	   if(!world.isRemote)
	   {
		   EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName("EnderDragon", entityplayer.worldObj);
		   entityliving.setLocationAndAngles(i, j + 20, k, 0F, 0F);
		   entityplayer.worldObj.spawnEntityInWorld(entityliving);
		   entityplayer.swingItem();
	   }
	   return true;
   }
   
   @SideOnly(Side.CLIENT)
   public String getTextureFile()
   {
       return "/cevicraft/items.png";
   }
}
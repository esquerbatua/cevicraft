/*package cevicraft;

import net.minecraft.src.*;
import org.lwjgl.opengl.*;

public class Rendermobilemagnetchest extends RenderLiving
{
	protected Modelmobilemagnetchest field_40295_c;
    public Rendermobilemagnetchest(Modelmobilemagnetchest modelDeadmau5, float f)
    {
        super(modelDeadmau5, f);
        field_40295_c = (Modelmobilemagnetchest)mainModel;
    }

    public void rendermobilemagnetchest(Entitymobilemagnetchest entity, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving(entity, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving((Entitymobilemagnetchest) entityliving, d, d1, d2, f, f1);
    }

    protected void func_40291_a(Entitymobilemagnetchest par1Entitymobilemagnetchest, float par2)
    {
        super.renderEquippedItems(par1Entitymobilemagnetchest, par2);
    }

    protected void func_40290_a(Entitymobilemagnetchest entitymobilemagnetchest, double d, double d1, double d2)
    {
    	
    }

    protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2)
    {
        func_40291_a((Entitymobilemagnetchest)par1EntityLiving, par2);
    }

    protected void preRenderScale(Entitymobilemagnetchest entity, float f)
    {
        GL11.glScalef(1.0F, 1.0F, 1.0F);
    }

    protected void func_40292_b(Entitymobilemagnetchest par1Entitymobilemagnetchest, float par2)
    {
        float f = 0.9375F;
        shadowSize = 0.5F;
        GL11.glScalef(f, f, f);
    }

    protected void passSpecialRender(EntityLiving par1EntityLiving, double par2, double par4, double par6)
    {
        func_40290_a((Entitymobilemagnetchest)par1EntityLiving, par2, par4, par6);
    }

    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        func_40292_b((Entitymobilemagnetchest)par1EntityLiving, par2);
    }
}*/
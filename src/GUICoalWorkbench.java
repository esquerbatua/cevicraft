/*package cevicraft;

import net.minecraft.src.*;
import org.lwjgl.opengl.GL11;

public class GUICoalWorkbench extends GuiContainer
{
	static final int m_iGuiHeight = 184;

        public GUICoalWorkbench(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
        {
            super(new ContainerWorkbench(par1InventoryPlayer, par2World, par3, par4, par5));
            ySize = 184;
        }

    public void onGuiClosed()
    {
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString(StatCollector.translateToLocal("container.crafting"), 22, 6, 0x404040);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int i = mc.renderEngine.getTexture("/gui/crafting.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
    }
}*/
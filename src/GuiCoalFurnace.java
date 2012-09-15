package cevicraft;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import org.lwjgl.opengl.GL11;

public class GuiCoalFurnace extends GuiContainer
{

    private TileEntityCoalFurnace coalfurnaceInventory;

    public GuiCoalFurnace(InventoryPlayer inventoryplayer, TileEntityCoalFurnace tileentitycoalfurnace)
    {
        super(new ContainerCoalFurnace(inventoryplayer, tileentitycoalfurnace));
        coalfurnaceInventory = tileentitycoalfurnace;
    }

    protected void drawGuiContainerForegroundLayer()
    {
    	fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96) + 2, 0xffffff);
    }
    
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        int k = mc.renderEngine.getTexture("/cevi/Coalfurnace.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(k);
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
        if(coalfurnaceInventory.isBurning())
        {
            int j1 = coalfurnaceInventory.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(l + 56, (i1 + 36 + 12) - j1, 176, 12 - j1, 14, j1 + 2);
        }
        int k1 = coalfurnaceInventory.getCookProgressScaled(24);
        drawTexturedModalRect(l + 79, i1 + 34, 176, 14, k1 + 1, 16);
    }
}
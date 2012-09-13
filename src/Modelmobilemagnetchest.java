/*package cevicraft;

import net.minecraft.src.*;
import java.util.*;

public class Modelmobilemagnetchest extends ModelBase
{
    ModelRenderer body;
    ModelRenderer i;
    ModelRenderer d;
  
  public Modelmobilemagnetchest()
  {
    textureWidth = 100;
    textureHeight = 50;
    
      body = new ModelRenderer(this, 18, 4);
      body.addBox(-6F, -10F, -7F, 15, 16, 16);
      body.setRotationPoint(-2F, 17F, 2F);
      body.setTextureSize(100, 50);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      i = new ModelRenderer(this, 0, 16);
      i.addBox(-3F, 0F, -2F, 1, 16, 8);
      i.setRotationPoint(10F, 8F, -6F);
      i.setTextureSize(100, 50);
      i.mirror = true;
      setRotation(i, 0F, 0F, 0F);
      d = new ModelRenderer(this, 0, 16);
      d.addBox(-1F, 0F, -2F, 1, 16, 8);
      d.setRotationPoint(8F, 8F, 2F);
      d.setTextureSize(100, 50);
      d.mirror = true;
      setRotation(d, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    body.render(f5);
    i.render(f5);
    d.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }
}*/
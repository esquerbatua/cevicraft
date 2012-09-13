package cevicraft;

import net.minecraft.src.*;
import java.util.*;

public class marble_light_blue extends Block
{

    public marble_light_blue(int par1, int par2)
    {
        super(par1, par2, Material.rock);
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }
}
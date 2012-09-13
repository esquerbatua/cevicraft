package cevicraft;

import net.minecraft.src.*;
import java.util.*;

public class marble_red extends Block
{

    public marble_red(int par1, int par2)
    {
        super(par1, par2, Material.rock);
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }
}
package cevicraft;

import net.minecraft.src.*;
import java.util.*;

public class marble_yellow extends Block
{

    public marble_yellow(int par1, int par2)
    {
        super(par1, par2, Material.rock);
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }
}
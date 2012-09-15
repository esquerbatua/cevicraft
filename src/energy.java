package cevicraft;

import net.minecraft.src.*;
import java.util.*;

public class energy
{
	public int id;
	public int voltios;

	public energy(int ID)
	{
		this.id = 0;
	}
	
	public void createid()
	{
		id++;
	}

	int[] ID = new int[id];
	boolean[] IDused = new boolean[id];
}
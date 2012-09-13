package cevicraft;

import java.util.*;
import net.minecraft.src.*;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerations implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.worldType)
		{
		case -1: generateNether(world, random,chunkX*16,chunkZ*16);
		case 0 : generateSurface(world, random,chunkX*16,chunkZ*16);
		case 1: generateEnd(world, random,chunkX*16,chunkZ*16); break;
		}
	}

	private void generateSurface(World world, Random rand, int y, int z)
	{
		for(int a = 0; a < 5; a++)
        {
            int randPosX = y + rand.nextInt(16);
            int randPosY = rand.nextInt(40);
            int randPosZ = z + rand.nextInt(16);
            (new WorldGenMinable(CommonProxy.b_platino_ore.blockID, (int)(Math.random() * 1D + 5D))).generate(world, rand, randPosX, randPosY, randPosZ);
        }

        for(int a = 0; a < 3; a++)
        {
            int randPosX = y + rand.nextInt(16);
            int randPosY = rand.nextInt(15);
            int randPosZ = z + rand.nextInt(16);
            (new WorldGenMinable(CommonProxy.b_plutonio_ore.blockID, (int)(Math.random() * 1D + 5D))).generate(world, rand, randPosX, randPosY, randPosZ);
        }

        for(int a = 0; a < 3; a++)
        {
            int randPosX = y + rand.nextInt(16);
            int randPosY = (int)(Math.random() * 120D + 40D);
            int randPosZ = z + rand.nextInt(16);
            (new WorldGenMinable(CommonProxy.b_marble_ore.blockID, (int)(Math.random() * 80D + 10D))).generate(world, rand, randPosX, randPosY, randPosZ);
        }

        for(int a = 0; a < 10; a++)
        {
            int randPosX = y + rand.nextInt(16);
            int randPosY = (int)(Math.random() * 0D + 5D);
            int randPosZ = z + rand.nextInt(16);
            (new WorldGenMinable(CommonProxy.b_coal_block.blockID, 10)).generate(world, rand, randPosX, randPosY, randPosZ);
        }
	}

	private void generateNether(World world, Random rand, int y, int z)
	{
		for(int a = 0; a < 10; a++)
        {
            int randPosX = y + rand.nextInt(16);
            int randPosY = rand.nextInt(100);
            int randPosZ = z + rand.nextInt(16);
            (new WorldGenMinable(CommonProxy.b_plutonio_ore.blockID, (int)(Math.random() * 1D + 30D))).generate(world, rand, randPosX, randPosY, randPosZ);
        }
	}

	private void generateEnd(World world, Random random, int i, int j)
	{
		
	}
}

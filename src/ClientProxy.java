package cevicraft;

import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.asm.*;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;

public class ClientProxy extends CommonProxy
{
	@SideOnly(Side.CLIENT)
    public static void registerRenderInformation()
    {
		//names
				//blocks
				LanguageRegistry.addName(CommonProxy.b_coal_block, "Coal block");
				LanguageRegistry.addName(CommonProxy.b_marble_ore, "Marble ore");
				//LanguageRegistry.addName(CommonProxy.b_marble, "Marble");
				LanguageRegistry.addName(CommonProxy.b_platino_block, "Platino block");
				LanguageRegistry.addName(CommonProxy.b_platino_ore, "Platino ore");
				LanguageRegistry.addName(CommonProxy.b_plutonio_ore, "Plutonio ore");
				LanguageRegistry.addName(CommonProxy.b_plutonio_block, "Plutonio block");
				LanguageRegistry.addName(CommonProxy.b_lightsensor, "Light sensor");
				//LanguageRegistry.addName(CommonProxy.b_magnetic_chest, "Magetic chest");
				LanguageRegistry.addName(CommonProxy.b_extra_sugar_canes, "Sugar Canes ++");
				LanguageRegistry.addName(CommonProxy.b_normal_house, "Normal house");
				LanguageRegistry.addName(CommonProxy.b_water_vapor, "Water vapor");
				LanguageRegistry.addName(CommonProxy.b_enriched_tnt, "Enriched TNT");
				LanguageRegistry.addName(CommonProxy.b_mini_charge, "Mini charge");
				LanguageRegistry.addName(CommonProxy.b_fast_sand, "Fast Sand");
				LanguageRegistry.addName(CommonProxy.b_jump_sand, "Jump Sand");
				//LanguageRegistry.addName(CommonProxy.b_coal_furnace, "Coal Furnace");
				//LanguageRegistry.addName(CommonProxy.b_coal_furnaceOn, "Coal Furnace");
				//LanguageRegistry.addName(CommonProxy.e_wire, "Wire");
				
				//items
				LanguageRegistry.addName(CommonProxy.i_platino_ingot, "Platino ingot");
				LanguageRegistry.addName(CommonProxy.i_platino_nugget, "Platino nugget");
				LanguageRegistry.addName(CommonProxy.i_plutonio, "Plutonio");
				LanguageRegistry.addName(CommonProxy.i_part_of_the_wand_of_the_golem, "Part of the wand of the golem");
				LanguageRegistry.addName(CommonProxy.i_part_of_the_wand_of_the_giant, "Part of the wand of the giant");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 0), "Marble White");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 1), "Marble Orange");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 2), "Marble Orange");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 3), "Marble Light Blue");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 4), "Marble Yellow");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 5), "Marble Lime");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 6), "Marble Pink");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 7), "Marble Gray");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 8), "Marble Light Gray");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 9), "Marble Cyan");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 10), "Marble Purple");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 11), "Marble Blue");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 12), "Marble Brown");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 13), "Marble Green");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 14), "Marble Red");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 15), "Marble Black");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 16), "prueba0");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 17), "prueba1");
				
				LanguageRegistry.addName(new ItemStack(b_multi_id1, 1, 0), "Redstone Block");
				LanguageRegistry.addName(new ItemStack(b_multi_id1, 1, 1), "Redstone Brick");
				LanguageRegistry.addName(new ItemStack(b_multi_id1, 1, 2), "Lapislazuli Brick");
				
				//tools
				LanguageRegistry.addName(CommonProxy.t_mega_sword, "Mega Sword");
				LanguageRegistry.addName(CommonProxy.t_platinoPickaxe, "Platino Pickaxe");
				LanguageRegistry.addName(CommonProxy.t_platinoShovel, "Platino Shovel");
				LanguageRegistry.addName(CommonProxy.t_platinoAxe, "Platino Axe");
				LanguageRegistry.addName(CommonProxy.t_platinoHoe, "Platino Hoe");
				LanguageRegistry.addName(CommonProxy.t_platinoSword, "Platino Sword");
				
				//images
				MinecraftForgeClient.preloadTexture("blocks.png");
				MinecraftForgeClient.preloadTexture("items.png");
				MinecraftForgeClient.preloadTexture("marble.png");
				MinecraftForgeClient.preloadTexture("multi_id1.png");	
    }
	
	/*static
    {
    	Item.itemsList[b_marble.blockID] = (new ItemMultiTextureTile(b_marble.blockID - 256, b_marble, marble.Names)).setItemName("marble");
    }*/
}
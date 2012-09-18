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
				LanguageRegistry.addName(CommonProxy.b_coal_furnace, "Coal Furnace");
				LanguageRegistry.addName(CommonProxy.b_coal_furnaceOn, "Coal Furnace");
				LanguageRegistry.addName(CommonProxy.e_wire, "Wire");
				
				//items
				LanguageRegistry.addName(CommonProxy.i_platino_ingot, "Platino ingot");
				LanguageRegistry.addName(CommonProxy.i_platino_nugget, "Platino nugget");
				LanguageRegistry.addName(CommonProxy.i_plutonio, "Plutonio");
				LanguageRegistry.addName(CommonProxy.i_part_of_the_wand_of_the_golem, "Part of the wand of the golem");
				LanguageRegistry.addName(CommonProxy.i_part_of_the_wand_of_the_giant, "Part of the wand of the giant");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 0), "Marble white");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 1), "Marble orange");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 2), "Marble magenta");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 3), "Marble light_blue");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 4), "Marble yellow");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 5), "Marble lime");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 6), "Marble pink");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 7), "Marble gray");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 8), "Marble light_gray");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 9), "Marble cyan");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 10), "Marble purple");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 11), "Marble blue");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 12), "Marble brown");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 13), "Marble green");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 14), "Marble red");
				LanguageRegistry.addName(new ItemStack(b_marble, 1, 15), "Marble black");
				
				//tools
				LanguageRegistry.addName(CommonProxy.t_mega_sword, "Mega Sword");
				LanguageRegistry.addName(CommonProxy.t_platinoPickaxe, "Platino Pickaxe");
				LanguageRegistry.addName(CommonProxy.t_platinoShovel, "Platino Shovel");
				LanguageRegistry.addName(CommonProxy.t_platinoAxe, "Platino Axe");
				LanguageRegistry.addName(CommonProxy.t_platinoHoe, "Platino Hoe");
				LanguageRegistry.addName(CommonProxy.t_platinoSword, "Platino Sword");
    }
}
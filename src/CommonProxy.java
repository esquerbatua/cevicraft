package cevicraft;

import cevicraft.mod_cevi.cevicraft;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;

public class CommonProxy implements IGuiHandler
{
	//blocks
	public static Block b_platino_ore = (new platino_ore(150, 0)).setHardness(3F).setResistance(40F).setBlockName("b_platino_ore");
    public static Block b_platino_block = (new platino_block(151, 1)).setHardness(10F).setResistance(100F).setBlockName("b_platino_block");
    public static Block b_coal_block = (new coal_block(152, 2)).setHardness(3F).setResistance(20F).setBlockName("b_coal_block");
    public static Block b_plutonio_ore = (new plutonio_ore(153, 3)).setLightValue(0.5F).setHardness(3F).setResistance(40F).setBlockName("b_plutonio_ore");
    public static Block b_plutonio_block = (new plutonio_block(154, 4)).setLightValue(1.0F).setHardness(3F).setResistance(100F).setBlockName("b_plutonio_block");
    //public static Block b_magnetic_chest = (new magnetic_chest(155)).setHardness(1F).setResistance(20F).setBlockName("b_magnetic_chest");
    public static Block b_water_vapor = (new water_vapor(156, 5)).setHardness(1F).setResistance(150F).setBlockName("b_water_vapor");
    public static Block b_marble_ore = (new marble_ore(157, 6)).setHardness(4F).setResistance(10F).setBlockName("b_marble_ore");
    public static Block b_extra_sugar_canes = (new extra_sugar_canes(158, 7)).setHardness(1F).setResistance(2F).setBlockName("b_extra_sugar_canes");
    public static Block b_lightsensor = (new sensor_of_light(159, 7)).setHardness(1F).setResistance(20F).setBlockName("b_lightSensor");
    public static Block b_mini_charge = (new mini_charge(160, 9)).setBlockName("b_wick");
    //blocks with multitextures
    public static Block b_normal_house = (new normal_house(161)).setHardness(4F).setResistance(150F).setBlockName("b_normal_house");
    public static Block b_marble = (new marble(162)).setHardness(4F).setResistance(10F).setBlockName("b_marble");
    public static Block b_enriched_tnt = (new EnrichedTNT(163, 9)).setBlockName("b_enriched_tnt");
    //public static Block b_fir_sapling = (new FirSapling(154, 0)).setHardness(3F).setResistance(1.0F).setBlockName("b_fir_sapling");
    //public static Block b_fir_log = (new FirLog(155)).setHardness(3F).setResistance(2.0F).setBlockName("b_fir_log");
    //public static Block b_fir_leaf = (new FirLeaf(156, 0)).setHardness(3F).setResistance(2.0F).setBlockName("b_fir_leaf");
    public static Block b_coal_furnace = (new coal_furnace(164, false)).setHardness(10F).setBlockName("b_coal_furnace");
    public static Block b_coal_furnaceOn = (new coal_furnace(165, false)).setHardness(10F).setBlockName("b_coal_furnace");
    //public static Block b_coal_furnaceOn = (new coal_furnace(159, true)).setHardness(10F).setLightValue(0.875F).setBlockName("b_coal_furnaceON");
    /**blocks of energy**/
    public static Block e_wire = (new wire(166, 10)).setHardness(3F).setResistance(20F).setBlockName("e_wire");
    public static Block e_generator = (new generator(167, 11)).setHardness(3F).setResistance(20F).setBlockName("e_generator");
    
    //items
    public static Item i_platino_nugget = (new platino_nugget(5000)).setIconIndex(0).setTabToDisplayOn(CreativeTabs.tabMaterials).setItemName("t_platino_nugget");
    public static Item i_platino_ingot = (new platino_ingot(5001)).setIconIndex(1).setTabToDisplayOn(CreativeTabs.tabMaterials).setItemName("t_platino_ingot");
    public static Item i_plutonio = (new plutonio(5002)).setIconIndex(2).setTabToDisplayOn(CreativeTabs.tabMaterials).setItemName("t_plutonio");
    public static Item i_part_of_the_wand_of_the_golem = (new part_of_the_wand_of_the_mob(5003)).setIconIndex(4).setTabToDisplayOn(CreativeTabs.tabMaterials).setItemName("t_part_of_the_wand_of_the_golem");
    public static Item i_part_of_the_wand_of_the_giant = (new part_of_the_wand_of_the_mob(5004)).setIconIndex(5).setTabToDisplayOn(CreativeTabs.tabMaterials).setItemName("t_part_of_the_wand_of_the_giant");
    public static Item i_part_of_the_wand_of_the_enderdragon = (new part_of_the_wand_of_the_mob(5005)).setIconIndex(5).setTabToDisplayOn(CreativeTabs.tabMaterials).setItemName("t_part_of_the_wand_of_the_enderdragon");
    
    //tool
    public static Item t_mega_sword = (new cevi_sword(5006, EnumToolcevi.CEVI)).setIconIndex(3).setTabToDisplayOn(CreativeTabs.tabCombat).setItemName("t_mega_sword");
    public static Item t_platinoSword = (new ItemSwordplatino(5007, EnumToolcevi.PLATINO)).setIconIndex(10).setTabToDisplayOn(CreativeTabs.tabCombat).setItemName("t_platinoSword");
    public static Item t_platinoPickaxe = (new ItemPickaxeplatino(5008, EnumToolcevi.PLATINO)).setIconIndex(6).setTabToDisplayOn(CreativeTabs.tabTools).setItemName("t_platinoPickaxe");
    public static Item t_platinoShovel = (new ItemShovelplatino(5009, EnumToolcevi.PLATINO)).setIconIndex(7).setTabToDisplayOn(CreativeTabs.tabTools).setItemName("t_platinoShovel");
    public static Item t_platinoAxe = (new ItemAxeplatino(5010, EnumToolcevi.PLATINO)).setIconIndex(8).setTabToDisplayOn(CreativeTabs.tabTools).setItemName("t_platinoAxe");
    public static Item t_platinoHoe = (new ItemHoeplatino(5011, EnumToolcevi.PLATINO)).setIconIndex(9).setTabToDisplayOn(CreativeTabs.tabTools).setItemName("t_platinoHoe");

	public static void registerRenderInformation()
	{
		//registros
		GameRegistry.registerBlock(b_platino_ore);
		GameRegistry.registerBlock(b_platino_block);
		GameRegistry.registerBlock(b_coal_block);
		GameRegistry.registerBlock(b_plutonio_ore);
		GameRegistry.registerBlock(b_plutonio_block);
		GameRegistry.registerBlock(b_marble_ore);
		GameRegistry.registerBlock(b_marble, marble_item.class);
		GameRegistry.registerBlock(b_lightsensor);
		GameRegistry.registerBlock(b_extra_sugar_canes);
		//GameRegistry.registerBlock(b_magnetic_chest);
		GameRegistry.registerBlock(b_normal_house);
		GameRegistry.registerBlock(b_water_vapor);
		GameRegistry.registerBlock(b_enriched_tnt);
		GameRegistry.registerBlock(b_mini_charge);
		GameRegistry.registerBlock(b_coal_furnace);
		GameRegistry.registerBlock(e_wire);
		GameRegistry.registerBlock(e_generator);
		//GameRegistry.registerBlock(b_fir_sapling);
		//GameRegistry.registerBlock(b_fir_log);
		//GameRegistry.registerBlock(b_fir_leaf);
		GameRegistry.registerFuelHandler(new Fuels());
		GameRegistry.registerWorldGenerator(new WorldGenerations());
		GameRegistry.registerTileEntity(TileEntityCoalFurnace.class, "CoalFurnace");
		ModLoader.registerContainerID(cevicraft.ContainerCoalFurnace, CoalFurnaceGUIid);
		//GameRegistry.registerTileEntity(cevicraft.TileEntitymagnetic_chest.class, "Magnetic Chest");
		
		//crafteos*/
		//bloques
		GameRegistry.addRecipe(new ItemStack(b_platino_block, 1), new Object[] {"xxx", "xxx", "xxx", Character.valueOf('x'), i_platino_ingot});
		GameRegistry.addRecipe(new ItemStack(i_platino_ingot, 9), new Object[] {"x", Character.valueOf('x'), b_platino_block});
		GameRegistry.addRecipe(new ItemStack(i_platino_ingot, 1), new Object[] {"xxx", "xxx", "xxx", Character.valueOf('x'), i_platino_nugget});
		GameRegistry.addRecipe(new ItemStack(i_platino_nugget, 9), new Object[] {"x", Character.valueOf('x'), i_platino_ingot});
		GameRegistry.addRecipe(new ItemStack(b_coal_block, 1), new Object[] {"xxx", "xxx", "xxx", Character.valueOf('x'), Item.coal});
		GameRegistry.addRecipe(new ItemStack(Item.coal, 9), new Object[] {"x", Character.valueOf('x'), b_coal_block});
		GameRegistry.addRecipe(new ItemStack(b_enriched_tnt, 4), new Object[] {"xyx", "yzy", "xyx", Character.valueOf('x'), Block.sand, Character.valueOf('y'), Item.gunpowder, Character.valueOf('z'), i_plutonio});
		GameRegistry.addRecipe(new ItemStack(b_extra_sugar_canes, 1), new Object[] {"xxx", "xxx", "xxx", Character.valueOf('x'), Item.reed});
		GameRegistry.addRecipe(new ItemStack(b_mini_charge, 4), new Object[] {"xxx", "yzy", "xxx", Character.valueOf('y'), Block.sand, Character.valueOf('z'), Item.gunpowder, Character.valueOf('x'), Item.leather});
		
		//furnace recipes
		GameRegistry.addSmelting(b_marble_ore.blockID, new ItemStack(b_marble, 1, 0), 30F);
		GameRegistry.addSmelting(b_coal_block.blockID, new ItemStack(Block.fire, 1), 50F);
		GameRegistry.addSmelting(b_platino_ore.blockID, new ItemStack(i_platino_ingot, 1), 50F);
		GameRegistry.addSmelting(b_plutonio_ore.blockID, new ItemStack(i_plutonio, 1), 100F);
		
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity != null)
        {
        	switch(ID)
			{
			}
        }
        return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity != null)
        {
        	switch(ID)
			{
			}
        }
        return null;
	}

	public static int fir_logBottom;
    public static int fir_logSide;
    public static int furnace_coal_block_logSide;
    public static int furnace_coal_block_logTop;
    public static int furnace_coal_block_Off;
    public static int furnace_coal_block_On2;
    public static int obsidianfurnaceBlockSide;
    public static int obsidianfurnaceBlockTop;
    public static int obsidianfurnaceBlockOff;
    public static int obsidianfurnaceBlockOn2;
    private static GuiScreen creativeInventory;
	public static int chestBottom;
	public static int chestSide;
	public static int chestFront;
	public static final int CoalFurnaceGUIid = 0;
	
	public GuiContainer getContainerGUI(EntityClientPlayerMP player, int id, int x, int y, int z)
	{
		switch(id)
		{
		case 0: return new GuiCoalFurnace(player.inventory, (TileEntityCoalFurnace)player.worldObj.getBlockTileEntity(x, y, z));
		default: return null;
		}
	}

}
package cevicraft;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import net.minecraft.client.*;
import net.minecraft.src.BaseMod;

@Mod(modid = "CEVICRAFT", name = "CEVICRAFT", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, versionBounds = "[1.0.0]")

public class mod_cevi
{
	@SidedProxy(clientSide = "cevicraft.ClientProxy", serverSide = "cevicraft.CommonProxy")
	public static CommonProxy proxy;
	//public static coal_furnace coal_furnace;
	@Instance("mod_cevi")
	public static mod_cevi instance;
	private int blockId;
	
	public static class cevicraft
	{
		//public final static BaseMod ContainerCoalFurnace = null;
	}
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
	}
	
	@Init
	public void Load(FMLInitializationEvent event)
	{
		instance = this;
		//coal_furnace = new coal_furnace(this.blockId, false);
		proxy.registerRenderInformation();
		ClientProxy.registerRenderInformation();
		//NetworkRegistry.instance().registerGuiHandler(instance, proxy);
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
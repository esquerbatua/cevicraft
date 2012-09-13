package cevicraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.client.*;
import net.minecraft.src.BaseMod;

@Mod(modid = "CEVICRAFT", name = "CEVI", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, versionBounds = "[1.0.0]")

public class mod_cevi
{
	
	@SidedProxy(clientSide = "cevicraft.ClientProxy", serverSide = "cevicraft.CommonProxy")
	public static CommonProxy proxy;

	public static class cevicraft
	{
		public final static BaseMod ContainerCoalFurnace = null;
	}
	
	@Init
	public void LoadFrom(FMLInitializationEvent event)
	{
		proxy.registerRenderInformation();
		ClientProxy.registerRenderInformation();
	}

	@PreInit
	public void PreLoad(FMLInitializationEvent event)
	{
	}
}
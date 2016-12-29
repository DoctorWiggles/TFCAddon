package tfcaddon;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(	modid=Main.MOD_ID,
		name=Main.MOD_NAME,
		version=Main.VERSION,
		dependencies="required-after:terrafirmacraft"
		)

public class Main 
{
	public static final String MOD_ID = "justanothertfcaddon";
	public static final String MOD_NAME = "JustAnotherTFCAddon";
	public static final String VERSION = "v1.1";
	public static final String CLIENT_PROXY_CLASS = "tfcaddon.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "tfcaddon.CommonProxy";
	
	@Instance(Main.MOD_ID)
	public static Main instance = new Main();
	
	public static final Logger logger = LogManager.getLogger(Main.MOD_ID);
	public static Configuration config;		
	
	@SidedProxy(clientSide=Main.CLIENT_PROXY_CLASS, serverSide=Main.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger.info("Loading JustAnotherTFCAddon");
		
		proxy.preInit(event);
		
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.init(event);
		logger.info("Finished Loading JustAnotherTFCAddon");

	}

	@EventHandler 
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
		
	}
}

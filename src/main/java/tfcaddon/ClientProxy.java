package tfcaddon;

import tfcaddon.entity.Hostile_Golem;
import net.minecraft.client.renderer.entity.RenderIronGolem;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {		
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
		RenderingRegistry.registerEntityRenderingHandler(Hostile_Golem.class, new RenderIronGolem());
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		
	}
}
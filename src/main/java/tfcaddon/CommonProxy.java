package tfcaddon;

import net.minecraft.entity.EntityList;
import tfcaddon.entity.Dummy_Bear;
import tfcaddon.entity.Hostile_Golem;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		
		Config.ProcessConfiguration(e);
	}

	public void init(FMLInitializationEvent e) {
		
		EntityRegistry.registerGlobalEntityID(Hostile_Golem.class, 
				"Hostile_Golem", EntityRegistry.findGlobalUniqueEntityId(), 0xbfb99a, 0x260026);
		EntityRegistry.registerModEntity(Hostile_Golem.class, "Hostile_Golem", 1, Main.instance, 160, 1, true);
		EntityRegistry.registerGlobalEntityID(Dummy_Bear.class, 
				"Alternate_Bear", EntityRegistry.findGlobalUniqueEntityId(), 0x5c4b3b, 0x260026);
		EntityRegistry.registerModEntity(Dummy_Bear.class, "Alternate_Bear", 2, Main.instance, 160, 1, true);	
	}

	public void postInit(FMLPostInitializationEvent e) {

	}
}
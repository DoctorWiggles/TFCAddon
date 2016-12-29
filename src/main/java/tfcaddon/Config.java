package tfcaddon;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config extends Main{

	public static int blacklist = 594;
	
	public static void ProcessConfiguration(FMLPreInitializationEvent event){
     	        	

		config = new Configuration(event.getSuggestedConfigurationFile());
		
		String prop = "Crushed ID";
		Property ItemsOutput = config.get(prop, " ", " ");
		ItemsOutput.comment = "Modify Blacklist ID";   
		
		
		config.load();
		logger.info("Loading Configs");
		blacklist = config.get(prop, "blacklist", 594).getInt();
		
		config.save(); 
		logger.info("Configurations Saved");
		
		
	}
}

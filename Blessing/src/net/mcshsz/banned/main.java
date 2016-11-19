package net.mcshsz.banned;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.mcshsz.config.BssConfig;
import net.mcshsz.config.Config;
import net.mcshsz.config.InsertDB;
import net.minecraft.server.v1_10_R1.PlayerList;

public class main extends JavaPlugin {
	main plugin = this;
	private Logger log = getLogger();
	protected BssConfig c = new BssConfig(plugin);

	@Override
	public void onEnable(){
		 
		new Config(plugin, log, "", "config.yml");
		///new Config(plugin, log, "", "message.yml");
		ConfigurationSerialization.registerClass((Class<? extends ConfigurationSerializable>) Config.class);
		getServer().getPluginManager().registerEvents(new Event(plugin, log, c), plugin);//
		log.info("完成最后初始化！");

	}
	
	@Override
	public void onDisable(){
		//saveConfig();
 	}
	
	
	
	
}

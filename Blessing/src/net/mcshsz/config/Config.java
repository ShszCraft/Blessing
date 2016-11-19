package net.mcshsz.config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config{
	private final JavaPlugin plugin;
	private FileConfiguration config;
	private File configFile;
	private final String folderName;
	private final String fileName;
	
	/**
	 * 
	 * @param plugin  Main
	 * @param folderName 文件夹
	 * @param fileName 文件
	 */
	public Config(JavaPlugin plugin, String folderName, String fileName){
		this.plugin = plugin;
		this.folderName = folderName;
		this.fileName = fileName;
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		File file=new File(plugin.getDataFolder(),fileName);
		if (!(file.exists())) {
			plugin.saveDefaultConfig();
			
		}
		reloadConfig();
	}
	
	Logger log;
	
	public Config(JavaPlugin plugin, Logger log, String folderName, String fileName){
		this.plugin = plugin;
		this.folderName = folderName;
		this.fileName = fileName;
		log.log(Level.INFO, "配置文件开始加载！");
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
			log.log(Level.INFO, "正在创建文件夹");
		}
		File file=new File(plugin.getDataFolder(),fileName);
		if (!(file.exists())) {
			plugin.saveDefaultConfig();
			log.log(Level.INFO, "正在创建配置文件"+fileName);
		}
		reloadConfig();
		log.log(Level.INFO, "重新载入配置文件"+fileName);
		folderName=null;
		fileName=null;
	}

	public void createNewFile(String paramString1, String paramString2) {
		reloadConfig();
		saveConfig();
		loadConfig(paramString2);

		if (paramString1 != null)
			this.plugin.getLogger().info(paramString1);
	}
	
	

	public FileConfiguration getConfig()
	{
		if (this.config == null) {
			reloadConfig();
		}
		return this.config;
	}

	public void loadConfig(String paramString) {
		this.config.options().header(paramString);
		this.config.options().copyDefaults(true);
		saveConfig();
	}

	public void reloadConfig() {
		if (this.configFile == null) {
			this.configFile = new File(this.plugin.getDataFolder() + this.folderName, this.fileName);
		}
		this.config = YamlConfiguration.loadConfiguration(this.configFile);
	}

	public void saveConfig() {
		if ((this.config == null) || (this.configFile == null))
			return;
		try
		{
			getConfig().save(this.configFile);
		} catch (IOException localIOException) {
			this.plugin.getLogger().log(Level.SEVERE, "配置文件无法保存 " + this.configFile, localIOException);
		}
	}
}

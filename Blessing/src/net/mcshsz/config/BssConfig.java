package net.mcshsz.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import net.mcshsz.banned.main;

public class BssConfig{
	main plugin;

	/*默认配置文件*/
  	public BssConfig(main paramDeluxeChat){
	  this.plugin = paramDeluxeChat;
	 
  	}

  	Logger log;
  	public BssConfig(main paramDeluxeChat, Logger log){
	  this.plugin = paramDeluxeChat;
	 
  	}
  	

  	public FileConfiguration load(File file){
        if (!(file.exists())) {  
       
        }
        return YamlConfiguration.loadConfiguration(file);
  	}
  	
  	public void fileNO(){
  		System.out.println("请检测配置文件！");
  	}
 
  	public String MariadbLocalHost() {
  		try{
  			return this.plugin.getConfig().getString("Bss.MariaDB.LocalHost");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}

  	public String MariadbPort() {
  		try{
  			return this.plugin.getConfig().getString("Bss.MariaDB.prot");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}

  	public String MariadbRoot() {
  		try{
  			return this.plugin.getConfig().getString("Bss.MariaDB.root");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}

  	public String MariadbPasswd() {
  		try{
  			return this.plugin.getConfig().getString("Bss.MariaDB.passwd");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}

  	public String MariadbDatabases() {
  		try{
  			return this.plugin.getConfig().getString("Bss.MariaDB.databases");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}

  	public String MariadbTable() {
  		try{
  			return this.plugin.getConfig().getString("Bss.MariaDB.table");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}

  	public boolean MariadbUnicode() {
  		try{
  			return this.plugin.getConfig().getBoolean("Bss.MariaDB.Unicode");
  		}catch (Exception e) {
  			fileNO();
  		}
		return true;
  	}

  	public String MariadbEncoding() {
  		try{
  			return this.plugin.getConfig().getString("Bss.MariaDB.Encoding");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}

  	/*语言配置文件*/
  	public String messagePrefix() {
  		try{
  			return this.plugin.getConfig().getString("messagePrefix");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	public String messageAdminDefault() {
  		try{
  			return this.plugin.getConfig().getString("messageAdminDefault");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	public String messageAdminPrompt() {
  		try{
  			return this.plugin.getConfig().getString("messageAdminPrompt");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	
  	public String messageDefault() {
  		try{
  			return this.plugin.getConfig().getString("messageDefault");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	public String messagePrompt() {
  		try{
  			return this.plugin.getConfig().getString("messagePrompt");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	public String messageSkinDefault() {
  		try{
  			return this.plugin.getConfig().getString("messageSkinDefault");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	public String messageSkinPrompt() {
  		try{
  			return this.plugin.getConfig().getString("messageSkinPrompt");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	
  	
  	
  	
  	public String messageSetUpSkinDefault() {
  		try{
  			return this.plugin.getConfig().getString("messageSetUpSkinDefault");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	public String messageSetUpSkinPrompt() {
  		try{
  			return this.plugin.getConfig().getString("messageSetUpSkinPrompt");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	
  	
  	
  	
  	
  	public String messageBannedDefault() {
  		try{
  			return this.plugin.getConfig().getString("messageBannedDefault");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	public String messageBannedPrompt() {
  		try{
  			return this.plugin.getConfig().getString("messageBannedPrompt");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	
  	public String messageAnnouncement0() {
  		try{
  			return this.plugin.getConfig().getString("announcement0");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	public String messageAnnouncement1() {
  		try{
  			return this.plugin.getConfig().getString("announcement1");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	public String messageAnnouncement2() {
  		try{
  			return this.plugin.getConfig().getString("announcement2");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
  	public String messageAnnouncement3() {
  		try{
  			return this.plugin.getConfig().getString("announcement3");
  		}catch (Exception e) {
  			fileNO();
  		}
		return null;
  	}
}

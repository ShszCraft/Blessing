package net.mcshsz.banned;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.xephi.authme.events.LoginEvent;
import net.mcshsz.config.BssConfig;
import net.mcshsz.config.InsertDB;
import net.mcshsz.event.LoginEvents;
import net.mcshsz.event.PlayerQuitEvents;


public class Event implements Listener{
	
	protected main plugin;
	protected String WebUrl;
	
	protected BssConfig c;
	protected String Url;
	protected String User; 
	protected String Password; 
	protected String Table;
	
	
	
	private String messageAdminDefault;
	private String messageAdminPrompt;
	private String messageAnnouncement0;
	private String messageAnnouncement1;
	private String messageAnnouncement2;
	private String messageAnnouncement3;
	private String messageBannedDefault;
	private String messageBannedPrompt;
	private String messageDefault;
	private String messagePrefix;
	private String messagePrompt;
	private String messageSkinPrompt;
	private String messageSkinDefault;
	private String messageSetUpSkinDefault;
	private String messageSetUpSkinPrompt; 
	
	
	private ArrayList<String> PlayerUser;
	private ArrayList<String> PlayerName;
	
	
	
	public Event(main plugin, Logger log, BssConfig c){
		String sql = "select * from options where option_name='site_url'";
		//System.out.println("SQL语句："+sql);
		Url = "jdbc:mysql://" + 
				c.MariadbLocalHost() + ":" + 
				c.MariadbPort() + "/" + 
				c.MariadbDatabases() + "?useUnicode=" +
				c.MariadbUnicode() + "&characterEncoding=" + 
				c.MariadbEncoding(); 
		User = c.MariadbRoot(); 
		Password = c.MariadbPasswd(); 
		Table = c.MariadbTable(); 
		
	    WebUrl = new InsertDB(Url, User, Password, Table).getSelect(sql).get(2);
		this.plugin = plugin;
		this.c = c;

		messageAdminDefault = c.messageAdminDefault();
		messageAdminPrompt = c.messageAdminPrompt();
		messageAnnouncement0 = c.messageAnnouncement0() ;
		messageAnnouncement1 = c.messageAnnouncement1() ;
		messageAnnouncement2 = c.messageAnnouncement2() ;
		messageAnnouncement3 = c.messageAnnouncement3() ;
		messageBannedDefault = c.messageBannedDefault() ;
		messageBannedPrompt = c.messageBannedPrompt() ;
		messageDefault = c.messageDefault() ;
		messagePrefix = c.messagePrefix() ;
		messagePrompt = c.messagePrompt() ;
		messageSkinDefault = c.messageSkinDefault() ;
		messageSkinPrompt = c.messageSkinPrompt() ;
		messageSetUpSkinDefault = c.messageSetUpSkinDefault();
		messageSetUpSkinPrompt = c.messageSetUpSkinPrompt();
		
		// messageAdminDefault, messageAdminPrompt, messageAnnouncement0, messageAnnouncement1, messageAnnouncement2, messageAnnouncement3 ,messageBannedDefault, messageBannedPrompt, messageDefault, messagePrefix, messagePrompt, messageSkinDefault, messageSkinPrompt, messageSkinDefaultNo, messageSkinPromptNo
	}
	
	/**
	 * 玩家登录成功之后 
	 * @param evt
	 * @return  
	 */
	@EventHandler
	public Listener LoginEventr (LoginEvent evt) {
		Player Player = evt.getPlayer();
		
		String sql = ("select * from players where player_name='" + Player.getName() + "'");//players 得到玩家信息
		new bug("调试类：LoginEventr; SQL：("+sql+")");
		PlayerName= new InsertDB(Url, User, Password, Table).getSelect(sql);
		new bug("调试类：LoginEventr; SQL结果：("+PlayerName+")");
		if(PlayerName.size()>1){
			sql = ("select * from users where uid='" + PlayerName.get(1) + "'");//通过玩家信息得到UID，查询皮肤站账户
			new bug("调试类：LoginEventr; SQL：("+sql+")");
			if(PlayerName.size()>1){
				PlayerUser = new InsertDB(Url, User, Password, Table).getSelect(sql);
				new bug("调试类：LoginEventr; SQL结果：("+PlayerUser+")");
			}
		}
		
		String Openadmin = null;
		String username = null;
		//System.out.println("tiaos:"+Url+"1 "+User+"2 "+Password+"3 "+Table+"4 "+WebUrl);
		new LoginEvents(messageAdminDefault, 
				messageAdminPrompt, 
				messageAnnouncement0,
				messageAnnouncement1, 
				messageAnnouncement2, 
				messageAnnouncement3,
				messageBannedDefault, 
				messageBannedPrompt, 
				messageDefault, 
				messagePrefix, 
				messagePrompt, 
				messageSkinDefault, 
				messageSkinPrompt, 
				messageSetUpSkinDefault, 
				messageSetUpSkinPrompt)
		.LoginEvent(Player, WebUrl, PlayerUser, PlayerName);
		
		
		if(PlayerUser!=null){
			if(PlayerUser.size()>1){
				new bug("动态数组：PlayerUser; 清空列表:"+PlayerUser+")");
				PlayerUser.removeAll(PlayerUser);
			}
		}
		if(PlayerName!=null){
			if(PlayerName.size()>1){
				new bug("动态数组：PlayerName; 清空列表:"+PlayerName+")");
				PlayerName.removeAll(PlayerName);
			}
		}
		
		
		
		return null;
	}
	
	@EventHandler
	public Listener LoginEventr (PlayerQuitEvent evt) {
		Player Player = evt.getPlayer();
		new PlayerQuitEvents().PlayerQuitEvent(Player);
		
		return null;
	}
	
}
